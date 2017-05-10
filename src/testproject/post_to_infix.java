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
public class  post_to_infix{
    
    public Stack calculate(String exp){
        
        Stack pexp = new Stack();
        // TODO code application logic here
        
        Stack opst = new Stack();
        //String exp = "(a+b)*(c+d)";
        //String exp = "a+b+c+d";
        //String exp = "a*b+c*d";
        //String exp = "a+b*c+d";
        //String exp = "a+b*c-d/e*f";
        //String exp = "a+b*c";
        //solution - abc*+de/f*-
        //-*
        int strlen = exp.length();

        for (int i = 0; i < strlen; i++) {

            if (!post_to_infix.isOprator(exp.charAt(i))) {
                pexp.push(exp.charAt(i));
                // System.out.println("print :"+exp.charAt(i));

            } else {

                //opst.push(exp.charAt(i));
                if (opst.isEmpty() || exp.charAt(i) == '(') {

                    //  System.out.println("opst.isEmpty or (");
                    opst.push(exp.charAt(i));

                } else if (exp.charAt(i) != ')') {

                    char chart = exp.charAt(i);
                    // System.out.println("exp.charati != )");
                    try {
                        while (!opst.isEmpty() && (char) opst.peek() != '(' && (post_to_infix.priotity(chart) >= post_to_infix.priotity((char) opst.peek()))) {
                            pexp.push(opst.pop());

                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    opst.push(chart);
                } else {
                    while ((char) opst.peek() != '(') {
                        pexp.push(opst.pop());
                    }
                    if ((char) opst.peek() == '(') {
                        opst.pop();
                    }

                }

            }

        }
        while (!opst.isEmpty() && (char)opst.peek() != '(' && (char)opst.peek() != ')') {
            pexp.push(opst.pop());
        }
       // System.out.println(pexp.toString());
       // System.out.println(opst.toString());
        return pexp;
    }
    
    
    public static boolean isOprator(char a) {
//        if(57< a | a<48 ){
//          
//           return true;
//           
//       }
//       else{
//           return false;
//       }
        //System.out.println("isOperator :"+ a);
        return (122 < a | a < 97);

    }

    public static int priotity(char Op) {
        int x = 0;
        switch (Op) {
            case '^':
                x = 1;
                break;
            case '*':
                x = 2;
                break;
            case '/':
                x = 2;
                break;
            case '+':
                x = 3;
                break;
            case '-':
                x = 3;
                break;
            default:
                System.out.println("NO MATCH FOUND");
        }
        return x;
    }

}

    
    
    
    




