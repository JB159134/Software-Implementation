/*
 Jennifer Burns
 L00159134
 L00159134@atu.ie
 3rd Year Applied Computing
 FAB Flights System
 27/11/2023
 */

package ie.atu.book;

import java.awt.*;
import javax.swing.*;
import ie.atu.serialize.BookSerializer;

// JFrame that contains two panels, one to the LEFT of the JFrame, and one to the CENTER
// SwingMenu IS-A JFrame ==> Inheritance
public class SwingMenu extends JFrame{  
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Instance Variables go here (properties of our JFrame)...
    private static final int FRAME_WIDTH = 300;
    private static final int FRAME_HEIGHT = 300;     
	
	// It has two JPanels...
    //    centerPAnel with a JLabel, and...
    private JPanel centerPanel;
    private JLabel jlblBookStore;	
	private Font f;
	
	//    buttonPanel with 6 JButtons
	private JPanel buttonPanel;  
    private JButton jbtAdd, jbtList, jbtView, jbtEdit, jbtDelete, jbtExit;
	
    // BookSerializer object for calling methods in BookSerializer class
    private BookSerializer bookSerializer;
    
	// Constructor - SetLayout & Add Components here...
    public SwingMenu(){	   
	   f = new Font("Gill Sans MT", Font.BOLD, 22);		
	   
	   /////
	   // Build centerPanel 
	   /////
	   centerPanel = new JPanel(new BorderLayout());
	   centerPanel.setBackground(Color.WHITE);
	   jlblBookStore = new JLabel("BOOKWORM",new ImageIcon("image/books.jpg"),SwingConstants.CENTER);
	   // Center the icon and text and place the text under the icon, and set the Font of jlblBookStore
	   jlblBookStore.setHorizontalTextPosition(JLabel.CENTER);
	   jlblBookStore.setVerticalTextPosition(JLabel.TOP);
	   jlblBookStore.setFont(f);
	   centerPanel.add(jlblBookStore,BorderLayout.NORTH);
	   jlblBookStore = new JLabel("BOOK STORE",SwingConstants.CENTER);
	   jlblBookStore.setFont(f);
	   centerPanel.add(jlblBookStore, BorderLayout.CENTER);
       centerPanel.setBackground(Color.WHITE);

	   /////
       // Build buttonPanel
       /////
       buttonPanel = new JPanel();
       buttonPanel.setLayout(new GridLayout(6,1,5,5));
       buttonPanel.setBackground(Color.WHITE);
       
       buttonPanel.add(jbtAdd=new JButton("ADD"));
       buttonPanel.add(jbtList=new JButton("LIST"));				
       buttonPanel.add(jbtView=new JButton("VIEW"));		
       buttonPanel.add(jbtEdit=new JButton("EDIT"));				
       buttonPanel.add(jbtDelete=new JButton("DELETE"));	
       buttonPanel.add(jbtExit=new JButton("EXIT"));				

		// setMnemonics on JButtons
       jbtAdd.setMnemonic('A');
       jbtList.setMnemonic('L');
       jbtView.setMnemonic('V');
       jbtEdit.setMnemonic('E');
       jbtDelete.setMnemonic('D');
       jbtExit.setMnemonic('X');

		// Set up Frame
        add(centerPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.WEST);

 	    // Create a BookSerializer object to call add(), list(), etc. methods
        bookSerializer=new BookSerializer();
        // deserializeBooks() before the JFrame is displayed...
        bookSerializer.deserializeBooks();
        
        // Create a Listener for each of the 6 JButtons		
		jbtAdd.addActionListener(e -> {
			bookSerializer.add();
		});
		jbtList.addActionListener(e -> {
			bookSerializer.list();
		});				
		jbtView.addActionListener(e -> {
			bookSerializer.view();
		});
		jbtEdit.addActionListener(e -> {
			bookSerializer.edit();
		});
		jbtDelete.addActionListener(e -> {
			bookSerializer.delete();
		});				
		jbtExit.addActionListener(e -> {
			// Serialize the Books ArrayList on Exit		
			bookSerializer.serializeBooks();
			dispose();
		});
   }
   
  
   public static void main(String[] args){ 
	   SwingMenu frame = new SwingMenu();
		
		// Do whatever to frame object
		// Set frame's title to "Three Colors Viewer"
		frame.setTitle("BOOKWORM");

		// Make frame big enough to hold components
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);

		// Add the Default Close operation to frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Center the frame
        frame.setLocationRelativeTo(null);

		// Set frame visible
		frame.setVisible(true);
   }
}