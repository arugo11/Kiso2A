import java.io.*;
import java.util.*;

// 数式処理プログラムのメインクラス

public class ExpMain {

    public static void main(String[] args) {
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
                    // 2) この行の残りを構文解析して式（Expressionオブジェクト）を取得する
                    // 3) 式の構文木を出力する（確認用）
                    // 4) 名前の文字列と式の対応関係を状態（Map）に登録する
                } else if (t.str.equals("eval")) {  // evalコマンドで式の値を計算する
                    // 1) まず，この行の残りを構文解析して式（Expressionオブジェクト）を取得する
                    // 2) 式の構文木を出力する（確認用）
                    // 3) 式にevalメソッドを適用して式の値を求め，出力する
                } else {  // コマンドが無い場合は，入力された式の構文木を出力する
                    tokenizer.backToken();  // トークンtを読まなかったことにする
                    Parser parser = new Parser(tokenizer);
                    Expression exp = parser.parseExpression();  // この行を構文解析して式を取得
                    exp.print();  // 式の構文木を出力
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
