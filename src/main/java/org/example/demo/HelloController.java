package org.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class HelloController {

    Calculator calc = new Calculator();
    private boolean isSecondOperand = false;


    @FXML
    private TextField txtDisplay;


    // Methods for UI interaction
    @FXML
    private void handlerDigitAction(ActionEvent event) {
        String digit = ((Button) event.getSource()).getText();
        if (isSecondOperand) {
            txtDisplay.setText(""); // Clear display for the second operand
            isSecondOperand = false;
        }
        txtDisplay.appendText(digit); // Append the digit to the display
    }

    @FXML
    private void handlerGeneralAction(ActionEvent event) {
        if (!txtDisplay.getText().isEmpty()) {
            String operator = ((Button) event.getSource()).getText();

            // Check if the "%" button is pressed
            if (operator.equals("%")) {
                double value = Double.parseDouble(txtDisplay.getText());
                // Convert the current value to a percentage
                txtDisplay.setText(String.valueOf(value / 100));
                isSecondOperand = true; // Reset for the next operand input
            } else {
                // For other operators, set the first operand and operator
                calc.setOperand1(Double.parseDouble(txtDisplay.getText()));
                calc.setOperator(operator.charAt(0));
                isSecondOperand = true; // Prepare for second operand input
            }
        }
    }


    @FXML
    private void handlerEqualAction(ActionEvent event) {
        if (!txtDisplay.getText().isEmpty()) {
            // Set the second operand
            calc.setOperand2(Double.parseDouble(txtDisplay.getText()));
            // Perform the calculation
            calc.calculate();
            if (calc.isError()) {
                txtDisplay.setText("Error: Division by Zero"); // Handle division by zero error
                calc.reset(); // Reset after error
            } else {
                txtDisplay.setText(String.valueOf(calc.getResult())); // Display the result
            }
        }
    }

    @FXML
    private void handlerClearAction(ActionEvent event) {
        // Reset the calculator and clear the display
        calc.reset();
        txtDisplay.setText("");
        isSecondOperand = false;
    }

    @FXML
    public void handlerDecimalAction(ActionEvent event) {
        String currentText = txtDisplay.getText();

        // Check if the current text already contains a decimal point
        if (!currentText.contains(".")) {
            if (isSecondOperand) {
                txtDisplay.setText("0."); // If starting a new operand, start with "0."
                isSecondOperand = false;  // Switch back to entering the second operand
            } else {
                txtDisplay.appendText("."); // Append the decimal point
            }
        }
    }

}