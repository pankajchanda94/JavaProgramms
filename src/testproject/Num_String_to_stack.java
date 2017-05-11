/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testproject;

import java.util.Stack;

/**
 *
 * @author pcchanda
 */
public class Num_String_to_stack {
    public static Stack calculateExp(String exp){
        //String exp = "13+(145*234)";
       // Stack result = null;
        Stack<String> result = new Stack<String>();
        String nums = "";
        for (int i=0;i<exp.length();i++)
        {
            if(Num_String_to_stack.isNum(exp.charAt(i)))
            {
                nums += exp.charAt(i);
            }
            else{
                
                if(nums==""){
                    result.push(Character.toString(exp.charAt(i)));
                    
                }
                else{
                    result.push(nums);
                    result.push(Character.toString(exp.charAt(i)));
                    nums = "";
                    
                }
            }
            
        }
  
        System.out.println("Num_String_to_stack ="+result.toString());
        
        return result;
                
    }
    
    public static boolean isNum(char num)
    {
        
        return((num>=48)&&(num<=57));
        
    }
    
}
