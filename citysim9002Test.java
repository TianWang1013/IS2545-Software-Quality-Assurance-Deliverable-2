package citysim9002;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
//import static org.mockito.Mockito.*;
import org.mockito.*;


public class citysim9002Test {

//	@SuppressWarnings("unchecked")
	
	@Mock
	Person mockedPerson = Mockito.mock(Person.class);
	Place mockedPlace = Mockito.mock(Place.class);
//	Citysim9002 mockedCitysim9002 = Mockito.mock(Citysim9002.class);
	
	@Before
	public void setUp() throws Exception {
		// If you use @Mock, you need to do this
		MockitoAnnotations.initMocks(mockedPerson);
//		MockitoAnnotations.initMocks(mockedPlace);
//		MockitoAnnotations.initMocks(mockedCitysim9002);
		
	}

	@After
	public void tearDown() throws Exception {
		// any necessary teardown - none needed here
	}
	

	// --------------------------------------------------------------
	// isInteger TESTS
	// --------------------------------------------------------------
	
    //  The command line input argument must be a integer.
    //  Set the argument equal to a character value,
    //  the program ceases execution 
	@Test
	public void testSeedInteger1() {
		String[] a = {"a"};
		assertFalse(Citysim9002.isInteger(a));
	}
	
    //  The command line input argument must be a integer.
    //  Set the argument equal to an integer value,
    //  the program can run 
	@Test
	public void testSeedInteger2() {
		String[] b = {"9"};
		assertTrue(Citysim9002.isInteger(b));
	}
	
    //  The command line input argument must be a integer.
    //  Set the argument equal to a null value,
    //  the program ceases execution 
	@Test
	public void testSeedInteger3() {
		String[] c = {" "};
		assertFalse(Citysim9002.isInteger(c));
	}
	
    //  The command line input argument must be a integer.
    //  Set the argument equal to three integer values,
    //  the program ceases execution 
	@Test
	public void testSeedInteger4() {
		String[] d = {"5","6","10"};
		assertFalse(Citysim9002.isInteger(d));
	}
	
	// --------------------------------------------------------------
	// Visitor ArrayList TESTS
	// --------------------------------------------------------------

	// The class Visitor should generate the array list for the four types of visitor.
	// The random number generator needs to generate the visitor randomly, according to the length of the array list,
	// which means the array list size should equal to the length of the array list
	@Test
	public void testVisitorArrayList() {
		Visitor visitorarray = new Visitor();
		assertEquals(visitorarray.person().size(), 4);
	}
	
	// --------------------------------------------------------------
	// Preference Class TESTS
	// --------------------------------------------------------------
	
	//test preference method
	//If the visitor is a Student and going to The Cathedral of Learning,
	//this method should return false.
	//Use stub to make the visitor to be a student.
	@Test
	public void testPerference1() {
		Mockito.when(mockedPerson.getIdentify()).thenReturn("Student");
		assertFalse(Citysim9002.perference(mockedPerson, "The Cathedral of Learning"));
	}
	
	//test preference method
	//If the visitor is a Business Person and going to The Downtown,
	//this method should return true.
	//Use stub to make the visitor to be a Business Person.
	@Test
	public void testPerference2() {
		Mockito.when(mockedPerson.getIdentify()).thenReturn("Business Person");
		assertTrue(Citysim9002.perference(mockedPerson, "The Downtown"));
	}
	
	//test preference method
	//If the visitor is a Blogger and going to The Downtown,
	//this method should return false.
	//Use stub to make the visitor to be a Blogger.
	@Test
	public void testPerference3() {
		Mockito.when(mockedPerson.getIdentify()).thenReturn("Blogger");
		assertFalse(Citysim9002.perference(mockedPerson, "The Downtown"));
	}

	//test preference method
	//If the visitor is empty and going to The Downtown,
	//this method should return false.
	//Use stub to make the visitor to be empty.
	@Test
	public void testPerference4() {
		Mockito.when(mockedPerson.getIdentify()).thenReturn(" ");
		assertFalse(Citysim9002.perference(mockedPerson, "The Downtown"));
	}
	
	//test preference method
	//If the visitor is a Blogger and no where to go,
	//this method should return false.
	//Use stub to make the visitor to be a Blogger.
	@Test
	public void testPerference5() {
		Mockito.when(mockedPerson.getIdentify()).thenReturn("Blogger");
		assertFalse(Citysim9002.perference(mockedPerson, " "));
	}

	// --------------------------------------------------------------
	// Person Class TESTS
	// --------------------------------------------------------------
	
	//test getIndentity method
	@Test
	public void testgetIdentify1() {
		Person a = new Person(); 
		a.identify = "Student";
        Assert.assertEquals("Student", a.getIdentify()); 
	}
	
	// --------------------------------------------------------------
	// Place Class TESTS
	// --------------------------------------------------------------
	
	//test getIndentity method
	@Test
	public void testgetIdentify2() {
		Place b = new Place(); 
		b.identify = "The Downtown";
        Assert.assertEquals("The Downtown", b.getIdentify()); 
	}

	// --------------------------------------------------------------
	// Location Class TESTS
	// --------------------------------------------------------------
	
	// test the array list of location
	// the index of list should equal to the specific element 
	@Test
	public void testLocation() {
		List<String> lista = new Location().place();
		String a = lista.get(3);
		assertEquals(a, "The Downtown");
	}
	
	// --------------------------------------------------------------
	// Visitor Class TESTS
	// --------------------------------------------------------------
	
	// test the array list of visitor
	// the index of list should equal to the specific element 
	@Test
	public void testVisitor() {
		List<String> listb = new Visitor().person();
		String b = listb.get(1);
		assertEquals(b, "Professor");
	}
	
}





