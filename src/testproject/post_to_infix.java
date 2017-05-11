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
    
    public  Stack calculate(Stack  exp){
        
        //  [), 456, *, 45422, (, +, 13]
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
        //String exp = "13+12*345";
        //-*
      //  int strlen = exp.length();
        
        while (!exp.isEmpty()) {
            
            String item = (String)exp.pop();

            if (!post_to_infix.isOprator(item)) {
                pexp.push(item);
                System.out.println("1 item is: "+item);
                System.out.println("pushed to pexp:"+item);
                System.out.println("pext is: "+pexp.toString());

            } else {
              //  [), 456, *, 45422, (, +, 13]
                //opst.push(item);
                //(89+45.3)*(8.0+3.9)
                if (opst.isEmpty() || item == "(") {

                    //  System.out.println("opst.isEmpty or (");
                    opst.push(item);
                    System.out.println("2 item is: "+item);
                    System.out.println("pushed to opst:"+item);
                    System.out.println("opst is: "+opst.toString());
                } else if (!item.equals(")")) {

                    String chart = item;
                    // System.out.println("exp.charati != )");
                    try {
                      while (!opst.isEmpty() && !((String)opst.peek()).equals("(") && (post_to_infix.priotity(chart) >= post_to_infix.priotity((String) opst.peek()))) 
                      {
                          
                          System.out.println(((String)opst.peek()).equals("("));
                             System.out.println("3 item is: "+opst.peek());
                            pexp.push(opst.pop());
                            System.out.println("4 item is: "+item);
                            System.out.println("pext is: "+pexp.toString());

                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    opst.push(chart);
                    System.out.println("5 item is: "+item);
                    System.out.println("opst is: "+opst.toString());
                } else {
                    while (!((String)opst.peek()).equals("(")) {
                        pexp.push(opst.pop());
                        System.out.println("6 item is: "+item);
                        System.out.println("pext is: "+pexp.toString());
                    }
                    if (((String)opst.peek()).equals("(")) {
                        opst.pop();
                        System.out.println("7 item is: "+item);
                        System.out.println("opst is: "+opst.toString());
                    }

                }

            }

        }
        while (!opst.isEmpty() && !((String)opst.peek()).equals("(") && !((String)opst.peek()).equals(")")) {
            pexp.push(opst.pop());
            System.out.println("pext is: "+pexp.toString());
        }
       // System.out.println(pexp.toString());
       // System.out.println(opst.toString());
        return pexp;
    }
    
    
    public static boolean isOprator(String a) {
//        if(57< a | a<48 ){
//          
//           return true;
//           
//       }
//       else{
//           return false;
//       }
        //System.out.println("isOperator :"+ a);
        try{
        Double.parseDouble(a);
        System.out.println("is not Operator :"+a);
        return false;
        
        }
        catch(NumberFormatException e)
        {
            System.out.println("is a Operator :"+a);
            return true;
        }
        //return (122 < a | a < 97);

    }

    public static int priotity(String Op) {
        int x = 0;
        switch (Op) {
            case "^":
                x = 1;
                break;
            case "*":
                x = 2;
                break;
            case "/":
                x = 2;
                break;
            case "+":
                x = 3;
                break;
            case "-":
                x = 3;
                break;
            default:
                System.out.println("NO MATCH FOUND");
        }
        return x;
    }

}

    
    
    
    




