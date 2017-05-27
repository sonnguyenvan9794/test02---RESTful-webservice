package restfulwebservice.DAO;

import java.io.Serializable;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import model.hibernate.Model;
import restfulwebservice.model.StudentAddresses;

public class StudentAddressesDAO {
	final static Logger logger = Logger.getLogger(StudentAddressesDAO.class);
	final static private String className = "StudentAddresses";

	/**
	 * add StudentAddresses
	 * 
	 * @param StudentAddresses
	 *            StudentAddresses
	 * @return Serializable
	 */
	public static int addStudentAddresses(StudentAddresses studentAddresses) {
		int idInt = -1;
		try{
		Serializable id = Model.save(studentAddresses);
		idInt = Integer.parseInt(id.toString());
		} catch(Exception e){
			logger.error("Lỗi add studentAddresses");
		}
		return idInt;
	}

	/**
	 * delete StudentAddresses
	 * 
	 * @param id id
	 * @return boolean
	 */
	public static boolean deleteStudentAddresses(String date) {
		boolean result = false;
		StudentAddresses studentAddresses = new StudentAddresses();
		try {
			studentAddresses.setDateFrom( java.sql.Date.valueOf(date));
		} catch(Exception e){
			logger.error("Lỗi delete studentAddresses: String -> Date");
		}
		result = Model.delete(studentAddresses);
		if (!result)
			logger.error("Lối delete studentAddresses: ");
		return result;
	}

	/**
	 * read StudentAddresses
	 * 
	 * @return ArrayList<StudentAddresses> list studentAddresses
	 */
	public static ArrayList<StudentAddresses> getStudentAddresses() {
		ArrayList<StudentAddresses> listStudentAddresses = new ArrayList<StudentAddresses>();
		ArrayList<Object> list = Model.getList( className);

		if (list == null){
			logger.error("Lỗi get List StudentAddresses ");
			return null;
		}
			
		for (int i = 1; i < list.size(); i++) {
			StudentAddresses studentAddresses = (StudentAddresses) list.get(i);
			listStudentAddresses.add(studentAddresses);
		}
		return listStudentAddresses;
	}

	/**
	 * Update StudentAddresses
	 * 
	 * @param studentAddresses
	 * @param id 
	 * @return boolean
	 */
	public static boolean updateStudentAddresses(StudentAddresses studentAddresses) {
		boolean result = Model.update(studentAddresses);

		if (!result)
			logger.error("Lối update StudentAddresses");
		return result;
	}

	public static StudentAddresses getStudentAddressesById(String id) {
		StudentAddresses tmp = (StudentAddresses) Model.getById(StudentAddresses.class, Integer.parseInt(id) );
		if (tmp == null)
			logger.error("Lối get StudentAddresses By Id");
		return tmp;
	}
}
