package restfulwebservice.DAO;

import java.io.Serializable;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import model.hibernate.Model;
import restfulwebservice.model.Students;

public class StudentsDAO {
	
	final static Logger logger = Logger.getLogger(StudentsDAO.class);
	final static private String className = "Students";

	/**
	 * add Students
	 * 
	 * @param Students students
	 * @return Serializable
	 */
	public static int addStudents(Students students) {
		int idInt = -1;
		try{
		Serializable id = Model.save(students);
		idInt = Integer.parseInt(id.toString());
		} catch(Exception e){
			logger.error("Lỗi add students");
		}
		return idInt;
	}

	/**
	 * delete Students
	 * 
	 * @param id id
	 * @return boolean
	 */
	public static boolean deleteStudents(String id) {
		Students students = new Students();
		students.setStudentId( Integer.parseInt( id));

		boolean result = Model.delete(students);
		if (!result)
			logger.error("Lối delete Students ");
			
		return result;
	}

	/**
	 * read Students
	 * 
	 * @return ArrayList<Students> list students
	 */
	public static ArrayList<Students> getStudents() {
		ArrayList<Students> listStudents = new ArrayList<Students>();
		ArrayList<Object> list = Model.getList( className);

		if (list == null){
			logger.error("Lỗi get List Students ");
			return null;
		}
			
		for (int i = 1; i < list.size(); i++) {
			Students students = (Students) list.get(i);
			listStudents.add(students);
		}
		return listStudents;
	}

	/**
	 * Update Students
	 * 
	 * @param students
	 * @return
	 */
	public static boolean updateStudents(Students students) {
		boolean result = Model.update(students);
		if (!result)
			logger.error("Lối update Students");
		return result;
	}

	public static Students getStudentsById(String id) {
		Students tmp = (Students) Model.getById(Students.class, Integer.parseInt(id) );
		if (tmp == null){
			logger.error("Lối get Students By Id");
			return null;
		}
		return tmp;
	}
}
