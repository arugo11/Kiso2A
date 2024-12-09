import java.util.LinkedList;
import java.util.*;

class FordFulkerson {
  
// 課題2-2. 幅優先探索の部分
  boolean bfs(int Gf[][], int s, int t, int p[]) {     // Gf: 残余グラフを与えるの配列，s:ソースの頂点, t:シンクの頂点, p: 拡張可能経路の親ノードを格納した配列
// 編集: グラフの頂点数 numVを，Gfの大きさで定義
int numV = Gf.length;
// 編集: 頂点を訪問したかどうかのboolean配列 doneを作る．(配列のサイズはnumV)
boolean done[] = new boolean[numV];
// 編集: 訪問済配列 doneの初期化．すべてみ訪問としてfalseで初期化． Arrays.fill(配列,初期化の値)が便利．
Arrays.fill(done, false);
// 編集: 幅優先探索のキューQを整数を要素にもつ連結リストLinkedListで生成
LinkedList<Integer> Q = new LinkedList<>();
// 編集: 初期化. 始点(ソース)の頂点sをキュー(queue)Qに追加
Q.add(s);
// 編集: 初期化. 始点(ソース)の頂点sは訪問済の印をつける．
done[s] = true;
// 編集: 配列pの頂点sを-1に初期化．(始点sに拡張可能経路の親ノードはないのであり得ない頂点の番号で初期化)
p[s] = -1;
// キューの出し入れの部分
// 編集: while () { キューQが空でない(=サイズが0でない)なら以下を実行．
while(Q.size() != 0){
  int u = Q.poll();/*u: 親ノード */
  for(int v = 0; v < numV; v++){
    if(!done[v] && Gf[u][v] > 0){
      Q.add(v);
      p[v] = u;
      done[v] = true;
    }
  }
}
// 編集: キューQの先頭にある頂点番号を取り出し，頂点uとする．
// 編集: for (int v =0 ...) 頂点vをfor文ですべて探索する
// 編集: if (...) 頂点vが未訪問，かつ辺(u,v)間の残余容量Gfが0よりも大きいなら以下を行う．
// 編集: キューQに頂点vを追加．
// 編集: 頂点vにつながる親ノードp[v]をuとする．
// 編集: 頂点vを訪問済とする
// 編集: if文    終了
// 編集: for文   終了
// 編集: while文 終了
// キューの出し入れの部分(ここまで)

// 編集: return ( 戻り値 )
return done[t];
// [シンクtが訪問済]かどうかの判定式をbfsの戻り値にする．
// もしtrueの場合，シンクtが訪問済で，拡張可能経路が存在する．
// もしfalseの場合，ソースsからシンクtへの拡張可能経路は存在しない．つまり，最大流に到達したことになる．
}
// 課題2-2. 幅優先探索の部分(ここまで)

// // 課題2-3. Ford-Fulkersonアルゴリズムの部分
//   int fordFulkerson(int adj[][], int s, int t) {       // fordFulkersonメソッド．引数: adj: 隣接行列の配列, s:ソースの頂点, t:シンクの頂点
//     int u, v;                                          // 頂点名
//                                                        // 編集: グラフの頂点数 numVを，adjの大きさで定義
//                                                        // 編集: 残余グラフの配列Gf[][]を生成 (サイズ numV x numV の配列)
//                                                        // 編集: 親ノードの配列pを作る．(サイズ numV の配列)

//                                                        // 編集: Int型変数 max_flow の初期化  ゼロフローとする．
//                                                        // 編集: 残余グラフGfの初期化．グラフの重み(adj)と等しくする．配列Aを配列Bと等しくする場合は，A = B.clone()が便利．

//                                                        // 拡張可能経路p上の最小残余容量を求める．
//                                                        // 編集: while (...) { } boolean型のメソッドbfsの戻り値がTrueなら拡張可能経路が存在するので以下を実行．
//                                                        // 以下では，拡張可能経路p上の辺の最小残余容量(path_flow)を求める
//                                                        // 編集: path_flowを最大の整数Integer.MAX_VALUEで初期化． 
//                                                        // 編集: for文で，拡張可能経路を逆にたどる．Int型の頂点の変数vをシンクtから始め，拡張可能経路の親ノードを辿り，始点sについたら反復条件を終了．
//                                                        // tips: for (v = 初期値, 反復条件, 処理)なので，vの初期値はシンクt, 反復条件は頂点vが始点sでない，処理は頂点vの親ノードp[v]を次の頂点vとする．
//                                                        // 編集: 頂点uを頂点vの親ノードとする．
//                                                        // 編集: いまのpath_flowの値と，いまいる辺の残余フローの値を比較し，小さい値をpath_flowの新しい値として更新する．
//                                                        // 編集: for文 終了

//                                                        // p上の辺の最小残余容量path_flowの分だけフローmax_flowを増やす．
//                                                        // 編集: for文で，拡張可能経路を逆にたどる．Int型の頂点の変数vをシンクtから始め，拡張可能経路の親ノードを辿り，始点sについたら反復条件を終了．
//                                                        // 編集: 頂点uを頂点vの親ノードとする．
//                                                        // 最小残余容量に従い，残余グラフGfを以下で更新する．
//                                                        // 編集: 残余グラフのGf[u][v]から，流したフロー分だけ引く
//                                                        // 編集: 残余グラフのGf[v][u]には，頂点が逆なので，流したフロー分だけ足す．
//                                                        // 編集: for文   終了

//                                                        // 編集: 最小残余容量path_flow分だけ流量が増えるので，max_flowをpath_flowだけ増やす．
//                                                        // 編集: while文 終了

//                                                        // 編集: 戻り値はmax_flow
//   }
// // 課題2-3. Ford-Fulkersonアルゴリズムの部分 (ここまで)

}