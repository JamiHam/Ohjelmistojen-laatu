package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//A JavaFx application that displays a window with 2 buttons, a text field and a label.
public class View extends Application {
    Calculator calculator = new Calculator();

    @Override
    public void start(Stage stage) {
        stage.setTitle("Calculator");

        Label sum = new Label();
        sum.setText("Sum: " + calculator.getSum());

        TextField input = new TextField();

        Button reset = new Button();
        reset.onMouseClickedProperty().set((event) -> {
            calculator.reset();
            sum.setText("Sum: " + calculator.getSum());
        });
        reset.setText("Reset");

        Button add = new Button();
        add.onMouseClickedProperty().set((event) -> {
            try {
                calculator.add(Integer.parseInt(input.getText()));
                sum.setText("Sum: " + calculator.getSum());
            } catch (NumberFormatException e) {
                System.out.println("The given input is not a number.");
            }
        });
        add.setText("Add");

        stage.setScene(new Scene(new VBox(input, add, reset, sum), 300, 250));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
