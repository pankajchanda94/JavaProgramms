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
public class TestProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Stack pexp = new Stack();
        Stack opst = new Stack();
       String exp = "(a+b)*(c+d)";
        //String exp = "a+b+c+d";
        //String exp = "a*b+c*d";
        //String exp = "a+b*c+d";
        //String exp = "a+b*c-d/e*f";
        //String exp = "a+b*c";
        //solution - abc*+de/f*-
        //-*
        int strlen = exp.length();
       
       
      
        for(int i = 0;i<strlen;i++)
        {
           
               
        if(!TestProject.isOprator(exp.charAt(i))) {
            pexp.push(exp.charAt(i));
            System.out.println("print :"+exp.charAt(i));
            
        }
        else{
            
            //opst.push(exp.charAt(i));
            if(opst.isEmpty() || exp.charAt(i) == '('){
                opst.push(exp.charAt(i));
            }
            else
            if(exp.charAt(i) != ')'){
                
                char chart = exp.charAt(i);
                while(!opst.isEmpty() && (TestProject.priotity(chart) >= TestProject.priotity((char)opst.peek())))
                {
                    pexp.push(opst.pop());
           
                    
                }
                opst.push(chart);
            }
        
            else{
                while((char)opst.peek() != '(')
                {
                    pexp.push(opst.pop());
                }
                if((char)opst.peek() == '('){
                    opst.pop();
                }
                
           
            
             }
        
        
           
            
        }
        
        
        
     
        
        
        
    }
        while(!opst.isEmpty())
        {
            pexp.push(opst.pop());
        }
        System.out.println(pexp.toString());
        System.out.println(opst.toString());
        
    }
     public static boolean isOprator(char a)
     {
//        if(57< a | a<48 ){
//          
//           return true;
//           
//       }
//       else{
//           return false;
//       }
         System.out.println(57< a | a<48);
         return (122< a | a<97);
       
     }
     public static int priotity(char Op)
     {
         int x=0;
         switch (Op)
         {
             case '^' : 
                 x=1;
                 break;
             case '*' :
                 x=2;
                 break;
             case '/' :
                 x=2;
                 break;
             case '+' :
                 x=3;
                 break;
             case '-' : 
                 x=3;
                 break;
             default:
                 System.out.println("NO MATCH FOUND");
         }
        return x;
     }
    
}
