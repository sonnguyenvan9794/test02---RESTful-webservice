package restfulwebservice.DAO;

import java.io.Serializable;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import model.hibernate.Model;
import restfulwebservice.model.RefAccountTypes;

public class RefAccountTypesDAO {
	final static Logger logger = Logger.getLogger(RefAccountTypesDAO.class);
	final static private String className = "RefAccountTypes";

	/**
	 * add RefAccountTypes
	 * 
	 * @param RefAccountTypes
	 *            RefAccountTypes
	 * @return String
	 */
	public static String addRefAccountTypes(RefAccountTypes refAccountTypes) {
		String code = "";
		try {
			Serializable id = Model.save(refAccountTypes);
			code = id.toString();
		} catch (Exception e) {
			logger.error("Lỗi add refAccountTypes");
			return "";
		}
		return code;
	}

	/**
	 * delete RefAccountTypes
	 * 
	 * @param id
	 *            id
	 * @return boolean
	 */
	public static boolean deleteRefAccountTypes(String code) {
		RefAccountTypes refAccountTypes = new RefAccountTypes();
		refAccountTypes.setAccountTypeCode(code);

		boolean result = Model.delete(refAccountTypes);
		if (!result)
			logger.error("Lối delete refAccountTypes: ");

		return result;
	}

	/**
	 * read RefAccountTypes
	 * 
	 * @return ArrayList<RefAccountTypes> list refAccountTypes
	 */
	public static ArrayList<RefAccountTypes> getRefAccountTypes() {
		ArrayList<RefAccountTypes> listRefAccountTypes = new ArrayList<RefAccountTypes>();
		ArrayList<Object> list = Model.getList(className);

		if (list == null) {
			logger.error("Lỗi get List RefAccountTypes ");
			return null;
		}

		for (int i = 1; i < list.size(); i++) {
			RefAccountTypes refAccountTypes = (RefAccountTypes) list.get(i);
			listRefAccountTypes.add(refAccountTypes);
		}
		return listRefAccountTypes;
	}

	/**
	 * Update RefAccountTypes
	 * 
	 * @param refAccountTypes
	 * @param id
	 * @return boolean
	 */
	public static boolean updateRefAccountTypes(RefAccountTypes refAccountTypes) {
		boolean result = Model.update(refAccountTypes);

		if (!result)
			logger.error("Lối update RefAccountTypes");
		return result;
	}

	public static RefAccountTypes getRefAccountTypesById(String id) {
		RefAccountTypes tmp = (RefAccountTypes) Model.getById(RefAccountTypes.class, Integer.parseInt(id));
		if (tmp == null)
			logger.error("Lối get RefAccountTypes By Id");
		return tmp;
	}
}
