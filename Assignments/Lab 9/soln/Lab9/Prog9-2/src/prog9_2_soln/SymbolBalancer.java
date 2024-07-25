package prog9_2_soln;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class SymbolBalancer {
	String ODD_DELIMITER = ""+(char)0;
	String filename;
	String text;
	char[] left;
	char[] right;
	public SymbolBalancer(String filename) {
		this.filename = filename;
		readFile();
	}
	public void setText(String text) {
		this.text = text;
	}
	
	boolean symbolsBalanced(String delimiters){
		Stack<Character> stk = new Stack<Character>();
		if(text == null || text.length() == 0) {
			return false;
		} else {    
			for(int i = 0; i < text.length(); i++) {
				if(text.charAt(i) == '(' || text.charAt(i) == '{' || text.charAt(i) == '[' ) {
	        		stk.push(text.charAt(i));
				} else if(text.charAt(i) == ')') {
					 if(!stk.isEmpty() && stk.peek() == '(') {
						  stk.pop();
					 } else {
						  return false;
					 }
				} else if(text.charAt(i) == ']') {
	               if(!stk.isEmpty() && stk.peek() == '[') {
	                  stk.pop();
	              } else {
	                  return false;
	              }
	          } else if(text.charAt(i) == '}') {
	              if(!stk.isEmpty() && stk.peek() == '{') {
	                  stk.pop();
	              } else {
	                  return false;
	              }
	          }
	        }
	 
	        // if stack is empty finally , it means symbol is balance in expression
	        if(stk.isEmpty()) {
	            return true;
	        } else {
	            return false;
	        }
	    }
	}
	
	public static void main(String[] args) {
		SymbolBalancer sb = new SymbolBalancer("prog9_2_soln\\Employee.java");
		System.out.println(sb.symbolsBalanced("[]{}<>()||"));
	}
	
	void readFile() {
		String prefix = System.getProperty("user.dir") + "\\src\\";
		try {
			Scanner sc = new Scanner(new File(prefix + filename));
			sc.useDelimiter(ODD_DELIMITER);
			text = sc.next();
			System.out.println(text);
			sc.close();
		}
		catch(FileNotFoundException ex) {
			System.err.println("File Not Found Exception "+ex.getMessage());
		}
	}	
}