package librarysystem;

import business.Address;
import business.CheckoutRecord;
import business.ControllerInterface;
import business.LibraryMember;
import business.SystemController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Collections;
import java.util.List;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class AddMemberWindow extends JFrame implements LibWindow {
    public static final AddMemberWindow INSTANCE = new AddMemberWindow();
	ControllerInterface ci = new SystemController();
	private boolean isInitialized = false;
	
	private JPanel mainPanel;
	private JPanel upperHalf;
	private JPanel middleHalf;
	private JPanel lowerHalf;
	private JPanel container;
	
	private JPanel topPanel;
	private JPanel middlePanel;
	private JPanel lowerPanel;
	private JPanel leftTextPanel;
	private JPanel rightTextPanel;
	private JPanel addressPanel;
	
	// private JTextField username;
	// private JTextField password;
	// 
	// private JButton loginButton;
	// private JButton logoutButton;

	//Add New Member Form Items
	private JLabel label;
	private JLabel titleLabel;
	private JTextField firstname;
	private JTextField lastname;
	private Address address;
	private JTextField tel;
	private JTextField zip;
	private JTextField city;
	private JTextField state;	
	private JTextField street;
	private JButton addMemberButton;
	private JButton cancelButton;
	private JButton addAddressButton;
	
	
	
	public boolean isInitialized() {
		return isInitialized;
	}
	public void isInitialized(boolean val) {
		isInitialized = val;
	}
	private JTextField messageBar = new JTextField();
	public void clear() {
		messageBar.setText("");
	}
	
	/* This class is a singleton */
    private AddMemberWindow () {}
    
    public void init() {
		if(!isInitialized()){
			mainPanel = new JPanel();
    		defineUpperHalf();
    		defineMiddleHalf();
    		defineLowerHalf();
    		BorderLayout bl = new BorderLayout();
    		bl.setVgap(30);
    		mainPanel.setLayout(bl);
    					
    		mainPanel.add(upperHalf, BorderLayout.NORTH);
    		mainPanel.add(middleHalf, BorderLayout.CENTER);
    		mainPanel.add(lowerHalf, BorderLayout.SOUTH);
			
    		getContentPane().add(mainPanel);
    		isInitialized(true);
    		pack();
    		//setSize(660, 500);
		}
    	
    }
    private void defineUpperHalf() {
    		
    		upperHalf = new JPanel();
    		upperHalf.setLayout(new BorderLayout());
    		defineTopPanel();
    		defineMiddlePanel();
    		defineLowerPanel();
    		upperHalf.add(topPanel, BorderLayout.NORTH);
    		upperHalf.add(middlePanel, BorderLayout.CENTER);
    		upperHalf.add(lowerPanel, BorderLayout.SOUTH);
    		
    	}
    	private void defineMiddleHalf() {
    		middleHalf = new JPanel();
    		middleHalf.setLayout(new BorderLayout());
    		JSeparator s = new JSeparator();
    		s.setOrientation(SwingConstants.HORIZONTAL);
    		//middleHalf.add(Box.createRigidArea(new Dimension(0,50)));
    		middleHalf.add(s, BorderLayout.SOUTH);
    		
    	}
    	private void defineLowerHalf() {

    		lowerHalf = new JPanel();
    		lowerHalf.setLayout(new FlowLayout(FlowLayout.LEFT));
    		
    		JButton backButton = new JButton("<= Back to Main");
    		addBackButtonListener(backButton);
    		lowerHalf.add(backButton);
    		
    	}
    	private void defineTopPanel() {
    		topPanel = new JPanel();
    		JPanel intPanel = new JPanel(new BorderLayout());
    		intPanel.add(Box.createRigidArea(new Dimension(0,20)), BorderLayout.NORTH);
    		JLabel loginLabel = new JLabel("Login");
    		Util.adjustLabelFont(loginLabel, Color.BLUE.darker(), true);
    		intPanel.add(loginLabel, BorderLayout.CENTER);
    		topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    		topPanel.add(intPanel);
    	}
    	
    	private void defineMiddlePanel() {
    		middlePanel=new JPanel();
    		middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.Y_AXIS));		
    		defineLeftTextPanel();
    		defineRightTextPanel();
			defineAddressPanel();


    		middlePanel.add(leftTextPanel);
    		middlePanel.add(rightTextPanel);
			middlePanel.add(addressPanel);
    	}

		private void defineAddressPanel(){	
			addressPanel = new JPanel();
			addressPanel.setLayout(new BoxLayout(addressPanel, BoxLayout.Y_AXIS));		

			// Combine left and right panels into one horizontal panel
			JPanel rowPanel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JPanel rowPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			// City
			JPanel cityPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
			city = new JTextField(10);
			label = new JLabel("City");
			label.setFont(Util.makeSmallFont(label.getFont()));
			label.setPreferredSize(new Dimension(100, label.getPreferredSize().height));
			cityPanel.add(label);
			cityPanel.add(city);
			//addressPanel.add(cityPanel);
			rowPanel1.add(cityPanel);

			JPanel zipPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
			zip = new JTextField(10);
			label = new JLabel("ZIP");
			label.setSize(50,30);
			label.setFont(Util.makeSmallFont(label.getFont()));
			label.setPreferredSize(new Dimension(100, label.getPreferredSize().height));
			zipPanel.add(label);
			zipPanel.add(zip);
			//addressPanel.add(zipPanel);
			rowPanel1.add(zipPanel);

			// state
			JPanel statePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
			state = new JTextField(10);
			label = new JLabel("State");
			label.setFont(Util.makeSmallFont(label.getFont()));
			label.setPreferredSize(new Dimension(100, label.getPreferredSize().height));
			statePanel.add(label);
			statePanel.add(state);
			//rightTextPanel.add(statePanel);
			rowPanel2.add(statePanel);

			// Street
			JPanel streetPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
			street = new JTextField(10);
			label = new JLabel("Street");
			label.setFont(Util.makeSmallFont(label.getFont()));
			label.setPreferredSize(new Dimension(100, label.getPreferredSize().height));
			streetPanel.add(label);
			streetPanel.add(street);
			//rightTextPanel.add(streetPanel);
			rowPanel2.add(streetPanel);

			addressPanel.add(rowPanel1);
			addressPanel.add(rowPanel2);
		}

		private void defineLeftTextPanel() {
			leftTextPanel = new JPanel();
			leftTextPanel.setLayout(new BoxLayout(leftTextPanel, BoxLayout.Y_AXIS));
			
			// Combine left and right panels into one horizontal panel
			JPanel rowPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

			// First Name
			JPanel firstNamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
			firstname = new JTextField(10);
			label = new JLabel("First Name");
			label.setFont(Util.makeSmallFont(label.getFont()));
			label.setPreferredSize(new Dimension(100, label.getPreferredSize().height));
			firstNamePanel.add(label);
			firstNamePanel.add(firstname);
			rowPanel.add(firstNamePanel);

			// First Name
			JPanel lastNamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
			lastname = new JTextField(10);
			label = new JLabel("Last Name");
			label.setFont(Util.makeSmallFont(label.getFont()));
			label.setPreferredSize(new Dimension(100, label.getPreferredSize().height));
			lastNamePanel.add(label);
			lastNamePanel.add(lastname);
			rowPanel.add(lastNamePanel);

			leftTextPanel.add(rowPanel);
    	}

    	private void defineRightTextPanel() {    		
    		rightTextPanel = new JPanel();
			rightTextPanel.setLayout(new BoxLayout(rightTextPanel, BoxLayout.Y_AXIS));

			// Telephone
			JPanel telPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
			tel = new JTextField(10);
			label = new JLabel("Telephone");
			label.setFont(Util.makeSmallFont(label.getFont()));
			label.setPreferredSize(new Dimension(100, label.getPreferredSize().height));
			telPanel.add(label);
			telPanel.add(tel);
			rightTextPanel.add(telPanel);

			//Add Separator with Space after and before
			// Add spacing after separator
			rightTextPanel.add(Box.createRigidArea(new Dimension(0, 10)));

			JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
			separator.setMaximumSize(new Dimension(Integer.MAX_VALUE, 1)); // Full width
			rightTextPanel.add(separator);

			// Add spacing after separator
			rightTextPanel.add(Box.createRigidArea(new Dimension(0, 10)));
    	}
		
    	private void defineLowerPanel() {
    		lowerPanel = new JPanel();
    		addMemberButton = new JButton("Add Member");
    		addMemberButtonListener(addMemberButton);
    		lowerPanel.add(addMemberButton);

			cancelButton = new JButton("Cancel");
			cancelButtonListener(cancelButton);
			lowerPanel.add(cancelButton);
    	}
    	
    	
    	private void addBackButtonListener(JButton butn) {
    		butn.addActionListener(evt -> {
    			LibrarySystem.hideAllWindows();
    			LibrarySystem.INSTANCE.setVisible(true);
    		});
    	}
    	
    	private void addMemberButtonListener(JButton butn) {
    		butn.addActionListener(evt -> {
				SystemController sc = new SystemController();
            	try {
					String telText = tel.getText();
					String firstnameText = firstname.getText();
					String lastnameText = lastname.getText();
					String stateText = state.getText();
					String cityText = city.getText();
					String zipText = zip.getText();
					String streetText = street.getText();

					if(!telText.isEmpty() && !firstnameText.isEmpty() && !lastnameText.isEmpty() && !stateText.isEmpty() && !cityText.isEmpty() && !zipText.isEmpty() && !streetText.isEmpty()){
						//All fields filled
						address = new Address(streetText,cityText,stateText,zipText);
						int latestId = 0;
						List<String> ids = ci.allMemberIds();
						Collections.sort(ids);
						for(String s: ids) {
							if(s.isEmpty()) latestId = 0;
							else{
								int tempId = Integer.parseInt(s);
								if(latestId < tempId) latestId = tempId;
							}
						}					
						
						LibraryMember member = new LibraryMember(String.valueOf(latestId+1), firstnameText, lastnameText, telText, address,new CheckoutRecord());
						ci.addNewMember(member);
						
						JOptionPane.showMessageDialog(this, "Member added successfully...");
						LibrarySystem.hideAllWindows();
    					LibrarySystem.INSTANCE.setVisible(true);
						//System.out.println(member.toString());
					}
					else{
						JOptionPane.showMessageDialog(this, "Some fields are empty!");
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(this, "Invalid User credentials!!");
				}
    		});
    	}

    	private void cancelButtonListener(JButton butn) {
    		butn.addActionListener(evt -> {
    			LibrarySystem.hideAllWindows();
    			LibrarySystem.INSTANCE.setVisible(true);
    		});
    	}

		
}
