package Prog6;
import java.util.Arrays;
public class Prog6 {

	public static void main(String[] args) {
	}
	
	public static void removeDups(String[] words) {
		int newIndex=0;
		for(int i=0;i<words.length;i++)       
	    {
	         if(words[i]!=null)
	         {
		         for(int j=i+1;j<words.length;j++) 
		         {
		            
			         if(words[i].equals(words[j])) 
			         {
			               words[j]=null;
			         }
		         }
		         if(words[i] != null) {
		        	 newIndex++;
		         }
	         }
	    }		
		String newWords[] = new String[newIndex];
		newIndex=0;
	    for(int k=0;k<words.length;k++)    
	    {
	         if(words[k]!=null)
	         {
	        	 newWords[newIndex] = words[k];
	        	 newIndex++;
	         }     
	    }
	    System.out.printf(Arrays.toString(newWords));
	}

}
