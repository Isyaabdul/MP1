import javafx.application.Application;
import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Text;


public class Fowl extends Application

{
    public void start(Stage primaryStage)
    {

        // Create the head
        Circle head = new Circle(100, 100, 50);
        head.setFill(Color.YELLOW);

        // Create the eyes
        Circle leftEye = new Circle(85, 85, 10);
        Circle rightEye = new Circle(115, 85, 10);
        leftEye.setFill(Color.WHITE);
        rightEye.setFill(Color.WHITE);

        // Create the beak
        Polygon beak = new Polygon();
        beak.getPoints().addAll(new Double[]{
                100.0, 100.0,
                120.0, 100.0,
                110.0, 120.0});

        //Create the neck
        Rectangle neck = new Rectangle (150, 180, 70, 60);
        neck.setFill(Color.RED);

        // Create the body
        Ellipse body = new Ellipse(100, 200, 50, 25);
        body.setFill(Color.YELLOW);

        // Create the wings
        Polygon leftWing = new Polygon();
        leftWing.getPoints().addAll(new Double[]{
                50.0, 200.0,
                75.0, 175.0,
                75.0, 225.0});
        Polygon rightWing = new Polygon();
        rightWing.getPoints().addAll(new Double[]{
                150.0, 200.0,
                125.0, 175.0,
                125.0, 225.0});

        // Create the legs
        Line leftLeg = new Line(90, 250, 90, 275);
        Line rightLeg = new Line(110, 250, 110, 275);

        // Create the tail
        Polygon tail = new Polygon();
        tail.getPoints().addAll(new Double[]{
                150.0, 200.0,
                175.0, 200.0,
                175.0, 225.0});

        // Add all the shapes to a group
        Group Fowl = new Group(head, leftEye, rightEye, beak, body, leftWing, rightWing, leftLeg, rightLeg, tail);
        Fowl.setTranslateX(170);
        Fowl.setTranslateY(50);

        Circle sun = new Circle(220, 50, 30);
        sun.setFill(Color.BLUE);

        Rectangle ground = new Rectangle(0,350,450,150);
        ground.setFill(Color.BROWN);

        Text quote = new Text(250, 10, "A beautiful fowl");

        Group root = new Group(ground, sun, Fowl);
        // Create the scene
        Scene scene = new Scene(root, 300, 300, Color.GREEN);

        // Set the stage
        primaryStage.setTitle("Fowl");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
