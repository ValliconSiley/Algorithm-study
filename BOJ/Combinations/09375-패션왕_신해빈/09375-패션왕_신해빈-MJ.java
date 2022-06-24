//# git commit -m "code: Solve boj 09375 패션왕 신해빈 (MJ)"
import java.util.*;
import java.io.*;

public class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static HashMap<String, Integer> map;
    static int[] partSize;
    static int N, m;
    static int sum = 1;
    public static void main(String[] args) throws IOException{
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++){
            makeTC();
            for (int p : partSize) sum *= (p + 1);
            bw.write(sum - 1 + "\n");
            sum = 1;
        }
        bw.close();
    }

    static void makeTC() throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new HashMap<String, Integer>();
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            String part = st.nextToken();
            map.put(part, map.containsKey(part) ? map.get(part) + 1 : 1);
        }
        partSize = new int[map.size()];
        int j = 0;
        for (String key : map.keySet()){
            partSize[j++] = map.get(key);
        }
    }
}
