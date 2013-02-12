package crawler;


import java.io.Reader;
import java.io.IOException;

public class HTMLread {

	/*
	 * This method consumes characters from an inputstream and stops when either
	 * ch1 or ch2 (it ignores case) are encountered.
	 * 
	 * @param InputStream is
	 * 
	 * @param char ch1
	 * 
	 * @param char ch2
	 * 
	 * @return boolean that shows if ch1 or ch2 has been encountered
	 */
	
	//CHECK INT ch2 INSTEAD OF CHAR ch2 HERE
	public static boolean readUntil(Reader is, char ch1, int ch2) {
		boolean returnBool = false;
		try {
			int data = is.read();
			while (data != ch2) {
				char ch = Character.toLowerCase((char) data);
				if (ch == (Character.toLowerCase(ch1))) {
					returnBool = true;
					break;
				}
				data = is.read();
			}
		} catch (IOException e) {
			System.out.println("File cannot be read: " + e);
		} finally {
		}
		return returnBool;
	}

	/*
	 * This method consumes up to and including the first non-whitespace
	 * character if ch is encountered, and returns the smallest possible value
	 * of a char(using the constant that Java provides!)
	 * 
	 * @param InputStream is
	 * 
	 * @param char ch
	 * 
	 * @return char the smallest possible value of a char otherwise it return
	 * the non-whitespace char that was read
	 */
	public static char skipSpace(Reader is, char ch) {
		char returnChar = Character.MIN_VALUE;
		try {
			int data = is.read();
			while (data != -1) {
				if (!Character.isWhitespace((char) data)) {
					returnChar = ((char) data == ch) ? Character.MIN_VALUE
							: (char) data;

					break;
				}
				data = is.read();
			}
		} catch (IOException e) {
			System.out.println("File cannot be read: " + e);
		} finally {
			// closeInputStream();
		}
		return returnChar;
	}

	/*
	 * This method consumes characters and stops when it hits ch1 or ch2. This
	 * method does not ignore case if ch is encountered, and returns the
	 * smallest possible value of a char(using the constant that Java provides!)
	 * 
	 * @param InputStream is
	 * 
	 * @param char ch
	 * 
	 * @return char the smallest possible value of a char otherwise it return
	 * the non-whitespace char that was read
	 */
	public static String readString(Reader is, char ch1, char ch2) {

		int data;
		StringBuffer output = new StringBuffer();
		try {
			while ((data = is.read()) != -1) {

				char ch = (char) data;
				if (ch == ch1) {
					break;
				} else if (ch == ch2) {
					return null;
				}
				output.append((char) data);
			}

		} catch (IOException e) {
			System.out.println("File cannot be read: " + e);
		}
		return output.toString();
	}

}
