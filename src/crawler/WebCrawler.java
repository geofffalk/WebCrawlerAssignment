package crawler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;

public class WebCrawler {

	private LinkedList<String[]> tempTable;
	// public void HTMLParser() {
	
	public WebCrawler() {
		tempTable = new LinkedList<>();


	}

	public void parsePage(String priority, String page) {
		// parses HTML commands from a stream
		try {
			URL url = new URL(page);
			Reader br = new BufferedReader(new InputStreamReader(
					url.openStream()));
			while (HTMLread.readUntil(br, '<', -1)) {
				if (checkForString(br, "ahref=")) {
					HTMLread.readUntil(br, '\'', '"');
					if (checkForString(br, "http")) {
						tempTable.add(new String[]{priority, "http"+HTMLread.readString(br, '"', '\'')});
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
		String startURL = "http://www.bbc.co.uk";
		wc.tempTable.add(new String[]{"0",startURL});
		wc.parsePage("1",startURL);
		for (String[] s : wc.tempTable) {
			System.out.println(s[0] + ": "+ s[1]);
		}
		for (int i=0;i<wc.tempTable.size();i++) {
			if (wc.tempTable.get(i)[0]=="1") {
				String currentURL = wc.tempTable.get(i)[1];
				wc.parsePage("2",currentURL);
				wc.tempTable.set(i, new String[]{"0",currentURL});
			} 
		}
		for (String[] s : wc.tempTable) {
			System.out.println(s[0] + ": "+ s[1]);
		}
	}

}
