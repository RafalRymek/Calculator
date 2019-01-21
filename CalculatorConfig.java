package main;

import java.util.Scanner;

import static main.CalculatorConsts.*;
import static main.CalculatorConsts.DECISION_OPERATION;
import static main.CalculatorConsts.MESSAGE;

class CalculatorConfig {


    private static Scanner userInput = new Scanner(System.in);

    protected static boolean status = true;


    protected static void startCalculator() {
        double firstNumber = getNumberInput(FIRST_NUMBER);

        String operationSymbol = getOperation();

        double secondNumber = getNumberInput(SECOND_NUMBER);

        chooseOperation(firstNumber, operationSymbol, secondNumber);
        checkStatus();
    }

    private static String getOperation() {
        System.out.println(CHOOSE_OPERATION);
        String operationSymbol = userInput.next();
        while (!operationSymbol.matches("[-+*:]")) {
            System.out.println(VALIDATE_OPERATION);
            operationSymbol = userInput.next();
        }
        return operationSymbol;
    }

    private static double getNumberInput(String s) {
        System.out.println(s);
        validateInput();
        return userInput.nextDouble();
    }

    private static void validateInput() {
        while (!userInput.hasNextDouble()) {
            userInput.next();
            System.out.println(MESSAGE);
        }
    }

    private static void checkStatus() {
        System.out.println(DECISION_OPERATION);
        String isOn = userInput.next();
        if (!isOn.equals("t")) status = false;
    }

    private static void chooseOperation(double firstNumber, String operationSymbol, double secondNumber) {
        switch (operationSymbol) {
            case "-":
                System.out.println(ComputationsEnum.SUBTRACT.perform(firstNumber, secondNumber));
                break;
            case "+":
                System.out.println(ComputationsEnum.ADD.perform(firstNumber, secondNumber));
                break;
            case "*":
                System.out.println(ComputationsEnum.MULTIPLY.perform(firstNumber, secondNumber));
                break;
            case ":":
                System.out.println(ComputationsEnum.DIVIDE.perform(firstNumber, secondNumber));
                break;
        }
    }

}
