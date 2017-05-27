package restfulwebservice.DAO;

import java.io.Serializable;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import model.hibernate.Model;
import restfulwebservice.model.StudentLoans;

public class StudentLoansDAO {
	final static Logger logger = Logger.getLogger(StudentLoansDAO.class);
	final static private String className = "StudentLoans";

	/**
	 * add StudentLoans
	 * 
	 * @param StudentLoans
	 *            StudentLoans
	 * @return Serializable
	 */
	public static int addStudentLoans(StudentLoans studentLoans) {
		int idInt = -1;
		try{
		Serializable id = Model.save(studentLoans);
		idInt = Integer.parseInt(id.toString());
		} catch(Exception e){
			logger.error("Lỗi add studentLoans");
		}
		return idInt;
	}

	/**
	 * delete StudentLoans
	 * 
	 * @param id id
	 * @return boolean
	 */
	public static boolean deleteStudentLoans(String id) {
		StudentLoans studentLoans = new StudentLoans();
		studentLoans.setStudentLoanId( Integer.parseInt( id));

		boolean result = Model.delete(studentLoans);
		if (!result)
			logger.error("Lối delete studentLoans: ");
			
		return result;
	}

	/**
	 * read StudentLoans
	 * 
	 * @return ArrayList<StudentLoans> list studentLoans
	 */
	public static ArrayList<StudentLoans> getStudentLoans() {
		ArrayList<StudentLoans> listStudentLoans = new ArrayList<StudentLoans>();
		ArrayList<Object> list = Model.getList( className);

		if (list == null){
			logger.error("Lỗi get List StudentLoans ");
			return null;
		}
			
		for (int i = 1; i < list.size(); i++) {
			StudentLoans studentLoans = (StudentLoans) list.get(i);
			listStudentLoans.add(studentLoans);
		}
		return listStudentLoans;
	}

	/**
	 * Update StudentLoans
	 * 
	 * @param studentLoans
	 * @param id
	 * @return boolean
	 */
	public static boolean updateStudentLoans(StudentLoans studentLoans) {
		boolean result = Model.update(studentLoans);

		if (!result)
			logger.error("Lối update StudentLoans");
		return result;
	}

	public static StudentLoans getStudentLoansById(String id) {
		StudentLoans tmp = (StudentLoans) Model.getById(StudentLoans.class, Integer.parseInt(id) );
		if (tmp == null)
			logger.error("Lối get StudentLoans By Id");
		return tmp;
	}
}
