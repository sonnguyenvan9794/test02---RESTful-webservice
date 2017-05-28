package restfulwebservice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import model.hibernate.Model;
import restfulwebservice.DAO.AccountsDAO;
import restfulwebservice.DAO.RefAccountTypesDAO;
import restfulwebservice.DAO.RefBanksDAO;
import restfulwebservice.DAO.StudentsDAO;
import restfulwebservice.model.Accounts;

public class AccountsDAOTest {
	private class ForeignTest{
		public RefAccountTypesDAOTest refAccountTypesDAOTest = new RefAccountTypesDAOTest();
		public RefBanksDAOTest refBanksDAOTest = new RefBanksDAOTest();
		public StudentsDAOTest studentsDAOTest = new StudentsDAOTest();
	}
	private class ForeignKey{
		public String refAccountTypesCode;
		public String refBanksCode;
		public int idStudents;
	}
	
	private Accounts accounts;

	private ForeignKey foreignKey = new ForeignKey();
	
	private ForeignTest foreignTest = new ForeignTest();
	
	@BeforeClass
	public static void setUp() throws Exception {
	    System.out.println("Accounts test starting...");
	}

	public int add(){
		foreignKey.refAccountTypesCode = foreignTest.refAccountTypesDAOTest.add();
		foreignKey.refBanksCode = foreignTest.refBanksDAOTest.add();
		foreignKey.idStudents = foreignTest.studentsDAOTest.add();

//		Add Accounts
		accounts = new Accounts();
		accounts.setRefAccountTypes( RefAccountTypesDAO.getRefAccountTypesById(foreignKey.refAccountTypesCode));
		accounts.setRefBanks( RefBanksDAO.getRefBanksById(foreignKey.refBanksCode));
		accounts.setStudents( StudentsDAO.getStudentsById(foreignKey.idStudents));
		accounts.setAccountNumber("012341234145");
		accounts.setOtherAccountDetails("details");
		
		int idAccounts = AccountsDAO.addAccounts(accounts);
//		System.out.println("success insert, id = " + idAccounts);
		assertNotEquals(idAccounts, -1);
		return idAccounts;
	}
	
	public void readList(){
		ArrayList<Accounts> list = AccountsDAO.getAccounts();
		assertEquals( true, list.get(list.size() - 1).equals(accounts));
	}
	
	public void read(int idAccounts){
		Accounts tmp1 = AccountsDAO.getAccountsById(idAccounts);
		assertEquals( tmp1.equals(accounts), true);
	}
	
	public void update(int idAccounts){
		String otherAccountDetails = "Tuấn";
		Accounts tmp = (Accounts) Model.getById(Accounts.class, idAccounts);
		tmp.setOtherAccountDetails(otherAccountDetails);
		boolean result = AccountsDAO.updateAccounts( tmp);
		assertTrue( result);
		
	}
	
	public void delete(int idAccounts){
		boolean result = AccountsDAO.deleteAccounts(idAccounts);
		assertEquals(result, true);
	}
	
	private void deleteThanhPhanPhu(){
		foreignTest.refAccountTypesDAOTest.delete(foreignKey.refAccountTypesCode);
		foreignTest.refBanksDAOTest.delete( foreignKey.refBanksCode);
		foreignTest.studentsDAOTest.delete( foreignKey.idStudents);
	}
	 
	@Test
	public void testAccountsDAO() {
		int idAccounts = add();
		readList();
		read(idAccounts);
		update(idAccounts);
		delete(idAccounts);
		
		deleteThanhPhanPhu();
	}

	@AfterClass
	  public static void destroy() throws Exception {
	    System.out.println("Accounts test done...");
	  }
}
