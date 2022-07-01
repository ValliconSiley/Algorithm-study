// git commit -m "code: Solve boj 02839 설탕 배달 (MJ)"
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int fiveMax = N / 5;
        int times = 5000;
        for (int i = 0; i <= fiveMax; i++){       
            int threeMax = (N - i*5)  / 3;
            for (int j = 0; j <= threeMax; j++){
                if ((i*5 +j*3) == N && (i+j)<times) times = i+j;
            }
        }
        System.out.println(times == 5000 ? -1 : times);
    }
}