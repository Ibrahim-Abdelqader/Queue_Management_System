package org.example.ui;

import javafx.animation.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class QueueApp extends Application {

    private static final int NUM_LINES = 3;
    private static final Color WINDOW_COLOR = Color.web("#1E88E5");
    private static final Color IN_COLOR = Color.web("#4CAF50"); // Green
    private static final Color OUT_COLOR = Color.web("#F44336"); // Red
    private static final Color QUEUE_LINE_COLOR = Color.web("#BDBDBD");

    @Override
    public void start(Stage primaryStage) {
        // Main container with padding to avoid extreme left-up position
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(50, 0, 0, 50)); // Top, Right, Bottom, Left
        root.setStyle("-fx-background-color: #FAFAFA;");

        // Container for all metro lines
        VBox linesContainer = new VBox(30); // Spacing between lines
        linesContainer.setAlignment(Pos.TOP_LEFT);

        // Create metro lines
        for (int i = 0; i < NUM_LINES; i++) {
            HBox line = createMetroLine(i + 1);
            linesContainer.getChildren().add(line);
        }

        root.setCenter(linesContainer);

        // Set up the scene
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Metro Queue Simulation");
        primaryStage.setMaximized(true); // Start maximized (not fullscreen)
        primaryStage.show();
    }

    private HBox createMetroLine(int lineNumber) {
        HBox lineContainer = new HBox(0); // No spacing between components
        lineContainer.setAlignment(Pos.CENTER_LEFT);

        // OUT Queue (vertical on left)
        VBox outQueue = createVerticalQueue("OUT", OUT_COLOR);

        // Metro Window
        StackPane window = createMetroWindow(lineNumber);

        // IN Queue (vertical on right)
        VBox inQueue = createVerticalQueue("IN", IN_COLOR);

        lineContainer.getChildren().addAll(outQueue, window, inQueue);
        return lineContainer;
    }

    private VBox createVerticalQueue(String label, Color color) {
        VBox queueContainer = new VBox(5); // Small spacing between elements
        queueContainer.setAlignment(Pos.CENTER);
        queueContainer.setPadding(new Insets(0, 10, 0, 10)); // Right padding only for OUT

        // Queue label
        Text queueLabel = new Text(label);
        queueLabel.setFont(Font.font(14));
        queueLabel.setFill(color);

        // Queue visualization (vertical line)
        Line queueLine = new Line(0, 0, 0, 150); // Vertical line
        queueLine.setStroke(QUEUE_LINE_COLOR);
        queueLine.setStrokeWidth(2);
        queueLine.getStrokeDashArray().addAll(5d, 5d); // Dashed line

        // Queue end marker (door)
        Rectangle door = new Rectangle(30, 5, color);
        door.setStroke(Color.BLACK);
        door.setStrokeWidth(1);

        queueContainer.getChildren().addAll(queueLabel, queueLine, door);
        return queueContainer;
    }

    private StackPane createMetroWindow(int lineNumber) {
        StackPane window = new StackPane();
        window.setStyle("-fx-background-color: " + toHex(WINDOW_COLOR) + ";"
                + "-fx-background-radius: 5;"
                + "-fx-border-color: #0D47A1;"
                + "-fx-border-radius: 5;"
                + "-fx-border-width: 2;");
        window.setPrefSize(120, 80);
        window.setPadding(new Insets(5));

        // Window text
        Text windowText = new Text("Line " + lineNumber);
        windowText.setFont(Font.font(16));
        windowText.setFill(Color.WHITE);

        window.getChildren().add(windowText);
        return window;
    }

    private String toHex(Color color) {
        return String.format("#%02X%02X%02X",
                (int) (color.getRed() * 255),
                (int) (color.getGreen() * 255),
                (int) (color.getBlue() * 255));
    }

    public static void main(String[] args) {
        launch(args);
    }
}