package Asymmetrik;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Tests {
	
	private String document1 = "ASYMMETRIK LTD\n" + 
			"Mike Smith\n" + 
			"Senior Software Engineer\n" + 
			"(410)555-1234\n" + 
			"msmith@asymmetrik.com";
	
	private String document2 = "Foobar Technologies\n" + 
			"Analytic Developer\n" + 
			"Lisa Haung\n" + 
			"1234 Sentry Road\n" + 
			"Columbia, MD 12345\n" + 
			"Phone: 410-555-1234\n" + 
			"Fax: 410-555-4321\n" + 
			"lisa.haung@foobartech.com";
	
	private String document3 = "Arthur Wilson\n" + 
			"Software Engineer\n" + 
			"Decision & Security Technologies\n" + 
			"ABC Technologies\n" + 
			"123 North 11th Street\n" + 
			"Suite 229\n" + 
			"Arlington, VA 22209\n" + 
			"Tel: +1 (703) 555-1259\n" + 
			"Fax: +1 (703) 555-1200\n" + 
			"awilson@abctech.com";
	
	private String document4 = "Diana Black\nTalent Acquisition Specialist\ndiana.black@ihsmarkit.com\nOffice +1 301 284 2168";
	
	private String document5 = "Grace Mary Polhemus\nManager, Talent Acquisition Americas\nT +16099874061\ngrace.polhemus@ses.com";
	
	private String document6 = "Jennifer Kessler MD\nDirector - Human Resources\n12530 Parklawn Drive\ndirect 240 290 3140\njkessler@davisconstruction.com";
	
	private String document7 = "John D. Kerins\nSenior Recruiter-Talent Acquisition\njkerins@alionscience.com\n301.532.2475";
	@Test 
	public void test1() {
		ContactInfo contact = new ContactInfo(document1);
		assertTrue(contact.getName().equals("Mike Smith"));
		assertTrue(contact.getEmail().equals("msmith@asymmetrik.com"));
		assertTrue(contact.getPhone().equals("4105551234"));
	}
	
	@Test
	public void test2() {
		ContactInfo contact = new ContactInfo(document2);
		assertTrue(contact.getName().equals("Lisa Haung"));
		assertTrue(contact.getEmail().equals("lisa.haung@foobartech.com"));
		assertTrue(contact.getPhone().equals("4105551234"));
	}
	
	@Test
	public void test3() {
		ContactInfo contact = new ContactInfo(document3);
		assertTrue(contact.getName().equals("Arthur Wilson"));
		assertTrue(contact.getEmail().equals("awilson@abctech.com"));
		assertTrue(contact.getPhone().equals("17035551259"));
	}
	
	@Test
	public void test4() {
		ContactInfo contact = new ContactInfo(document4);
		assertTrue(contact.getName().equals("Diana Black"));
		assertTrue(contact.getEmail().equals("diana.black@ihsmarkit.com"));
		assertTrue(contact.getPhone().equals("13012842168"));
	}
	
	@Test
	public void testMiddleName() {
		ContactInfo contact = new ContactInfo(document5);
		assertTrue(contact.getName().equals("Grace Mary Polhemus"));
		assertTrue(contact.getEmail().equals("grace.polhemus@ses.com"));
		assertTrue(contact.getPhone().equals("16099874061"));
	}
	
	@Test
	public void testTitle() {
		ContactInfo contact = new ContactInfo(document6);
		assertTrue(contact.getName().equals("Jennifer Kessler MD"));
		assertTrue(contact.getEmail().equals("jkessler@davisconstruction.com"));
		assertTrue(contact.getPhone().equals("2402903140"));
	}
	
	@Test
	public void testMiddleInitial() {
		ContactInfo contact = new ContactInfo(document7);
		assertTrue(contact.getName().equals("John D. Kerins"));
		assertTrue(contact.getEmail().equals("jkerins@alionscience.com"));
		assertTrue(contact.getPhone().equals("3015322475"));
	}
	
	
	
}
