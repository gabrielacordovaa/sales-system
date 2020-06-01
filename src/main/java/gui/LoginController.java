package gui;


import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;

import com.cordovagabriela.system.services.ClientService;

import gui.util.Alerts;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController implements Initializable{

	@FXML
    private Button btnLogin;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;
   
    @Autowired
    private ClientService service;
    
    @FXML
    public void onActionlogin(ActionEvent event) {
    	Alerts.showAlert("Login", "Login efetuado", "LOGIN SUCESSO", AlertType.CONFIRMATION);
    }
    
	@Override
	public void initialize(URL url, ResourceBundle rb) {
	}
	
	public String getPassword() {
		return password.getText();
	}

	public String getUsername() {
		return username.getText();
	}
	
}
