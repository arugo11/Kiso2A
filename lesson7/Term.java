import java.util.*;
public class Term extends Node {
    double eval(Map<String, Expression> state) {
        System.out.println("Term eval start");
        System.out.println("Term childList size: " + childList.size());
        
        double val = childList.get(0).eval(state);
        System.out.println("Term initial value: " + val);
        
        for (int i = 1; i < childList.size(); i += 2) {
            Token t = (Token)childList.get(i);
            System.out.println("Term operator: " + t.str);
            
            Factor f = (Factor)childList.get(i + 1);
            double factorVal = f.eval(state);
            System.out.println("Term factor value: " + factorVal);
            
            if (t.str.equals("*")) {
                val *= factorVal;
            } else if(t.str.equals("/")) {
                val /= factorVal;
            } else {
                System.out.println("Err : 不適切な演算子: " + t.str);
                System.exit(1);
            }
            System.out.println("Term current value: " + val);
        }
        System.out.println("Term returning value: " + val);
        return val;
    }
}