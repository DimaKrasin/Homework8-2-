package com.goit.homework;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;


public class ThirdTask extends Application {

//    int Height;
//    int Width;
//
//    ThirdTask(int Height,int Width){
//        this.Height = Height;
//        this.Width = Width;
//    }

    public void getReady(){
        launch();
    }

    public void start(Stage primaryStage) throws Exception {

        Pane root = new Pane();

        URL[] urls = new URL[50];
        URL url = new URL("https://i.imgur.com/B31Uwkm.png");

        for(int i =0;i<urls.length;i++){
            urls[i] = url;
        }

        Button button = new Button();
        button.setTranslateX(root.getWidth()/3);
        button.setTranslateY(10);
        button.setOnAction(event -> {
            try{Update(root,urls);}catch (Exception e){
            }
        });
        root.getChildren().add(button);

        primaryStage.setScene(new Scene(root,500,600));
        primaryStage.show();
    }

    private void Update(Pane root,URL[] urls)throws Exception{
        for(int x = 0;x<5;x++){
            for(int y = 0;y<5;y++){
                Image image = new Image(urls[rnd(0,50)].openStream());
                ImageView imageView = new ImageView(image);
                imageView.setFitWidth(100);
                imageView.setFitHeight(100);
                imageView.setTranslateX(root.getWidth()*x);
                imageView.setTranslateY((root.getHeight()*y)-100);

                root.getChildren().add(imageView);
            }
        }
    }

    private int rnd(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

}
