import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.Insets;



public class NumberCheckerApp extends Application {

    private Stage window;
    private TextField numberInput;
    private RadioButton button1, button2;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Number Checker App");

        // Initialize GUI components
        numberInput = new TextField();
        button1 = new RadioButton("Red Background");
        button2 = new RadioButton("Blue Background");
        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e -> processInput());

        // Create a VBox layout for the scene
        VBox layout = new VBox(20);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(
                new Label("Enter a number:"), numberInput,
                new Label("Select Background Color:"), button1, button2,
                submitButton
        );

        // Set initial background color
        layout.setStyle("-fx-background-color: red;");

        // Create the scene
        Scene scene = new Scene(layout, 200, 200);
        window.setScene(scene);
        window.show();
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
            if (button1.isSelected()) {
                window.getScene().getRoot().setStyle("-fx-background-color: red;");
            } else if (button2.isSelected()) {
                window.getScene().getRoot().setStyle("-fx-background-color: blue;");
            }
        } catch (NumberFormatException e) {
            showAlert("Error", "Please enter a valid integer.");
        }
    }

    // Method to display picture based on even or odd
    private void displayPicture(boolean isEven) {
        ImageView imageView;
        if (isEven) {
            imageView = new ImageView(new Image("Lion.jpg")); // Assuming "Boy.jpg" is the image file
        } else {
            imageView = new ImageView(new Image("Boy.jpg")); // Assuming "Lion.jpg" is the image file
        }

        // Center the image within the VBox layout
        StackPane imageContainer = new StackPane(imageView);
        ((VBox) window.getScene().getRoot()).getChildren().set(1, imageContainer);
    }

    // Method to show an alert for error messages
    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
