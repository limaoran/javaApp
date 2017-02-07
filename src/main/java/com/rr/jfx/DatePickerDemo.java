package com.rr.jfx;

import java.time.LocalDate;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author Administrator
 */
public class DatePickerDemo extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		DatePicker dp = new DatePicker(LocalDate.now());
		dp.setShowWeekNumbers(true);
		HBox hbox=new HBox(15,new Label("Date Picker:"),dp );
		hbox.setAlignment(Pos.CENTER);
		Scene scene = new Scene(hbox);
		primaryStage.setTitle("日期控件");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
