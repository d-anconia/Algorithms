package com.danil.gorchakov;


import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

import java.util.Stack;

public class Evaluate {
    public static void main(String[] args) {

        Stack<String> ops = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();
        while(!StdIn.isEmpty()){
            String s = StdIn.readString();
            if(s.equals("(")) ;
            else if(s.equals("+")) ops.push(s);
            else if(s.equals("-")) ops.push(s);
            else if(s.equals("*")) ops.push(s);
            else if(s.equals("/")) ops.push(s);
            else if(s.equals("sqrt")) ops.push(s);
            else if(s.equals(")")){

                // Выталкивание, вычисление и вталкивание результата
                String op = ops.pop();
                double v = vals.pop();
                if(op.equals("+")) v = vals.pop()+v;
                else if(op.equals("-")) v = vals.pop()-v;
                else if(op.equals("*")) v = vals.pop()*v;
                else if(op.equals("/")) v = vals.pop()/v;
                else if(op.equals("sqrt")) v = Math.sqrt(v);
                vals.push(v);
            }
            else vals.push(Double.parseDouble(s));
        }
        StdOut.println(vals.pop());
    }
}
