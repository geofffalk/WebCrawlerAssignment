package crawler;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class WebCrawler {

	// public void HTMLParser() {

	public ArrayList<String> HTMLParser() {
		// parses HTML commands from a stream
		ArrayList<String> list = new ArrayList<>();
		try {
			URL url = new URL("http://www.bbc.co.uk");
			Reader br = new BufferedReader(new InputStreamReader(
					url.openStream()));
			while (HTMLread.readUntil(br, '<', -1)) {
				if (checkForString(br, "ahref=")) {
					HTMLread.readUntil(br, '\'', '"');
					if (checkForString(br, "http")) {
						list.add("http"+HTMLread.readString(br, '"', '\''));
					}
				}
			}
			br.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			System.out.println("Can't read URL " + e);
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IOExceptions " + e);

			e.printStackTrace();
		} finally {

		}
		return list;
	}

	public boolean checkForString(Reader r, String s) {
		boolean output = true;
		for (int i = 0; i < s.length(); i++) {
			if (HTMLread.skipSpace(r, s.charAt(i)) != Character.MIN_VALUE) {
				output = false;
				break;
			}

		}
		return output;
	}

	public String StringConstructor(String inputString) {
		// Constructs string from information read
		String s = inputString;
		return s;

	}

	public void crawl(URL url, String databaseInfo) {
		// opens an HTTP connection to the starting URL and reviews the entire
		// web page, saving all URL links to a temporary database table
		// InputStream inputStream = new FileInputStream("c:\\data\\input.txt");

	}

	public static void main(String[] args) {
		System.out.println("Hello this is a webcrawler!");
		WebCrawler wc = new WebCrawler();
		ArrayList<String> list = wc.HTMLParser();
		for (String s : list) {
			System.out.println("Link: " + s);
		}

	}

}
