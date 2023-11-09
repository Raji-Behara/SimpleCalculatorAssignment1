package com.example.simplecalculatorapp;

import android.util.Log;

import java.util.Arrays;
import java.util.List;

public class Calculator {
    private String inputString;

    List<String> operators = Arrays.asList(new String[]{"*", "+", "-", "/"});

    final static int DOUBLE_DIGIT = 02;
    final static int EMPTY_EXPRESSION = 02;
    final static int OPERATOR_ERROR = 02;

    public void push(String input) {
        if (input != null && !input.isEmpty()) {
            this.inputString = input;
        }

    }

    public int calculate() {

        char[] charArray = this.inputString.toCharArray();

        if (!(isValidOperand(charArray[0])))//validating firstoperand
        {
            // return  DOUBLE_DIGIT;
            throw new CalculatorException("Invalid Input", 1001);

        }

        int firstOperand = Character.getNumericValue(charArray[0]);
        int result = 0;
        for (int i = 1; i <= charArray.length - 2; ) {
            char opr = charArray[i];
            if (!isValidOperator(opr + "")) {
                // return OPERATOR_ERROR;
                throw new CalculatorException("Invalid Input", 1001);
            }

            if (!(isValidOperand(charArray[i + 1])))//validating second operand
            {
                // return DOUBLE_DIGIT;
                throw new CalculatorException("Invalid Input", 1001);
            }

            int secondOperand = Character.getNumericValue(charArray[i + 1]);

            switch (opr) {
                case '+':
                    result = firstOperand + secondOperand;
                    break;


                case '-':
                    result = firstOperand - secondOperand;
                    break;

                case '*':
                    result = firstOperand * secondOperand;
                    break;

                case '/':
                    if (secondOperand == 0) {
                        throw new CalculatorException("/ Zero Not Possible", 1002);
                    }

                    result = firstOperand / secondOperand;
                    break;
            }

            firstOperand = result;
            i = i + 2;
        }

        return result;

    }

    private boolean isValidOperator(String opr) {

        if (operators.contains(opr)) {
            return true;
        }
        return false;
    }

    private boolean isValidOperand(char c) {

        if (Character.isDigit(c)) {
            return true;
        }
        return false;
    }
}

