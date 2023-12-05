/*
 Jennifer Burns
 L00159134
 L00159134@atu.ie
 3rd Year Applied Computing
 FAB Flights System
 27/11/2023
 */

package ie.atu.book;
import ie.atu.serialize.BookSerializer;

import java.awt.Button;
import java.awt.Font;
import java.awt.Label;
import javafx.application.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.geometry.*;


// Stage that contains two panes, one to the LEFT of the Stage, and one to the CENTER
// FXMenu IS-A Application ==> Inheritance
public class FXMenu extends Application{  
	// Instance Variables go here (properties of our JFrame)...
    private static final int SCENEWIDTH = 300;
    private static final int SCENEHEIGHT = 250;     
	
    // FXMenu HAS-A Scene that uses BorderPane as its Layout Pane
    private Scene scene;
    private BorderPane sceneLayout;

    // It has a BorderPane two Labels, and...
    private BorderPane centerPane;
    private Label lblBookStore;	
	private Font labelFont;
	
	// a VBox with 6 Buttons
	private VBox buttonPane;  
    private Button btAdd, btList, btView, btEdit, btDelete, btExit;
    private Font buttonFont;
    
    // BookSerializer object for calling methods
    private BookSerializer bookSerializer;
    
    @Override
    public void start(Stage primaryStage){  
	   labelFont = Font.font("Gill Sans MT", FontWeight.BOLD, 24);
	   buttonFont = Font.font("Gill Sans MT", FontWeight.BOLD, 16);	
	   
	   /////
	   // Build centerPane
	   /////
	   centerPane = new BorderPane();
	   centerPane.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
	   centerPane.setPadding(new Insets(10)); 

	   centerPane.setTop(lblBookStore=new Label("BOOKWORM",new ImageView("books.jpg")));
	   // Center the icon and text and place the text under the icon, and set the Font of lblBookStore
	   BorderPane.setAlignment(lblBookStore, Pos.CENTER);
	   lblBookStore.setContentDisplay(ContentDisplay.BOTTOM);
	   lblBookStore.setFont(labelFont);

	   centerPane.setBottom(lblBookStore=new Label("BOOK STORE"));
	   // Center the text, and set the Font of lblBookStore
	   BorderPane.setAlignment(lblBookStore, Pos.CENTER);
	   lblBookStore.setFont(labelFont);

	   /////
	   // Build buttonPane
	   /////
	   buttonPane = new VBox(10);
       buttonPane.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
	   buttonPane.setPadding(new Insets(15,0,15,15)); // set the padding to 5 for top,right,bottom,left

	   buttonPane.getChildren().add(btAdd=new Button("_ADD"));
       buttonPane.getChildren().add(btList=new Button("_LIST"));				
       buttonPane.getChildren().add(btView=new Button("_VIEW"));		
       buttonPane.getChildren().add(btEdit=new Button("_EDIT"));				
       buttonPane.getChildren().add(btDelete=new Button("_DELETE"));	
       buttonPane.getChildren().add(btExit=new Button("E_XIT"));
	   btAdd.setMaxWidth(Double.MAX_VALUE);
       btList.setMaxWidth(Double.MAX_VALUE);
       btView.setMaxWidth(Double.MAX_VALUE);
       btEdit.setMaxWidth(Double.MAX_VALUE);
       btDelete.setMaxWidth(Double.MAX_VALUE);       
       btExit.setMaxWidth(Double.MAX_VALUE);
       btAdd.setFont(buttonFont);
       btList.setFont(buttonFont);
       btView.setFont(buttonFont);
       btEdit.setFont(buttonFont);
       btDelete.setFont(buttonFont);
       btExit.setFont(buttonFont);
       btAdd.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,
               					  new CornerRadii(4),new BorderWidths(1))));
       btList.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,
               					   new CornerRadii(4),new BorderWidths(1))));
       btView.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,
               					   new CornerRadii(4),new BorderWidths(1))));
       btEdit.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,
                                   new CornerRadii(4),new BorderWidths(1))));
       btDelete.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,
                                     new CornerRadii(4),new BorderWidths(1))));
       btExit.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,   
    		   					   new CornerRadii(4),new BorderWidths(1))));
     
   
       
       sceneLayout = new BorderPane();
       // Add buttonPane to left of sceneLayout and…
       sceneLayout.setLeft(buttonPane);
       // ...add centerPane to center of sceneLayout
       sceneLayout.setCenter(centerPane);     
 
       // Construct scene to contain sceneLayout
       scene=new Scene(sceneLayout,SCENEWIDTH,SCENEHEIGHT);

       // ...setScene() of primaryStage to scene created
       primaryStage.setScene(scene);      
       primaryStage.setTitle("BOOKWORM");
       primaryStage.show();

       // Create a BookSerializer object to call add(), list(), etc. methods
       bookSerializer=new BookSerializer();
       // deserializeBooks() to populate the ArrayList
       bookSerializer.deserializeBooks();
 
        // anonymous inner class listener using lambda for each of the 6 Buttons		
		btAdd.setOnAction(e->{bookSerializer.add();});
		btList.setOnAction(e->{ bookSerializer.list();});				
		btView.setOnAction(e->{bookSerializer.view();});
		btEdit.setOnAction(e->{bookSerializer.edit();});
		btDelete.setOnAction(e->{bookSerializer.delete();});				
		btExit.setOnAction(e->{
			// Serialize the Books ArrayList on Exit		
			bookSerializer.serializeBooks();
			Platform.exit();
		});
   }
}