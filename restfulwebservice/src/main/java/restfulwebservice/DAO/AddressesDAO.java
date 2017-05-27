package restfulwebservice.DAO;

import java.io.Serializable;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import model.hibernate.Model;
import restfulwebservice.model.Addresses;

public class AddressesDAO {
	final static Logger logger = Logger.getLogger(AddressesDAO.class);
	final static private String className = "Addresses";

	/**
	 * add Addresses
	 * 
	 * @param Addresses
	 *            Addresses
	 * @return Serializable
	 */
	public static int addAddresses(Addresses addresses) {
		int idInt = -1;
		try{
		Serializable id = Model.save(addresses);
		idInt = Integer.parseInt(id.toString());
		} catch(Exception e){
			logger.error("Lỗi add addresses");
		}
		return idInt;
	}

	/**
	 * delete Addresses
	 * 
	 * @param id id
	 * @return boolean
	 */
	public static boolean deleteAddresses(String id) {
		Addresses addresses = new Addresses();
		addresses.setAddressId( Integer.parseInt( id));

		boolean result = Model.delete(addresses);
		if (!result)
			logger.error("Lối delete addresses: ");
			
		return result;
	}

	/**
	 * read Addresses
	 * 
	 * @return ArrayList<Addresses> list addresses
	 */
	public static ArrayList<Addresses> getAddresses() {
		ArrayList<Addresses> listAddresses = new ArrayList<Addresses>();
		ArrayList<Object> list = Model.getList( className);

		if (list == null){
			logger.error("Lỗi get List Addresses ");
			return null;
		}
			
		for (int i = 1; i < list.size(); i++) {
			Addresses addresses = (Addresses) list.get(i);
			listAddresses.add(addresses);
		}
		return listAddresses;
	}

	/**
	 * Update Addresses
	 * 
	 * @param addresses
	 * @param id
	 * @return boolean
	 */
	public static boolean updateAddresses(Addresses addresses) {
		boolean result = Model.update(addresses);

		if (!result)
			logger.error("Lối update Addresses");
		return result;
	}

	public static Addresses getAddressesById(String id) {
		Addresses tmp = (Addresses) Model.getById(Addresses.class, Integer.parseInt(id) );
		if (tmp == null)
			logger.error("Lối get Addresses By Id");
		return tmp;
	}
}
