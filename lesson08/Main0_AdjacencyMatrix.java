import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class Main0_AdjacencyMatrix {
  public static void main(String args[]) {

    // Scannerオブジェクトを作成
    Scanner scanner = new Scanner(System.in);
    // ユーザーに入力を促す
    System.out.print("グラフのノード数を入力してください: ");
    // 整数をキーボードから取得
    int numV = scanner.nextInt();
    

      GraphMatrix g = new GraphMatrix(numV);

      String filePath = "./data_sample.txt";

      try {
          BufferedReader br = new BufferedReader(new FileReader(filePath));
          String line;
  
          // ファイルの各行を読み込む
          while ((line = br.readLine()) != null) {
              // カンマで分割
              String[] values = line.split(", ");
  
              // ファイルから，辺(u、v)のノード番号 u,v を読み取る処理
              int u = Integer.parseInt(values[0]);
              int v = Integer.parseInt(values[1]);
  
              // ここで取得した値に対して処理を行う
              g.addEdge(u,v);
          }

          g.printG();

      } catch (IOException e) {
          e.printStackTrace();
      }

    }
}
