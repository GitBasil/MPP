package librarysystem;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import business.CheckoutRecordEntry;
import business.LibraryMember;
import business.SystemController;

public class SearchMemberWindow extends JFrame implements LibWindow {
    public static final SearchMemberWindow INSTANCE = new SearchMemberWindow();

    private boolean isInitialized = false;

    private JPanel mainPanel;
    private JPanel upperHalf;
    private JPanel lowerHalf;
    private JTextField memberIdField;
    private JTable resultTable;
    private DefaultTableModel tableModel;
    private static final String[] COLUMN_NAMES = { "Book Title", "Checkout Date", "Return Date" };

    public boolean isInitialized() {
        return isInitialized;
    }

    public void isInitialized(boolean val) {
        isInitialized = val;
    }

    private JTextField messageBar = new JTextField();

    /* This class is a singleton */
    private SearchMemberWindow() {
    }

    public void init() {
        if (isInitialized) {
            clear();
            return;
        }
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        defineUpperHalf();
        defineLowerHalf();
        defineResultTable();

        mainPanel.add(upperHalf, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(resultTable), BorderLayout.CENTER);
        mainPanel.add(lowerHalf, BorderLayout.SOUTH);

        getContentPane().add(mainPanel);
        isInitialized(true);
        pack();
    }

    private void defineUpperHalf() {
        upperHalf = new JPanel();
        upperHalf.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel memberIdLabel = new JLabel("Member ID:");
        memberIdField = new JTextField(15);
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(e -> searchMember());
        JButton printButton = new JButton("Print Checkout Record");
        printButton.addActionListener(e -> printCheckoutRecord());

        upperHalf.add(memberIdLabel);
        upperHalf.add(memberIdField);
        upperHalf.add(searchButton);
        upperHalf.add(printButton);
    }

    private void defineLowerHalf() {
        lowerHalf = new JPanel();
        lowerHalf.setLayout(new FlowLayout(FlowLayout.LEFT));
        JButton backButton = new JButton("<= Back to Main");
        backButton.addActionListener(e -> {
            LibrarySystem.hideAllWindows();
            LibrarySystem.INSTANCE.setVisible(true);
        });

        lowerHalf.add(backButton);
    }

    private void searchMember() {
        String memberId = memberIdField.getText().trim();
        if (memberId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Member ID field cannot be empty");
            return;
        }

        LibraryMember member = new SystemController().searchMember(memberId);
        tableModel.setRowCount(0); // Clear previous results

        if (member != null) {
            for (CheckoutRecordEntry record : member.getCheckoutRecord().getEntries()) {
                tableModel.addRow(new Object[] {
                        record.getBookCopy().getBook().getTitle(),
                        record.getCheckoutDate(),
                        record.getDueDate()
                });
            }
        } else {
            JOptionPane.showMessageDialog(this, "No member found with ID: " + memberId);
        }
    }

    private void printCheckoutRecord() {
        String memberId = memberIdField.getText().trim();
        if (memberId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Member ID field cannot be empty");
            return;
        }

        LibraryMember member = new SystemController().searchMember(memberId);

        if (member != null) {
            System.out.println("Checkout Record for " + member.getFirstName() + " " + member.getLastName() + ":");
            System.out.printf("%-20s %-15s %-15s\n", "Book Title", "Checkout Date", "Return Date");
            for (CheckoutRecordEntry record : member.getCheckoutRecord().getEntries()) {
                System.out.println(record.toString());
            }
        } else {
            System.out.println("No member found with ID: " + memberId);
        }
    }

    public void clear() {
        memberIdField.setText("");
        tableModel.setRowCount(0);
    }

    private void defineResultTable() {
        tableModel = new DefaultTableModel(COLUMN_NAMES, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        resultTable = new JTable(tableModel);
    }

}