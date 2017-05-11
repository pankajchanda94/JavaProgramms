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
    
    public static String calculate(Stack exp)
    {
        Stack result = exp;
        int a;
        int b;
        
        ArrayList<Character> arrlist;
        arrlist = new ArrayList<Character>();
     
        System.out.println(exp.getClass().getName());
        String str = new String();
        
        while(!exp.isEmpty())
        {
            arrlist.add((char)exp.pop());
        }
       System.out.println("dfdfdf"+arrlist.toString());
       for(int i=arrlist.size();i>=0;i--)
       {
           if(!post_to_infix.isOprator((char)arrlist.indexOf(i)))
           {
               result.push(arrlist.indexOf(i));
           }
           else if(post_to_infix.isOprator((char)arrlist.indexOf(i)))
           {
               //a-b
               a = (int)result.pop();
               b= (int)result.pop();
               result.push(calculate_postfix.math(a,b,(char)arrlist.indexOf(i)));
           }
            
           
       }
        return str;
    }
    
    public static float math(int a,int b,char op)
    {
        float r;
       switch(op)
       {
           case '+':
               r = a+b;
           case '-':
               r = a-b;
           case '*':
               r = a*b;
           case '/':
               r = a/b;
           default:
               r = 0;        
       }
       return r;
    }
    
}
