package restfulwebservice.DAO;

import java.io.Serializable;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import model.hibernate.Model;
import restfulwebservice.model.RefBanks;

public class RefBanksDAO {
	final static Logger logger = Logger.getLogger(RefBanksDAO.class);
	final static private String className = "RefBanks";

	/**
	 * add RefBanks
	 * 
	 * @param RefBanks
	 *            RefBanks
	 * @return String
	 */
	public static String addRefBanks(RefBanks refBanks) {
		String code = "";
		try {
			Serializable id = Model.save(refBanks);
			code = id.toString();
		} catch (Exception e) {
			logger.error("Lỗi add refBanks");
			return "";
		}
		return code;
	}

	/**
	 * delete RefBanks
	 * 
	 * @param id
	 *            id
	 * @return boolean
	 */
	public static boolean deleteRefBanks(String code) {
		RefBanks refBanks = new RefBanks();
		refBanks.setBankCode(code);

		boolean result = Model.delete(refBanks);
		if (!result)
			logger.error("Lối delete refBanks: ");

		return result;
	}

	/**
	 * read RefBanks
	 * 
	 * @return ArrayList<RefBanks> list refBanks
	 */
	public static ArrayList<RefBanks> getRefBanks() {
		ArrayList<RefBanks> listRefBanks = new ArrayList<RefBanks>();
		ArrayList<Object> list = Model.getList(className);

		if (list == null) {
			logger.error("Lỗi get List RefBanks ");
			return null;
		}

		for (int i = 1; i < list.size(); i++) {
			RefBanks refBanks = (RefBanks) list.get(i);
			listRefBanks.add(refBanks);
		}
		return listRefBanks;
	}

	/**
	 * Update RefBanks
	 * 
	 * @param refBanks
	 * @param id
	 * @return boolean
	 */
	public static boolean updateRefBanks(RefBanks refBanks) {
		boolean result = Model.update(refBanks);

		if (!result)
			logger.error("Lối update RefBanks");
		return result;
	}

	public static RefBanks getRefBanksById(String id) {
		RefBanks tmp = (RefBanks) Model.getById(RefBanks.class, id);
		if (tmp == null)
			logger.error("Lối get RefBanks By Id");
		return tmp;
	}
}
