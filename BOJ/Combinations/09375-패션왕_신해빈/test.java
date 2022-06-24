
//# git commit -m "code: Solve boj 09375 패션왕 신해빈 (byeongdoo)"
import java.util.Scanner;

public class test {
    // static boolean[] visited = new boolean[n];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        while (N-- > 0) {
            int n = sc.nextInt();
            String[] category = new String[n];
            for (int i = 0; i < n; i++) {
                category = new String[n];
                category[i] = sc.nextLine().split(" ")[1];
            }
            // count = Arrays.sort(category);
            System.out.println(category[0]);
        }
        sc.close();
    }
}