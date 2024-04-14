package Dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import domain.Teacher;

public class TeacherDao {

	public TeacherDao() {
		
	}
	public void insertTeacher(Teacher teacher) {
		 Transaction transaction = null;
	        Session session = HibernateUtil.getsession().openSession();

	        try {
	            // Start a transaction
	            transaction = session.beginTransaction();
	            // Save the student object
	            session.save(teacher);
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

	public Teacher selectTeacher(int id) {
		 Transaction transaction = null;
	        Teacher teacher = null;
	        Session session = HibernateUtil.getsession().openSession();

	        try {
	            // Start a transaction
	            transaction = session.beginTransaction();
	            // Get a student object
	            teacher = session.get(Teacher.class, id);
	            // Commit the transaction
	            transaction.commit();
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
	        return teacher;
	}

	public List<Teacher> selectAllTeachers() {
		Transaction transaction = null;
      List<Teacher> teachers = null;
      Session session = HibernateUtil.getsession().openSession();

      try {
          // Start a transaction
          transaction = session.beginTransaction();
          // Retrieve all student records
          teachers = session.createQuery("from Teacher", Teacher.class).list();
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
      return teachers;
	}


	public boolean deleteTeacher(int id) {
		 Transaction transaction = null;
	        Session session = HibernateUtil.getsession().openSession();

	        try {
	            // Start a transaction
	            transaction = session.beginTransaction();
	            // Get the student to delete
	            Teacher stu = session.get(Teacher.class, id);
	            if (stu != null) {
	                session.delete(stu);
	                transaction.commit();
	                return true;
	            }
	            transaction.commit();
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

	public void updateTeacher(Teacher teacher) {
		 Transaction transaction = null;
	        Session session = HibernateUtil.getsession().openSession();

	        try {
	            // Start a transaction
	            transaction = session.beginTransaction();
	            // Save or update the student object
	            session.saveOrUpdate(teacher);
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
