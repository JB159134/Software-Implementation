/*
 Jennifer Burns
 L00159134
 L00159134@atu.ie
 3rd Year Applied Computing
 FAB Flights System
 27/11/2023
 */

package ie.atu.flight;

import java.io.Serializable;

public class Passenger extends Person implements Serializable{
	private String emailAddress;
	private int noBags;
	private boolean priorityBoarding;
	private CreditCard creditCard;
	
	public Passenger()
	{
		super();
		emailAddress="";
	    noBags=0;
		priorityBoarding=false;
	}
	
	public Passenger(Name nameIn,String phoneNoIn, String emailIn, 
			int noBagsIn, boolean pBIn, CreditCard ccIn) 
	{
		super(nameIn,phoneNoIn);
		this.emailAddress=emailIn;
	    this.noBags=noBagsIn;
		this.priorityBoarding=pBIn;
		this.creditCard=ccIn;
	}
	
	@Override
	public String toString()
	{
		String pb="";
		if(priorityBoarding)
			pb="Priority Boarding";
		else
			pb="No Priority Boarding";
			
		return name + "\t" + emailAddress + "\t"
		     + "\t" + noBags + " bag(s), " + "\t" + pb ;
	}
	
	public String getEmail() {
		return emailAddress;
	}

	public void setEmail(String emailIn) {
		this.emailAddress = emailIn;
	}

	public int getNoBags() {
		return noBags;
	}

	public void setNoBags(int noBIn) {
		if(noBags>3)
			this.noBags=3;
		else
		this.noBags = noBIn;
	}
	
	public boolean getPrioityBoarding() {
		return priorityBoarding;
	}

	public void setPrioityBoarding(boolean PBIn) {
		this.priorityBoarding = PBIn;
	}
	
	public CreditCard getCreditCard()
	{
		return creditCard;
	}
	
	public void setCreditCard(CreditCard ccIn)
	{
		this.creditCard=ccIn;
	}
	
}
