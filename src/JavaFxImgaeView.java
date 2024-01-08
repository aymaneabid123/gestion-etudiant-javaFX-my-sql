
import java.awt.Image;
import javafx.application.Application;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ayman
 */
public class JavaFxImgaeView  extends Application{

   
    public void start(Stage primaryStage) throws Exception {
    
        Pane pane=new HBox(15);
        ImageView img=new ImageView("Untitled design (13).png");
        pane.getChildren().add(img);
    }
     public static void main(String[] args) {
       launch(args);
     }
 }
    
 
