import java.util.*;

public class Factor extends Node {
    public String toString() {
        return "Factor";
    }

    double eval(Map<String, Expression> state) {
        // System.out.println("Factor eval start");
        Token t = (Token)childList.get(0);
        // System.out.println("Factor token type: " + t.kind + ", value: " + t.str);
        
        double result = 0;
        if(t.str.equals("(")) {
            // System.out.println("Factor processing bracket");
            Expression exp = (Expression)childList.get(1);
            if(exp == null) {
                // System.out.println("Error: Expression is null");
                System.exit(1);
            }
            result = exp.eval(state);
            // System.out.println("Factor bracket evaluation result: " + result);
        } else if(t.kind.equals("number")) {
            result = t.value;
            // System.out.println("Factor number value: " + result);
        } else if(t.kind.equals("name")) {
            Expression exp = state.get(t.str);
            if(exp == null) {
                // System.out.println("Err : Undefined expression: " + t.str);
                System.exit(1);
            }
            result = exp.eval(state);
            // System.out.println("Factor name value: " + result);
        } else {
            // System.out.println("Err : Invalid factor type: " + t.kind + ", str: " + t.str);
            System.exit(1);
        }
        // System.out.println("Factor returning value: " + result);
        return result;
    }
}