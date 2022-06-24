
//# git commit -m "code: Solve boj 09375 패션왕 신해빈 (byeongdoo)"


public class test {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) { // 2
            HashMap<String, Integer> hm = new HashMap<>();

            int N = Integer.parseInt(br.readLine());

            while (N-- > 0) { // 3
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");

                st.nextToken();

                String kind = st.nextToken(); // 옷 종류

                if (hm.containsKey(kind)) { // 해시에 옷종류가 있으면
                    hm.put(kind, hm.get(kind) + 1); // 해당 옷종류에 있는 옷 숫자에 1더함
                } else {
                    hm.put(kind, 1); // 그게 아니면 새로운 옷종류랑 1을 넣어줌
                }
            }
            int result = 1;

            for (int i : hm.values()) {
                result *= (i + 1);
            }
            sb.append(result - 1).append('\n'); // 알몸상태 제거
        }
        System.out.println(sb);
    }
}
