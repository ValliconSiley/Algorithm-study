import java.util.*;
import java.io.*;

public class Main{

    static boolean[] dfsVisited;
    static boolean[] bfsVisited;
    static ArrayList<Integer>[] arr;
    static BufferedWriter bw;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // input first line
        int nodes = Integer.parseInt(st.nextToken());
        int lines = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(st.nextToken());
        arr = new ArrayList[nodes + 1];
        dfsVisited = new boolean[nodes + 1];
        bfsVisited = new boolean[nodes + 1];
        int i, j, head,rear;
        for (i = 1; i <= nodes; i++){
            arr[i] = new ArrayList<Integer>();
        }
        for (j = 0; j < lines; j++){
            st = new StringTokenizer(br.readLine());
            head = Integer.parseInt(st.nextToken());
            rear = Integer.parseInt(st.nextToken());
            arr[head].add(rear);
            arr[rear].add(head);
        }
        
        while (--i > 0){
            arr[i].sort(Comparator.naturalOrder());
        }
        dfs(startNode);
        bw.write("\n");
        bfs(startNode);
        bw.close();
  }

  static void dfs(int x) throws Exception{
      if(dfsVisited[x]) return;
      dfsVisited[x] = true;
      bw.write(x + " ");
      int c, y;
      for (c = 0; c < arr[x].size(); c++){
          y = arr[x].get(c);
          dfs(y);
      }
  }

  static void bfs(int z) throws Exception{
      Queue q = new LinkedList<>();
      q.add(z);
      bfsVisited[z] = true;
      int w, o, p;
      while(!q.isEmpty()){
          w = (int)q.peek();
          q.poll();   
          bw.write(w + " ");
          for (o = 0; o < arr[w].size(); o++){
              p = arr[w].get(o);
              if(!bfsVisited[p]){
                  q.add(p);
                  bfsVisited[p] = true;
              }
          }
      }
  }
}
