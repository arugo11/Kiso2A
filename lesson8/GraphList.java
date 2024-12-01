import java.util.*;

public class GraphList {
    int numV;
    List<LinkedList<Integer>> adj; // 整数型のリンクリストのリスト adj

    public GraphList(int numV) {
        this.numV = numV;
        adj = new ArrayList<LinkedList<Integer>>();// 整数型のリンクリストのArrayList adjを作る
        for (int i = 0; i < numV; i++) {
            adj.add(new LinkedList<Integer>()); // 初期化 numVの数だけ，LinkedList<Integer>()を挿入．
        }
    }

    public void addEdge(int node, int next) {  
        adj.get(node).add(next); // 指定したノード番号nodeのLinkedList<Integer>を取得し，そのLinkedListに隣接ノード情報を挿入
    }

    public void printG(){
        for (int i = 0; i < numV; i++) {
            LinkedList<Integer> list = adj.get(i); // 指定したノードiのLinkedList<Integer>を取得し，listと呼ぶ．
            System.out.print(i);
            for (int j = 0; j < list.size(); j++) { // 指定したノードiのlistの要素数だけfor文を回す
                System.out.print(" -> " + list.get(j)); // 指定したノードiのlistのj番目の要素を取得．
            }
            System.out.println();
        }
    }
}
