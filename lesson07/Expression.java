import java.util.*;

// 式（expression）を表すクラス

public class Expression extends Node {
    public String toString() {
        return "Expression";
    }

    double eval(Map<String, Expression> state) {
        // System.out.println("Expression eval start");
        Node firstChild = childList.get(0);
        // System.out.println("Expression first child type: " + firstChild.getClass().getName());
        
        double value = firstChild.eval(state);
        // System.out.println("Expression first term value: " + value);
    
        for (int i = 1; i < childList.size(); i += 2) {
            Node operator = childList.get(i);
            Node secondChild = childList.get(i+1);
            // System.out.println("Expression operator type: " + operator.getClass().getName());
            // System.out.println("Expression second child type: " + secondChild.getClass().getName());
            
            Token t = (Token)operator;
            Term t2 = (Term)secondChild;
            // System.out.println("Expression operator: " + t.str);
            double termVal = t2.eval(state);
            // System.out.println("Expression term value: " + termVal);
            
            if (t.str.equals("+")) {
                value += termVal;
            } else {
                value -= termVal;
            }
            // System.out.println("Expression current value: " + value);
        }
        // System.out.println("Expression final value: " + value);
        return value;
    }
}