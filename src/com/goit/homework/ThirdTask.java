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

    public void getReady(){
        launch();
    }

    public void start(Stage primaryStage) throws Exception {

        Pane root = new Pane();

        URL[] urls = new URL[50];
        URL[]tmp_urls = new URL[5];
        tmp_urls[0] = new URL("https://i.imgur.com/B31Uwkm.png");
        tmp_urls[1] = new URL("https://i.ytimg.com/vi/hCTGoOPy614/maxresdefault.jpg");
        tmp_urls[2] = new URL("https://i.ytimg.com/vi/TXIvVo1aejI/hqdefault.jpg");
        tmp_urls[3] = new URL("http://www.gogetnews.info/uploads/posts/2014-11/1416475617_barbi.jpg");
        tmp_urls[4] = new URL("http://v1.popcornnews.ru/upload/_500_600_80_dNeuXd.jpg");

        for(int i =0;i<urls.length;i++){
            urls[i]= tmp_urls[rnd(0,4)];
        }

        Button button = new Button();
        button.setTranslateX(100);
        button.setTranslateY(570);
        button.setText("Update");
        button.setPrefSize(60,15);
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
                imageView.setTranslateX((root.getWidth()/5)*x);
                imageView.setTranslateY(((root.getHeight()-100)/5)*y);

                root.getChildren().add(imageView);
            }
        }
    }

    private int rnd(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

}
