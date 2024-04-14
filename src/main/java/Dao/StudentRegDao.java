package Dao;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import domain.Semester;
import domain.StudentRegistration;


public class StudentRegDao {

	public StudentRegDao() {
		
	}
	public void insertStudent(StudentRegistration student) {
		 Transaction transaction = null;
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

	public StudentRegistration selectStudent(int id) {
		 Transaction transaction = null;
	        StudentRegistration stu = null;
	        Session session = HibernateUtil.getsession().openSession();

	        try {
	            // Start a transaction
	            transaction = session.beginTransaction();
	            // Get a student object
	            stu = session.get(StudentRegistration.class, id);
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

	public List<StudentRegistration> selectAllStudents() {
		Transaction transaction = null;
      List<StudentRegistration> students = null;
      Session session = HibernateUtil.getsession().openSession();

      try {
          // Start a transaction
          transaction = session.beginTransaction();
          // Retrieve all student records
          students = session.createQuery("from StudentRegistration", StudentRegistration.class).list();
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
	            StudentRegistration stu = session.get(StudentRegistration.class, id);
	            if (stu != null) {
	                session.delete(stu);
	                transaction.commit();
	                session.close();
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

	public void updateStudent(StudentRegistration student) {
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
	
	
	
	
	public List<StudentRegistration> getStudentsRegisteredForSemester(int semid) {
	    Transaction transaction = null;
	    Session session = HibernateUtil.getsession().openSession();
	    List<StudentRegistration> students = new ArrayList<StudentRegistration>();

	    try {
	        transaction = session.beginTransaction();
	        String hql = "SELECT DISTINCT sr FROM StudentRegistration sr WHERE sr.sem.semid = :semid";
	        students = session.createQuery(hql, StudentRegistration.class)
	                         .setParameter("semid", semid)
	                         .list();
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
	    return students;
	}
	
	public List<StudentRegistration> getStudentsByAcademicUnitAndSemester(int academicUnitId, int semesterId) {
	    Transaction transaction = null;
	    Session session = HibernateUtil.getsession().openSession();
	    List<StudentRegistration> students = new ArrayList<>();

	    try {
	        transaction = session.beginTransaction();

	        String hql = "SELECT DISTINCT sr FROM StudentRegistration sr " +
	                     "WHERE sr.unit.id = :academicUnitId " +
	                     "AND sr.sem.semid = :semesterId";

	        students = session.createQuery(hql, StudentRegistration.class)
	                          .setParameter("academicUnitId", academicUnitId)
	                          .setParameter("semesterId", semesterId)
	                          .list();

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
	    
	    return students;
	}
	
	public List<StudentRegistration> getStudentsByCourseAndSemester(int courseId, int semesterId) {
	    Transaction transaction = null;
	    Session session = HibernateUtil.getsession().openSession();
	    List<StudentRegistration> students = new ArrayList<>();

	    try {
	        transaction = session.beginTransaction();

	        String hql = "SELECT DISTINCT sr FROM StudentRegistration sr " +
                    "JOIN sr.courses course " +
                    "WHERE sr.sem.semid = :semesterId " +
                    "AND course.courseid = :courseId";

       students = session.createQuery(hql, StudentRegistration.class)
                         .setParameter("semesterId", semesterId)
                         .setParameter("courseId", courseId)
                         .list();

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

	    return students;
	}

}
