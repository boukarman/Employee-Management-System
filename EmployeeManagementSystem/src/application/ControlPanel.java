package application;



import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControlPanel {
	
	public void viewEmployee(ActionEvent e) throws IOException {
		
		
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("ViewEmployees.fxml"));
		
		Scene scene = new Scene(root,1200,600);
		//Scene.getStylesheet().addgetClass().getResource("application.css").toExternal();
		
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	
	}

	
public void InsertEmployee(ActionEvent e) throws IOException {
		
		
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("InsertEmployees.fxml"));
		
		Scene scene = new Scene(root,1200,500);
		//Scene.getStylesheet().addgetClass().getResource("application.css").toExternal();
		
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	
}
	
public void UpdateDelete(ActionEvent e) throws IOException {
	
	
	Stage primaryStage = new Stage();
	Parent root = FXMLLoader.load(getClass().getResource("UpdateDelete.fxml"));
	
	Scene scene = new Scene(root,1200,500);
	//Scene.getStylesheet().addgetClass().getResource("application.css").toExternal();
	
	
	primaryStage.setScene(scene);
	primaryStage.show();
	

}
	
	

}
