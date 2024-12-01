import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DFS {
  private int numV;
  private List<LinkedList<Integer>> adj; // 整数型のリンクリストのリスト adj
  private boolean done[]; // 訪問したかのbooleanリスト(サイズは頂点数) 

  DFS(List<LinkedList<Integer>>  adj) { // 整数型のリンクリストのリスト adjが引数
    int numV = adj.size(); // ネットワークの頂点数 = adの要素数
    boolean done[] = new boolean[numV]; // 訪問したかのbooleanリスト(サイズは頂点数)
    this.adj = adj;   // インスタンス化
    this.done = done; // インスタンス化 初期値はfalse
  }

  // DFS recursive
  void DFSrecursive(int u) {

    //////////////////////////////////////////////////////
    // 以下コメントアウトの行を描きなさい．

    // 頂点uに訪問したという印をつける
    // 訪問したノードuを出力
    // ノードuの隣接頂点のリストからIterator itrを作成．返り値の型は整数．
    // while( 隣接要素がまだある? ) {　
    // 取得した隣接要素をvとする
    // if(vがまだ訪問されていない){
    // 次を指す矢印を出力
    // 頂点vについて再帰的に深さ優先探索を呼び出す
    // if文を閉じる
    // while文を閉じる

    //////////////////////////////////////////////////////

  }



}
