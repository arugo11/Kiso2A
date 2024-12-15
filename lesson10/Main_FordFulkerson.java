import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class Main_FordFulkerson {
  public static void main(String[] args) throws java.lang.Exception {

    try {
// 課題2-1. 重み付き有向グラフのdata.txtファイルを読み込む．
// ユーザー入力
// "グラフのノード数"   整数 numV
// "ソースのノード番号" 整数 s
// "シンクのノード番号" 整数 t
// GraphMatrixWeightのインスタンス gを生成
// ファイルから，辺(u、v, c)を取得
// 辺(u、v, c)の情報をaddEdgeでgに追加
// 編集: Scannerオブジェクトを作成
Scanner scanner = new Scanner(System.in);
// 編集: ユーザーに入力を促す. "グラフのノード数を入力してください: "
System.out.print("グラフのノード数を入力してください: ");
// 編集: 整数 numV をキーボードから取得
int numV = scanner.nextInt();
// 編集: ユーザーに入力を促す. "ソースのノード番号を入力してください: "
System.out.println("ソースのノード番号を入力してください: ");
// 編集: 整数 s をキーボードから取得
int s = scanner.nextInt();
// 編集: ユーザーに入力を促す．"シンクのノード番号を入力してください: "
System.out.println("シンクのノード番号を入力してください: ");
// 編集: 整数 t をキーボードから取得
int t = scanner.nextInt();

// 編集: GraphMatrixWeightのインスタンス g を生成
GraphMatrixWeight g = new GraphMatrixWeight(numV);
// 編集: data.txt のパスの指定
String filePath = "data.txt";

// 編集: ファイルを読み込むために BufferedReader を初期化
BufferedReader br = new BufferedReader(new FileReader(filePath));
// 編集: ファイルの各行を格納する変数 line を宣言
String line;
// 編集: ファイルの各行を1行ずつ読み込むループ
while((line = br.readLine()) != null){
  String[] values = line.split(", ");

  int u = Integer.parseInt(values[0]);
  int v = Integer.parseInt(values[1]);
  int c = Integer.parseInt(values[2]);

  g.addEdge(u, v, c);
}
br.close();

// 編集: 読み込んだ行をカンマで分割し、文字列配列 values に格納
// 編集: 分割された値の1つ目を整数に変換し、ノード u として格納
// 編集: 分割された値の2つ目を整数に変換し、ノード v として格納
// 編集: 分割された値の3つ目を整数に変換し、重み c として格納
// 編集: 辺(u、v, c)の情報をaddEdgeでgに追加
// 編集: while文 終了
// 課題2-1. 重み付き有向グラフのtxtファイルを読み込む． (ここまで)
    
      FordFulkerson m = new FordFulkerson();

// 課題2-2. 幅優先探索が動くかの確認用
      int p[] = new int[g.adj.length];
      m.bfs(g.adj, s, t, p);
      for (int i = 0; i < g.adj.length; i++){
        System.out.println(i + "の親ノード:" + p[i]);
      }
      System.out.println();
// 課題2-2. 幅優先探索が動くかの確認用 (ここまで)


// 課題2-3. Ford-Fulkerson法の動作
      int maxflow = m.fordFulkerson(g.adj, s, t);
      System.out.println("最大流は" + maxflow);
// 課題2-3. Ford-Fulkerson法の動作 (ここまで)

// 発展 - ノードiを削除したとき,最大流がどのように変化するか
      for (int i = 0; i < g.adj.length; i++){
        for (int j = 0; j < g.adj.length; j++){
          if (g.adj[i][j] > 0 && i != s && i != t){
            g.adj[i][j] = 0;
            int maxflow2 = m.fordFulkerson(g.adj, s, t);
            System.out.println("ノード" + i + "を削除したときの最大流は" + maxflow2);
            g.adj[i][j] = 1;
          }
        }
      }
  /* 以上のような発展を考えましたが, あんまりおもしろくなかったので以下追加 */
  /* もし, 電車の遅延のように時間でランダムでコストが増加したり減少したりしたときに*/
  
    } catch (IOException e) {
        e.printStackTrace();
    }

  }
}
