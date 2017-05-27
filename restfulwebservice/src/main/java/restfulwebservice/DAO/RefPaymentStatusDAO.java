package restfulwebservice.DAO;

import java.io.Serializable;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import model.hibernate.Model;
import restfulwebservice.model.RefPaymentStatus;

public class RefPaymentStatusDAO {
	final static Logger logger = Logger.getLogger(RefPaymentStatusDAO.class);
	final static private String className = "RefPaymentStatus";

	/**
	 * add RefPaymentStatus
	 * 
	 * @param RefPaymentStatus
	 *            RefPaymentStatus
	 * @return String
	 */
	public static String addRefPaymentStatus(RefPaymentStatus refPaymentStatus) {
		String code = "";
		try {
			Serializable id = Model.save(refPaymentStatus);
			code = id.toString();
		} catch (Exception e) {
			logger.error("Lỗi add refPaymentStatus");
			return "";
		}
		return code;
	}

	/**
	 * delete RefPaymentStatus
	 * 
	 * @param id
	 *            id
	 * @return boolean
	 */
	public static boolean deleteRefPaymentStatus(String code) {
		RefPaymentStatus refPaymentStatus = new RefPaymentStatus();
		refPaymentStatus.setPaymentStatusCode(code);

		boolean result = Model.delete(refPaymentStatus);
		if (!result)
			logger.error("Lối delete refPaymentStatus: ");

		return result;
	}

	/**
	 * read RefPaymentStatus
	 * 
	 * @return ArrayList<RefPaymentStatus> list refPaymentStatus
	 */
	public static ArrayList<RefPaymentStatus> getRefPaymentStatus() {
		ArrayList<RefPaymentStatus> listRefPaymentStatus = new ArrayList<RefPaymentStatus>();
		ArrayList<Object> list = Model.getList(className);

		if (list == null) {
			logger.error("Lỗi get List RefPaymentStatus ");
			return null;
		}

		for (int i = 1; i < list.size(); i++) {
			RefPaymentStatus refPaymentStatus = (RefPaymentStatus) list.get(i);
			listRefPaymentStatus.add(refPaymentStatus);
		}
		return listRefPaymentStatus;
	}

	/**
	 * Update RefPaymentStatus
	 * 
	 * @param refPaymentStatus
	 * @param id
	 * @return boolean
	 */
	public static boolean updateRefPaymentStatus(RefPaymentStatus refPaymentStatus) {
		boolean result = Model.update(refPaymentStatus);

		if (!result)
			logger.error("Lối update RefPaymentStatus");
		return result;
	}

	public static RefPaymentStatus getRefPaymentStatusById(String id) {
		RefPaymentStatus tmp = (RefPaymentStatus) Model.getById(RefPaymentStatus.class, Integer.parseInt(id));
		if (tmp == null)
			logger.error("Lối get RefPaymentStatus By Id");
		return tmp;
	}
}
