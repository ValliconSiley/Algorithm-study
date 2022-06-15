// git commit -m "code: Solve boj 01260 DFS와 BFS (FeVirus)"
#include <iostream>
using namespace std;
int n, m, v;
int G[1001][1001]={0}, visit[1001]={0};

void dfs(int v){
	int s[10000];
	int top=0;
	
	s[top]=v;
	while(top!=-1){ // 시작지점으로 돌아왔다면 모든 정점을 돈 것이므로 종료
		if(visit[s[top]]){ // 현재 위치가 이미 방문되었다면 이전으로 돌아가기
			top--;
			continue;
		}
		
        //현재위치 방문하고 출력하기
		int t=s[top--]; 
		visit[t]=1;
		cout << t << " ";
		
		for(int i=1000; i>=1; i--){ // 정점이 낮은 순으로 방문하기 위해 내림차순으로 stack에 쌓는다
			if(G[t][i] && !visit[i]){
				s[++top]=i;
			}
		}
	}
	cout << endl;
	return ;
}

void bfs(int v){
	int q[1001];
	int f=-1, r=-1; // f는 pop을 위한 변수, r은 push를 위한 변수로 각각 queue 양 끝을 가리킨다.
	
	q[++r]=v;
	visit[v]=1;
	while(f!=r){ // f==r이면 queue 내부 원소가 없다는 뜻이므로 종료
		int t=q[++f]; // 하나씩 꺼내서
		cout << t << " "; // 출력하고
		
		for(int i=1; i<1001; i++){ // 현재 방문 중인 t와 연결된 정점들을 번호 순대로 queue에 넣어버린다.
			if(G[t][i]==1 && visit[i]==0){
				q[++r]=i;
				visit[i]=1;
			}
		}
	}
	cout << endl;
	return ;
}

int main(){
	cin >> n >> m >> v;
	for(int i=0; i<m; i++){
		int x, y;
		cin >> x >> y;
		G[x][0]++; // G[x][0]은 x와 연결된 정점의 수를 의미
		G[y][0]++; // 마찬가지
		G[x][y]=1; // x, y의 연결을 의미
		G[y][x]=1;
	}

	dfs(v);
	for(int i=1; i<=1001; i++){ // bfs 하기 위해 방문배열 visit을 초기화해준다
		visit[i]=0;
	}
	bfs(v);
	
	return 0;
}