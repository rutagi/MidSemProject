package Dao;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import domain.Student;


public class StudentDao {

	public StudentDao() {
	}
	public void insertStudent(Student student) {
		 Transaction transaction= null;
	        Session session = HibernateUtil.getsession().openSession();

	        try {
	            // Start a transaction
	            transaction = session.beginTransaction();
	            // Save the student object
	            session.save(student);
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

	public Student selectStudent(int studentId) {
		 Transaction transaction = null;
	        Student stu = null;
	        Session session = HibernateUtil.getsession().openSession();

	        try {
	            // Start a transaction
	            transaction = session.beginTransaction();
	            // Get a student object
	            stu = session.get(Student.class, studentId);
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
	        return stu;
	}

	public List<Student> selectAllStudents() {
		Transaction transaction = null;
       List<Student> students = null;
       Session session = HibernateUtil.getsession().openSession();

       try {
           // Start a transaction
           transaction = session.beginTransaction();
           // Retrieve all student records
           students = session.createQuery("from Student", Student.class).list();
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
       return students;
	}


	public boolean deleteStudent(int id) {
		 Transaction transaction = null;
	        Session session = HibernateUtil.getsession().openSession();

	        try {
	            // Start a transaction
	            transaction = session.beginTransaction();
	            // Get the student to delete
	            Student stu = session.get(Student.class, id);
	            if (stu != null) {
	                session.delete(stu);
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

	public void updateStudent(Student student) {
		 Transaction transaction = null;
	        Session session = HibernateUtil.getsession().openSession();

	        try {
	            // Start a transaction
	            transaction = session.beginTransaction();
	            // Save or update the student object
	            session.saveOrUpdate(student);
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
	
	
	 public Student authenticate(String email, String password) {
	        Session session = HibernateUtil.getsession().openSession();
	        Transaction tx = session.beginTransaction();
	        Student authenticatedUser = null;

	        try {
	            String hql = "FROM Student  where email = :email and password=:password";
	            Query query = session.createQuery(hql);
	            query.setParameter("email", email);
	            query.setParameter("password", password);

	            List<Student> users = query.list();
	            if (!users.isEmpty()) {
	                authenticatedUser = users.get(0);
	            }

	            tx.commit();
	        } catch (HibernateException ex) {
	            ex.printStackTrace();
	        } finally {
	            if (session != null) {
	                session.close();
	            }
	        }

	        return authenticatedUser;
	    }
	

}
