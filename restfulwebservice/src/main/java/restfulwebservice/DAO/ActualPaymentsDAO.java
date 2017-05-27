package restfulwebservice.DAO;

import java.io.Serializable;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import model.hibernate.Model;
import restfulwebservice.model.ActualPayments;

public class ActualPaymentsDAO {
	final static Logger logger = Logger.getLogger(ActualPaymentsDAO.class);
	final static private String className = "ActualPayments";

	/**
	 * add ActualPayments
	 * 
	 * @param ActualPayments
	 *            ActualPayments
	 * @return Serializable
	 */
	public static int addActualPayments(ActualPayments actualPayments) {
		int idInt = -1;
		try{
		Serializable id = Model.save(actualPayments);
		idInt = Integer.parseInt(id.toString());
		} catch(Exception e){
			logger.error("Lỗi add actualPayments");
		}
		return idInt;
	}

	/**
	 * delete ActualPayments
	 * 
	 * @param id id
	 * @return boolean
	 */
	public static boolean deleteActualPayments(String id) {
		ActualPayments actualPayments = new ActualPayments();
		actualPayments.setActualPaymentId( Integer.parseInt( id));

		boolean result = Model.delete(actualPayments);
		if (!result)
			logger.error("Lối delete actualPayments: ");
			
		return result;
	}

	/**
	 * read ActualPayments
	 * 
	 * @return ArrayList<ActualPayments> list actualPayments
	 */
	public static ArrayList<ActualPayments> getActualPayments() {
		ArrayList<ActualPayments> listActualPayments = new ArrayList<ActualPayments>();
		ArrayList<Object> list = Model.getList( className);

		if (list == null){
			logger.error("Lỗi get List ActualPayments ");
			return null;
		}
			
		for (int i = 1; i < list.size(); i++) {
			ActualPayments actualPayments = (ActualPayments) list.get(i);
			listActualPayments.add(actualPayments);
		}
		return listActualPayments;
	}

	/**
	 * Update ActualPayments
	 * 
	 * @param actualPayments
	 * @param id
	 * @return
	 */
	public static boolean updateActualPayments(ActualPayments actualPayments) {
		boolean result = Model.update(actualPayments);

		if (!result)
			logger.error("Lối update ActualPayments");
		return result;
	}

	public static ActualPayments getActualPaymentsById(String id) {
		ActualPayments tmp = (ActualPayments) Model.getById(ActualPayments.class, Integer.parseInt(id) );
		if (tmp == null)
			logger.error("Lối get ActualPayments By Id");
		return tmp;
	}
}
