package MainPack.DAO;

import MainPack.model.User;
import MainPack.model.Account;
import MainPack.model.userWallet;
import MainPack.util.HibernateSessionFactoryUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class DAOAccount implements DAOinterface {
    @Override
    public User foundByID(int id) {
        return null;
    }

    public void tableSummAcc() {
        List<userWallet> outList = new ArrayList();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbfordv", "root", "123qwe");
            Statement st = con.createStatement();

            //st.executeUpdate("drop table accsumm");
            st.executeUpdate("create table if not exists accsumm(user_id int, totalcash int )");
            st.executeUpdate("truncate table accsumm");

            ResultSet rs = st.executeQuery("select user_id from account order by user_id");
            Set varSet = new LinkedHashSet();
            while (rs.next()) {
                varSet.add(new userWallet(rs.getInt(1)));
            }

            List<userWallet> varList = new ArrayList(varSet);
            for (int i = 0; i < varList.size(); i++) {
                rs = st.executeQuery("select account, user_id from account where user_id=" + varList.get(i).getUserid() + " order by user_id");
                while (rs.next()) {
                    varList.get(i).cash += rs.getInt(1);
                }
            }
            for (int i = 0; i < varList.size(); i++) {
                st.executeUpdate("insert into accsumm values(" + varList.get(i).getUserid() + ", " + varList.get(i).getCash() + ") ");
            }

        } catch (ClassNotFoundException ex1) {
            System.out.println("ClassNOtFoundEX " + ex1.getMessage());
        } catch (SQLException ex2) {
            System.out.println("SQL exaption" + ex2.getMessage());
        }

    }

    public User findRichest() {
        DAOAccount ac = new DAOAccount();
        ac.tableSummAcc();
        User user = new User("Mike", "Vazovskiy");

        int usid = 0;
        int acc = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbfordv", "root", "123qwe");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from accsumm");
            while (rs.next()) {
                if (rs.getInt(2) > acc) {
                    acc = rs.getInt(2);
                    usid = rs.getInt(1);
                }
            }
            rs = st.executeQuery("SELECT * FROM user LEFT OUTER JOIN account ON user.id = account.user_id where user.id=" + usid);

            while (rs.next()) {
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setSurName(rs.getString(3));
                user.addAccount(new Account(rs.getInt(4), rs.getInt(5)));
            }

        } catch (ClassNotFoundException ex1) {
            System.out.println("Class not found EX " + ex1.getMessage());
        } catch (SQLException ex2) {
            System.out.println("SQL EX " + ex2.getMessage());
        }
        return user;
    }

    public String totalBank() {

        List<Account> accounts = (List<Account>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Account").list();
        int summ=0;
        for(int i=0; i<accounts.size(); i++) {
            summ+=accounts.get(i).getAccount();
        }
        return "" + summ;
    }

    @Override
    public List<Account> allAccounts() {

        List<Account> accounts = (List<Account>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Account").list();
        return accounts;
    }
}
