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
        String previousOperator = "";
        for (int i=0;i<exp.length();i++)
        {
            
//            if( i != exp.length()-1 &&  exp.charAt(i) == ')' && ( exp.charAt(i+1)==')' || Num_String_to_stack.isNum(exp.charAt(i+1) )))
//            {
//                System.out.println("char at i" +exp.charAt(i));
//                System.out.println("char at i+1"+exp.charAt(i+1));
//                result.push("*");
//                
//            }
            if(Num_String_to_stack.isNum(exp.charAt(i)))
            {
                nums += exp.charAt(i);
                if((i != exp.length() -1) && !Num_String_to_stack.isNum(exp.charAt(i+1)) && exp.charAt(i) == '.' )
                {
                    nums += '0';
                }
                //System.out.println("nums is : "+nums);
                //System.out.println("result is"+ result);
            }
            else{
                
                if(nums==""){
                    
                    if(exp.charAt(i)=='(' && i!=0 && exp.charAt(i-1) == ')')
                    {
                        result.push("*");
                    }
                    
//                    if(exp.charAt(i) == ')')
//                    {
//                    System.out.println(exp.charAt(i) == ')' );
//                    System.out.println((i != exp.length()-1) );
//                    System.out.println((exp.charAt(i+1) == '(' ));
//                    System.out.println(exp.charAt(i+1));
//                    System.out.println(Num_String_to_stack.isNum(exp.charAt(i+1)));
//                    }
                    
                    result.push(Character.toString(exp.charAt(i)));
                    previousOperator = Character.toString(exp.charAt(i));
                    //System.out.println("pushed to result , coz nums = null : "+exp.charAt(i));
                    //System.out.println("result is"+ result);
                    
                }
                else{
                    result.push(nums);
                    // || (i!= exp.length()-1 && (Num_String_to_stack.isNum(exp.charAt(i+1))))
                    if(exp.charAt(i) == '(')
                    {
                        result.push("*");
                    }
                    result.push(Character.toString(exp.charAt(i)));
                    if(exp.charAt(i) == ')' && i != exp.length()-1 && Num_String_to_stack.isNum(exp.charAt(i+1)))
                    {
                        result.push("*");
                    }
                    previousOperator = Character.toString(exp.charAt(i));
                    nums = "";
                    //System.out.println("pushed to result,nums made=null : "+exp.charAt(i));
                    //System.out.println("result is"+ result);
                    
                }
            }
            
        }
        if(nums!=""){
           result.push(nums);  
        }
       
  
        System.out.println("Num_String_to_stack ="+result.toString());
        
        return result;
                
    }
    
    public static boolean isNum(char num)
    {
        
        return(((num>=48)&&(num<=57)) || num==46 );
        
    }
    
}
