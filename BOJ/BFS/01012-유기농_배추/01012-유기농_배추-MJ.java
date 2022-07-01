import java.util.*;
import java.io.*;

public class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static boolean[][] b;
    static int[][] pos;
    static int M, N, K;
    static int worms = 0;
    static int[] rowMoves = {0,0,-1,1};
    static int[] colMoves = {-1,1,0,0};
    public static void main(String[] args) throws IOException{
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++){
            makeTC();
            for (int[] p : pos){
                if (b[p[0]][p[1]]) worms += 1;
                putWorm(p[0], p[1]);
            }
            bw.write(worms + "\n");
            worms = 0;
        }
        bw.close();
    }

    static void makeTC() throws IOException {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        b = new boolean[M][N];
        pos = new int[K][2];
        for (int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int row =Integer.parseInt(st.nextToken());
            int col =Integer.parseInt(st.nextToken());
            pos[i] = new int[]{row, col};
            b[row][col] = true;
        }
    }

    static void putWorm(int x, int y) {
        if (!b[x][y]) return;
        b[x][y] = false;
        for (int i = 0; i < 4; i++){
            int nx = x + rowMoves[i];
            int ny = y + colMoves[i];
            if (nx != -1 && ny != -1 && nx < M && ny < N && b[nx][ny]){
                putWorm(nx, ny);
            } 
        }
    }

}
