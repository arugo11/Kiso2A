    import java.io.*;
    import java.util.*;

    /**
     * @author al23088 Yudai Shimanaka
     * @file ExpSimple.java
     */
    public class ExpSimple {
        /**
         * 変数名と整数値の対応を保持するマップ
         * キー: 変数名 (String)
         * 値: 割り当てられた整数値 (Integer)
         */
        static Map<String, Integer> state = new HashMap<String, Integer>();

        /**
         * 標準入力からコマンドを読み取り、対応する処理を実行
         * 
         * 入力形式:
         * - set 変数名 整数値
         * - show
         * - exit
         * - 変数名
         * 
         * 空行は無視
         * exitが入力されるまで処理を継続
         * 
         * @param args コマンドライン引数
         */
        public static void main(String[] args) {
            try {
                BufferedReader br = new BufferedReader(
                    new InputStreamReader(System.in)); // 標準入力
                String line;
                while ((line = br.readLine()) != null) { // 対話的な入出力のループ
                    if (line.equals("")) { // 空行の場合
                        continue;
                    }
                    if (line.equals("exit")) { // exit コマンド：プログラム終了
                        break;
                    }
                    if (line.startsWith("set")) { // set コマンド：変数と数値の対応
                        processSetCommand(line);
                    } else if (line.equals("show")) { // show コマンド
                        processShowCommand();
                    } else {
                        processVariableReference(line);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /**
         * setコマンド
         * 入力形式: set 変数名 整数値
         * 
         * @param line 入力された文字列
         */
        private static void processSetCommand(String line) {
            String[] parts = line.split(" ");
            if (parts.length != 3) {
                return;
            }
            String varName = parts[1];
            // 変数名の文字列が英字で始まる英数字列かどうか確認
            if (!varName.matches("[a-zA-Z][a-zA-Z0-9]*")) {
                System.out.println("変数名 " + varName + "は不正です");
                return;
            }
            try {
                // 数値の文字列を int 型の値に変換
                int value = Integer.parseInt(parts[2]);
                // マップ（state）に変数名と数値の関係を設定
                state.put(varName, value);
                System.out.println("変数 " + varName + " に " + value + " を割り当てました");
            } catch (NumberFormatException e) {
                // 数値変換失敗
            }
        }

        /**
         * showコマンドを処理します。
         * 定義済みの全変数とその値を表示
         */
        private static void processShowCommand() {
            for (Map.Entry<String, Integer> entry : state.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }

        /**
         * 変数参照を処理
         * 変数が定義済みの場合はその値を、未定義の場合はエラーメッセージを表示
         * 
         * @param varName 参照する変数名
         */
        private static void processVariableReference(String varName) {
            Integer value = state.get(varName);
            if (value == null) {
                System.out.println("変数 " + varName + " は未定義です");
            } else {
                System.out.println(value);
            }
        }
    }