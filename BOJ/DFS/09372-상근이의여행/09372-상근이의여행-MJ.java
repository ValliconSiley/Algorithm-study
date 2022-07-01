import java.util.*;
import java.io.*;

public class Main{

    static boolean[] visited;
    static ArrayList<Integer>[] arr;
    static StringTokenizer st;
    static int temp = 0;
    static int[] flyTimes;
    static BufferedReader br;
    static BufferedWriter bw;
    static int N;
    public static void main(String[] args) throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            arr = new ArrayList[N + 1];
            flyTimes = new int[N];
            for (int j = 1; j <= N; j++) arr[j] = new ArrayList<Integer>();
            putIn(M);
            for (int k = 1; k <= N; k++){                
                visited = new boolean[N + 1];
                dfs(k);
                flyTimes[k-1] = temp;
                temp = 0;
            }
            Arrays.sort(flyTimes);
            bw.write(flyTimes[0] + "\n");
        }
        bw.close();
    }

    static void putIn(int m) throws Exception{
        for(int i = 0; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int head = Integer.parseInt(st.nextToken());
            int rear = Integer.parseInt(st.nextToken());
            arr[head].add(rear);
            arr[rear].add(head);
        }
    }

    static void dfs(int k){
        visited[k] = true;
        boolean b = true;
        for (int n = 1; n <= N; n++){
            if (!visited[n]){
                b = false;
                break;
            }
        }
        if (b) return;
        temp += 1;
        for (int i = 0 ; i < arr[k].size(); i++){
            int mm = arr[k].get(i);
            if (!visited[mm]){
                dfs(mm);
            }
        }
    }
}