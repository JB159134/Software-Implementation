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

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Employee extends Person implements Payable, Serializable {
	
	
		private double salary;
		private int emNumber;
		
		final long MAX_SALARY = 150000;
		private static int nextNumber =10000;
		
		public Employee()
		{
			super();
			//this.dob=null;
			//this.startDate=null;
			this.salary=0;
			this.emNumber=nextNumber;
			nextNumber++;
		}
		public Employee(Name nameIn,String phoneNoIn, Date dobIn, 
				Date sDIn, double salaryIn) 
		{
			super(nameIn,phoneNoIn);
			//this.dob=dobIn;
			//this.startDate=sDIn;
		    this.salary=salaryIn;
		    this.emNumber=nextNumber;
		    nextNumber++;
		}
		
		@Override
		public String toString() 
		{
			return emNumber+"\t"+super.toString()+"\t"+salary;
		}
		
		@Override
		public boolean equals(Object obj)
		{
				Employee eObj;
				if (obj instanceof Employee) {
					eObj = (Employee) obj;
				} else
					return false;

				return (this.emNumber==eObj.emNumber);
		}
	
		//public Date getDOB() {
		//	return dob;
		//}
		
		//public void setDOB(Date dobIn) {
		//	this.dob = dobIn;
		//}
		
		//public Date getStartDate() {
		//	return startDate;
		//}
		
		//public void setStartDate(Date startIn) {
		//	this.startDate = startIn;
		//}
		
		public double getSalary() {
			return salary;
		}
		
		public void setSalary(double salaryIn) {
			this.salary = salaryIn;
		}
		
		public int getEmployeeNo() {
			return emNumber;
		}
		
	@Override
	public double calculatePay(double taxPercentage) {
		double pay =salary/12;
		pay -=(pay * (taxPercentage/100));
		return pay;
	}

	@Override
	public double incrementSalary(double incrementAmount) {
	salary +=incrementAmount;
	if(salary > MAX_SALARY)
		salary = MAX_SALARY;
	
		return salary;
	}
	
	public void read()
	   {
	      JTextField txtEmployeeNo = new JTextField();
	      txtEmployeeNo.setText("" + this.getEmployeeNo());
	      JTextField txtTitle = new JTextField();
	      txtTitle.requestFocus();
	      JTextField txtFirstName = new JTextField();
	      JTextField txtSurname = new JTextField();
	      JTextField txtPhoneNumber = new JTextField();
	      JTextField txtSalary = new JTextField();
	      txtSalary.setText("" + this.getSalary());

	      Object[] message = {
	          "Employee Number:", txtEmployeeNo,
	          "Employee Title:", txtTitle,
	          "Employee Frist Name:", txtFirstName,
	          "Employee Surname:", txtSurname,
	          "Phone Number:", txtPhoneNumber,
	          "Salary:", txtSalary,
	      };

	      JDialog dialog = new JDialog();
	      dialog.setAlwaysOnTop(true);    
	      int option = JOptionPane.showConfirmDialog(dialog, message, "Enter Employee details", JOptionPane.OK_CANCEL_OPTION);

	      if (option == JOptionPane.OK_OPTION)
	      {
	          this.name.setTitle(txtTitle.getText());
	          this.name.setFirstName(txtFirstName.getText());
	          this.name.setSurname(txtSurname.getText());
	          this.phoneNo = txtPhoneNumber.getText();
	          String salaryS = txtSalary.getText();
	          
	          double enteredSalary = Double.parseDouble(salaryS);
	          if(enteredSalary <= MAX_SALARY)
	          {
	        	  salary = enteredSalary;
	          }
	          else {
	        	  JOptionPane.showMessageDialog(null, "Salary too high : Max salary 150000.00");
	        	  salary = MAX_SALARY;
	          }
	      }   
		}
	}
