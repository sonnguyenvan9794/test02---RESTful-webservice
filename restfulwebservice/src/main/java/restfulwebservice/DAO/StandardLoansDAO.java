package restfulwebservice.DAO;

import java.io.Serializable;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import model.hibernate.Model;
import restfulwebservice.model.StandardLoans;

public class StandardLoansDAO {
	final static Logger logger = Logger.getLogger(StandardLoansDAO.class);
	final static private String className = "StandardLoans";

	/**
	 * add StandardLoans
	 * 
	 * @param StandardLoans
	 *            StandardLoans
	 * @return Serializable
	 */
	public static int addStandardLoans(StandardLoans standardLoans) {
		int idInt = -1;
		try{
		Serializable id = Model.save(standardLoans);
		idInt = Integer.parseInt(id.toString());
		} catch(Exception e){
			logger.error("Lỗi add standardLoans");
		}
		return idInt;
	}

	/**
	 * delete StandardLoans
	 * 
	 * @param id id
	 * @return boolean
	 */
	public static boolean deleteStandardLoans(String id) {
		StandardLoans standardLoans = new StandardLoans();
		standardLoans.setStandardLoanId( Integer.parseInt( id));

		boolean result = Model.delete(standardLoans);
		if (!result)
			logger.error("Lối delete standardLoans: ");
			
		return result;
	}

	/**
	 * read StandardLoans
	 * 
	 * @return ArrayList<StandardLoans> list standardLoans
	 */
	public static ArrayList<StandardLoans> getStandardLoans() {
		ArrayList<StandardLoans> listStandardLoans = new ArrayList<StandardLoans>();
		ArrayList<Object> list = Model.getList( className);

		if (list == null){
			logger.error("Lỗi get List StandardLoans ");
			return null;
		}
			
		for (int i = 1; i < list.size(); i++) {
			StandardLoans standardLoans = (StandardLoans) list.get(i);
			listStandardLoans.add(standardLoans);
		}
		return listStandardLoans;
	}

	/**
	 * Update StandardLoans
	 * 
	 * @param standardLoans
	 * @param id
	 * @return boolean
	 */
	public static boolean updateStandardLoans(StandardLoans standardLoans) {
		boolean result = Model.update(standardLoans);

		if (!result)
			logger.error("Lối update StandardLoans");
		return result;
	}

	public static StandardLoans getStandardLoansById(String id) {
		StandardLoans tmp = (StandardLoans) Model.getById(StandardLoans.class, Integer.parseInt(id) );
		if (tmp == null)
			logger.error("Lối get StandardLoans By Id");
		return tmp;
	}
}
