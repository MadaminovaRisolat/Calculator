package org.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class HelloController {

    // Calculator instance to handle arithmetic operations
    Calculator calc = new Calculator();

    // Flag to track if the user is entering the second operand
    private boolean isSecondOperand = false;

    // TextField for displaying the calculator's input and result
    @FXML
    private TextField txtDisplay;

    // Method to handle digit button clicks
    @FXML
    private void handlerDigitAction(ActionEvent event) {
        String digit = ((Button) event.getSource()).getText();
        // If the user is entering the second operand, clear the display
        if (isSecondOperand) {
            txtDisplay.setText(""); // Clear display for the second operand
            isSecondOperand = false;
        }
        // Append the clicked digit to the display
        txtDisplay.appendText(digit);
    }

    // Method to handle operator button clicks
    @FXML
    private void handlerGeneralAction(ActionEvent event) {
        // Ensure the display is not empty before proceeding
        if (!txtDisplay.getText().isEmpty()) {
            String operator = ((Button) event.getSource()).getText();

            // Handle percentage button press separately
            if (operator.equals("%")) {
                double value = Double.parseDouble(txtDisplay.getText());
                // Convert the current value to a percentage
                txtDisplay.setText(String.valueOf(value / 100));
                isSecondOperand = true; // Prepare for next operand input
            } else {
                // Set the first operand and the chosen operator
                calc.setOperand1(Double.parseDouble(txtDisplay.getText()));
                calc.setOperator(operator.charAt(0)); // Set the operator (+, -, *, /)
                isSecondOperand = true; // Prepare for second operand input
            }
        }
    }

    // Method to handle the "=" button click (perform calculation)
    @FXML
    private void handlerEqualAction(ActionEvent event) {
        // Ensure the display is not empty before proceeding
        if (!txtDisplay.getText().isEmpty()) {
            // Set the second operand
            calc.setOperand2(Double.parseDouble(txtDisplay.getText()));
            // Perform the calculation based on the set operands and operator
            calc.calculate();
            // Handle any calculation errors (e.g., division by zero)
            if (calc.isError()) {
                txtDisplay.setText("Error: Division by Zero"); // Display error message
                calc.reset(); // Reset the calculator after an error
            } else {
                // Display the calculated result
                txtDisplay.setText(String.valueOf(calc.getResult()));
            }
        }
    }

    // Method to handle the "C" button click (clear display and reset calculator)
    @FXML
    private void handlerClearAction(ActionEvent event) {
        // Reset the calculator and clear the display
        calc.reset();
        txtDisplay.setText("");
        isSecondOperand = false; // Reset flag for entering new operands
    }

    // Method to handle the decimal point button click
    @FXML
    public void handlerDecimalAction(ActionEvent event) {
        String currentText = txtDisplay.getText();

        // Ensure the display doesn't already contain a decimal point
        if (!currentText.contains(".")) {
            // If starting a new operand, start with "0."
            if (isSecondOperand) {
                txtDisplay.setText("0.");
                isSecondOperand = false;  // Prepare for second operand input
            } else {
                // Append a decimal point to the current input
                txtDisplay.appendText(".");
            }
        }
    }
}
