/*
 Jennifer Burns
 L00159134
 L00159134@atu.ie
 3rd Year Applied Computing
 FAB Flights System
 27/11/2023
 */

package ie.atu.serialize;

import java.io.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import ie.atu.flight.Employee;

public class EmployeeSerializer {
	private ArrayList<Employee> employees;
	
	final String FILENAME = "employees.bin";	
	private File employeesFile;

	
	public EmployeeSerializer()
	{
		employees = new ArrayList<Employee>();
		employeesFile = new File(FILENAME);	
	}
	
	public void add()
	{
		Employee tmpEmployee=new Employee();
		tmpEmployee.read();
		employees.add(tmpEmployee);
	}
	
	public void list() {
	    if (employees.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "No employees found.");
	    } else {
	        StringBuilder employeesToList = new StringBuilder();
	        employeesToList.append("List of Employees:\n\n");

	        for (Employee employee : employees) {
	            employeesToList.append("Employee ID: ").append(employee.getEmployeeNo()).append("\n");
	            employeesToList.append("Name: ").append(employee.getName()).append("\n");
	            employeesToList.append("Salary: ").append(employee.getSalary()).append("\n");
	            employeesToList.append("----------------------------------------\n");
	        }

	        JOptionPane.showMessageDialog(null, employeesToList.toString());
	    }
	}
	
	public Employee view() {
	    try {
	        String employeeToViewAsString = JOptionPane.showInputDialog("Number of Employee");
	        int employeeToView = Integer.parseInt(employeeToViewAsString);

	        boolean employeeFound = false;

	        StringBuilder employeesToList = new StringBuilder();
	        for (Employee tmpEmployee : employees) {
	            if (tmpEmployee.getEmployeeNo() == employeeToView) {
	            	employeesToList.append("Employee ID: ").append(tmpEmployee.getEmployeeNo()).append("\n");
		            employeesToList.append("Name: ").append(tmpEmployee.getName()).append("\n");
		            employeesToList.append("Salary: ").append(tmpEmployee.getSalary()).append("\n");
		            employeesToList.append("----------------------------------------\n");
	                JOptionPane.showMessageDialog(null, employeesToList.toString());
	                return tmpEmployee;
	            }
	        }

	        if (!employeeFound) {
	            throw new Exception("Employee not found.");
	        }

	    } catch (NumberFormatException e) {
	        System.out.println("Invalid input. Please enter a valid employee number.");
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	    }

	    return null;
	}

	
	public void delete() {
	    try {
	        if (employees.isEmpty()) {
	            System.out.println("No employees to delete.");
	            return; // Exit the method if there are no employees
	        }

	        Employee tempEmployee = view();

	        if (tempEmployee != null) {
	            employees.remove(tempEmployee);
	            System.out.println("Employee deleted successfully.");
	        }
	    } catch (Exception e) {
	        // Handle the exception here, e.g., display an error message
	        System.out.println("Error deleting employee: " + e.getMessage());
	        // You can also log the exception if needed: e.printStackTrace();
	    }
	}

	public void edit()
	{	
		 try {
		        Employee tempEmployee = view();
		        if (tempEmployee != null) {
		            int index = employees.indexOf(tempEmployee);
		            tempEmployee.read();
		            employees.set(index, tempEmployee);
		        }
		    }catch (Exception e) {
		        System.out.println("An unexpected error occurred: " + e.getMessage());
		    }
	}
	
	public void serializeEmployee()
	{
		try {
		FileOutputStream fos= new FileOutputStream(employeesFile);
		
		ObjectOutputStream oos= new ObjectOutputStream(fos);
				
		oos.writeObject(employees);
		
		oos.close();
		}
		catch(FileNotFoundException fNFE){
			System.out.println("Cannot create file to store employees.");
		}
		catch(IOException ioE){
			 System.out.println("Cannot write to " + FILENAME + ".");
		}
	}
	public void deserializeEmployee(){
		try {
			FileInputStream fileStream = new FileInputStream(FILENAME);
		
			ObjectInputStream is = new ObjectInputStream(fileStream);
				
			employees = (ArrayList<Employee>)is.readObject();

			is.close();
		}
		catch(FileNotFoundException fNFE){
			System.out.println("Cannot create file to store employees.");
		}
		catch(IOException ioE){
			 System.out.println("Cannot read from " + FILENAME + ".");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}

	
	