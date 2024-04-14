package Dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import domain.Semester;

public class SemesterDao {

	public SemesterDao() {
		
	}

	public void insertSemester(Semester semester) {
		 Transaction transaction = null;
	        Session session = HibernateUtil.getsession().openSession();

	        try {
	            // Start a transaction
	            transaction = session.beginTransaction();
	            // Save the student object
	            session.save(semester);
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

	public Semester selectSemester(int semesterId) {
		 Transaction transaction = null;
	        Semester sem = null;
	        Session session = HibernateUtil.getsession().openSession();

	        try {
	            // Start a transaction
	            transaction = session.beginTransaction();
	            // Get a student object
	            sem = session.get(Semester.class, semesterId);
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
	        return sem;
	}

	public List<Semester> selectAllSemesters() {
		Transaction transaction = null;
        List<Semester> semesters = null;
        Session session = HibernateUtil.getsession().openSession();

        try {
            // Start a transaction
            transaction = session.beginTransaction();
            // Retrieve all student records
            semesters = session.createQuery("from Semester", Semester.class).list();
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
        return semesters;
	}


	public boolean deleteSemester(int id) {
		 Transaction transaction = null;
	        Session session = HibernateUtil.getsession().openSession();

	        try {
	            // Start a transaction
	            transaction = session.beginTransaction();
	            // Get the student to delete
	            Semester sem = session.get(Semester.class, id);
	            if (sem != null) {
	                session.delete(sem);
	                transaction.commit();
	                session.close();
	                return true;
	            }
	            transaction.commit();
	            session.close();
	            return false;
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	            return false;
	        } finally {
	            if (session != null) {
	                session.close(); // Close the session in the finally block
	            }
	        }
	}

	public void updateSemester(Semester semester) {
		 Transaction transaction = null;
	        Session session = HibernateUtil.getsession().openSession();

	        try {
	            // Start a transaction
	            transaction = session.beginTransaction();
	            // Save or update the student object
	            session.saveOrUpdate(semester);
	            // Commit the transaction
	            transaction.commit();
	            System.out.println("Update done successfully! Thank You.......");
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
}
	
