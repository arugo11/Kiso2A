// 編集: 必要なものをimportする

public class Dijkstra {
  // フィールド変数の定義
    int numV; // ネットワークの頂点数
    int[][] adjM; //  隣接行列 (課題3で使う)
    List<LinkedList<GraphListWeight.Edge>> adjL; // 隣接リスト (課題4で使う)
    boolean[] done; // 最短距離が確定済の頂点集合 X に含まれているかどうか．trueなら最短距離が確定済,falseなら未確定 
    boolean[] vertex; // 頂点の参照用
    int[] distance; // 始点からの距離を格納する配列．配列の大きさは頂点数
    int[] parent; // 親ノードを格納する配列．配列の大きさは頂点数
    int   start; //  始点のノード番号
  // フィールド変数の定義
  
  // 課題3用のコンストラクタ 配列adjMが引数
    public Dijkstra(int numV, int[][] adjM) {
      this.adjM = adjM; // adjMはDijkstraクラスの変数
  
      boolean[] done = new boolean[numV]; // 配列doneの生成
      boolean[] vertex = new boolean[numV]; // 配列vertexの生成
      int[] distance = new int[numV]; // 配列distanceの生成
      int[] parent = new int[numV]; // 配列parentの生成
      this.numV = numV; // numVはDijkstraクラスの変数
      this.done = done; // doneはDijkstraクラスの変数
      this.vertex = vertex; // vertexはDijkstraクラスの変数
      this.distance = distance; // distanceはDijkstraクラスの変数
      this.parent = parent; // parentはDijkstraクラスの変数
    }
  // 課題3用のコンストラクタ 配列adjMが引数（ここまで）
  
  //////////////////////// 課題4. ///////////////////////////////
  // 課題4用のコンストラクタ LinkedList adjLが引数 (課題3と同様につくってみよう)
  // オーバーロードするので，名前は上のDijkstraと同じにする．
  // 引数は int numV と List<LinkedList<GraphListWeight.Edge>> adjL にする
      // 編集: 課題4 (コンストラクタ LinkedList adjLが引数)
      //
      //
      //
      //
      // 編集: 課題4 (コンストラクタ LinkedList adjLが引数（ここまで）)
  //////////////////////// 課題4. ///////////////////////////////
  
  // dijkstraのメソッド
    public void dijkstra(int s) { // 入力は始点s(source)
  
      start = s;
  
  //////////////////////// 課題3. ///////////////////////////////
  // 以下で初期化を行います．
  // 配列の初期化はArrays.fill(配列,初期化の値)が便利．
      // 編集: 課題3 始点からの距離の配列distanceの全要素をInt型で扱える範囲の最大値に初期化: 最大値はInteger.MAX_VALUEを使うと便利
      // 編集: 課題3 最短距離確定済頂点集合Xについて，配列doneの全要素を未確定(false)で初期化．
      // 編集: 課題3 参照用の配列vertexの全要素をtrueで初期化
      // 編集: 課題3 始点sの距離distanceを0に初期化
  // 初期化はここまで
  //////////////////////// 課題3. ///////////////////////////////
  
  //////////////////////// 課題3. ///////////////////////////////
  // 擬似コードの while (X!=V){ の部分．(Vは全頂点の集合．Xは最短距離が確定した頂点集合)
  // while(条件式){ は条件式=trueの場合，処理が行われることに注意．
  // 配列Aと配列Bが等しいかの比較はboolean型のArrays.equals(配列A,配列B)が便利．否定する場合は，!を使って，!Arrays.equals(配列A,配列B)とすると簡潔．
      while (   ) { // 編集: 課題3. while文の完成．doneの中身が全てtrueになり，vertexと等しくなるまで回す．
  //////////////////////// 課題3. ///////////////////////////////
  
  //////////////////////// 課題3. ///////////////////////////////
  // V-X (X以外の部分) の中で，Dの値が最小の頂点をuとする計算を実行する部分．
  // 最小の距離minDとその最小距離を与える頂点u=minD_Vertexを与えるアルゴリズムを書く．
        // 編集: 課題3. 最小値を求めるので，minDは扱える最大の数で初期化．
        // 編集: 課題3. minD_Vertexはあり得ない頂点の番号で初期化
        // 編集: 課題3. for文で全頂点を探索 
        // 編集: 課題3. for文で探索している頂点iが，(1) 最短距離が確定済の頂点集合 X に取り込まれておらす，(2) minDよりも距離distanceが短いなら以下の処理を行う
        // 編集: 課題3. for文の中身1． minDをいまのdistance[i]で置き換え
        // 編集: 課題3. for文の中身2. minD_vertexの値をいまの頂点番号iとする
        // 編集: 課題3. if文終了
        // 編集: 課題3. for文終了
        // 編集: 課題3. Dの値が最小の頂点uをminD_Vertexで与える
  // V-X (X以外の部分) の中で，Dの値が最小の頂点をuとする計算を実行する部分．（ここまで）
  //////////////////////// 課題3. ///////////////////////////////
      
  //////////////////////// 課題3. ///////////////////////////////
  // 擬似コードの ① X = X U {u} の部分．
        // 編集. 課題3 doneのu成分をtrueに更新
  // 擬似コードの ① X = X U {u} の部分（ここまで）
  //////////////////////// 課題3. ///////////////////////////////
  
  // 擬似コードの②の部分
  // uに接続する各辺について，最短距離distance[v]と，それを与える親ノードparent[v]を求めるメソッドを使う
  // 引数を配列adjMにするか，LinkedListにするかを選択するが，メソッド名はfindMinDで共通．<- オーバーロード
  // findMinDのメソッドの中身は後で定義
  // この部分は変えない
        if (adjM != null) { findMinD(u, adjM); } // 隣接行列なら実行
        if (adjL != null) { findMinD(u, adjL); } // 隣接リストな実行
  // 擬似コードの②の部分
  
      }
  // ここまで擬似コードの while (X!=V){ の部分．
  
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // print （ここは書き換えない）
        System.out.println("");
  // 出力: 0からvまでの距離: d
      for (int i = 0; i < distance.length; i++) {
        System.out.println(String.format(s+ "から" +i+ "までの距離:" +distance[i]));
      }
  // 出力: 0からvまでの距離: d (ここまで．)
  
      System.out.println();
      System.out.println(String.format("始点:" + s));
  
  // 出力: uの親ノード: v
      for (int i = 0; i < distance.length; i++) {
        if (i != s) {
        System.out.println(String.format(i+ "の親ノード: " +parent[i]));
        }
      }
  // 出力: uの親ノード: v (ここまで．)
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
  
    }
  
  // 擬似コードの②の部分のメソッド (課題3の隣接行列の場合)
  // uに接続する各辺について，最短距離distance[v]と，それを与える親ノードparent[v]を求める．
    public void findMinD(int u,  int[][] adj) { // 入力はXに取り込む頂点 (int u)と配列adj (int[][] adj)
  //////////////////////// 課題3. ///////////////////////////////
        // 編集: 課題3. 全ての頂点vをfor文で回す．
        // 編集: 課題3 もし，(1)頂点vの最短距離が未確定で，かつ(2)辺(u,v)がつながっているなら・・・
        // 編集: 課題3. もし，距離[u]と辺(u,v)の距離の和が，距離[v]よりも短いなら・・・
        // 編集: 課題3. 距離[v]を更新する
        // 編集: 課題3. vの親ノードをuに更新する
        // 編集: 課題3. if文終了
        // 編集: 課題3. if文終了
        // 編集: 課題3. for文終了
  //////////////////////// 課題3. ///////////////////////////////
    }
  // 擬似コードの②の部分のメソッド (課題3の隣接行列の場合．ここまで)
  
  // 擬似コードの②の部分のメソッド (課題4の隣接リストの場合)
  // uに接続する各辺について，最短距離distance[v]と，それを与える親ノードparent[v]を求める．
  // GraphListWeight.javaのprintGの部分と課題3の上のメソッド"findMinD"を参考に残りの部分を書いてみよう．
  public void findMinD(int u,  List<LinkedList<GraphListWeight.Edge>> adj) { 
  //////////////////////// 課題4. ///////////////////////////////
  // 編集: 課題4. 頂点uを始点とするLinkedList(adj[u])をlistとおく．LinkedList<GraphListWeight.Edge> の型．
  for (GraphListWeight.Edge edge : list) { // 拡張for文．list内の各要素をEdge型の変数edgeに順番に代入する．
  // 編集: 課題4. uを始点とするLinkedListから，隣接頂点の情報を取得しvと置く．(GraphListWeight.javaのメソッドprintGを参照すると良い)
  // 編集: 課題4 もし，(1) 頂点vの最短距離が未確定で，かつ(2)その頂点の距離が短く更新されるなら・・・
  // 編集: 課題4. 距離[v]を更新する
  // 編集: 課題4. vの親ノードをuに更新する
  // 編集: 課題4. if文終了
  } 
  //////////////////////// 課題4. ///////////////////////////////
  }
  // 擬似コードの②の部分のメソッド (課題4の隣接リストの場合．ここまで)
  
  
  //////////////////////// 課題4. ///////////////////////////////
  // 任意の点uまでの最短経路
   public void printPath(int end_node) { // int end_nodeは求めたい経路の終点を与える
     // 編集: 課題4. 整数を要素にもつArrayListのpathを生成
     // 編集: 課題4. 終点end_nodeをpathに追加．(以降，親ノードを辿ってpathに追加するので逆順になる．)
   
     // 編集: 課題4. end_nodeをint nodeに渡す．
     while (true) {
         // 編集: 課題4. nodeの親ノードをint parentNodeに渡す
         // 編集: 課題4. parentNodeをpathに追加．
         // 編集: 課題4. parentNodeを新たにnodeとする
         // 編集: 課題4. もしこのnodeが始点ならbreak
     }
   
     System.out.print("\n最短経路："); 
     // 編集: 課題4. pathの要素の順序を反転する
     // 編集: 課題4. for文で始点から終点までの経路を出力する (行数は任意)
  
  
     System.out.println("");
   }
  /////////////////////// 課題4. ///////////////////////////////
  
  
  }
  