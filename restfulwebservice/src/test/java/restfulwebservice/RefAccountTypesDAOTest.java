package restfulwebservice;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.Random;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import model.hibernate.Model;
import restfulwebservice.DAO.RefAccountTypesDAO;
import restfulwebservice.model.RefAccountTypes;

public class RefAccountTypesDAOTest {
	
	private RefAccountTypes refAccountTypes;
	
	@BeforeClass
	public static void setUp() throws Exception {
	    System.out.println("RefAccountTypes test starting...");
	}

	/**
	 * Lấy code
	 * @return
	 */
	public String getCode(){
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String code = dateFormat.format(date); //2016/11/16 12:08:43
		
		Random rand = new Random();
		int  n = rand.nextInt(50) + 1;
		return (n + code);
	}

	public String add(){
		// Add RefAccountTypes
		refAccountTypes = new RefAccountTypes();
		refAccountTypes.setAccountTypeCode( getCode());
		refAccountTypes.setAccountTypeDescription("Tín dụng");
		
		String refAccountTypesCode = RefAccountTypesDAO.addRefAccountTypes(refAccountTypes);
//		System.out.println("success insert, id = " + refAccountTypesCode);
		assertNotEquals(refAccountTypesCode, -1);
		return refAccountTypesCode;
	}
	
	public void readList(){
		ArrayList<RefAccountTypes> list = RefAccountTypesDAO.getRefAccountTypes();
		assertEquals( list.get(list.size() - 1).equals(refAccountTypes), true);
	}
	
	public void read(String refAccountTypesCode){
		RefAccountTypes tmp1 = RefAccountTypesDAO.getRefAccountTypesById(refAccountTypesCode);
		assertEquals( tmp1.equals(refAccountTypes), true);
	}
	
	public void update(String refAccountTypesCode){
		String accountTypeDescription = "VietinBank";
		RefAccountTypes tmp = (RefAccountTypes) Model.getById(RefAccountTypes.class, refAccountTypesCode);
		tmp.setAccountTypeDescription(accountTypeDescription);
		boolean result = RefAccountTypesDAO.updateRefAccountTypes( tmp);
		assertTrue( result);
		
	}
	
	public void delete(String refAccountTypesCode){
		boolean result = RefAccountTypesDAO.deleteRefAccountTypes(refAccountTypesCode);
		assertEquals(result, true);
	}
	 
	@Test
	public void testRefAccountTypesDAO() {
		String refAccountTypesCode = add();
		readList();
		read(refAccountTypesCode);
		update(refAccountTypesCode);
		delete(refAccountTypesCode);
	}

	@AfterClass
	  public static void destroy() throws Exception {
	    System.out.println("RefAccountTypes test done...");
	  }
}
