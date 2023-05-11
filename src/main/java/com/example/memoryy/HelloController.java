package com.example.memoryy;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.io.IOException;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import java.net.URL;

import javafx.fxml.FXML;

import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class HelloController {

    @FXML
    private Button quitButton;

    @FXML
    private void handleQuitButtonAction(ActionEvent event) {
        Stage stage = (Stage) quitButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private Button startButton;

    @FXML
    private void handleStartButtonAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) startButton.getScene().getWindow();
        URL location = new URL("file:///C:/Users/Emili/Documents/Webstart_2/Java/Projet/Memoryy/src/main/resources/com/example/memoryy/game-view.fxml");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(location);
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML private Rectangle rectangle00;
    @FXML private Rectangle rectangle01;
    // ...
    @FXML private Rectangle rectangle18;

    public void rotateClockwise() {
        // Animate the rotation of each rectangle
        animateRotation(rectangle00, 0, 3);
        animateRotation(rectangle01, 0, 3);
        // ...
        animateRotation(rectangle18, 0, 3);
    }

    private void animateRotation(Rectangle rectangle, int startAngle, int endAngle) {
        RotateTransition rt = new RotateTransition(Duration.seconds(1), rectangle);
        rt.setFromAngle(startAngle * 90);
        rt.setToAngle(endAngle * 90);
        rt.play();

        // Translate the rectangle so that it remains in the same position
        double centerX = rectangle.getX() + rectangle.getWidth() / 2;
        double centerY = rectangle.getY() + rectangle.getHeight() / 2;
        rectangle.setTranslateX(centerX * (1 - Math.cos(Math.toRadians(90 * (endAngle - startAngle)))) - centerY * Math.sin(Math.toRadians(90 * (endAngle - startAngle))));
        rectangle.setTranslateY(centerY * (1 - Math.cos(Math.toRadians(90 * (endAngle - startAngle)))) + centerX * Math.sin(Math.toRadians(90 * (endAngle - startAngle))));
    }
}

