package sample;

import javafx.application.Application;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.BlurType;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.scene.effect.DropShadow;
import javafx.scene.transform.Shear;
import javafx.animation.RotateTransition;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application{

    @Override
    public void start(Stage primaryStage) {
        Rectangle rect = new Rectangle(20,70,100,100);
        rect.setFill(Color.LIMEGREEN);
        rect.setStroke(Color.BLACK);
        Rotate rotate = new Rotate();

        //setting properties for the rotate object.
        rotate.setAngle(45);
        rotate.setPivotX(100);
        rotate.setPivotY(250);
        rect.getTransforms().add(rotate);
        Shear shearX = new Shear();
        shearX.setPivotX(200);
        shearX.setPivotY(250);
        shearX.setX(0.3);
        shearX.setY(0.0);
        // applying the shear to first rectangle.
        rect.getTransforms().add(shearX);
        DropShadow drop = new DropShadow();
        drop.setBlurType(BlurType.GAUSSIAN);
        drop.setColor(Color.BLACK);
        drop.setHeight(10);
        drop.setWidth(10);
        drop.setOffsetX(20);
        drop.setOffsetY(120);
        drop.setSpread(0.2);
        drop.setRadius(10);
        rect.setEffect(drop);

        RotateTransition rot = new RotateTransition();

        //Setting Axis of rotation
        rot.setAxis(Rotate.X_AXIS);

        // setting the angle of rotation
        rot.setByAngle(30);

        //setting cycle count of the rotation
        rot.setCycleCount(1000);

        //Setting duration of the transition
        rot.setDuration(Duration.millis(1000));

        //the transition will be auto reversed by setting this to true
        rot.setAutoReverse(true);

        //setting Rectangle as the node onto which the
        // transition will be applied
        rot.setNode(rect);

        //playing the transition
        rot.play();

        TranslateTransition translate = new TranslateTransition();

        //shifting the X coordinate of the centre of the circle by 400
        translate.setByX(150);

        //setting the duration for the Translate transition
        translate.setDuration(Duration.millis(3000));

        //setting cycle count for the Translate transition
        translate.setCycleCount(1000);

        //the transition will set to be auto reversed by setting this to true
        translate.setAutoReverse(true);

        //setting Circle as the node onto which the transition will be applied
        translate.setNode(rect);

        //playing the transition
        translate.play();

        Group root = new Group();

        root.getChildren().add(rect);
        Scene scene=new Scene(root,600,400,Color.LIGHTBLUE);
        primaryStage.setTitle("(19BCT0081) JavaFX Application ");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main (String[] args)
    {
        launch(args);
    }

}