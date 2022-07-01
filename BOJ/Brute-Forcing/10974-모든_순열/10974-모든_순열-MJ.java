// git commit -m "code: Solve boj 10974 모든 순열 (MJ)"
import java.util.*;
import java.io.*;

public class Main{

    static int N;
    static boolean[] visited = new boolean[10];
    static int[] num = new int[10];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dfs(0);
        System.out.println(sb.toString());
    }

    static void dfs(int a){
        if (a >= N){
            for (int i = 0; i < N; i++){
                sb.append(num[i] + " ");
            }
            sb.append("\n");
        }
        for (int i = 1; i <= N; i++){
            if(visited[i]) continue;
            visited[i] = true;
            num[a] = i;
            dfs(a + 1);
            visited[i] = false;
        }
    }
}