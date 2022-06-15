# git commit -m "code: Solve boj 01966 프린터 큐 (MJ)"
import java.util.*;
import java.io.*;

public class Main{

    static Queue<int[]> q = new LinkedList<int[]>();

    public static void main(String[] args) throws IOException {
        // 입력 값 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // N 값: 테스트 케이스의 수
        int times = Integer.parseInt(br.readLine());
        for (int i = 0; i < times; i++){
            // 줄 단위로 입력 받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            // M, N
            int cases = Integer.parseInt(st.nextToken());
            int PrintPos = Integer.parseInt(st.nextToken());
            // 중요도 리스트
            st = new StringTokenizer(br.readLine());
            int count = 0;
            while (st.hasMoreTokens()){
                q.add(new int[] {Integer.parseInt(st.nextToken()), count++});
            }
            printq(cases, PrintPos, q);
        }

    }

    static void printq(int cases, int PrintPos, Queue<int[]> q){
        int PrintCnt = 1;
        while (!q.isEmpty()){
            // 첫 문서의 순서 및 인덱스값 임시 저장
            int temp = (int)q.peek()[0];
            int tempPos = (int)q.poll()[1];
            int Qsize = q.size();
            int MAX = 0;
            int maxPos = 0;
            for (int a = 0; a < Qsize; a++){
                // 나머지 문서 중 가장 높은 중요도(MAX) 찾기
                if (MAX < (int)q.peek()[0]){
                    MAX = (int)q.peek()[0];
                }
                q.add(new int[] {(int)q.peek()[0], (int)q.poll()[1]});
            }
            // 첫 문서와 MAX와 비교
            if (temp < MAX){
                q.add(new int[] {temp, tempPos});
            } else{
                if(tempPos == PrintPos) System.out.println(PrintCnt);
                PrintCnt += 1;
            }
        }

    }
}
