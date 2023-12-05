/*
 Jennifer Burns
 L00159134
 L00159134@atu.ie
 3rd Year Applied Computing
 FAB Flights System
 27/11/2023
 */

package ie.atu.testers;

import ie.atu.flight.Name;

public class NameTester {

	public static void main(String[] args) 
	{
		Name n1 = new Name();
		Name n2 = new Name("Mr","Cillian","Murphy");
		
		
		//display names
		System.out.println(n1.toString());
		System.out.println(n2.toString());
		
		Name n3 = new Name("Miss","Georgia","Rudden");
		Name n4 = new Name("Miss","Georgia","Rudden");
		//Equality check
		System.out.println(n3.toString()+" and "+n4.toString()+" are equal: "+n3.equals(n4));
		
		//Testing Setters & Getters
		n1.setTitle("Mr");
		n1.setFirstName("Leo");
		n1.setSurname("Viradkir");
		
		System.out.println(n1.toString());
		
		//Test if Female
		//True
		System.out.println(n3.toString()+" is female: "+n3.isFemale());
		//False
		System.out.println(n2.toString()+" is female: "+n2.isFemale());
	}
}
