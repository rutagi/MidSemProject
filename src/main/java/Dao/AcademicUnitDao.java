package Dao;

import java.sql.SQLException;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import domain.AcademicUnit;

public class AcademicUnitDao {

	public AcademicUnitDao() {
	}
	public void createAcademic(AcademicUnit academic) {
		Transaction trans=null;
		Session session= HibernateUtil.getsession().openSession();
		
		try {
			trans=session.beginTransaction();
			session.save(academic);
			trans.commit();
			session.close();
		    } catch (Exception e) {
		        if(trans != null) {
		            trans.rollback();
		        }
		        e.printStackTrace();
		    } finally {
		        if (session != null) {
		            session.close(); // Close the session in the finally block
		        }
		    }
	}


public AcademicUnit selectAcademicUnit(int academicUnitId) {
	Transaction transaction = null;
	AcademicUnit academicunit = null;
	try (Session session = HibernateUtil.getsession().openSession()) {
		// start a transaction
		transaction = session.beginTransaction();
		// get an academic unit object
		academicunit = session.get(AcademicUnit.class, academicUnitId);
		// commit transaction
		transaction.commit();
	} catch (Exception e) {
		if (transaction != null) {
			transaction.rollback();
		}
		e.printStackTrace();
	}
	return academicunit;
}
public List<AcademicUnit> selectAllAcademicUnit() {
    Transaction transaction = null;
    List<AcademicUnit> academic = null;
    Session session = null;

    try {
        session = HibernateUtil.getsession().openSession();
        transaction = session.beginTransaction();
        academic = session.createQuery("from AcademicUnit", AcademicUnit.class).list();
        transaction.commit();
    } catch (Exception e) {
        if (transaction != null) {
            transaction.rollback();
        }
        e.printStackTrace();
    } finally {
        if (session != null) {
            session.close(); // Close the session in the finally block if it's open
        }
    }
    return academic;
}
public boolean deleteAcademicUnit(int id) {
	Transaction transaction = null;
	try (Session session = HibernateUtil.getsession().openSession()) {
		transaction = session.beginTransaction();
		AcademicUnit academic = session.get(AcademicUnit.class, id);
		if (academic != null) {
			session.delete(academic);
			session.close();
			return true;
		}
		transaction.commit();
	} catch (Exception e) {
		if (transaction != null) {
			transaction.rollback();
		}
		e.printStackTrace();
	}
	return false;
}
public void updateAcademicUnit(AcademicUnit academic){
	Transaction transaction = null;
	try (Session session = HibernateUtil.getsession().openSession()) {
		transaction = session.beginTransaction();
		session.saveOrUpdate(academic);
		transaction.commit();
	} catch (Exception e) {
		if (transaction != null) {
			transaction.rollback();
		}
		e.printStackTrace();
	}

	
}
}
