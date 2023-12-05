/*
 Jennifer Burns
 L00159134
 L00159134@atu.ie
 3rd Year Applied Computing
 FAB Flights System
 27/11/2023
 */

package ie.atu.testers;

import java.util.Scanner;

import ie.atu.flight.Date;

public class DateTester{
	public static void main(String[] args) {
		Date d1 = new Date();
      System.out.println(d1);      

	    d1.setDay(4);
		d1.setMonth(6);
		d1.setYear(1941);
		
		System.out.println(d1);
      
		Date d2 = new Date(28, 12, 1982);
        System.out.println(d2);
      
		if(d1.equals(d2))
			System.out.println("Date's are equal.");
		else
			System.out.println("Date's are not equal.");
		
		// PART F.
		int day=55,month=13,year=-200;
		boolean goodInput=false;
		try (Scanner keyboard = new Scanner(System.in)) {
			do {
				try {
					Date dateA=new Date();
					// Put date class into an incorrect state
					dateA.setDay(day);
					dateA.setMonth(month);
					dateA.setYear(year);
					System.out.println(dateA);
					goodInput=true;
				}
				catch(IllegalArgumentException e) {
					System.out.println("Incorrect day, month or year.Re-enter.");
					
					System.out.print("Enter day [1-31]:");
					day = keyboard.nextInt();
					System.out.print("Enter month [1-12]:");
					month = keyboard.nextInt();
					System.out.print("Enter Year [above 1900]:");
					year = keyboard.nextInt();							
				}
			}while(!goodInput);
			
			day=62;month=15;year=10;
			goodInput=false;
			do {
				try {
					Date dateB = new Date(day,month,year);
					System.out.println(dateB);
					goodInput=true;
				}
				catch(IllegalArgumentException e) {
					System.out.println("Incorrect day, month or year.Re-enter.");
						
					System.out.print("Enter day [1-31]:");
					day = keyboard.nextInt();
					System.out.print("Enter month [1-12]:");
					month = keyboard.nextInt();
					System.out.print("Enter Year [above 1900]:");
					year = keyboard.nextInt();							
				}
			}while(!goodInput);
		}		
   }
}
