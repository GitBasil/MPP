package librarysystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import business.Book;
import business.BookCopy;
import business.CheckoutRecord;
import business.CheckoutRecordEntry;
import business.LibraryMember;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;

public class CheckOutWindow extends JFrame implements LibWindow {
    public static final CheckOutWindow INSTANCE = new CheckOutWindow();

    private boolean isInitialized = false;

    private JPanel mainPanel;
    private JPanel upperHalf;
    private JPanel middleHalf;
    private JPanel lowerHalf;

    private JPanel topPanel;
    private JPanel middlePanel;
    private JPanel lowerPanel;
    private JPanel leftTextPanel;
    private JPanel rightTextPanel;

    private JTextField memberIdField;
    private JTextField isbnField;
    private JTable checkoutTable;
    private DefaultTableModel tableModel;
    private JLabel label;
    private JButton checkoutButton;

    public boolean isInitialized() {
        return isInitialized;
    }

    public void isInitialized(boolean val) {
        isInitialized = val;
    }

    private JTextField messageBar = new JTextField();

    public void clear() {
        messageBar.setText("");
        memberIdField.setText("");
        isbnField.setText("");
    }

    /* This class is a singleton */
    private CheckOutWindow() {
    }

    public void init() {
        if (isInitialized) {
            clear();
            return;
        }
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
        middleHalf.add(s, BorderLayout.SOUTH);
        DataAccess da = new DataAccessFacade();
        List<LibraryMember> memberList = new ArrayList<>(da.readMemberMap().values());
        tableModel = new DefaultTableModel(
                new Object[] { "Member ID", "ISBN", "Book Title", "Checkout Date", "Due Date" }, 0);
        for (int i = 0; i < memberList.size(); i++) {
            final LibraryMember mem = memberList.get(i);
            String memberId = mem.getMemberId();
            final CheckoutRecord record = mem.getCheckoutRecord();
            for (CheckoutRecordEntry entry : record.getEntries()) {
                String checkoutDate = entry.getCheckoutDate().toString();
                String dueDate = entry.getDueDate().toString();
                String bookTitle = entry.getBookCopy().getBook().getTitle();
                String isbn = entry.getBookCopy().getBook().getIsbn();
                tableModel.addRow(new Object[] { memberId, isbn, bookTitle, checkoutDate, dueDate });
            }
        }
        checkoutTable = new JTable(tableModel);
        checkoutTable.setEnabled(false); // Make table read-only
        middleHalf.add(new JScrollPane(checkoutTable), BorderLayout.CENTER);
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
        intPanel.add(Box.createRigidArea(new Dimension(0, 20)), BorderLayout.NORTH);
        JLabel checkoutLabel = new JLabel("Checkout");
        Util.adjustLabelFont(checkoutLabel, Color.BLUE.darker(), true);
        intPanel.add(checkoutLabel, BorderLayout.CENTER);
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        topPanel.add(intPanel);
    }

    private void defineMiddlePanel() {
        middlePanel = new JPanel();
        middlePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        defineLeftTextPanel();
        defineRightTextPanel();
        middlePanel.add(leftTextPanel);
        middlePanel.add(rightTextPanel);
    }

    private void defineLowerPanel() {
        lowerPanel = new JPanel();
        checkoutButton = new JButton("Checkout");
        addCheckoutButtonListener(checkoutButton);
        lowerPanel.add(checkoutButton);
    }

    private void defineLeftTextPanel() {
        JPanel topText = new JPanel();
        JPanel bottomText = new JPanel();
        topText.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
        bottomText.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));

        memberIdField = new JTextField(10);
        label = new JLabel("Member ID");
        label.setFont(Util.makeSmallFont(label.getFont()));
        topText.add(memberIdField);
        bottomText.add(label);

        leftTextPanel = new JPanel();
        leftTextPanel.setLayout(new BorderLayout());
        leftTextPanel.add(topText, BorderLayout.NORTH);
        leftTextPanel.add(bottomText, BorderLayout.CENTER);
    }

    private void defineRightTextPanel() {
        JPanel topText = new JPanel();
        JPanel bottomText = new JPanel();
        topText.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
        bottomText.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));

        isbnField = new JTextField(10);
        label = new JLabel("ISBN");
        label.setFont(Util.makeSmallFont(label.getFont()));
        topText.add(isbnField);
        bottomText.add(label);

        rightTextPanel = new JPanel();
        rightTextPanel.setLayout(new BorderLayout());
        rightTextPanel.add(topText, BorderLayout.NORTH);
        rightTextPanel.add(bottomText, BorderLayout.CENTER);
    }

    private void addBackButtonListener(JButton butn) {
        butn.addActionListener(evt -> {
            LibrarySystem.hideAllWindows();
            LibrarySystem.INSTANCE.setVisible(true);
        });
    }

    private void addCheckoutButtonListener(JButton butn) {
        butn.addActionListener(evt -> {
            String memberId = memberIdField.getText().trim();
            String isbn = isbnField.getText().trim();
            System.out.println("memberId :" + memberId);
            if (memberId.isEmpty() || isbn.isEmpty()) {
                JOptionPane.showMessageDialog(CheckOutWindow.this, "Please enter both Member ID and ISBN.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            DataAccess da = new DataAccessFacade();
            final LibraryMember member = da.searchMember(memberId);
            if (member == null) {
                Util.showErrorMessage(CheckOutWindow.this, "Invalid Member ID.");
                return;
            }

            final Book book = da.searchBook(isbn);
            if (book == null) {
                Util.showErrorMessage(CheckOutWindow.this, "Invalid ISBN.");
                return;
            }

            if (!book.isAvailable()) {
                Util.showErrorMessage(CheckOutWindow.this, "No Copies Available.");
                return;
            }

            final BookCopy bookCopy = book.getNextAvailableCopy();
            final int maxCheckoutLength = book.getMaxCheckoutLength();

            String bookTitle = book.getTitle();
            LocalDate checkoutDate = LocalDate.now();
            LocalDate dueDate = checkoutDate.plusDays(maxCheckoutLength);

            member.checkOut(bookCopy, checkoutDate, dueDate);
            book.updateCopies(bookCopy);
            da.saveNewMember(member);
            da.saveBook(book);

            tableModel.addRow(new Object[] { memberId, isbn, bookTitle, checkoutDate, dueDate });
            JOptionPane.showMessageDialog(CheckOutWindow.this, "Book checked out successfully", "Success",
                    JOptionPane.INFORMATION_MESSAGE);
        });
    }
}