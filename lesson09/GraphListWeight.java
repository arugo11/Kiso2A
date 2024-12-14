import java.util.*;

public class GraphListWeight {

// グラフのクラス
int numV;
List<LinkedList<Edge>> adj; // 整数型ではなく以下で定義するEdgeクラスのリンクリストのリストを作る． 

// Edgeクラスを与える[ここを書く]
    // integer型のメンバ変数node, next, weightを持つ
    // node: 注目しているノード番号, next: nodeの隣接ノードの番号, wight: nodeとnext間の辺の重み
    // 上の３つのメンバ変数を引数として読み込み，それをインスタンスに代入するEdgeメソッドを作成
class Edge {
    int node;
    int next;
    int weight;
    
    Edge(int node, int next, int weight) {
        this.node = node;
        this.next = next;
        this.weight = weight;
    }
}

public GraphListWeight(int numV) {
    this.numV = numV;
    adj = new ArrayList<LinkedList<Edge>>(); // 整数型のリンクリストのArrayList adjを作る
    for (int i = 0; i < numV ; i++) {
        adj.add(new LinkedList<Edge>()); // 初期化 numVの数だけ，LinkedList<Edge>()を挿入．
    }
}

// addEdgeメソッドを与える[ここを書く]
    //引数はnode, next, weight 
    // 引数にnode, next, weightを持つEdgeクラスのインスタンスedgeを作る．
    // 指定したノード番号nodeのLinkedList<Integer>を取得し，そのLinkedListにedge情報を挿入
public void addEdge(int node, int next, int weight) {
    Edge edge = new Edge(node, next, weight);
    adj.get(node).add(edge);
}

public void printG(){
    for (int i = 0; i < numV ; i++) {
        LinkedList<Edge> list = adj.get(i); // 指定したノードiのLinkedList<Edge>を取得し，listと呼ぶ．
            System.out.print(i);
        for (Edge edge : list) { // 拡張for文．list内の各要素をEdge型の変数edgeに順番に代入する．
            System.out.print(" -> " + edge.next + ":" + edge.weight); // edgeのnextとweightをを出力
        }
            System.out.println();
    }
}
}
