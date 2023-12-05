/*
 Jennifer Burns
 L00159134
 L00159134@atu.ie
 3rd Year Applied Computing
 FAB Flights System
 27/11/2023
 */

package ie.atu.book;

import java.util.Scanner;

public class Menu {
	private int option;
	
	public Menu() {
		option=-1;
	}
	
    public void display()
    {
      System.out.println("\t\tFAB FLIGHTS\n");
      System.out.println("\t\tBOOKING MENU\n");
      System.out.println("\t1. Add");
	  System.out.println("\t2. List");
	  System.out.println("\t3. View");
	  System.out.println("\t4. Edit");
	  System.out.println("\t5. Delete");
	  System.out.println("\t6. Quit");		
	}

    public void readOption()
    {
       Scanner kbInt = new Scanner(System.in);
			try {
			System.out.println("\n\tEnter Option [1|2|3|4|5|6]");
			option=kbInt.nextInt();
			}catch(java.util.InputMismatchException e) 
			{
			System.out.println("Invalid input. Please enter a number.");
			kbInt.nextLine(); 
			readOption(); 
			}
		
    }
    
	public int getOption(){
	   return option;
	}	    
}