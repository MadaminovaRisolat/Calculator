package org.example.demo;

public class Calculator {

    private double operand1;
    private double operand2;
    private char operator;
    private double result;
    private boolean isError;

    // Setters for operands and operator
    public void setOperand1(double operand1) {
        this.operand1 = operand1;
    }

    public void setOperand2(double operand2) {
        this.operand2 = operand2;
    }

    public void setOperator(char operator) {
        this.operator = operator;
    }

    // Get the result of the calculation
    public double getResult() {
        return result;
    }

    // Check if an error occurred during the calculation
    public boolean isError() {
        return isError;
    }

    // Reset the calculator state
    public void reset() {
        operand1 = 0;
        operand2 = 0;
        operator = '\0';
        result = 0;
        isError = false;
    }

    // Perform the calculation based on the operator
    public void calculate() {
        isError = false;  // Reset error state before each calculation

        switch (operator) {
            case '+':
                result = operand1 + operand2;
                break;
            case '-':
                result = operand1 - operand2;
                break;
            case '*':
                result = operand1 * operand2;
                break;
            case '/':
                if (operand2 == 0) {
                    isError = true;  // Division by zero error
                } else {
                    result = operand1 / operand2;
                }
                break;
            default:
                isError = true; // Invalid operator
        }
    }
}
