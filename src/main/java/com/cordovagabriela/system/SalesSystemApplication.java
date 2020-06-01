package com.cordovagabriela.system;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

@SpringBootApplication
public class SalesSystemApplication extends Application {

	protected ConfigurableApplicationContext springContext;

	private static Scene mainScene;
	
	public static void main(String[] args) {
		// SpringApplication.run(SalesSystemApplication.class, args);
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/MainView.fxml"));
			Parent parent = loader.load();
			parent.setStyle("-fx-background-color: linear-gradient(from 25% 25% to 100% 100%, #9400d3, #8a2be2)");
			Scene mainScene = new Scene(parent);
			
			stage.setScene(mainScene);
			stage.setTitle("SALES SYSTEM ");
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static Scene getMainScene() {
		return mainScene;
	}

	@Override
	public void init() throws Exception {
		springContext = springBootApplicationContext();
	}

	private ConfigurableApplicationContext springBootApplicationContext() {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(SalesSystemApplication.class);
		String[] args = getParameters().getRaw().stream().toArray(String[]::new);
		return builder.run(args);
	}

}
