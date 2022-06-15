import java.util.*;
import java.io.*;

public class Main{
    // 방문 노드 기록
    static boolean[] dfsVisited;
    static boolean[] bfsVisited;
    // 노드 배열 및 출력 선언
    static ArrayList<Integer>[] arr;
    static BufferedWriter bw;
    public static void main(String[] args) throws Exception{
        // 입력 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // input first line
        int nodes = Integer.parseInt(st.nextToken());
        int lines = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(st.nextToken());
        // 노드 배열, 방문 노드 기록 초기화
        arr = new ArrayList[nodes + 1];
        dfsVisited = new boolean[nodes + 1];
        bfsVisited = new boolean[nodes + 1];
        int i, j, head,rear;
        // 인덱스마다 리스트 생성 및 노드 입력
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
        // 입력 후 리스트 정렬
        while (--i > 0){
            arr[i].sort(Comparator.naturalOrder());
        }
        // 두 함수 실행 후 출력
        dfs(startNode);
        bw.write("\n");
        bfs(startNode);
        bw.close();
  }
  // dfs 함수
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
  // bfs 함수
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
