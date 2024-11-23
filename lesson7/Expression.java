import java.util.*;

// 式（expression）を表すクラス

public class Expression extends Node {

    public String toString() {
        return "Expression";
    }

    // 指定された状態（state）での式の値を求めるメソッド
// Expression.java
double eval(Map<String, Expression> state) {
    System.out.println("Expression eval start");
    double value = childList.get(0).eval(state);
    System.out.println("Expression first term value: " + value);

    for (int i = 1; i < childList.size(); i += 2) {
        Token t = (Token)childList.get(i);
        Term t2 = (Term)childList.get(i+1);
        System.out.println("Expression operator: " + t.str);
        double termVal = t2.eval(state);
        System.out.println("Expression term value: " + termVal);
        if (t.str.equals("+")) {
            value += termVal;
        } else {
            value -= termVal;
        }
        /*デバック用 */
        System.out.println("Expression current value: " + value);
    }
    System.out.println("Expression final value: " + value);
    return value;
}
}
