package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.mysql.jdbc.PreparedStatement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ViewEmployees implements Initializable {
	
	
	
	@FXML
	private TableView<Employee>table;
	@FXML
	private TableColumn<Employee,Integer>id;
	@FXML
	private TableColumn<Employee,String>fname;
	@FXML
	private TableColumn<Employee,String>lname;
	@FXML
	private TableColumn<Employee,Float>salary;
	@FXML
	private TableColumn<Employee,Integer>age;
	@FXML
	private TableColumn<Employee,String>department;
	@FXML
	private TableColumn<Employee,String>address;
	@FXML 
	private TableColumn<Employee,String>date_of_birth;
	
	/*
	
	@FXML
	private TableColumn<Employee,String>contract_start;
	@FXML
	private TableColumn<Employee,String>contract_end;
	@FXML
	private TableColumn<Employee,String>nationality;  */

	public ObservableList<Employee> data = FXCollections.observableArrayList(); //  ObservableList a l'utiliser avec TableView  (to use it show oracle doc)
	
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		try {
			String sql = "SELECT * FROM employee WHERE 1";
			Connection con = DBInfo.getConnection();
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);

			ResultSet rs = preparedStatement.executeQuery();	
			
			while(rs.next()) {
				
				data.add(new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8)));
				
			}
			
			con.close();
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		// ici on realise la connexion ou plutot la laison entre notre Base de donnees et notre TableView
		id.setCellValueFactory(new PropertyValueFactory<Employee,Integer>("id"));
		fname.setCellValueFactory(new PropertyValueFactory<Employee,String>("fname"));
		lname.setCellValueFactory(new PropertyValueFactory<Employee,String>("lname"));
		salary.setCellValueFactory(new PropertyValueFactory<Employee,Float>("salary"));
		age.setCellValueFactory(new PropertyValueFactory<Employee,Integer>("age"));
		department.setCellValueFactory(new PropertyValueFactory<Employee,String>("department"));
		address.setCellValueFactory(new PropertyValueFactory<Employee,String>("address"));
		date_of_birth.setCellValueFactory(new PropertyValueFactory<Employee,String>("date_of_birth"));
		
		
		table.setItems(data);

		
	}
	
	

		
	
	

}
