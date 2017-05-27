package restfulwebservice.DAO;

import java.io.Serializable;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import model.hibernate.Model;
import restfulwebservice.model.PlannedPayments;

public class PlannedPaymentsDAO {
	final static Logger logger = Logger.getLogger(PlannedPaymentsDAO.class);
	final static private String className = "PlannedPayments";

	/**
	 * add PlannedPayments
	 * 
	 * @param PlannedPayments
	 *            PlannedPayments
	 * @return Serializable
	 */
	public static int addPlannedPayments(PlannedPayments plannedPayments) {
		int idInt = -1;
		try{
		Serializable id = Model.save(plannedPayments);
		idInt = Integer.parseInt(id.toString());
		} catch(Exception e){
			logger.error("Lỗi add plannedPayments");
		}
		return idInt;
	}

	/**
	 * delete PlannedPayments
	 * 
	 * @param id id
	 * @return boolean
	 */
	public static boolean deletePlannedPayments(String id) {
		PlannedPayments plannedPayments = new PlannedPayments();
		plannedPayments.setRegularOrderId( Integer.parseInt( id));

		boolean result = Model.delete(plannedPayments);
		if (!result)
			logger.error("Lối delete plannedPayments: ");
			
		return result;
	}

	/**
	 * read PlannedPayments
	 * 
	 * @return ArrayList<PlannedPayments> list plannedPayments
	 */
	public static ArrayList<PlannedPayments> getPlannedPayments() {
		ArrayList<PlannedPayments> listPlannedPayments = new ArrayList<PlannedPayments>();
		ArrayList<Object> list = Model.getList( className);

		if (list == null){
			logger.error("Lỗi get List PlannedPayments ");
			return null;
		}
			
		for (int i = 1; i < list.size(); i++) {
			PlannedPayments plannedPayments = (PlannedPayments) list.get(i);
			listPlannedPayments.add(plannedPayments);
		}
		return listPlannedPayments;
	}

	/**
	 * Update PlannedPayments
	 * 
	 * @param plannedPayments
	 * @param id
	 * @return boolean
	 */
	public static boolean updatePlannedPayments(PlannedPayments plannedPayments) {
		boolean result = Model.update(plannedPayments);

		if (!result)
			logger.error("Lối update PlannedPayments");
		return result;
	}

	public static PlannedPayments getPlannedPaymentsById(String id) {
		PlannedPayments tmp = (PlannedPayments) Model.getById(PlannedPayments.class, Integer.parseInt(id) );
		if (tmp == null)
			logger.error("Lối get PlannedPayments By Id");
		return tmp;
	}
}
