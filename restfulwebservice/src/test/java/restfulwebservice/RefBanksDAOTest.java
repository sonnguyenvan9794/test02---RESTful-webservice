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
import restfulwebservice.DAO.RefBanksDAO;
import restfulwebservice.model.RefBanks;

public class RefBanksDAOTest {
	
	private RefBanks refBanks;
	
	@BeforeClass
	public static void setUp() throws Exception {
	    System.out.println("RefBanks test starting...");
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
		// Add RefBanks
		refBanks = new RefBanks();
		refBanks.setBankCode(getCode());
		refBanks.setBankName("BIDV");
		
		String refBanksCode = RefBanksDAO.addRefBanks(refBanks);
		//System.out.println("success insert, id = " + refBanksCode);
		assertNotEquals(refBanksCode, -1);
		return refBanksCode;
	}
	
	public void readList(){
		ArrayList<RefBanks> list = RefBanksDAO.getRefBanks();
		assertEquals( list.get(list.size() - 1).equals(refBanks), true);
	}

	public void read(String refBanksCode){
		RefBanks tmp1 = RefBanksDAO.getRefBanksById(refBanksCode);
		assertEquals( tmp1.equals(refBanks), true);
	}
	
	public void update(String refBanksCode){
		String bankName = "VietinBank";
		RefBanks tmp = (RefBanks) Model.getById(RefBanks.class, refBanksCode);
		tmp.setBankName(bankName);
		boolean result = RefBanksDAO.updateRefBanks( tmp);
		assertTrue( result);
		
	}
	
	public void delete(String refBanksCode){
		boolean result = RefBanksDAO.deleteRefBanks(refBanksCode);
		assertEquals(result, true);
	}
	 
	@Test
	public void testRefBanksDAO() {
		String refBanksCode = add();
		readList();
		read(refBanksCode);
		update(refBanksCode);
		delete(refBanksCode);
	}

	@AfterClass
	  public static void destroy() throws Exception {
	    System.out.println("RefBanks test done...");
	  }
}
