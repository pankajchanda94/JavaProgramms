/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testproject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 *
 * @author pcchanda
 */
public class TestProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String exp = "";
        Stack pexp = new Stack();
        Stack<String> corrStack = new Stack<String>();

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            exp = in.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }

        post_to_infix calc = new post_to_infix();

        corrStack = Stack_inverter.evaluate(Num_String_to_stack.calculateExp(exp));

        pexp = calc.calculate(corrStack);

        System.out.println("Result is: " + calculate_postfix.calculate(pexp).toString());
    }
}
