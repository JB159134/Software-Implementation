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

public abstract class Person implements Serializable{

	protected Name name;
	protected String phoneNo;

	public Person() {
		this.name = new Name();
		this.phoneNo = "";
	}

	public Person(Name name, String phoneNo) {
		this.name = name;
		this.phoneNo = phoneNo;
	}

	@Override
	public String toString() {
		return name + "\t" + phoneNo;
	}

	public boolean equal(Object obj) {
		Person pObj;
		if (obj instanceof Person) {
			pObj = (Person) obj;
		} else
			return false;

		return this.name.equals(pObj.name) && this.phoneNo.equals(pObj.phoneNo);
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
}
