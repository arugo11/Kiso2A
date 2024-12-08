import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MainMatrix {
      public static void main(String[] args) {

            try {
                // Scannerオブジェクトを作成
                Scanner scanner = new Scanner(System.in);
                // ユーザーに入力を促す
                System.out.print("グラフのノード数を入力してください: ");
                // 整数をキーボードから取得
                int numV = scanner.nextInt();
                // ユーザーに入力を促す
                System.out.print("ダイクストラ法の始点のノード番号を入力してください: ");
                // 整数をキーボードから取得
                int start_node = scanner.nextInt();


                GraphMatrixWeight g = new GraphMatrixWeight(numV); // 隣接行列

                String filePath = "./data.txt";


                BufferedReader br = new BufferedReader(new FileReader(filePath));
                String line;
        
                // ファイルの各行を読み込む
                while ((line = br.readLine()) != null) {
                    // カンマで分割
                    String[] values = line.split(", ");
        
                    // x座標、y座標、関数の値に対する処理
                    int u = Integer.parseInt(values[0]);
                    int v = Integer.parseInt(values[1]);
                    int c = Integer.parseInt(values[2]);
        
                    // ここで取得した値に対する処理を行う
                    g.addEdge(u,v,c);
                }
                
                g.printG();

                Dijkstra d = new Dijkstra(numV, g.adj);
                d.dijkstra(start_node);
      
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
}
