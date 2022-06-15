// git commit -m "code: Solve boj 10250 ACM 호텔 (FeVirus)" 
// 걸린시간 12:00
#include <iostream>
using namespace std;
int tc, h, w, n;

int main(){
	cin >> tc;
	while(tc--){
		cin >> h >> w >> n;
		
		int order=(n-1)/h+1, floor=(n-1)%h+1; // 몫, 나머지 계산 시 상식적으로 나와야 할 값보다 1크게 해주기 위한 처리
		cout << floor*100+order << '\n';
	}	
	
	return 0;
}