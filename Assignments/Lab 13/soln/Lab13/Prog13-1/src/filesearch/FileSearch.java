package filesearch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
//PSEUDO-CODE
boolean searchForFile(Object file, Object startDir) {
	Object[] fileSystemObjects =
						startDir.getContents();
	for(Object o: fileSystemObjects) {
		//base case
		if(isFile(o) && isSameFile(o,f)) {
			return true;
		}

		if(isDirectory(o)) {
			searchForFile(file, o);
		}
	}
	//file not found in startDir
	return false;
}
*/
public class FileSearch {
	static boolean found = false;
	//Store the text that is found in the
	//file that is found in this String variable
	static String discoveredText = null;
	
	public static boolean searchForFile(String filename, String startDir) {
		File folder = new File(startDir);		
		for (File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	        	searchForFile(filename,fileEntry.toString());
	        } else {
	            if(fileEntry.getName().equals(filename)) {
	            	found = true;
	            	try {
	    				FileReader reader = new FileReader(fileEntry);
	    				BufferedReader bufreader = new BufferedReader(reader);
	    				String line = null;
	    				while((line = bufreader.readLine()) != null) {
	    					if(discoveredText == null)
	    						discoveredText = line;
	    					else 
	    						discoveredText += line;
	    				}
	    				bufreader.close();
	    				reader.close();    				
	    			}
	            	catch(IOException e) {
	            		e.printStackTrace();
	            	}
	            }
	        }
	    }
		return found;		
	}	
}
