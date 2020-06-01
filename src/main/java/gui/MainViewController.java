package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.cordovagabriela.system.SalesSystemApplication;

import gui.util.Alerts;
import gui.util.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainViewController implements Initializable{

	@FXML
	private Button btLogin;

	@FXML
	private Button btProducts;

	@FXML
	private Button btHelp;
	
	@FXML
	public void onBtLoginAction(ActionEvent event) {
		Stage parentStage = (Stage) Utils.currentStage(event);
		createLoginForm("/gui/LoginView.fxml", parentStage);
	}
	
	@FXML
	public void onBtProductsAction() {
		System.out.println("Deu certo");	}
	
	@FXML
	public void onBtHelpAction() {
		loadView("/gui/HelpView.fxml");
	}
	
	
	private void loadView(String absolutName) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(absolutName));
		try {
			VBox newVbox = loader.load();
			Scene mainScene = SalesSystemApplication.getMainScene();
			VBox mainVbox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();
			
			Node mainMenu = mainVbox.getChildren().get(0);
			mainVbox.getChildren().clear();
			mainVbox.getChildren().add(mainMenu);
			mainVbox.getChildren().addAll(newVbox.getChildren());
			
		} catch (IOException e) {
			Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), AlertType.ERROR);
		}
	}
	
	private void createLoginForm(String absoluteName, Stage stage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			Pane pane = loader.load();

			Stage dialogStage = new Stage();
			dialogStage.setScene(new Scene(pane));
			dialogStage.setTitle("SIGN IN");
			dialogStage.setResizable(false);
			dialogStage.initOwner(stage);
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.showAndWait();
		}
		catch (IOException e) {
			Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), AlertType.ERROR);
		}
	}

	@Override
	public void initialize(URL uri, ResourceBundle rb) {
	}
	
}
