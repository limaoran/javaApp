package com.rr.jfx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DropShadowDemo extends Application {

	private DropShadow dropShadow = new DropShadow();
	
	public static void main(String[] args) {
		launch(args);
	}

	public Parent show(){
		StackPane pane = new StackPane();
		
		Text text = new Text("Hello ! This is Text Demo!");
		text.setFont(Font.font(Font.getDefault().getFamily(),FontWeight.BOLD,36));
		text.setEffect(dropShadow);
		
		pane.setAlignment(Pos.CENTER);
		pane.getChildren().add(text);
		return pane;
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setScene(new Scene(show(),600,200));
		primaryStage.show();
	}

}
