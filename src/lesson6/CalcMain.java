/**
 * 並列数値加算プログラムのメインクラス
 * data.txtから数値を読み込み、複数スレッドで並列に合計値を計算
 * @author AL23088 嶋中雄大
 * @file   CalcMain.java
 */
public class CalcMain {
    /**
     * Calculatorを使用して並列数値加算を実行し、処理時間を計測
     */
    public static void main(String[] args) {
        Calculator calc = new Calculator("data.txt");
        long start = System.nanoTime();
        calc.createNodes(3);
        System.out.println("SUM:" + calc.getSum());
        long end = System.nanoTime();
        System.out.println("Time:" + (end - start) / 1000000f + "ms");
    }
}