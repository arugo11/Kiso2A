import java.beans.Expression;
import java.util.*;

// 式の項（term）を表すクラス

public class Term extends Node {
    public String toString() {
        return "Term";
    }

    // 指定された状態（state）での式の値を求めるメソッド
    double eval(Map<String, Expression> state) {
        double val = childList.get(0).eval(state);  // 1つめの子であるTermの値を求める
        // 処理内容を考えて
        // ここに実装する

        for (int i = 1; i < childList.size(); i += 2/*演算子と因子を処理 */){
            Token t = (Token)childList.get(i);
            Factor f = (Token)childList.get(i + 1);
            if (t.str.equals("*")){
                val *= f.eval(state);
            }else if(t.str.equals("/")){
                val /= f.eval(state);
            }else{
                System.out.println("Err : 不適切な演算子");
                System.exit(1);
            }

            return val;
        }
    }
}
