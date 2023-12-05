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

public class Name implements Serializable{
	
 private String title;
 private String firstName;
 private String surname;

public Name()
{
	this.title=this.firstName=this.surname=null;
}

public Name(String t, String fN, String sN)
{
	this.title=t;
	this.firstName=fN;
	this.surname=sN;
}

@Override
public String toString() {
	return this.title+" "+this.firstName+" "+this.surname;
}

@Override
public boolean equals(Object obj)
{
	Name nObj;
	if(obj instanceof Name) 
	{
		nObj=(Name)obj;
	}
	else
		return false;
	
	return this.title.equals(nObj.title)&&
		   this.firstName.equals(nObj.firstName)&&
		   this.surname.equals(nObj.surname);
}

public String getTitle() 
{
	return title;
}

public void setTitle(String title) 
{
	this.title=title;
}

public String getFirstName() 
{
	return firstName;
}

public void setFirstName(String firstName) 
{
	this.firstName=firstName;
}

public String getSurname() 
{
	return surname;
}

public void setSurname(String surname) 
{
	this.surname=surname;
}

public boolean isFemale()
{
	if(title=="Miss"||title=="Ms"||title=="Mrs") 
	{
		return true;
	}
	else
		return false;
	}
}
