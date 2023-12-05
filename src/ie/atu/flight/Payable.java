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

public interface Payable {

	//interfaces can't have instant variables
	//private String name;
	//interfaces can't have constructors
	//public Payable(){
	
	//}
	//interfaces may not have method bodies
	//public void test(){
	
	//}
	//Can only have Abstract methods
	//A method with no body---->e.g.
	public double calculatePay(double taxPercentage);
	
	public double incrementSalary(double incrementAmount);
}
