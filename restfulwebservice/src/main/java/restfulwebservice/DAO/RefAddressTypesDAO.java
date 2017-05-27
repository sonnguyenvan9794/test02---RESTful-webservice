package restfulwebservice.DAO;

import java.io.Serializable;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import model.hibernate.Model;
import restfulwebservice.model.RefAddressTypes;

public class RefAddressTypesDAO {
	final static Logger logger = Logger.getLogger(RefAddressTypesDAO.class);
	final static private String className = "RefAddressTypes";

	/**
	 * add RefAddressTypes
	 * 
	 * @param RefAddressTypes
	 *            RefAddressTypes
	 * @return String
	 */
	public static String addRefAddressTypes(RefAddressTypes refAddressTypes) {
		String code = "";
		try {
			Serializable id = Model.save(refAddressTypes);
			code = id.toString();
		} catch (Exception e) {
			logger.error("Lỗi add refAddressTypes");
			return "";
		}
		return code;
	}

	/**
	 * delete RefAddressTypes
	 * 
	 * @param id
	 *            id
	 * @return boolean
	 */
	public static boolean deleteRefAddressTypes(String code) {
		RefAddressTypes refAddressTypes = new RefAddressTypes();
		refAddressTypes.setAddressTypeCode(code);

		boolean result = Model.delete(refAddressTypes);
		if (!result)
			logger.error("Lối delete refAddressTypes: ");

		return result;
	}

	/**
	 * read RefAddressTypes
	 * 
	 * @return ArrayList<RefAddressTypes> list refAddressTypes
	 */
	public static ArrayList<RefAddressTypes> getRefAddressTypes() {
		ArrayList<RefAddressTypes> listRefAddressTypes = new ArrayList<RefAddressTypes>();
		ArrayList<Object> list = Model.getList(className);

		if (list == null) {
			logger.error("Lỗi get List RefAddressTypes ");
			return null;
		}

		for (int i = 1; i < list.size(); i++) {
			RefAddressTypes refAddressTypes = (RefAddressTypes) list.get(i);
			listRefAddressTypes.add(refAddressTypes);
		}
		return listRefAddressTypes;
	}

	/**
	 * Update RefAddressTypes
	 * 
	 * @param refAddressTypes
	 * @param id
	 * @return boolean
	 */
	public static boolean updateRefAddressTypes(RefAddressTypes refAddressTypes) {
		boolean result = Model.update(refAddressTypes);

		if (!result)
			logger.error("Lối update RefAddressTypes");
		return result;
	}

	public static RefAddressTypes getRefAddressTypesById(String id) {
		RefAddressTypes tmp = (RefAddressTypes) Model.getById(RefAddressTypes.class, Integer.parseInt(id));
		if (tmp == null)
			logger.error("Lối get RefAddressTypes By Id");
		return tmp;
	}
}
