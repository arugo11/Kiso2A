import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main2_AdjacencyList {
      public static void main(String[] args) {

            // Scannerオブジェクトを作成
            Scanner scanner = new Scanner(System.in);
            // ユーザーに入力を促す
            System.out.print("グラフのノード数を入力してください: ");
            // 整数をキーボードから取得
            int numV = scanner.nextInt();

            GraphListWeight g = new GraphListWeight(numV);

            String filePath = "./data2.txt";

            try {
                  BufferedReader br = new BufferedReader(new FileReader(filePath));
                  String line;
      
                  // ファイルの各行を読み込む
                  while ((line = br.readLine()) != null) {
                        // カンマで分割
                        String[] values = line.split(", ");
      
              // ファイルから，辺(u、v, c)のノード番号 u,v と重み c を読み取る処理
                        int u = Integer.parseInt(values[0]);
                        int v = Integer.parseInt(values[1]);
                        int c = Integer.parseInt(values[2]);
      
                        // ここで取得した値に対する処理を行う
                        g.addEdge(u,v,c);
                  }
                        g.printG();

            } catch (IOException e) {
            e.printStackTrace();
            }

      }
}
