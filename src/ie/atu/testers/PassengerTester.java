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
import ie.atu.flight.CreditCard;
import ie.atu.flight.Name;
import ie.atu.flight.Date;
import ie.atu.flight.Passenger;

public class PassengerTester {

	public static void main(String[] args) {
		
		ArrayList<Passenger> passengers = 
				new ArrayList<Passenger>();
		
		Name homer=new Name("Mr","Homer","Simpson");
		CreditCard homersCard=new CreditCard(1111222233334444L,
				                             new Date(31,12,2027),
				                             111);
		Passenger p1=new Passenger(homer, "087 1234567", 
				             "homer.simpson@atu.ie", 0, false, homersCard);
		
		
		CreditCard margesCard=new CreditCard(5555666677778888L,
                new Date(31,12,2024),
                222);

		Passenger p2=new Passenger(new Name("Mrs","Marge","Simpson"),
					"086 1234567", "marge.simpson@atu.ie",
					1, true, margesCard);
		CreditCard lisasCard=new CreditCard(9999000011112222L,
                new Date(31,3,2024),
                333);
		
		Passenger p3=new Passenger(new Name("Miss","Lisa","Simpson"),
		"087 9876543", "lisa.simpson@atu.ie",
		3, true, lisasCard);
		
	passengers.add(p1);
	passengers.add(p2);
	passengers.add(p3);

	System.out.println("LIST OF PASSENGERS");
	for(Passenger passenger:passengers) 
		
	System.out.println(passenger);

	int femaleCount=0,maleCount=0;
	
	for(Passenger passenger:passengers) 
	{
	if(passenger.getName().isFemale())
	femaleCount++;
	else
	maleCount++;
	}
	System.out.println("");
	System.out.println("MALE/FEMALE PASSENGER COUNT");
	System.out.println(maleCount + " MALE(S), " + femaleCount + " FEMALE(S).");		

	System.out.println("");
	System.out.println("PASSENGERS CREDIT CARD DETAILS");
	for(Passenger passenger:passengers) 
	System.out.println(passenger.getName() + " Card Number :" + passenger.getCreditCard());

	}

}
