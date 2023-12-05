/*
 Jennifer Burns
 L00159134
 L00159134@atu.ie
 3rd Year Applied Computing
 FAB Flights System
 27/11/2023
 */

package ie.atu.testers;
import ie.atu.serialize.EmployeeSerializer;
import ie.atu.book.Menu;


public class EmployeeSerializerTester
{
	public static void main(String args[]) 
	{
		EmployeeSerializer employeeSerializer = new EmployeeSerializer();
		employeeSerializer.deserializeEmployee();
		
		 // Create a Menu Object
		Menu menuObj = new Menu();
		
		do {
			// Call it's display() method
			menuObj.display();
			// Call it's readOption() method
			menuObj.readOption();
	
			// switch on the option and call the appropriate method
			switch(menuObj.getOption()){
			   case 1:employeeSerializer.add();break;
			   case 2:employeeSerializer.list();break;
			   case 3:employeeSerializer.view();break;
			   case 4:employeeSerializer.edit();break;
			   case 5:employeeSerializer.delete();break;
			   case 6:System.out.println("Goodbye!"); break;
			   			
			   default:System.out.println("INVALID OPTION...");
			}
		}while(menuObj.getOption() != 6);
		
		// Write the books ArrayList to File
		// THIS SERIALIZES THE ARRAYLIST		
		employeeSerializer.serializeEmployee();
	}
}
 
