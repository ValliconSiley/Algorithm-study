// git commit -m "code: Solve boj 01966 프린터 큐 (FeVirus)"
// 걸린시간 : 23분 30초
#include <iostream>
#include <queue>
using namespace std;
int tc; //테스트 케이스 개수

int run(queue<pair<int, int> > q, int priorities[10], int m){ // 중요도 순으로 빼내는 로직
	int priority=9, ret=0; // 초기값 설정
	while(!q.empty()){
		if(priorities[priority]==0){ // 해당 중요도가 없다면 중요도 나춤
			priority--;
			continue;
		}
		
		if(q.front().first==priority){ // 가장 높은 중요도 문서가 맨 앞에 있다면 개수세고 문서 빼기
			ret++;
			if(q.front().second==m) return ret;

			q.pop();
			priorities[priority]--;
		}
		else{ // 가장 높은 중요도 문서가 맨 앞에 있지 않다면 뒤로 다시 넣기
			int a=q.front().first, b=q.front().second;
			q.pop();
			q.push({a, b});
		}
	}
}

int main(){
	cin >> tc;
	while(tc--){
		int n, m;
		queue<pair<int, int> > q; // {문서 중요도, 문서 초기위치}를 원소로 가짐
		int priorities[10]={0, }; // 우선순위 담는 배열, index : 중요도를 의미, value : 해당 중요도를 갖는 문서 개수

		cin >> n >> m;
		
		for(int i=0; i<n; i++){
			int priority;
			cin >> priority;
			q.push({priority, i});
			priorities[priority]++;
		}		
		
		cout << run(q, priorities, m) << '\n';
	}		
	
	return 0;
}
