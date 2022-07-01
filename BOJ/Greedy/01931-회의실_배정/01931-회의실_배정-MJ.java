// git commit -m "code: Solve boj 01931 회의실 배정 (MJ)"
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        StringTokenizer st;
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }
        Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1]) {
					return o1[0] - o2[0];
				} 
				else {
					return o1[1] - o2[1];
				}
			}
		});
        int cnt = 0;
        int end = 0;
        for (int[] a : arr){
            if (a[0] >= end){
                 end = a[1];
                 cnt += 1;
            }
        }
        System.out.println(cnt);
    }
    
}