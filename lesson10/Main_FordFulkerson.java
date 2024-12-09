import java.io.IOException;

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
                                                                           // 編集: ユーザーに入力を促す. "グラフのノード数を入力してください: "
                                                                           // 編集: 整数 numV をキーボードから取得
                                                                           // 編集: ユーザーに入力を促す. "ソースのノード番号を入力してください: "
                                                                           // 編集: 整数 s をキーボードから取得
                                                                           // 編集: ユーザーに入力を促す．"シンクのノード番号を入力してください: "
                                                                           // 編集: 整数 t をキーボードから取得

                                                                           // 編集: GraphMatrixWeightのインスタンス g を生成
                                                                           // 編集: data.txt のパスの指定

                                                                           // 編集: ファイルを読み込むために BufferedReader を初期化
                                                                           // 編集: ファイルの各行を格納する変数 line を宣言

                                                                           // 編集: ファイルの各行を1行ずつ読み込むループ
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

    } catch (IOException e) {
        e.printStackTrace();
    }

  }
}
