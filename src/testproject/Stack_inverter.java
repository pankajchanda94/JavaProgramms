/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testproject;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author pcchanda
 */
public class Stack_inverter {
    public static Stack evaluate(Stack exp){
        
        Stack<String> result = new Stack<String>();
        ArrayList<String> arrlist = new ArrayList<String>();
        //[13, +, (, 145, *, 234, )]
        String temp;
        while(!exp.isEmpty())
        {
            temp = (String)exp.pop();
        arrlist.add(temp);
        result.push(temp);
        }
        System.out.println(arrlist.toString());
        System.out.println(result.toString());
        return result;
        
    }
}
