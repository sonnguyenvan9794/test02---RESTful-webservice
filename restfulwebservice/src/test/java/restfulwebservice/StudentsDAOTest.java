package restfulwebservice;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import model.hibernate.Model;
import restfulwebservice.DAO.StudentsDAO;
import restfulwebservice.model.Students;

/**
 * @author SON-HA
 *
 */
public class StudentsDAOTest {
	
	private Students students;
	
	@BeforeClass
	public static void setUp() throws Exception {
	    System.out.println("Students test starting...");
	}

	public int add(){
		// Add Students
		students = new Students();
		students.setStudentName("Nguyễn Văn Sơn");
		students.setStudentPhone("01633507534");
		students.setStudentEmail("sonnguyenvan9794@gmail.com");
		students.setOtherStudentDetails("details");
		
		int idStudents = StudentsDAO.addStudents(students);
//		System.out.println("success insert, id = " + idStudents);
		assertNotEquals( idStudents, -1);
		return idStudents;
	}
	
	public void readList(){
		ArrayList<Students> list = StudentsDAO.getStudents();
		assertEquals( list.get(list.size() - 1).equals(students), true);
	}
	
	public void read(int idStudents){
		Students tmp1 = StudentsDAO.getStudentsById(idStudents);
		assertEquals( tmp1.equals(students), true);
	}
	
	public void update(int idStudents){
		String studentName = "Tuấn";
		Students tmp = (Students) Model.getById(Students.class, idStudents);
		tmp.setStudentName(studentName);
		boolean result = StudentsDAO.updateStudents( tmp);
		assertTrue( result);
		
	}
	
	public void delete(int idStudents){
		boolean result = StudentsDAO.deleteStudents(idStudents);
		assertEquals(result, true);
	}
	
	@Test
	public void testStudentsDAO() {
		int tmp = add();
		
		readList();
		read(tmp);
		update(tmp);
		delete(tmp);
	}

	@AfterClass
	  public static void destroy() throws Exception {
	    System.out.println("Students test done...");
	  }
}
