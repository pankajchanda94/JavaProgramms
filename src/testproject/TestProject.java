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
        // TODO code application logic here
     
        String exp = "";
        Stack pexp = new Stack();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            exp = in.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        post_to_infix calc = new post_to_infix();
        pexp = calc.calculate(exp);
        //System.out.println(pexp.peek());
        System.out.println(pexp.toString());
       // System.out.println(pexp.toArray());
        //String exp = "(a+b)*(c+d)";
        //String exp = "a+b+c+d";
        //String exp = "a*b+c*d";
        //String exp = "a+b*c+d";
        //String exp = "a+b*c-d/e*f";
        //String exp = "a+b*c";
        //solution - abc*+de/f*-
        //-*
     
    }
    }

    