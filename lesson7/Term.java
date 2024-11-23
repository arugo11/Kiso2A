import java.util.*;
public class Term extends Node {
    double eval(Map<String, Expression> state) {
        System.out.println("Term eval start");
        System.out.println("Term childList size: " + childList.size());
        
        // デバッグ用に最初の子の型を確認
        Node firstChild = childList.get(0);
        System.out.println("Term first child type: " + firstChild.getClass().getName());
        
        double val = firstChild.eval(state);  // 変数名を変更して明確に
        System.out.println("Term initial value: " + val);
        
        for (int i = 1; i < childList.size(); i += 2) {
            Token t = (Token)childList.get(i);
            System.out.println("Term operator: " + t.str);
            
            Node nextChild = childList.get(i + 1);  // 次の子の型も確認
            System.out.println("Term next child type: " + nextChild.getClass().getName());
            
            Factor f = (Factor)nextChild;
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
    
    public String toString() {  // toString()メソッドも追加
        return "Term";
    }
}