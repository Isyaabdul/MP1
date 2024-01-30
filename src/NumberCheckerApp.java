import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class NumberCheckerApp extends Application {

    private TextField numberInput;
    private RadioButton redBackground;
    private RadioButton blueBackground;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Number Checker App");

        // Initialize GUI components
        numberInput = new TextField();
        redBackground = new RadioButton("Red Background");
        blueBackground = new RadioButton("Blue Background");
        Button submitButton = new Button("Submit");

        // Group the RadioButtons
        ToggleGroup toggleGroup = new ToggleGroup();
        redBackground.setToggleGroup(toggleGroup);
        blueBackground.setToggleGroup(toggleGroup);

        // Set default background color
        redBackground.setSelected(true);

        // Event handler for the Submit button
        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                processInput();
            }
        });

        // Layout
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20, 20, 20, 20));
        vbox.getChildren().addAll(
                new Label("Enter a number:"),
                numberInput,
                new Label("Select background color:"),
                redBackground,
                blueBackground,
                submitButton
        );

        // Create a BorderPane for the background color change
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(vbox);

        // Set initial background color
        borderPane.setStyle("-fx-background-color: red;");

        // Set the scene
        Scene scene = new Scene(borderPane, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Method to process user input
    private void processInput() {
        String inputText = numberInput.getText();

        try {
            int number = Integer.parseInt(inputText);
            boolean isEven = (number % 2 == 0);

            // Display picture based on even or odd
            displayPicture(isEven);

            // Change background color based on selected Radio Button
            changeBackgroundColor();
        } catch (NumberFormatException e) {
            // Handle non-integer input
            showAlert("Error", "Please enter a valid integer.");
        }
    }

    // Method to display picture based on even or odd
    private void displayPicture(boolean isEven) {
        ImageView imageView;
        if (isEven) {
            imageView = new ImageView(new Image("https://upload.wikimedia.org/wikipedia/commons/6/6c/Kid_boy.jpg"));
        } else {
            imageView = new ImageView(new Image("https://ellecrafts.blogspot.com/2017/02/25-baby-girl-hairstyles-best-and-recommended-2017.html"));
        }

        // Replace the center of the BorderPane with the new ImageView
        ((BorderPane) numberInput.getParent()).setCenter(imageView);
    }

    // Method to change background color based on selected Radio Button
    private void changeBackgroundColor() {
        if (redBackground.isSelected()) {
            ((BorderPane) numberInput.getParent()).setStyle("-fx-background-color: red;");
        } else if (blueBackground.isSelected()) {
            ((BorderPane) numberInput.getParent()).setStyle("-fx-background-color: blue;");
        }
    }

    // Method to show an alert for error messages
    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
