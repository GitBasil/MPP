package prog6_3_soln;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;

import javax.swing.*;

public class Main extends JFrame {
	private static final long serialVersionUID = 361897678917594143L;
	JPanel leftPanel,rightPanel;
	JTextField txtInput,txtOutput;
	JButton btnCount,btnReverse,btnRemoveDuplicate;
	JLabel lblInput,lblOutput;
	Main() {
		initializeWindow();
		JPanel mainPanel = new JPanel();
		defineLeftPanel();
		defineRightPanel();
		mainPanel.setLayout(new BorderLayout(0,0));
		mainPanel.add(leftPanel,BorderLayout.WEST);
		mainPanel.add(rightPanel,BorderLayout.EAST);
		getContentPane().add(mainPanel);
	}
	private void defineLeftPanel() {
		btnCount = new JButton();
		btnCount.setText("Count Letters");
		btnCount.setPreferredSize(new Dimension(140, 25));
		//btnCount.addActionListener(new CountListener());
		btnCount.addActionListener(
				evt-> {
					String inputText = Integer.toString(txtInput.getText().length());
					txtOutput.setText(inputText);
				}
			);
		
		btnReverse = new JButton();
		btnReverse.setText("Reverse Letters");
		btnReverse.setPreferredSize(new Dimension(140, 25));
		//btnReverse.addActionListener(new ReverseListener());
		btnReverse.addActionListener(
				evt-> {
					String inputText = txtInput.getText();
					String reverseLetter = "";
					for(int i = inputText.length()-1;i >= 0;--i) {
						reverseLetter += inputText.charAt(i);
					}
					txtOutput.setText(reverseLetter);
				}
			);
		
		
		btnRemoveDuplicate = new JButton();
		btnRemoveDuplicate.setText("Remove Duplicates");
		btnRemoveDuplicate.setPreferredSize(new Dimension(140, 25));
		//btnRemoveDuplicate.addActionListener(new RemoveDuplicateListener());
		btnRemoveDuplicate.addActionListener(
					evt-> {
						String inputText = txtInput.getText().toLowerCase();
						String cleanLetter = "";
						boolean duplicate;
						for(int i = 0;i < inputText.length();i++) {
							duplicate = false;
							for(int j = 0;j < cleanLetter.length();j++) {					
								if(cleanLetter.charAt(j) == inputText.charAt(i)) {
									duplicate = true;
									break;
								}
							}
							if(! duplicate) {
								cleanLetter += inputText.charAt(i);
							}
						}
						txtOutput.setText(cleanLetter);
					}
				);
		
		JPanel topLeftPanel = new JPanel();
		topLeftPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		topLeftPanel.add(btnCount);
		
		JPanel middleLeftPanel = new JPanel();
		middleLeftPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		middleLeftPanel.add(btnReverse);
		
		JPanel bottomLeftPanel = new JPanel();
		bottomLeftPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		bottomLeftPanel.add(btnRemoveDuplicate);
		
		leftPanel = new JPanel();
		leftPanel.setLayout(new BorderLayout(0,0));
		leftPanel.setPreferredSize(new Dimension(200, 10));
		leftPanel.add(topLeftPanel,BorderLayout.NORTH);
		leftPanel.add(middleLeftPanel,BorderLayout.CENTER);
		leftPanel.add(bottomLeftPanel,BorderLayout.SOUTH);
	}
	
	private void defineRightPanel() {
		rightPanel = new JPanel();
		rightPanel.setLayout(new BorderLayout(0,10));
		//rightPanel.setPreferredSize(new Dimension(200, 50));
		defineTopRightPanel();
		defineBottomRightPanel();
	}
	private void defineTopRightPanel() {
		txtInput = new JTextField(15);
		lblInput = new JLabel("Input");
		
		JPanel topRightPanel = new JPanel();
		topRightPanel.setLayout(new BorderLayout(0,0));
		topRightPanel.setPreferredSize(new Dimension(200,50));
		
		JPanel topRightTopPanel = new JPanel();
		topRightTopPanel.setLayout(new FlowLayout(FlowLayout.LEFT,0,5));
		//topRightTopPanel.setPreferredSize(new Dimension(200, 40));
		topRightTopPanel.add(lblInput);
		
		JPanel mRightBottomPanel = new JPanel();
		mRightBottomPanel.add(txtInput);
		mRightBottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		
		topRightPanel.add(topRightTopPanel,BorderLayout.NORTH);
		topRightPanel.add(mRightBottomPanel,BorderLayout.CENTER);
		rightPanel.add(topRightPanel,BorderLayout.NORTH);
	}
	private void defineBottomRightPanel() {
		txtOutput = new JTextField(15);
		lblOutput = new JLabel("Output");
		
		JPanel bottomRightPanel = new JPanel();
		bottomRightPanel.setLayout(new BorderLayout(0,0));
		bottomRightPanel.setPreferredSize(new Dimension(200, 40));
		
		JPanel topRightBottomPanel = new JPanel();
		topRightBottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		topRightBottomPanel.add(lblOutput);
		
		JPanel bottomRightBottomPanel = new JPanel();
		bottomRightBottomPanel.add(txtOutput);
		bottomRightBottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		
		bottomRightPanel.add(topRightBottomPanel,BorderLayout.NORTH);
		bottomRightPanel.add(bottomRightBottomPanel,BorderLayout.CENTER);
		rightPanel.add(bottomRightPanel,BorderLayout.CENTER);		
	}
	private void initializeWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("String Utility");
		setSize(450,140);
		centerFrameOnDesktop(this);
		setResizable(false);
	}
	public static void centerFrameOnDesktop(Component f) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		int height = toolkit.getScreenSize().height;
		int width = toolkit.getScreenSize().width;
		int frameHeight = f.getSize().height;
		int frameWidth = f.getSize().width;
		int xpos = (width - frameWidth) / 2;
		int ypos = (height - frameHeight) / 3;
		f.setLocation(xpos, ypos);
	}
	/*
	class CountListener implements ActionListener {
		public void actionPerformed(ActionEvent evt){;
			String inputText = Integer.toString(txtInput.getText().length());
			txtOutput.setText(inputText);
		}
	}
	class ReverseListener implements ActionListener {
		public void actionPerformed(ActionEvent evt){;
			String inputText = txtInput.getText();
			String reverseLetter = "";
			for(int i = inputText.length()-1;i >= 0;--i) {
				reverseLetter += inputText.charAt(i);
			}
			txtOutput.setText(reverseLetter);
		}
	}
	class RemoveDuplicateListener implements ActionListener {
		public void actionPerformed(ActionEvent evt){;
			String inputText = txtInput.getText().toLowerCase();
			String cleanLetter = "";
			boolean duplicate;
			for(int i = 0;i < inputText.length();i++) {
				duplicate = false;
				for(int j = 0;j < cleanLetter.length();j++) {					
					if(cleanLetter.charAt(j) == inputText.charAt(i)) {
						duplicate = true;
						break;
					}
				}
				if(! duplicate) {
					cleanLetter += inputText.charAt(i);
				}
			}
			txtOutput.setText(cleanLetter);
		}
	}*/
	public static void main(String[] args) {
		Main frame = new Main();
		frame.setVisible(true);
	}
}