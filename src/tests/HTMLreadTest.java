package tests;

import static org.junit.Assert.assertEquals;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Test;

import crawler.HTMLread;



public class HTMLreadTest {


	@Test
	public void testReadUntil() {
		String str = "This is a String ~ GoGoGo";
		// convert String into InputStream
		InputStream is = new ByteArrayInputStream(str.getBytes());
		boolean expectedOutput = false;
		boolean actualOutput = HTMLread.readUntil(is, '~', 'S');
		assertEquals("Wrong Answer!", expectedOutput, actualOutput);
	}

	@Test
	public void testSkipSpace() {
		String str = "     This is a String ~ GoGoGo";
		// convert String into InputStream
		InputStream is = new ByteArrayInputStream(str.getBytes());
		char expectedOutput = Character.MIN_VALUE;
		char actualOutput = HTMLread.skipSpace(is,'T');
		assertEquals("Wrong Answer!", expectedOutput, actualOutput);
	}

	@Test
	public void testReadString() {
		String str = "This is a String ~ GoGoGo";
		// convert String into InputStream
		InputStream is = new ByteArrayInputStream(str.getBytes());
		String expectedOutput = "This is a ";
		String actualOutput = HTMLread.readString(is, 'S', 't');
		assertEquals("Wrong Answer!", expectedOutput, actualOutput);
	}

}
