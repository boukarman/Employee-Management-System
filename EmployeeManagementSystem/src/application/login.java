package application;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class login {

	@FXML
	Label dbConlb;
	@FXML
	TextField username;
	@FXML
	TextField password;
	@FXML
	Label check;

	public void statusDB(ActionEvent e) throws IOException, SQLException {
		if (!AdminsDB.getConnection().isClosed()) {
			dbConlb.setText("connected");
		} else {
			dbConlb.setText("Not connected");

		}
	}

public void enterCP(ActionEvent e) throws IOException,SQLException  {
	
	List<Admins> list = AdminsDB.getAdmins();//from mysql
	
	//List<String> listusers = new ArrayList<String>();
	//List<String> listpwd = new ArrayList<String>();
	Map<String,String> map = new HashMap<String,String>();
	
	for(Admins a:list) {
		
		//listusers.add(a.getUsername());
		//listpwd.add(a.getPassword());
		map.put(a.getUsername(),a.getPassword());
	}
	
	if(map.containsKey(username.getText())) {
		 
		
		String val2 = map.get(username.getText());
		
		if (val2.equals(password.getText())) {
			
			check.setText("Success");
			
			AdminsDB.getConnection();
			
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("ControlOPanel.fxml"));
			
			Scene scene = new Scene(root,700,500);
			//Scene.getStylesheet().addgetClass().getResource("application.css").toExternal();
			
			
			primaryStage.setScene(scene);
			primaryStage.show();
		
		}else {
			
			check.setText("Failed try again please");
		}
	
	}else {
		
		check.setText("Failed try again please");
	
}
}
}