package prog13_2_soln;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.print.attribute.AttributeSet;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

public class sample extends JFrame {
	/**
	 * Default Serial VUID
	 */
	private static final long serialVersionUID = 1L;
	ConnectManager cm = new ConnectManager();
	private JPanel topPanel;
	private JPanel middlePanel;
	private JPanel bottomPanel,topBottomPanel,bottomBottomPanel;
	private JButton search;
	private JButton save;
	private JButton clear;
	public JTextField ID;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField SSN;
	private JTextField street;
	private JTextField city;
	private JTextField state;
	private JTextField zip;
	public JTextPane output;
	public sample() {
		initializeWindow();
		JPanel mainPanel = new JPanel();
		defineTopPanel();
		defineMiddlePanel();
		defineBottomPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(topPanel, BorderLayout.NORTH);
		mainPanel.add(middlePanel, BorderLayout.CENTER);
		mainPanel.add(bottomPanel, BorderLayout.SOUTH);
		getContentPane().add(mainPanel);
	}
	private void defineTopPanel() {
		topPanel = new JPanel();
		
		JLabel labelID = new JLabel("ID");
		labelID.setFont(makeSmallFont(labelID.getFont()));
		ID = new JTextField(12);
		JPanel IDPanel = createTextPanel(labelID, ID);
		
		JLabel labelFName = new JLabel("First Name");
		labelFName.setFont(makeSmallFont(labelFName.getFont()));
		firstName = new JTextField(12);
		JPanel fNamePanel = createTextPanel(labelFName, firstName);
		
		JLabel labelLName = new JLabel("Last Name");
		labelLName.setFont(makeSmallFont(labelLName.getFont()));
		lastName = new JTextField(12);
		JPanel lNamePanel = createTextPanel(labelLName, lastName);
		
		JLabel labelSSN = new JLabel("SSN");
		labelSSN.setFont(makeSmallFont(labelSSN.getFont()));
		SSN = new JTextField(12);
		JPanel SSNPanel = createTextPanel(labelSSN, SSN);
		
		topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		topPanel.add(IDPanel);
		topPanel.add(fNamePanel);
		topPanel.add(lNamePanel);
		topPanel.add(SSNPanel);
	}
	private void defineMiddlePanel() {
		middlePanel = new JPanel();
		JLabel labelStreet = new JLabel("Street");
		labelStreet.setFont(makeSmallFont(labelStreet.getFont()));
		street = new JTextField(12);
		JPanel streetPanel = createTextPanel(labelStreet, street);
		
		JLabel labelCity = new JLabel("City");
		labelCity.setFont(makeSmallFont(labelCity.getFont()));
		city = new JTextField(12);
		JPanel cityPanel = createTextPanel(labelCity, city);
		
		JLabel labelState = new JLabel("State");
		labelState.setFont(makeSmallFont(labelState.getFont()));
		state = new JTextField(12);
		JPanel statePanel = createTextPanel(labelState, state);
		
		JLabel labelZip = new JLabel("Zip");
		labelZip.setFont(makeSmallFont(labelZip.getFont()));
		zip = new JTextField(12);
		JPanel ZIPPanel = createTextPanel(labelZip, zip);
		
		middlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));		
		middlePanel.add(streetPanel);
		middlePanel.add(cityPanel);
		middlePanel.add(statePanel);
		middlePanel.add(ZIPPanel);
	}	
	private void defineBottomPanel() {
		bottomPanel = new JPanel();
		defineTopBottomPanel();
		defineBottomBottomPanel();
		bottomPanel.setLayout(new BorderLayout());
		bottomPanel.add(topBottomPanel, BorderLayout.NORTH);
		bottomPanel.add(bottomBottomPanel, BorderLayout.CENTER);
	}
	private void defineBottomBottomPanel() {
		bottomBottomPanel = new JPanel();
		search = new JButton("Search");
		search.addActionListener(new SearchActionListener());
		bottomBottomPanel.add(search);

		save = new JButton("Save");
		save.addActionListener(new SaveActionListener());
		bottomBottomPanel.add(save);
		
		clear = new JButton("Clear");
		clear.addActionListener(new ClearActionListener());
		bottomBottomPanel.add(clear);
	}
	private void defineTopBottomPanel() {
		topBottomPanel = new JPanel();
		output = new JTextPane();
		//output.setEditable(false);
		//output.setMargin(new Insets(5, 5, 5, 5));
		output.setPreferredSize( new Dimension(500,25));
		topBottomPanel.add(output);
	}
	class SearchActionListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) /*throws SQLException*/ {
			try {
				String ID_txt = ID.getText().trim();
				if(ID_txt.length() > 0) {
					//output.setText(ID_txt);
					Connection con = cm.getConnection();
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("SELECT P.*, A.* FROM PERSON P, ADDRESS A WHERE P.id = A.id AND P.id = '"+ID_txt+"';");
					if(rs.next()){
						firstName.setText(rs.getString("firstname").trim());
						lastName.setText(rs.getString("lastname").trim());
						SSN.setText(rs.getString("ssn").trim());
						street.setText(rs.getString("street").trim());
						city.setText(rs.getString("city").trim());
						state.setText(rs.getString("state").trim());
						zip.setText(rs.getString("zip").trim());
						//output.setText("Record Found");
						appendToPane(output, "Record Found.", Color.GREEN);
					}
					else {
						appendToPane(output,"Not records Found!", Color.RED);
					}
					stmt.close();
				} else {
					JOptionPane.showMessageDialog(null,"Please Enter ID!");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	class SaveActionListener implements ActionListener {
		public void actionPerformed(ActionEvent evt){
			try {
				String error = null;
				
				String _firstname = firstName.getText().trim();
				String _lastname  = lastName.getText().trim();
				String _ssn       = SSN.getText().trim();
				String _street    = street.getText().trim();
				String _city      = city.getText().trim();
				String _state     = state.getText().trim();
				String _zip       = zip.getText().trim();
				if(_firstname.length()==0 || _lastname.length()==0 || _ssn.length()==0 || _street.length()==0 
					|| _city.length()==0 || _state.length()==0 || _zip.length()==0) {
					error = "To perform a Save, all fields is requireds but ID not required!";
				}
				if(error==null) {
					Connection con = cm.getConnection();
					Statement stmt = con.createStatement();	
					String insertstmt = "INSERT INTO `person` SET " + 
										"	`firstname` = '"+_firstname+"', " + 
										"	`lastname` = '"+_lastname+"', " + 
										"	`ssn` = '"+_ssn+"';";
					stmt.executeUpdate(insertstmt, Statement.RETURN_GENERATED_KEYS);
					ResultSet rs = stmt.getGeneratedKeys();
					int newId = -1;
					if (rs.next()) {
						newId = rs.getInt(1);
						System.out.println("Insert Person successful. New row has id " + newId);
						Statement statementAdd = con.createStatement();
						statementAdd.executeUpdate("INSERT INTO `address` SET "+
												   "    `id` = '"+newId+"'," + 
												   "	`street` = '"+_street+"'," + 
												   "	`city`   = '"+_city+"'," + 
												   "	`state`  = '"+_state+"'," + 
												   "	`zip`    = '"+_zip+"' ");
						appendToPane(output, "Database has been updated.", Color.GREEN);
					} else{
						appendToPane(output,"Insert unsuccessful. No new row has been added.", Color.RED);
					}
				} else {
					appendToPane(output,error, Color.RED);
				}
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	class ClearActionListener implements ActionListener {
		public void actionPerformed(ActionEvent evt){
			clearFields();
		}
	}
	private void appendToPane(JTextPane tp, String msg, Color c)
    {
        StyleContext sc = StyleContext.getDefaultStyleContext();
        javax.swing.text.AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, c);

        aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Lucida Console");
        aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);

        int len = tp.getDocument().getLength();
        tp.setCaretPosition(len);
        tp.setCharacterAttributes(aset, false);
        //tp.replaceSelection(msg);
        tp.setText(msg);
    }
	private void clearFields() {
		ID.setText("");
		firstName.setText("");
		lastName.setText("");
		SSN.setText("");
		street.setText("");
		city.setText("");
		state.setText("");
		zip.setText("");
	}
	private static JPanel createTextPanel(JLabel lab, JTextField textField) {	
		JPanel top = new JPanel();
		JPanel bottom = new JPanel();
		top.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));
		bottom.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));		
		top.add(lab);
		bottom.add(textField);
		JPanel textPanel = new JPanel();
		textPanel.setLayout(new BorderLayout());
		textPanel.add(top,BorderLayout.NORTH);
		textPanel.add(bottom,BorderLayout.CENTER);
		return textPanel;
	}
	private void initializeWindow() {
		setTitle("Address FORM");		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		centerFrameOnDesktop(this);
		setResizable(true);
	}
	public static Font makeSmallFont(Font f) {
        return new Font(f.getName(), f.getStyle(), (f.getSize()-2));
    }

	public static void centerFrameOnDesktop(Component f) {
	        final int SHIFT_AMOUNT = 0;
	        Toolkit toolkit = Toolkit.getDefaultToolkit();
	        int height = toolkit.getScreenSize().height;
	        int width  = toolkit.getScreenSize().width;
	        int frameHeight = f.getSize().height;
	        int frameWidth  = f.getSize().width;
	        f.setLocation(((width-frameWidth)/2)-SHIFT_AMOUNT, (height-frameHeight)/3);
	        f.setSize(600, 300);
	}
	public static void main(String[] args){
		sample ex = new sample();
		ex.setVisible(true);
	}
}
