package restfulwebservice.DAO;

import java.io.Serializable;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import model.hibernate.Model;
import restfulwebservice.model.Accounts;
import restfulwebservice.model.Accounts;

public class AccountsDAO {
	
	final static Logger logger = Logger.getLogger(AccountsDAO.class);
	final static private String className = "Accounts";

	/**
	 * add Accounts
	 * 
	 * @param Accounts
	 *            Accounts
	 * @return Serializable
	 */
	public static int addAccounts(Accounts accounts) {
		int idInt = -1;
		try{
		Serializable id = Model.save(accounts);
		idInt = Integer.parseInt(id.toString());
		} catch(Exception e){
			logger.error("Lỗi add accounts");
		}
		return idInt;
	}

	/**
	 * delete Accounts
	 * 
	 * @param id id
	 * @return boolean
	 */
	public static boolean deleteAccounts(String id) {
		Accounts accounts = new Accounts();
		accounts.setAccountId( Integer.parseInt( id));

		boolean result = Model.delete(accounts);
		if (!result)
			logger.error("Lối delete accounts: ");
			
		return result;
	}

	/**
	 * read Accounts
	 * 
	 * @return ArrayList<Accounts> list accounts
	 */
	public static ArrayList<Accounts> getAccounts() {
		ArrayList<Accounts> listAccounts = new ArrayList<Accounts>();
		ArrayList<Object> list = Model.getList( className);

		if (list == null){
			logger.error("Lỗi get List Accounts ");
			return null;
		}
			
		for (int i = 1; i < list.size(); i++) {
			Accounts accounts = (Accounts) list.get(i);
			listAccounts.add(accounts);
		}
		return listAccounts;
	}

	/**
	 * Update Accounts
	 * 
	 * @param accounts
	 * @param id
	 * @return boolean
	 */
	public static boolean updateAccounts(Accounts accounts) {
		boolean result = Model.update(accounts);

		if (!result)
			logger.error("Lối update Accounts");
		return result;
	}

	public static Accounts getAccountsById(String id) {
		Accounts tmp = (Accounts) Model.getById(Accounts.class, Integer.parseInt(id) );
		if (tmp == null)
			logger.error("Lối get Accounts By Id");
		return tmp;
	}
}
