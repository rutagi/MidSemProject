package Dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import domain.Teacher;
import domain.User;

public class UserDao {

	public UserDao() {
	}
	public void insertUser(User user) {
		 Transaction transaction = null;
	        Session session = HibernateUtil.getsession().openSession();

	        try {
	            // Start a transaction
	            transaction = session.beginTransaction();
	            // Save the student object
	            session.save(user);
	            // Commit the transaction
	            transaction.commit();
	          session.close();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        } finally {
	            if (session != null) {
	                session.close(); // Close the session in the finally block
	            }
	        }

	}
    public User getUserByEmail(String email) {
        Transaction transaction = null;
        Session session = HibernateUtil.getsession().openSession();
        User user = null;

        try {
            transaction = session.beginTransaction();
            String hql = "FROM User WHERE email = :email";
            user = session.createQuery(hql, User.class)
                         .setParameter("email", email)
                         .uniqueResult();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
       return user;
    }
}
