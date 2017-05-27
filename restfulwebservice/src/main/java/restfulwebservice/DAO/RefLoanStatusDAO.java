package restfulwebservice.DAO;

import java.io.Serializable;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import model.hibernate.Model;
import restfulwebservice.model.RefLoanStatus;

public class RefLoanStatusDAO {
	final static Logger logger = Logger.getLogger(RefLoanStatusDAO.class);
	final static private String className = "RefLoanStatus";

	/**
	 * add RefLoanStatus
	 * 
	 * @param RefLoanStatus
	 *            RefLoanStatus
	 * @return String
	 */
	public static String addRefLoanStatus(RefLoanStatus refLoanStatus) {
		String code = "";
		try {
			Serializable id = Model.save(refLoanStatus);
			code = id.toString();
		} catch (Exception e) {
			logger.error("Lỗi add refLoanStatus");
			return "";
		}
		return code;
	}

	/**
	 * delete RefLoanStatus
	 * 
	 * @param id
	 *            id
	 * @return boolean
	 */
	public static boolean deleteRefLoanStatus(String code) {
		RefLoanStatus refLoanStatus = new RefLoanStatus();
		refLoanStatus.setLoanStatusCode(code);

		boolean result = Model.delete(refLoanStatus);
		if (!result)
			logger.error("Lối delete refLoanStatus: ");

		return result;
	}

	/**
	 * read RefLoanStatus
	 * 
	 * @return ArrayList<RefLoanStatus> list refLoanStatus
	 */
	public static ArrayList<RefLoanStatus> getRefLoanStatus() {
		ArrayList<RefLoanStatus> listRefLoanStatus = new ArrayList<RefLoanStatus>();
		ArrayList<Object> list = Model.getList(className);

		if (list == null) {
			logger.error("Lỗi get List RefLoanStatus ");
			return null;
		}

		for (int i = 1; i < list.size(); i++) {
			RefLoanStatus refLoanStatus = (RefLoanStatus) list.get(i);
			listRefLoanStatus.add(refLoanStatus);
		}
		return listRefLoanStatus;
	}

	/**
	 * Update RefLoanStatus
	 * 
	 * @param refLoanStatus
	 * @param id
	 * @return boolean
	 */
	public static boolean updateRefLoanStatus(RefLoanStatus refLoanStatus) {
		boolean result = Model.update(refLoanStatus);

		if (!result)
			logger.error("Lối update RefLoanStatus");
		return result;
	}

	public static RefLoanStatus getRefLoanStatusById(String id) {
		RefLoanStatus tmp = (RefLoanStatus) Model.getById(RefLoanStatus.class, Integer.parseInt(id));
		if (tmp == null)
			logger.error("Lối get RefLoanStatus By Id");
		return tmp;
	}
}
