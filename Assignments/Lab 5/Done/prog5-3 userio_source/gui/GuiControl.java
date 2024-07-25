package lesson5.userio_source.gui;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.math.BigDecimal;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.Box;
/**
 * 
 * @author klevi, pcorazza 
 * @since Oct 22, 2004
 * <p>
 * Class Description: This is a factory class that provides utilities
 * for creating various screen elements in a standardized way. Also,
 * all screen element constants, like color names and screen sizes,
 * are stored here. 
 * <p>
 * <table border="1">
 * <tr>
 * 		<th colspan="3">Change Log</th>
 * </tr>
 * <tr>
 * 		<th>Date</th> <th>Author</th> <th>Change</th>
 * </tr>
 * <tr>
 * 		<td>Oct 22, 2004</td>
 *      <td>klevi, pcorazza</td>
 *      <td>New class file</td>
 * </tr>
 * </table>
 *
 */
public class GuiControl {
	private static GuiControl control;
	
	private GuiControl() {
	}
	
	public static GuiControl getInstance() {
		if(control == null) {
			control = new GuiControl();
		}
		return control;
	}
	
	
	public static int SCREEN_WIDTH = 640;
	public static int SCREEN_HEIGHT = 480;
	

	
	//colors
	//public static Color BROWN = new Color(0x9a7c46);
	//public static Color PALE_YELLOW = new Color(0xffface);
	//public static Color FAINT_YELLOW = new Color(0xffffe0);
	public static Color DARK_BLUE = Color.blue.darker();
	public static Color LIGHT_BLUE = new Color(0xf2ffff);
	public static Color LIGHT_GRAY = new Color(0xdddddd);
    public static Color APRICOT = new Color(0xfff2a9);
	
    public static Color OUTPUT_SCREEN = LIGHT_GRAY;
	public static Color WINDOW_BORDER = DARK_BLUE;
	public static Color FILLER_COLOR = Color.white;
	
    public static void centerFrameOnDesktop(Component f) {
        final int SHIFT_AMOUNT = 0;
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        int height = toolkit.getScreenSize().height;
        int width  = toolkit.getScreenSize().width;
        int frameHeight = f.getSize().height;
        int frameWidth  = f.getSize().width;
        f.setLocation(((width-frameWidth)/2)-SHIFT_AMOUNT, (height-frameHeight)/3);    
    }
    
 	public static Font makeSmallFont(Font f) {
        return new Font(f.getName(), f.getStyle(), (f.getSize()-2));
    }
    
    public static Font makeLargeFont(Font f) {
        return new Font(f.getName(), f.getStyle(), (f.getSize()+2));
    }
    public static Font makeVeryLargeFont(Font f) {
        return new Font(f.getName(), f.getStyle(), (f.getSize()+4));
    }
    
    public static Font makeBoldFont(Font f) {
        return new Font(f.getName(), Font.BOLD, f.getSize());
    }
    
    public static Font makeDialogFont(Font f) {
    	return new Font("Dialog", f.getStyle(), f.getSize());
    }
    
 
    public static Border createBlueTitledBorder(String title, Font f) {
        f = new Font(f.getName(), Font.BOLD, f.getSize());
        Border lineborder =BorderFactory.createLineBorder(Color.blue.darker().darker());
        return BorderFactory.createTitledBorder(lineborder,
                                                title,
                                                TitledBorder.DEFAULT_JUSTIFICATION,
                                                TitledBorder.DEFAULT_POSITION,
                                                f,
                                                Color.blue.darker().darker()); 
    }
    
    public static Border createRedTitledBorder(String title, Font f) {
        f = new Font(f.getName(), Font.BOLD, f.getSize());
        Border lineborder =BorderFactory.createLineBorder(Color.red.darker().darker());
        return BorderFactory.createTitledBorder(lineborder,
                                                title,
                                                TitledBorder.DEFAULT_JUSTIFICATION,
                                                TitledBorder.DEFAULT_POSITION,
                                                f,
                                                Color.red.darker().darker()); 
    }
    
    	

    public static JPanel createStandardButtonPanel(JButton[] buttons) {
    	
    	
    	JPanel buttonPanel = new JPanel();
    	
    	buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));	
    	buttonPanel.setBackground(FILLER_COLOR);
    	if(buttons != null && buttons.length>0) {
    		for(int i = 0; i < buttons.length; ++i) {
    			buttonPanel.add(buttons[i]);	
    		}
    	}
    	return buttonPanel;
    	
    }
    public static JPanel createStandardButtonPanel(JButton[] buttons, Color backgroundColor) {
        
        
        JPanel buttonPanel = new JPanel();
        
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));   
        buttonPanel.setBackground(backgroundColor);
        if(buttons != null && buttons.length>0) {
            for(int i = 0; i < buttons.length; ++i) {
                buttonPanel.add(buttons[i]);    
            }
        }
        return buttonPanel;
        
    }    
    
 
 
    
    public static void main(String [] args) {
    	System.out.println(System.getProperty("user.dir"));	
    }	

}
