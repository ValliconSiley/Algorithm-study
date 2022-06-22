
// git commit -m "code: Solve boj 02512 예산 (byeongdoo)"
import java.util.*;

/**
 * 02512-예산-byeongdoo
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] budge = new int[N];
        for (int i = 0; i < N; i++) {
            budge[i] = sc.nextInt();
        }
        int MAX = sc.nextInt();

        int avg, sum = 0, budgesum = 0, mcount = 0, key, result;
        for (int i = 0; i < N; i++)
            budgesum += budge[i];

        if (budgesum <= MAX)
            result = Arrays.stream(budge).max().getAsInt();
        else {
            // 1. 평균을 구한다 (485 -> (4) -> 121)
            avg = MAX / N;
            // 120 110 140 150 / 485 // 127 127?
            // 2. 평균보다 낮은 것들 숫자 다 더함 1+11 = 12
            // 3. 평균보다 높은 것들 갯수 구함 2
            for (int i = 0; i < N; i++) {
                if (budge[i] <= avg)
                    sum += avg - budge[i];
                else {
                    mcount++;
                }
            }
            // 4. 2번을 3번으로 나눔 12/2=6
            key = sum / mcount;
            // 5. 평균에 4번 더함 = 121+6 = 127
            result = key + avg;
        }
        System.out.println(result);
        sc.close();
    }

}