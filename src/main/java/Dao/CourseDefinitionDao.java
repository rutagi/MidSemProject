package Dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import domain.CourseDefinition;



public class CourseDefinitionDao {
	public CourseDefinitionDao() {
	}
    public void insertCourseDefinition(CourseDefinition courseDefinition) {
		 
		
		Transaction transaction = null;
        Session session = HibernateUtil.getsession().openSession();

        try {
            // Start a transaction
            transaction = session.beginTransaction();
            // Save the student object
            session.save(courseDefinition);
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

	public CourseDefinition selectCourseDefinition(int id) {
		 Transaction transaction = null;
		 CourseDefinition student = null;
	        Session session = HibernateUtil.getsession().openSession();

	        try {
	            // Start a transaction
	            transaction = session.beginTransaction();
	            // Get a student object
	            student = session.get(CourseDefinition.class, id);
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
	        return student;
	}

	public List<CourseDefinition> selectAllCourseDefinitions() {
		Transaction transaction = null;
        List<CourseDefinition> courses = null;
        Session session = HibernateUtil.getsession().openSession();

        try {
            // Start a transaction
            transaction = session.beginTransaction();
            // Retrieve all student records
            courses = session.createQuery("from CourseDefinition", CourseDefinition.class).list();
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
        return courses;
	}

	public boolean deleteCourseDefinition(int id) {
		
		Transaction transaction = null;
        Session session = HibernateUtil.getsession().openSession();

        try {
            // Start a transaction
            transaction = session.beginTransaction();
            // Get the student to delete
            CourseDefinition course = session.get(CourseDefinition.class, id);
            if (course != null) {
                session.delete(course);
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

	public void updateCourseDefinition(CourseDefinition courseDefinition) {
		 Transaction transaction = null;
	        Session session = HibernateUtil.getsession().openSession();

	        try {
	            // Start a transaction
	            transaction = session.beginTransaction();
	            // Save or update the student object
	            session.saveOrUpdate(courseDefinition);
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
