import java.io.*;
import java.util.*;

// 数式処理プログラムのメインクラス
public class ExpMain {
    public static void main(String[] args) {
        // 名前と式の対応を記憶するマップ型のオブジェクト
        Map<String, Expression> state = new HashMap<String, Expression>();
        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(System.in));  // 標準入力
            String line;
            while ((line = br.readLine()) != null) {  // 対話的な入出力のループ
                Tokenizer tokenizer = new Tokenizer(line);  // 入力行を字句解析する
                Token t = tokenizer.nextToken();
                if (t == null) {  // 空行の場合
                    continue;
                }
                if (t.str.equals("exit")) {  // exitコマンドでプログラム終了
                    break;
                }
                if (t.str.equals("set")) {  // setコマンドで名前と式の対応を定義できる
                    // 1) 次のトークンを取得する（名前のはず）
                    Token name = tokenizer.nextToken();
                    // 2) この行の残りを構文解析して式を取得する
                    Parser parser = new Parser(tokenizer);
                    Expression exp = parser.parseExpression();
                    // 3) 式の構文木を出力する（確認用）
                    exp.print();
                    // 4) 名前の文字列と式の対応関係を状態（Map）に登録する
                    state.put(name.str, exp);

                } else if (t.str.equals("eval")) {  // evalコマンドで式の値を計算する
                    Parser parser = new Parser(tokenizer);
                    Expression exp = parser.parseExpression();
                    exp.print();
                    double val = exp.eval(state);
                    System.out.println(val);
                } else {  // コマンドが無い場合は，入力された式の構文木を出力する
                    tokenizer.backToken();  // トークンtを読まなかったことにする
                    Parser parser = new Parser(tokenizer);
                    Expression exp = parser.parseExpression();
                    exp.print();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}