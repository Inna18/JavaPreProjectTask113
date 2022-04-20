package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class UserDaoHibernateImpl extends Util implements UserDao {
    public UserDaoHibernateImpl() {
        super();
    }


    @Override
    public void createUsersTable() {
        String sql = "CREATE TABLE IF NOT EXISTS user" +
                "(id INT NOT NULL AUTO_INCREMENT," +
                " name VARCHAR(255) NOT NULL," +
                " lastName VARCHAR(255) NOT NULL," +
                " age INT NOT NULL," +
                " PRIMARY KEY(id))";
        try (Session session = Util.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            Query query = session.createSQLQuery(sql).addEntity(User.class);
            query.executeUpdate();
            System.out.println("Table created in given DB");
            transaction.commit();
        }
    }

    @Override
    public void dropUsersTable() {
        String sql = "DROP TABLE IF EXISTS user";
        try (Session session = Util.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createSQLQuery(sql).addEntity(User.class);
            query.executeUpdate();
            System.out.println("Table deleted in given DB");
            transaction.commit();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        String sql = "INSERT INTO user (NAME, LASTNAME, AGE) VALUES (?, ?, ?)";
        try (Session session = Util.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createSQLQuery(sql).addEntity(User.class);
            query.setParameter(1, name);
            query.setParameter(2, lastName);
            query.setParameter(3, age);
            query.executeUpdate();
            System.out.println("User - " + name + " added to DB");

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeUserById(long id) {
        String sql = "DELETE FROM user WHERE ID = :id";
        try (Session session = Util.getSessionFactory().openSession();) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createSQLQuery(sql);
            query.setParameter("id", id);
            query.executeUpdate();
            System.out.println("User with id " + id + " deleted");

            transaction.commit();
        }
    }

    @Override
    public List<User> getAllUsers() {
        String sql = "SELECT * FROM user";
        try (Session session = Util.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createNativeQuery(sql).addEntity(User.class);
            List<User> list = query.list();

            transaction.commit();
            return list;
        }
    }

    @Override
    public void cleanUsersTable() {
        String sql = "TRUNCATE TABLE user";
        try (Session session = Util.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createSQLQuery(sql).addEntity(User.class);
            query.executeUpdate();

            transaction.commit();
        }
    }
}
