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

import ie.atu.book.Book;

public class BookSerializer {
	private ArrayList<Book> books;
	
	final String FILENAME = "books.bin";	
	private File booksFile;

	
	public BookSerializer()
	{
		books = new ArrayList<Book>();
		booksFile = new File(FILENAME);	
	}
	
	public void add()
	{
		Book tmpBook=new Book();
		tmpBook.read();
		books.add(tmpBook);
	}
	
	public void list()
	{
		String booksToList="";

		for(Book tmpBook : books)
		{
			booksToList+=tmpBook;
			booksToList+="\n";
	    }
	    JOptionPane.showMessageDialog(null, booksToList);
	}
	
	public Book view()
	{
		String bookToViewAsString=JOptionPane.showInputDialog("Library Number of Book");	
		int bookToView=Integer.parseInt(bookToViewAsString);
		
		for(Book tmpBook:books) 
		{
 		   if(tmpBook.getLibraryNumber() == bookToView)
 		   {
 		       JOptionPane.showMessageDialog(null, tmpBook);
 			   return tmpBook;
 		   }
       }
	    return null;		
	}
	
	public void delete()
	{	
		Book tempBook = view();
		if(tempBook != null)
		{
		books.remove(tempBook);	
		}
	}

	public void edit()
	{	
		Book tempBook = view();
		if(tempBook != null)
		{
		   int index=books.indexOf(tempBook);
		   tempBook.read();
		   books.set(index, tempBook);
	    }
	}
	
	public void serializeBooks()
	{
		try {
		FileOutputStream fos= new FileOutputStream(booksFile);
		
		ObjectOutputStream oos= new ObjectOutputStream(fos);
				
		oos.writeObject(books);
		
		oos.close();
		}
		catch(FileNotFoundException fNFE){
			System.out.println("Cannot create file to store books.");
		}
		catch(IOException ioE){
			 System.out.println("Cannot write to " + FILENAME + ".");
		}
	}
	@SuppressWarnings("unchecked")
	public void deserializeBooks(){
		try {
			FileInputStream fileStream = new FileInputStream(FILENAME);
		
			ObjectInputStream is = new ObjectInputStream(fileStream);
				
			books = (ArrayList<Book>)is.readObject();

			is.close();
		}
		catch(FileNotFoundException fNFE){
			System.out.println("Cannot create file to store books.");
		}
		catch(IOException ioE){
			 System.out.println("Cannot read from " + FILENAME + ".");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}

	
	