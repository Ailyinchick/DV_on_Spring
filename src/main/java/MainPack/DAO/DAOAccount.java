package MainPack.DAO;

import MainPack.model.User;
import MainPack.model.Account;
import MainPack.model.userWallet;
import MainPack.util.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

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

    public String findRichest() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbfordv", "root", "123qwe");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("call findRichest()");
            while (rs.next()) {
                return rs.getString(1) + " - " + rs.getInt(2);
            }
        } catch (ClassNotFoundException ex1) {
            System.out.println("Class not found EX " + ex1.getMessage());
        } catch (SQLException ex2) {
            System.out.println("SQL EX " + ex2.getMessage());
        }
        return null;
    }

    public String totalBank() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        org.hibernate.procedure.ProcedureCall call = session.createStoredProcedureCall("totalbank");
        org.hibernate.procedure.ProcedureOutputs callOutputs = call.getOutputs();
        org.hibernate.result.Output output;
        while ((output = callOutputs.getCurrent()) != null) { // проверяем наличие выходных значений
            if (output.isResultSet()) { // если выходное значение результат запроса (некоторые процедуры могут возвращать количество обработанных строк, тогда вернет false)
                List<Integer> result = ((org.hibernate.result.ResultSetOutput) output).getResultList();
                return "" + result.get(0);
            }
            if (!callOutputs.goToNext()) // некоторые процедуры могут возвращать несколько последовательных результатов
                break;
        }
        return "";
    }

    @Override
    public List<Account> allAccounts() {
        List<Account> accounts = (List<Account>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Account").list();
        return accounts;
    }
}
