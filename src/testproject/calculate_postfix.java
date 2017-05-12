/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testproject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author pcchanda
 */
public class calculate_postfix {

    public static Stack calculate(Stack exp) {
        Stack result = exp;
        double a;
        double b;
        ArrayList<String> arrlist;
        arrlist = new ArrayList<String>();

        while (!exp.isEmpty()) {
            arrlist.add((String) exp.pop());
        }

        for (int i = arrlist.size() - 1; i >= 0; i--) {

            if (!post_to_infix.isOprator(arrlist.get(i))) {
                result.push(Double.parseDouble(arrlist.get(i)));
            } else if (post_to_infix.isOprator(arrlist.get(i))) {

                b = (double) result.pop();  //top
                a = (double) result.pop();
                result.push(calculate_postfix.math(a, b, arrlist.get(i)));

            }

        }
        return result;
    }

    public static double math(double a, double b, String op) {
        double r;
        switch (op) {
            case "+":
                r = a + b;
                break;
            case "-":
                r = a - b;
                break;
            case "*":
                r = a * b;
                break;
            case "/":
                r = a / b;
                break;
            default:
                r = 0;
        }
        return r;
    }

}
