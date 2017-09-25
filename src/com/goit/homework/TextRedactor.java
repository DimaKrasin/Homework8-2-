package com.goit.homework;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TextRedactor extends Application {
    String path;

    public void getReady() {
        launch();
    }

    public void start(Stage primaryStage) throws Exception {
        Pane root = new Pane();

        TextField textField_long = new TextField();
        textField_long.setTranslateX(10);
        textField_long.setTranslateY(10);
        textField_long.setPrefColumnCount(50);
        textField_long.setText("Recomended : files/textRedactor.txt");

        TextArea textArea = new TextArea();
        textArea.setTranslateX(80);
        textArea.setTranslateY(40);
        textArea.setPrefHeight(500);
        textArea.setPrefWidth(505);


        Button load = new Button();
        load.setText("load");
        load.setPrefSize(60, 15);
        load.setTranslateX(10);
        load.setTranslateY(40);
        load.setOnAction(event1 -> {

            path = textField_long.getText().toString();

            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    try {
                        String input = ReadWriteDelete.read(path);
                        textArea.setText(input);
                        System.out.println("load");

                    ReadWriteDelete.DeleteAllData(path);

                    } catch (
                            Exception e) {
                        System.out.println("Path not found?");
                    }
                }
            });

            Thread thread1 = new Thread();
            thread1.start();
        });


        Button save = new Button();
        save.setText("save");
        save.setPrefSize(60, 15);
        save.setTranslateX(10);
        save.setTranslateY(70);
        save.setOnAction(event -> {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    try {
                        ReadWriteDelete.writeToFile(textArea.getText(),path);
                        System.out.println("save");
                    } catch (
                            Exception e) {
                        System.out.println("Path not found!");
                    }
                }
            });

            Thread thread2 = new Thread();
            thread2.start();
        });

        TextField textField_short = new TextField();
        textField_short.setTranslateX(10);
        textField_short.setTranslateY(100);
        textField_short.setPrefColumnCount(4);
        textField_short.setText("Fib here");

        Button fib = new Button();
        fib.setText("Calc");
        fib.setPrefSize(60, 15);
        fib.setTranslateX(10);
        fib.setTranslateY(130);
        fib.setOnAction(event -> {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    long priveosli_priveosli_fib_result=1;
                    long priveosli_fib_result = 1;
                    long fib_result =0;
                    StringBuilder string =  new StringBuilder();
                    string.append(1+" ");
                    try {
                        int final_fib_index = Integer.parseInt(textField_short.getText().toString());
                        for(int i = 0;i<final_fib_index;i++){
                            fib_result = priveosli_priveosli_fib_result + priveosli_fib_result;
                            priveosli_priveosli_fib_result = priveosli_fib_result;
                            priveosli_fib_result = fib_result;
                            string.append(priveosli_priveosli_fib_result+" ");
                        }
                        textArea.appendText(string.toString());

                    } catch (
                            Exception e) {
                        System.out.println("Path not found!");
                    }
                }
            });

            Thread thread3 = new Thread();
            thread3.start();
        });

        root.getChildren().addAll(textField_short, load, save, textArea,fib,textField_long);

        primaryStage.setScene(new Scene(root, 630, 550));
        primaryStage.show();
    }
}
