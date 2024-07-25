package lesson6.lecture.splitpane;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;


import java.awt.FlowLayout;
import java.util.ArrayList;

/**
 * This sample code illustrate several Swing techniques:
 * 
 * 1. Use of split panes
 * 2. Using the CardLayout to switch the view to different panels in the same space
 * 3. Using a JList to control the CardLayout
 * 
 * 
 * @author corazza
 *
 */
public class SampleFrame extends JFrame {
	
	JList<String> linkList;
	//context for CardLayout
	JPanel cards;

	public SampleFrame() {
		setSize(300, 200);
		String[] items = {"Item 1", "Item 2", "Item 3"};
		linkList = new JList<String>(items);				
		createPanels();	
		// set up split panes
		JSplitPane splitPane = new JSplitPane(
			JSplitPane.HORIZONTAL_SPLIT, linkList, cards);
		splitPane.setDividerLocation(50);
		//default layout for JFrame is BorderLayout; add method 
		//adds to contentpane
		add(splitPane, BorderLayout.CENTER);
	}
	
	/* Organize panels into a CardLayout */
	public void createPanels() {
		JPanel[] panel=new JPanel[3];
		cards = new JPanel(new CardLayout());
		for(int i=0;i<3;i++)
        {
        	panel[i]=new JPanel();
			panel[i].add(new JLabel("Item "+(i+1)+" Panel"));
        	cards.add(panel[i], String.valueOf(i+1));
        }
		//connect JList elements to CardLayout panels
		linkList.addListSelectionListener(event -> {
			Integer v = linkList.getSelectedIndex();
			//String value = linkList.getSelectedValue().toString();
			CardLayout cl = (CardLayout) (cards.getLayout());
			cl.show(cards, String.valueOf(v+1));
		});

	}
	private static final long serialVersionUID = -760156396736751840L;
	
}
