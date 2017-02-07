/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rr.jfx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Administrator
 */
public class DropShadowApp extends Application {
    
    private DropShadow dropShadow = new DropShadow();
    
    @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();
        
        Text sample = new Text(0,40,"DropShadow Effect");
        sample.setFont(Font.getDefault());
        sample.setEffect(dropShadow);
        
        root.setAlignment(Pos.CENTER);
        root.getChildren().add(sample);
        
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
