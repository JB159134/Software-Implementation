/*
 Jennifer Burns
 L00159134
 L00159134@atu.ie
 3rd Year Applied Computing
 FAB Flights System
 27/11/2023
 */

package ie.atu.testers;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import ie.atu.flight.CreditCard;
import ie.atu.flight.Date;
import ie.atu.flight.Employee;
import ie.atu.flight.Name;
import ie.atu.flight.Passenger;
import ie.atu.flight.Person;

public class ExceptionHandlerDemo {
	public static void main(String[] args) {
		// PART B.
		// Create an ArrayList of Employees called employees;
		ArrayList<Employee> employees=new ArrayList<Employee>();
		
		// Add 3 Employees to employees
	   Name name = new Name("Ms","Faye","McGuire");
	   Employee e1 = new Employee(name, "087 1234567",
	        	                     new Date(7,12,2000),
	    		                     new Date(12,10,2020),
	    		                     24000.00);

	   name = new Name("Mr","Ben","Carson");
	   Employee e2 = new Employee(name, "086 1234567",
	     		                     new Date(20,10,1980), 
	    						         new Date(10,10,2012),
	    						         42000.00);	
	    
	   name = new Name("Mr","Mark","Logan");
	   Employee e3 = new Employee(name, "087 9876543",
	     		                     new Date(1,1,1994), 
	    						         new Date(2,8,2018),
	    						         28000.00);		    
	    
	    employees.add(e1);
	    employees.add(e2);
	    employees.add(e3);	
	    
	    String employeeNumberAsString="";
	    boolean goodInput=false;
	    // PART D.
	    do {
	    	try {
		    // RISKY CODE, might throw an exception
		    // try signals my intention to handle the exception
			    // PART C.
			    // Ask user which Employee to view
			    employeeNumberAsString=
			    	JOptionPane.showInputDialog(null,
			    	"Enter Employee to View ("+1+" to "+ 
			    	employees.size()+")");
			    // Convert String to an int
			    int employeeToView=Integer.parseInt(employeeNumberAsString);
			    // Get and display required Employee
			    JOptionPane.showMessageDialog(null,
			    		employees.get(employeeToView-1));
			    // At this point the required Employee will
			    // be displayed with no Exceptions thrown
			    // So set goodInput to true
			    goodInput=true;
		    }
		    catch(NumberFormatException e) {
		    	JOptionPane.showMessageDialog(null,
		    	 employeeNumberAsString + 
		    	 " is not a valid number, please re-enter.");
		    }
		    catch(IndexOutOfBoundsException e) {
		    	JOptionPane.showMessageDialog(null, 
		    	 "You must choose an employee from (" + 
		    	  1 + " to " + employees.size() + ")" + 
		    	  ", please re-enter.");
		    }
	    }while(!goodInput);
	    
	    // PART E.
	    // create a polymorphic ArrayList called allPersons
	    // allPersons is of type Person so it can store
	    // both Employee and Passenger objects
	    ArrayList<Person> allPersons=new ArrayList<Person>();
	    // add three Employees to allPersons
	    allPersons.add(e1);
	    allPersons.add(e2);
	    allPersons.add(e3);
	    // add two Passengers to allPersons
		name=new Name("Mr","Homer","Simpson");
		CreditCard homersCard=new CreditCard(
		                          1111222233334444L,
		                          new Date(1,12,2027),
		                          111);
		Passenger homer=new Passenger(name,"0871234567",
		                              "homer.simpson@atu.ie",
		                              0,false,
		                              homersCard);
		name=new Name("Mrs","Marge","Simpson");
		CreditCard margesCard=new CreditCard(
		                          5555666677778888L,
		                          new Date(1,12,2027),
		                          222);
		Passenger marge=new Passenger(name,"0877654321",
		                              "marge.simpson@atu.ie",
		                              3,true,
		                              margesCard);
		allPersons.add(homer);
		allPersons.add(marge);
		// print out allPersons
		// This is a polymorphic for loop
		// tempP takes on both Employee and Passenger objects
		for(Person tempP : allPersons)
		   System.out.println(tempP);		
	}
}