package librarysystem;

import business.ControllerInterface;
import business.SystemController;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Collections;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class LibrarySystem extends JFrame implements LibWindow {
	ControllerInterface ci = new SystemController();
	public final static LibrarySystem INSTANCE = new LibrarySystem();
	JPanel mainPanel;
	JPanel middleHalf;
	JPanel middlePanel;
	JMenuBar menuBar;
	JMenu options, members, books;
	JMenuItem login, allBookIds, allMemberIds, OverdueBooks, addMember, addBook, listMembers, listBooks,
			checkOut, searchForMember;
	String pathToImage;
	private boolean isInitialized = false;

	private static LibWindow[] allWindows = {
			LibrarySystem.INSTANCE,
			LoginWindow.INSTANCE,
			AllMemberIdsWindow.INSTANCE,
			AllBookIdsWindow.INSTANCE,
			OverdueBooksWindow.INSTANCE,
			AddMemberWindow.INSTANCE,
			AddBookWindow.INSTANCE,
			CheckOutWindow.INSTANCE,
			SearchMemberWindow.INSTANCE,

	};

	public static void hideAllWindows() {
		for (LibWindow frame : allWindows) {
			frame.setVisible(false);
		}
	}

	private LibrarySystem() {
	}

	public void init() {

		formatContentPane();
		setPathToImage();
		mainPanel.setLayout(new BorderLayout());
		insertSplashImage();
		createMenus();
		// pack();
		setSize(660, 500);
		isInitialized = true;
	}

	private void formatContentPane() {
		mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(1, 1));
		getContentPane().add(mainPanel);
	}

	private void setPathToImage() {
		pathToImage = System.getProperty("user.dir")
				+ File.separator + "src" + File.separator + "librarysystem" + File.separator + "library.jpg";
	}

	private void insertSplashImage() {
		ImageIcon image = new ImageIcon(pathToImage);
		mainPanel.add(new JLabel(image));
	}

	private void createMenus() {
		menuBar = new JMenuBar();
		menuBar.setBorder(BorderFactory.createRaisedBevelBorder());
		addMenuItems();
		setJMenuBar(menuBar);
	}

	private void addMenuItems() {
		options = new JMenu("Options");
		menuBar.add(options);
		login = new JMenuItem("Login");
		login.addActionListener(new LoginListener());
		allBookIds = new JMenuItem("All Book Ids");
		allBookIds.addActionListener(new AllBookIdsListener());
		allMemberIds = new JMenuItem("All Member Ids");
		allMemberIds.addActionListener(new AllMemberIdsListener());

		options.add(login);

		// basil
		books = new JMenu("Books");
		addBook = new JMenuItem("Add New Book");
		addBook.addActionListener(new AddBookListener());
		listBooks = new JMenuItem("List All Books");
		listBooks.addActionListener(new AllBookIdsListener());
		OverdueBooks = new JMenuItem("Overdue Books");
		OverdueBooks.addActionListener(new OverdueBooksListener());
		checkOut = new JMenuItem("Checkout Books");
		checkOut.addActionListener(new CheckOutListener());
		
		books.add(addBook);
		books.add(checkOut);
		books.add(OverdueBooks);
		books.add(listBooks);
		menuBar.add(books);
		
		members = new JMenu("Members");
		addMember = new JMenuItem("Add New Member");
		addMember.addActionListener(new AddMemberListener());
		listMembers = new JMenuItem("List All Members");
		listMembers.addActionListener(new AllMemberIdsListener());
		searchForMember = new JMenuItem("Search For Member");
		searchForMember.addActionListener(new SearchForMemberListener());
		menuBar.add(members);
		members.add(addMember);
		members.add(searchForMember);
		members.add(listMembers);

		menuBar.add(members);
	}

	public void disableLoginMenuItem() {
		login.setText("Logout");
	}

	class LoginListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (SystemController.currentAuth != null) {
				SystemController.currentAuth = null;
				login.setText("Login");
			} else {
				LibrarySystem.hideAllWindows();
				LoginWindow.INSTANCE.init();
				Util.centerFrameOnDesktop(LoginWindow.INSTANCE);
				LoginWindow.INSTANCE.setVisible(true);
				resetTextFields(LoginWindow.INSTANCE);
			}

		}

	}

	class AddMemberListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			SystemController sc = new SystemController();
			if (ci.checkAddMemberAuth()) {
				LibrarySystem.hideAllWindows();
				AddMemberWindow.INSTANCE.init();
				Util.centerFrameOnDesktop(AddMemberWindow.INSTANCE);
				AddMemberWindow.INSTANCE.setVisible(true);
				AddMemberWindow.INSTANCE.setSize(500, 500);
				AddMemberWindow.INSTANCE.setTitle("Add New Member");

				// System.out.println(SystemController.currentAuth);
				// Reset All Fields in Window
				resetTextFields(AddMemberWindow.INSTANCE);
			} else {
				JOptionPane.showMessageDialog(LibrarySystem.INSTANCE,
						"Oooops... You don't have permissions to access this feature!");
			}

		}
	}

	class AddBookListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			SystemController sc = new SystemController();
			if (ci.checkAddBookAuth()) {
				LibrarySystem.hideAllWindows();
				AddBookWindow.INSTANCE.init();
				Util.centerFrameOnDesktop(AddBookWindow.INSTANCE);
				AddBookWindow.INSTANCE.setVisible(true);
				AddBookWindow.INSTANCE.setSize(700, 500);
				AddBookWindow.INSTANCE.setTitle("Add New Book");

				// Reset All Fields in Window
				resetTextFields(AddBookWindow.INSTANCE);
			} else {
				JOptionPane.showMessageDialog(LibrarySystem.INSTANCE,
						"Oooops... You don't have permissions to access this feature!");
			}
		}
	}

	public void resetTextFields(Container container) {
		// Container container = mainPanel;
		for (Component component : container.getComponents()) {
			if (component instanceof JTextField) {
				((JTextField) component).setText("");
			} else if (component instanceof Container) {
				resetTextFields((Container) component);
			}
		}
	}

	class AllBookIdsListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			LibrarySystem.hideAllWindows();
			AllBookIdsWindow.INSTANCE.init();

			List<String> ids = ci.allBookIds();
			Collections.sort(ids);
			StringBuilder sb = new StringBuilder();
			for (String s : ids) {
				sb.append(s + "\n");
			}
			System.out.println(sb.toString());
			AllBookIdsWindow.INSTANCE.setData(sb.toString());
			AllBookIdsWindow.INSTANCE.pack();
			// AllBookIdsWindow.INSTANCE.setSize(660,500);
			Util.centerFrameOnDesktop(AllBookIdsWindow.INSTANCE);
			AllBookIdsWindow.INSTANCE.setVisible(true);

		}

	}

	class AllMemberIdsListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			LibrarySystem.hideAllWindows();
			AllMemberIdsWindow.INSTANCE.init();
			AllMemberIdsWindow.INSTANCE.pack();
			AllMemberIdsWindow.INSTANCE.setVisible(true);

			LibrarySystem.hideAllWindows();
			AllBookIdsWindow.INSTANCE.init();

			List<String> ids = ci.allMemberIds();
			Collections.sort(ids);
			StringBuilder sb = new StringBuilder();
			for (String s : ids) {
				sb.append(s + "\n");
			}
			System.out.println(sb.toString());
			AllMemberIdsWindow.INSTANCE.setData(sb.toString());
			AllMemberIdsWindow.INSTANCE.pack();
			// AllMemberIdsWindow.INSTANCE.setSize(660,500);
			Util.centerFrameOnDesktop(AllMemberIdsWindow.INSTANCE);
			AllMemberIdsWindow.INSTANCE.setVisible(true);

		}

	}

	class SearchForMemberListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (ci.checkAddMemberAuth()) {
				LibrarySystem.hideAllWindows();
				SearchMemberWindow.INSTANCE.init();
				Util.centerFrameOnDesktop(CheckOutWindow.INSTANCE);
				SearchMemberWindow.INSTANCE.setVisible(true);
			} else {
				Util.showErrorMessage(LibrarySystem.INSTANCE,
						"Oooops... You don't have permissions to access this feature!");
			}
		}

	}

	class LogOutListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			SystemController.currentAuth = null;
			LibrarySystem.INSTANCE.init();
			LibrarySystem.hideAllWindows();
			LoginWindow.INSTANCE.init();
			Util.centerFrameOnDesktop(LoginWindow.INSTANCE);
			LoginWindow.INSTANCE.setVisible(true);
		}

	}

	class OverdueBooksListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			LibrarySystem.hideAllWindows();
			OverdueBooksWindow.INSTANCE.init();
			Util.centerFrameOnDesktop(OverdueBooksWindow.INSTANCE);
			OverdueBooksWindow.INSTANCE.setVisible(true);
		}

	}

	class CheckOutListener implements ActionListener {
		@Override

		public void actionPerformed(ActionEvent e) {
			if (ci.checkAddMemberAuth()) {
				LibrarySystem.hideAllWindows();
				CheckOutWindow.INSTANCE.init();
				Util.centerFrameOnDesktop(CheckOutWindow.INSTANCE);
				CheckOutWindow.INSTANCE.setVisible(true);
			} else {
				Util.showErrorMessage(LibrarySystem.INSTANCE,
						"Oooops... You don't have permissions to access this feature!");
			}
		}
	}

	@Override
	public boolean isInitialized() {
		return isInitialized;
	}

	@Override
	public void isInitialized(boolean val) {
		isInitialized = val;

	}

}
