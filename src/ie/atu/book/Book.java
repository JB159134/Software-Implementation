/*
 Jennifer Burns
 L00159134
 L00159134@atu.ie
 3rd Year Applied Computing
 FAB Flights System
 27/11/2023
 */

package ie.atu.book;
import java.io.Serializable;
import javax.swing.*;

public class Book implements Serializable{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String name;  			
   private String isbnNumber;		
   private String author;  		
   private String publishingCompany;
   private int libraryNumber;   
   
   private static int nextNumber=1000;	
	
	public Book()
	{
		name=isbnNumber=author=publishingCompany="";
 		libraryNumber=nextNumber++;
	}
	
	public Book(String name, String isbnNumber, String author, String publishingCompany)
	{
		this.name = name;
		this.isbnNumber = isbnNumber;
		this.author = author;
		this.publishingCompany = publishingCompany;      
 		libraryNumber=nextNumber++;
	}

	@Override
	public String toString()
	{
 		return("BOOK "+libraryNumber+":"+name+" by "+author+" [ISBN "+isbnNumber+" PUBLISHER "+publishingCompany+"]");
  	}	

 	@Override
 	public boolean equals(Object obj)
 	{
      Book bObject;
	   if (obj instanceof Book)
	      bObject = (Book)obj;
	   else
	       return false;
	 
	   return this.libraryNumber == bObject.libraryNumber;
	}	

	public String getName()
	{
	   return name;
	}
	
	public void setName(String name)
	{
	   this.name=name;
	}
	
	public String getIsbnNumber()
	{
	   return isbnNumber;
	}	
	
	public void setIsbnNumber(String isbnNumber)
	{
	   this.isbnNumber=isbnNumber;
	}
	
	public String getAuthor()
	{
	   return author;
	}
	
	public void setAuthor(String author)
	{
	   this.author=author;
	}

	public String getPublishingCompany()
	{
	   return publishingCompany;
	}
	
	public void setPublishingCompany(String publishingCompany)
	{
	   this.publishingCompany=publishingCompany;
	}

	public int getLibraryNumber()
	{
	   return libraryNumber;
	}
   
   public void read()
   {
      JTextField txtLibraryNo = new JTextField();
      txtLibraryNo.setText("" + this.getLibraryNumber());
      JTextField txtName = new JTextField();
      txtName.requestFocus();
      JTextField txtIsnbNumber = new JTextField();
      JTextField txtAuthor = new JTextField();
      JTextField txtPublishingCompany = new JTextField();

      Object[] message = {
          "Library Number:", txtLibraryNo,
          "Book Name:", txtName,
          "ISBN Number:", txtIsnbNumber,
          "Author:", txtAuthor,
          "Publishing Company:", txtPublishingCompany,
      };

      JDialog dialog = new JDialog();
      dialog.setAlwaysOnTop(true);    
      int option = JOptionPane.showConfirmDialog(dialog, message, "Enter book details", JOptionPane.OK_CANCEL_OPTION);

      if (option == JOptionPane.OK_OPTION)
      {
          this.name = txtName.getText();
          this.isbnNumber = txtIsnbNumber.getText();
          this.author = txtAuthor.getText();
          this.publishingCompany = txtPublishingCompany.getText();
      }   
	}
}