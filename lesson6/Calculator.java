import java.util.*;
import java.io.*;

/**
 * 複数スレッドを使用して数値の並列加算処理を行うクラス
 * @author AL23088 嶋中雄大
 * @file   Calculator.java
 */
public class Calculator {
    
    /** 入力データを保持するリスト */
    private List<Integer> dataList;
    
    /** 計算ノードを管理するリスト */
    private List<CalcNode> nodeList;
    
    /** 合計値 */
    private long sum;

    /**
     * でCalculatorの初期化
     * @param fileName 入力ファイル名
     */
    public Calculator(String fileName) {
        dataList = new ArrayList<Integer>();
        nodeList = new ArrayList<CalcNode>();
        sum = 0;
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {
                dataList.add(Integer.parseInt(line.trim()));
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 計算ノードの生成
     * @param n 生成する計算ノード数
     */
    public void createNodes(int n) {
        for (int i = 0; i < n; i++) {
            CalcNode node = new CalcNode();
            node.assign(i, n);
            nodeList.add(node);
            node.start();
        }
    }

    /**
     * 合計値に加算
     * @param value 加算する値
     */
    synchronized void addSum(long value) {
        sum += value;
    }

    /**
     * 合計値を返す
     * @return 計算結果の合計値
     */
    public long getSum() {
        try {
            for (CalcNode node : nodeList) {
                node.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return sum;
    }

    /**
     * 並行して動作する計算ノードを表す
     */
    class CalcNode extends Thread {
        int myId;
        int numNodes;
        
        void assign(int i, int n) {
            this.myId = i;
            this.numNodes = n;
        }

        public void run() {
            long sum = 0;
            int numData = dataList.size();
            long start = System.nanoTime();
            
            // このノードの担当範囲の加算を実行
            for (int i = this.myId * numData / this.numNodes;
                 i < (this.myId + 1) * numData / this.numNodes; i++) {
                sum += dataList.get(i);
                try {
                    Thread.sleep(1); // 計算コストの代わり
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            
            addSum(sum); // 計算結果を全体のsumに加える
            long end = System.nanoTime();
            System.out.println("ThreadTime:" + (end - start) / 1000000f + "ms");
        }
    }
}