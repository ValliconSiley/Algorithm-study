
//# git commit -m "code: Solve boj 09375 패션왕 신해빈 (byeongdoo)"
import java.util.HashMap;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        while (num-- > 0) { // 2
            HashMap<String, Integer> h = new HashMap<>();
            int N = sc.nextInt();
            while (N-- > 0) { // 3
                sc.next(); // 옷 이름
                String cloth = sc.next();// 옷 종류
                if (h.containsKey(cloth)) { // 해시에 옷종류가 있으면
                    h.put(cloth, h.get(cloth) + 1); // 해당 옷종류에 있는 옷 숫자에 1더함
                } else {
                    h.put(cloth, 1); // 그게 아니면 새로운 옷종류랑 1을 넣어줌
                }
            }
            int result = 1;
            for (int i : h.values()) {
                result *= (i + 1); // null 추가
            } // 모든 조합 null * null * null //알몸
            System.out.println(result - 1);// 알몸상태 제거
        }
    }
}