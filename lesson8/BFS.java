import java.util.*;

public class BFS {
  boolean done[]; // 訪問したかのbooleanリスト(サイズは頂点数)
  LinkedList<Integer> Q; // キュー（待ち行列）を表現するための，整数型要素を格納するリンクリストの変数Qを宣言

  public BFS(List<LinkedList<Integer>> adj, int s) { // 整数型の要素を持つリンクリストのリストadjと始点sを引数とする．
    int numV = adj.size(); // ネットワークの頂点数 
    boolean done[] = new boolean[numV]; // 訪問したかのbooleanリスト(サイズは頂点数)

    Q = new LinkedList<Integer>(); // Qのインスタンスを作成

    //////////////////////////////////////////////////////
    // 以下コメントアウトの行を描きなさい．

    //頂点sは訪問した印をつける
    // 頂点sをキューに入れ初期化
    // while(キューQが空でない){
    // キューQから先頭の要素を取得しuとする．その後，この要素をキューQから削除する．
    System.out.print(u); // // キューから取り出した先頭要素uをプリント．
    Iterator<Integer> itr = adj.get(u).iterator(); // // ノードuの隣接頂点のリストからIteratorのitrを作成．返り値の型は整数．
  　// while( uの隣接要素がまだある? ) {
    int v = itr.next(); // // 取得した隣接要素をvとする
    // if(vがまだ訪問されていない){
    System.out.print(">"); // // 次を指す矢印を出力
    // vに訪問したという印をつける
    // vをキューQに入れる
    // if文を閉じる
    // while文を閉じる
    // while文を閉じる
    
    //////////////////////////////////////////////////////

    System.out.println("");
  }
}
