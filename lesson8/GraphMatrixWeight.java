public class GraphMatrixWeight {
    public int adj[][]; //i列j番目に重み[int]を格納
    public int numV; // 頂点の数
  
    // コンストラクタ 初期化
    public GraphMatrixWeight(int numV) {
      this.numV = numV; // インスタンス変数numVに，引数 numVの値を代入．
      adj = new int[numV][numV];
      for(int i = 0; i < numV; i++){
        for(int j = 0; j < numV; j++){
          adj[i][j] = 0;
        }
      }
    }
  
    // 辺の追加 : 有向辺グラフ
    public void addEdge(int i, int j, int w){
      adj[i][j] += w;
    }

  
    // 行列の表示
    public void printG(){
      StringBuilder s = new StringBuilder();
      // StringBuilder クラスは文字列を効率的に操作でき、文字列の結合や変更などの操作を高速に行える．
      for (int i = 0; i < numV; i++) {
        s.append(i + ": "); // 頂点の番号を追加
        // 隣接行列の各要素に対して処理
        for(int j : adj[i]) {
          s.append(j + " ");
        }
        s.append("\n"); // 行末に改行を追加
      }
      System.out.println(s); // 構築した文字列をコンソールに出力
    }
    
  }