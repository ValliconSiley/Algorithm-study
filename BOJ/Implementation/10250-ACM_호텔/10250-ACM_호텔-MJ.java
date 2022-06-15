import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception{
        //입출력 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //T: 테스트 케이스
        int testCase = Integer.parseInt(br.readLine());
        // for문에서 사용할 변수 미리 선언
        int i, floor, room, th, curFloor, curRoom;
        StringTokenizer st;
        for (i = 0; i < testCase; i++){
            // 줄 단위로 입력 받아서 숫자로 전환
            st = new StringTokenizer(br.readLine());
            // H, W, N
            floor = Integer.parseInt(st.nextToken());
            room = Integer.parseInt(st.nextToken());
            th = Integer.parseInt(st.nextToken());
            // 층: N % H가 0일때 층을 표시. 이 처리를 안하면 610호가 아닌 010호가 나올 수 있음
            curFloor = (th % floor == 0) ? floor * 100: th % floor * 100;
            // 호 : N % H가 0일때와 구분. 610호가 아닌 600이 나올 수 있음
            curRoom = (th % floor == 0 ) ? th / floor : th / floor + 1;
            bw.write(curFloor + curRoom + "\n");
        }
        bw.close();
    }
}
