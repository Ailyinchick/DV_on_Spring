package net.proselyte.springmvc.DAO;

import net.proselyte.springmvc.model.Account;
import net.proselyte.springmvc.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import net.proselyte.springmvc.util.HibernateSessionFactoryUtil;

import java.util.List;

public class DAOuser implements DAOinterface {
    @Override
    public User foundByID(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(User.class, id);
    }

    public void save(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
    }

    public void update(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(user);
        tx1.commit();
        session.close();
    }

    public void delete(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(user);
        tx1.commit();
        session.close();
    }

    public User testUser(String name){
        User user = new User();
        user.setName(name);
        return user;
    }

    public List<User> findAll() {
        List<User> users = (List<User>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From User").list();
        return users;
    }
    @Override
    public List<Account> allAccounts() {
        return null;
    }
}
