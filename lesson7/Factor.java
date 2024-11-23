import java.beans.Expression;
import java.util.*;

// 式の因子（factor）を表すクラス

public class Factor extends Node {

    public String toString() {
        return "Factor";
    }

    // 指定された状態（state）での式の値を求めるメソッド
    double eval(Map<String, Expression> state) {
        Token t = (Token)childList.get(0);
        // 処理内容を考えて
        // ここに実装する
        /*（）：括弧の処理 */

        if(t.str.equals("(")) {
            Expression exp = (Expression)childList.get(1);
            return exp.eval(state);

        /*数値の処理 */
        }else if(t.kind.equals("number")){
            return t.value;

        /*変数名の処理 */
        }else if(t.kind.equals("name")){
            Expression exp = state.get(t.str);
            if(exp == null){
                System.out.println("Err : Undefined expression: " + t.str);
                System.exit(1);
            }
            return exp.eval(state);
        }
    }
}
