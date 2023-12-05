/*
 Jennifer Burns
 L00159134
 L00159134@atu.ie
 3rd Year Applied Computing
 FAB Flights System
 27/11/2023
 */

package ie.atu.testers;
import ie.atu.serialize.BookSerializer;
import ie.atu.book.Menu;

public class BookSerializerTester
{
	public static void main(String args[])
	{
		BookSerializer bookSerializer = new BookSerializer();
		
		 // Create a Menu Object
		Menu menuObj = new Menu();
		
		do {
			// Call the display() method
			menuObj.display();
			// Call the readOption() method
			menuObj.readOption();
	
			// switch on the option and call the appropriate method
			switch(menuObj.getOption()){
			   case 1:bookSerializer.add();break;
			   case 2:bookSerializer.list();break;
			   case 3:bookSerializer.view();break;
			   case 4:bookSerializer.edit();break;
			   case 5:bookSerializer.delete();break;
			   case 6:break;				
			   default:System.out.println("INVALID OPTION...");
			}
		}while(menuObj.getOption() != 6);
		
		// Write the books ArrayList to File
		// THIS SERIALIZES THE ARRAYLIST		
		bookSerializer.serializeBooks();
	}
}
 
