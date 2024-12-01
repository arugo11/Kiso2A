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
    // 頂点uに訪問したという印をつける
    done[u] = true;
    
    // 訪問したノードuを出力
    System.out.print(u);
    
    // ノードuの隣接頂点のリストからIterator itrを作成．返り値の型は整数．
    Iterator<Integer> itr = adj.get(u).iterator();
    
    // while( 隣接要素がまだある? ) {　
    while(itr.hasNext()) {
        // 取得した隣接要素をvとする
        int v = itr.next();
        
        // if(vがまだ訪問されていない){
        if(!done[v]) {
            // 次を指す矢印を出力
            System.out.print(">");
            // 頂点vについて再帰的に深さ優先探索を呼び出す
            DFSrecursive(v);
        }    
        // if文を閉じる
    }    
    // while文を閉じる
}


}
