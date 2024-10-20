![Screen Shot 2024-10-20 at 16 28 55](https://github.com/user-attachments/assets/ea2e885d-a244-4aea-a51b-c10dd92f4537)


This  'HelloController' manages a calculator's input and operations. It uses a `Calculator` object to handle arithmetic functions. The `TextField` (`txtDisplay`) shows user input and results.

Key methods:
- *handlerDigitAction: Appends digits to the display.
- *handlerGeneralAction: Sets the operator and first operand, handles percentage conversion.
- *handlerEqualAction: Executes the calculation, displays the result or an error if needed.
- *handlerClearAction: Resets the calculator and clears the display.
- *handlerDecimalAction: Ensures only one decimal point is added.

This `Calculator` class performs basic arithmetic operations and handles errors like division by zero.

### Key Components:
- *Fields*: 
  - `operand1` and `operand2` store the operands.
  - `operator` holds the chosen arithmetic operator.
  - `result` stores the calculation result.
  - `isError` tracks if an error occurs during calculations.

### Methods:
- **Setters**: `setOperand1()`, `setOperand2()`, `setOperator()` to assign values.
- **`calculate()`**: Performs the operation based on the operator (`+`, `-`, `*`, `/`), sets `isError` if an invalid operation occurs (e.g., division by zero).
- **`reset()`**: Clears operands, operator, result, and error status.
- **Getters**: `getResult()` retrieves the result, and `isError()` checks for errors. 

