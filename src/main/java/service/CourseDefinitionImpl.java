package service;

import java.rmi.RemoteException;
import java.util.List;

import Dao.CourseDefinitionDao;
import domain.CourseDefinition;
import interfaces.CourseDefinitionInterface;

public class CourseDefinitionImpl implements CourseDefinitionInterface {
         private CourseDefinitionDao dao = new CourseDefinitionDao();
	@Override
	public void insertCourseDefinition(CourseDefinition courseDefinition) throws RemoteException {
		// TODO Auto-generated method stub
		dao.insertCourseDefinition(courseDefinition);
	}

	@Override
	public CourseDefinition selectCourseDefinition(int id) throws RemoteException {
		// TODO Auto-generated method stub
		return dao.selectCourseDefinition(id);
	}

	@Override
	public List<CourseDefinition> selectAllCourseDefinitions() throws RemoteException {
		// TODO Auto-generated method stub
		return dao.selectAllCourseDefinitions();
	}

	@Override
	public boolean deleteCourseDefinition(int id) throws RemoteException {
		// TODO Auto-generated method stub
		return dao.deleteCourseDefinition(id);
	}

	@Override
	public void updateCourseDefinition(CourseDefinition courseDefinition) throws RemoteException {
		// TODO Auto-generated method stub
	 dao.updateCourseDefinition(courseDefinition);	
	}

}
