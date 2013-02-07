package crawler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.io.Reader;

public class HTMLread {

	public HTMLread() {

	}

	public static boolean readUntil(InputStream is, char ch1, char ch2) {
		// consumes characters from is, and stops when either ch1 or ch2 is
		// encountered. Ignore case
		BufferedReader breader = new BufferedReader(new InputStreamReader(is));
		int data;
		try {
			data = breader.read();
			// WE NEED TO CHECK WHY THIS IS -1
			while (data != -1) {
				char ch = Character.toLowerCase((char) data);
				if (ch == (Character.toLowerCase(ch1))) {
					breader.close();
					return true;
				} else if (ch == (Character.toLowerCase(ch2))) {
					break;
				}
				data = breader.read();
				breader.close();
				return false;
			}

		} catch (IOException e) {

			System.out.println("File cannot be read: " + e);
		}
		return false;

	}

	public static char skipSpace(InputStream is, char ch) {
		// consumes up to and including the first non-whitespace character
		// if ch is encountered, return the smallest possible value of a char
		// (use constant Java provides!)
		// otherwise return the non-whitespace char that was read

		BufferedReader breader = new BufferedReader(new InputStreamReader(is));
		int data;
		try {
			data = breader.read();
			// WE NEED TO CHECK WHY THIS IS -1
			while (data != -1) {
				if (!Character.isWhitespace((char) data)) {
					if ((char) data == ch) {
						breader.close();
						return Character.MIN_VALUE;
					}

				}

			}
			return (char) data;
		} catch (IOException e) {

			System.out.println("File cannot be read: " + e);

			// FIND ANOTHER WAY OF RETURNING THIS
			return 0;
		}

	}

	public static String readString(InputStream is, char ch1, char ch2) {
		// consumes characters and stops when it hits ch1 or ch2. This method
		// does not ignore case
		// encountered. Ignore case
		BufferedReader breader = new BufferedReader(new InputStreamReader(is));
		int data;
		// IMplement a StringBuffer here!
		String s = "";
		try {
			data = breader.read();
			// WE NEED TO CHECK WHY THIS IS -1
			while (data != -1) {
				char ch = (char) data;
				if (ch == ch1) {
					breader.close();
					return s;
				} else if (ch == ch2) {
					breader.close();
					return null;
				}

				s += (char) data;
			}
			return s;
		} catch (IOException e) {
			System.out.println("File cannot be read: " + e);
			return "";

		}

	}

}

// */
// public static void saveURL(URL url, Writer writer)
// throws IOException {
// BufferedInputStream in = new BufferedInputStream(url.openStream());
// for (int c = in.read(); c != -1; c = in.read()) {
// writer.write(c);
// }
// }
//
// /**
// * Opens a buffered stream on the url and copies the contents to OutputStream
// */
// public static void saveURL(URL url, OutputStream os)
// throws IOException {
// InputStream is = url.openStream();
// byte[] buf = new byte[1048576];
// int n = is.read(buf);
// while (n != -1) {
// os.write(buf, 0, n);
// n = is.read(buf);
// }
// }

// URL my_url = new URL("http://www.vimalkumarpatel.blogspot.com/");
// BufferedReader br = new BufferedReader(new
// InputStreamReader(my_url.openStream()));
// String strTemp = "";
// while(null != (strTemp = br.readLine())){
// System.out.println(strTemp);
