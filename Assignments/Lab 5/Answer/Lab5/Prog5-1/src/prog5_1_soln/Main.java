package prog5_1_soln;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Main extends JFrame {
	private static final long serialVersionUID = 3618976789175941431L;
	private JPanel topPanel,middlePanel,bottomPanel;
	private JTextField textField01,textField02,textField03,textField04,textField05;
	private JLabel label01,label02,label03,label04,label05;
	private JButton button;
	
	public Main() {
		initializeWindow();
		JPanel mainPanel = new JPanel();
		defineTopPanel();
		defineMiddlePanel();
		defineBottomPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(topPanel,BorderLayout.NORTH);
		mainPanel.add(middlePanel,BorderLayout.CENTER);
		mainPanel.add(bottomPanel,BorderLayout.SOUTH);
		getContentPane().add(mainPanel);
	}
	private void defineTopPanel() {
		topPanel = new JPanel();
		topPanel.setLayout(new BorderLayout());
		defineTopLeftPanel();
		defineTopCenterPanel();
		defineTopRightPanel();
	}
	private void defineTopLeftPanel() {
		textField01 = new JTextField(15);
		label01 = new JLabel("Name");
		
		JPanel topLeftPanel = new JPanel();
		topLeftPanel.setLayout(new BorderLayout());
		
		JPanel topLeftTopPanel = new JPanel();
		topLeftTopPanel.setLayout(new FlowLayout(FlowLayout.LEFT,10,0));
		topLeftTopPanel.add(label01);
		
		JPanel topLeftBottomPanel = new JPanel();
		topLeftBottomPanel.add(textField01);
		topLeftBottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT,10,0));
		
		topLeftPanel.add(topLeftTopPanel,BorderLayout.NORTH);
		topLeftPanel.add(topLeftBottomPanel,BorderLayout.SOUTH);
		topPanel.add(topLeftPanel,BorderLayout.WEST);
	}
	private void defineTopCenterPanel() {
		textField02 = new JTextField(15);
		label02 = new JLabel("Street");
		
		JPanel topCenterPanel = new JPanel();
		topCenterPanel.setLayout(new BorderLayout());
		
		JPanel topCenterTopPanel = new JPanel();
		topCenterTopPanel.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));
		topCenterTopPanel.add(label02);
		
		JPanel topCenterBottomPanel = new JPanel();
		topCenterBottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));
		topCenterBottomPanel.add(textField02);
		
		topCenterPanel.add(topCenterTopPanel,BorderLayout.NORTH);
		topCenterPanel.add(topCenterBottomPanel,BorderLayout.SOUTH);
		topPanel.add(topCenterPanel,BorderLayout.CENTER);
	}
	private void defineTopRightPanel() {
		textField03 = new JTextField(15);
		label03 = new JLabel("City");
		
		JPanel topRightPanel = new JPanel();
		topRightPanel.setLayout(new BorderLayout());
		
		JPanel topRightTopPanel = new JPanel();
		topRightTopPanel.setLayout(new FlowLayout(FlowLayout.LEFT,10,0));
		topRightTopPanel.add(label03);
		
		JPanel topRightBottomPanel = new JPanel();
		topRightBottomPanel.add(textField03);
		topRightBottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT,10,0));
		
		topRightPanel.add(topRightTopPanel,BorderLayout.NORTH);
		topRightPanel.add(topRightBottomPanel,BorderLayout.SOUTH);
		topPanel.add(topRightPanel,BorderLayout.EAST);
	}
	private void defineMiddlePanel() {
		middlePanel = new JPanel();
		middlePanel.setLayout(new BorderLayout());
		defineMiddleLeftPanel();
		defineMiddleRightPanel();
	}
	private void defineMiddleLeftPanel() {
		textField04 = new JTextField(15);
		label04 = new JLabel("State");
		
		JPanel middleLeftPanel = new JPanel();
		middleLeftPanel.setLayout(new BorderLayout());
		
		JPanel mLeftTopPanel = new JPanel();
		mLeftTopPanel.setLayout(new FlowLayout(FlowLayout.LEFT,50,0));
		mLeftTopPanel.add(label04);
		
		JPanel mLeftBottomPanel = new JPanel();
		mLeftBottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT,50,0));
		mLeftBottomPanel.add(textField04);
		
		middleLeftPanel.add(mLeftTopPanel,BorderLayout.NORTH);
		middleLeftPanel.add(mLeftBottomPanel,BorderLayout.SOUTH);
		middlePanel.add(middleLeftPanel,BorderLayout.WEST);
	}
	private void defineMiddleRightPanel() {
		textField05 = new JTextField(15);
		label05 = new JLabel("Zip");
		
		JPanel middleRightPanel = new JPanel();
		middleRightPanel.setLayout(new BorderLayout());
		
		JPanel mRightTopPanel = new JPanel();
		mRightTopPanel.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		mRightTopPanel.add(label05);
		
		JPanel mRightBottomPanel = new JPanel();
		mRightBottomPanel.add(textField05);
		mRightBottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		
		middleRightPanel.add(mRightTopPanel,BorderLayout.NORTH);
		middleRightPanel.add(mRightBottomPanel,BorderLayout.SOUTH);
		middlePanel.add(middleRightPanel,BorderLayout.CENTER);
	}
	private void defineBottomPanel() {
		bottomPanel = new JPanel();
		bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
		button = new JButton();
		button.setText("Submit");
		button.addActionListener(new MyButtonListener());
		bottomPanel.add(button);
	}
	class MyButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent evt){;
			System.out.print(textField01.getText()+"\n"+
		                     textField02.getText()+"\n"+
		                     textField03.getText()+", "+
		                     textField04.getText()+" "+textField05.getText());
		}
	}
	private void initializeWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Address Form");
		setSize(520,155);
		//pack();
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
	public static void main(String[] args) {
		Main frame = new Main();
		frame.setVisible(true);
	}
}