package filesearch;

//import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
//import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import org.junit.Before;
import junit.framework.TestSuite;

public class Test extends TestSuite {
	static File insert;
	private String expectedText = "This is the file you are seeking!";
	private String setupDirectory = "C:\\testCode";
	private String targetFile = "seek.txt";
	@Before
	public void setUp() {
		File f = new File("C:\\testCode\\level1\\level2\\finalLevel");
		//System.out.println(f.mkdirs());
		f = new File("C:\\testCode\\level1\\level2a\\thirdLevel");
		//System.out.println(f.mkdirs());
		f = new File("C:\\testCode\\level1\\level2b\\thirdLevelb");
		//System.out.println(f.mkdirs());
		f = new File("C:\\testCode\\level1\\level2b\\thirdLevelc\\fourthLevel");
		//System.out.println(f.mkdirs());
		insert = new File(f.getAbsolutePath() + "\\seek.txt");
		//System.out.println("writing to " + insert.getAbsolutePath());
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(insert)));
			pw.write(expectedText);
			pw.flush();
			pw.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	@org.junit.Test
	public void testSearchForFile() {
		boolean result = FileSearch.searchForFile(targetFile, setupDirectory);
		if(result) {
			System.out.println(FileSearch.discoveredText);
			/*try {
				FileReader reader = new FileReader(setupDirectory+targetFile);
				BufferedReader bufreader = new BufferedReader(reader);
				String line = null;
				while((line = bufreader.readLine()) != null) {
					System.out.println(line);
				}
				bufreader.close();
				reader.close();    				
			}
        	catch(IOException e) {
        		System.out.println("File not found!");
        	}
        	finally {
        		System.exit(0);
        	}*/
		} else {
			System.out.println("File not found!");
		}
	}
}
