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

public class CreditCard implements Serializable{

private long number;
private Date expiryDate;
private int securityCode;

public CreditCard(long number, Date expiryDate,  int securityCode) {
	this.number=number;
	this.expiryDate=expiryDate;
	this.securityCode=securityCode;
}

@Override
public String toString() {
	return "Credit card number is: "+this.number;
}

@Override
public boolean equals(Object obj)
{
	CreditCard c1;
	if(obj instanceof CreditCard) 
	{
		c1=(CreditCard)obj;
	}
	else
		return false;
	
	return this.number==c1.number;
}

public long getNumber() 
{
	return number;
}

public Date getExpiryDate() 
{
	return expiryDate;
}

public int getSecurityCode() 
{
	return securityCode;
}
}
