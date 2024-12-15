import java.util.LinkedList;
import java.util.*;

class FordFulkerson {

 boolean bfs(int Gf[][], int s, int t, int p[]) {
   int numV = Gf.length;
   boolean done[] = new boolean[numV];
   Arrays.fill(done, false);
   LinkedList<Integer> Q = new LinkedList<>();
   Q.add(s);
   done[s] = true;
   p[s] = -1;

   while(Q.size() != 0){
     int u = Q.poll();
     for(int v = 0; v < numV; v++){
       if(!done[v] && Gf[u][v] > 0){
         Q.add(v);
         p[v] = u;
         done[v] = true;
       }
     }
   }
   return done[t];
 }

 int fordFulkerson(int adj[][], int s, int t) {
   int u, v;
   int numV = adj.length;
   int Gf[][] = new int[numV][numV];
   int p[] = new int[numV];

   int max_flow = 0;
   for(int i = 0; i < numV; i++) {
       for(int j = 0; j < numV; j++) {
           Gf[i][j] = adj[i][j];
       }
   }

   while(bfs(Gf, s, t, p)){
     int path_flow = Integer.MAX_VALUE;
     /* シンクからソースに向かって親ノードを辿る */
     /* 辿った中で一番軽い重さをフローとする */
     for(v = t; v != s; v = p[v]){
       u = p[v];
       if(path_flow > Gf[u][v]){
         path_flow = Gf[u][v];
       }
     }
     /* 残余グラフを計算 */
     for(v = t; v != s; v = p[v]){
       u = p[v];
       Gf[u][v] -= path_flow;
       Gf[v][u] += path_flow;
     }
     max_flow += path_flow;
   }
   return max_flow;
 }
}