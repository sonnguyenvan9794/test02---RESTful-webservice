package restfulwebservice.DAO;

import java.io.Serializable;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import model.hibernate.Model;
import restfulwebservice.model.Guarantors;

public class GuarantorsDAO {
	final static Logger logger = Logger.getLogger(GuarantorsDAO.class);
	final static private String className = "Guarantors";

	/**
	 * add Guarantors
	 * 
	 * @param Guarantors
	 *            Guarantors
	 * @return Serializable
	 */
	public static int addGuarantors(Guarantors guarantors) {
		int idInt = -1;
		try{
		Serializable id = Model.save(guarantors);
		idInt = Integer.parseInt(id.toString());
		} catch(Exception e){
			logger.error("Lỗi add guarantors");
		}
		return idInt;
	}

	/**
	 * delete Guarantors
	 * 
	 * @param id id
	 * @return boolean
	 */
	public static boolean deleteGuarantors(String id) {
		Guarantors guarantors = new Guarantors();
		guarantors.setGuarantorId( Integer.parseInt( id));

		boolean result = Model.delete(guarantors);
		if (!result)
			logger.error("Lối delete guarantors: ");
			
		return result;
	}

	/**
	 * read Guarantors
	 * 
	 * @return ArrayList<Guarantors> list guarantors
	 */
	public static ArrayList<Guarantors> getGuarantors() {
		ArrayList<Guarantors> listGuarantors = new ArrayList<Guarantors>();
		ArrayList<Object> list = Model.getList( className);

		if (list == null){
			logger.error("Lỗi get List Guarantors ");
			return null;
		}
			
		for (int i = 1; i < list.size(); i++) {
			Guarantors guarantors = (Guarantors) list.get(i);
			listGuarantors.add(guarantors);
		}
		return listGuarantors;
	}

	/**
	 * Update Guarantors
	 * 
	 * @param guarantors
	 * @param id
	 * @return boolean
	 */
	public static boolean updateGuarantors(Guarantors guarantors) {
		boolean result = Model.update(guarantors);

		if (!result)
			logger.error("Lối update Guarantors");
		return result;
	}

	public static Guarantors getGuarantorsById(String id) {
		Guarantors tmp = (Guarantors) Model.getById(Guarantors.class, Integer.parseInt(id) );
		if (tmp == null)
			logger.error("Lối get Guarantors By Id");
		return tmp;
	}
}
