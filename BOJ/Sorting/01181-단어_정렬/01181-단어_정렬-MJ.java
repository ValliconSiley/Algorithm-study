import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        HashSet s = new HashSet<String>();
        for (int i = 0; i < N; i++){
            s.add(br.readLine());
        }
        String[] strArr = new String[s.size()];
        s.toArray(strArr);
        Arrays.sort(strArr, new Comparator<String>() {
			public int compare(String s1, String s2) {
				if (s1.length() == s2.length()) {
					return s1.compareTo(s2);
				} 
				else {
					return s1.length() - s2.length();
				}
			}
		});
        for (String str :strArr) bw.write(str + "\n");
        bw.close();
    }

}