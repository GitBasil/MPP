package pencil6;

import java.awt.event.*;
import javax.swing.*;

public class Main {
	public static JTextField upperText = new JTextField();
	public static JTextField lowerText = new JTextField();
	public static JButton submitButn = new JButton();

	
	private static void addActionListener(final JButton b) {
		class SubmitListener implements ActionListener {
			public void actionPerformed(ActionEvent evt) {
				System.out.println("Got input: "+upperText.getText());
			}
		}
		b.addActionListener(new SubmitListener());
	}

	public static void main(String[] args) {
		submitButn.setText("SUBMIT");
		//submitButn.addActionListener(new SubmitListener());
		addActionListener(submitButn);		

		
		JButton clearButn = new JButton();
		clearButn.setText("CLEAR");
		clearButn.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent evt) {
											lowerText.setText("");
											System.out.println("Clearing output text area.");
										}
									});
		//the inner classes
		
		/*
		class ClearListener implements ActionListener {
			public void actionPerformed(ActionEvent evt) {
				lowerText.setText("");
				System.out.println("Clearing output text area.");
			}
		}*/
				
		System.out.println("a. Explain why these inner classes should not be made static nested classes?");
		System.out.println("Answer: static classes can not access nonstatic instance variables or\r\n" + 
				"methods from the outer class.");
		
		System.out.println("A. Situation: Your method myMethod() will make use of the inner class several times, "
				+ "but the inner class will not be needed for any other purpose.");
		System.out.println("Answer: (ii) Make it a local inner class, defined within myMethod()\n");
		System.out.println("B. Situation. Your method myMethod() will use the inner class just once, "
				+ "and it will not be referred to again; also, users of myMethod will make relatively few calls "
				+ "to myMethod().");
		System.out.println("Answer: (iii)Make it an anonymous inner class, defined within myMethod() \n");
		System.out.println("C. Situation. Your method myMethod() "
				+ "will be accessed and repeatedly called in a loop from an instance of another class.");
		System.out.println("Answer: (i) Make it a member inner class\n");
	}

}
