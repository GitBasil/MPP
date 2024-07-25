package lesson6.lecture.jlist;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 * Shows how a list model is used to provide data for a JList
 * Shows how scrollbars can be used and how to add and remove items.
 * @author pcorazza
 *
 */
public class Lists1 extends JFrame {
	private List<String> defaultList = new ArrayList<>();
	private JPanel mainPanel;
	private JPanel middlePanel;
	private JList<String> mainList;
	private JScrollPane mainScroll;
	private DefaultListModel<String> listModel = new DefaultListModel<String>();
	private JButton removeSelectedButton, addItemButton;
	private JTextField addField;
	public Lists1() {
		initializeWindow();
		initializeDefaultList();
		initializeModel(defaultList);
		defineMiddlePanel();
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(middlePanel, BorderLayout.NORTH);	
		getContentPane().add(mainPanel);
	}
	
	private void initializeWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("List Example");	
		centerFrameOnDesktop(this); 
		setResizable(false);
	}
	
	public static void centerFrameOnDesktop(Component f) {
	        //final int SHIFT_AMOUNT = 0;
	        Toolkit toolkit = Toolkit.getDefaultToolkit();
	        int height = toolkit.getScreenSize().height;
	        int width  = toolkit.getScreenSize().width;
	        int frameHeight = f.getSize().height;
	        int frameWidth  = f.getSize().width;
	        f.setLocation(((width-frameWidth)/2), (height-frameHeight)/3);    
	    }
	
	private void initializeDefaultList() {
		defaultList.add("Red");
		defaultList.add("Blue");
		defaultList.add("Yellow");
	}
	
	private void initializeModel(List<String> vals) {
		for(String s : vals){
			listModel.addElement(s);
		}
	}
		
	private void defineMiddlePanel(){
		middlePanel=new JPanel();
		middlePanel.setLayout(new BorderLayout());
		mainList = createJList();
		mainList.setFixedCellWidth(70);
		mainScroll = new JScrollPane(mainList);
		JPanel jListPanel = new JPanel();
		jListPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		jListPanel.add(mainScroll);
		
		//remove item components
		JPanel removeItemPanel = new JPanel();
		removeItemPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		removeSelectedButton = new JButton("Remove Selected");
		removeItemPanel.add(removeSelectedButton);
		
		
		//add item components
		JPanel addItemPanel = new JPanel();
		addItemPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		addItemButton = new JButton("Add Item");
		addField = new JTextField(10);
		addItemPanel.add(addItemButton);
		addItemPanel.add(addField);
		
		//arrange in middlePanel
		middlePanel.add(jListPanel, BorderLayout.NORTH);
		middlePanel.add(removeItemPanel, BorderLayout.CENTER);
		middlePanel.add(addItemPanel, BorderLayout.SOUTH);
		
		removeSelectedButton.addActionListener(new RemoveListener());
		addItemButton.addActionListener(new AddItemListener());		
	}
	
	private JList<String> createJList() {
		JList<String> ret = new JList<String>(listModel);
		ret.setVisibleRowCount(4);
		return ret;
	}
	
	class AddItemListener implements ActionListener {
		public void actionPerformed(ActionEvent evt){
			String newVal = addField.getText();
			listModel.addElement(newVal);
			addField.setText("");
			System.out.println(listModel);
			
		}
	}
	
	class RemoveListener implements ActionListener {
		public void actionPerformed(ActionEvent evt){
			List<String> selected = mainList.getSelectedValuesList();
			for(String s: selected) {
				listModel.removeElement(s);
			}
			System.out.println(listModel);
			
			/* use if list is made single-select
			String s = mainList.getSelectedValue();
			listModel.removeElement(s);
			*/			
		}
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable()
		{
			public void run() {
				Lists1 mf = new Lists1();
				mf.pack();
				mf.setVisible(true);
			}
		});
	}
	
	
	
	//////// illustrates how data model can be used for multiple presentations ////
	
	
	private static final long serialVersionUID = 3618976789175941431L;
}
