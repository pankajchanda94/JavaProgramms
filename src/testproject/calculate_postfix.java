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
    
    public static Stack calculate(Stack exp)
    {
        Stack result = exp;
        double a;
        double b;
       System.out.println("calculat_postfix : "+ exp.toString());
        ArrayList<String> arrlist;
        arrlist = new ArrayList<String>();
       
     //((3473.343+33)/(34*43.8))+789-89*(778.9/78.7867678)
     
       // System.out.println(exp.getClass().getName());
        //String str = new String();
        
        while(!exp.isEmpty())
        {
             arrlist.add((String)exp.pop());
        }
        
      // result =  Stack_inverter.evaluate(exp);
       System.out.println("Stack inverter in arr list : "+ arrlist.toString());
       //System.out.println("dfdfdf"+arrlist.toString());
       System.out.println("arraylist size is: "+arrlist.size());
       
       for(int i=arrlist.size()-1;i>=0;i--)
       {
           //str = arrlist.get(i);
           //(343+23.4)-(345*343)
           //[-, *, 343, 345, +, 23.4, 343]
           if(!post_to_infix.isOprator(arrlist.get(i)))
           {
               result.push(Double.parseDouble(arrlist.get(i)));
               System.out.println("the number is : "+arrlist.get(i));
               System.out.println("result stack is :"+result.toString());
           }
           else if(post_to_infix.isOprator(arrlist.get(i)))
           {
               //b-a
               b = (double)result.pop();  //top
               a= (double)result.pop();
               result.push(calculate_postfix.math(a,b,arrlist.get(i)));
               System.out.println("the pushed result is : "+calculate_postfix.math(a,b,arrlist.get(i)));
               System.out.println("result stack is :"+result.toString());
           }
            
           
       }
        return result;
    }
    
    public static double math(double a,double b,String op)
    {
        double r;
       switch(op)
       {
           case "+":
               r = a+b;
               System.out.println("1 r is "+r);
               break;
           case "-":
               r = a-b;
               break;
           case "*":
               r = a*b;
               break;
           case "/":
               r = a/b;
               break;
           default:
               r = 0;        
       }
       System.out.println("2 r is "+r);
       return r;
    }
    
}
