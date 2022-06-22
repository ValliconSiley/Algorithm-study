// git commit -m "code: Solve boj 18111 마인크래프트 (FeVirus)"
#include <iostream>
#define MAX 987654321
using namespace std;

int n, m, b, map[500][500], sum, time=MAX, height;

void init(){
	cin >> n >> m >> b;	
	sum+=b;
	for(int i=0; i<n; i++){
		for(int j=0; j<m; j++){
			cin >> map[i][j];
			sum+=map[i][j];
		}
	}
	return ;
}

int calc(int h){
	int ret=0;
	for(int i=0; i<n; i++){
		for(int j=0; j<m; j++){
			if(map[i][j]<h) ret+=(h-map[i][j]);
			else ret+=(map[i][j]-h)*2;
		}
	}
	
	return ret;	
}

int main(){
	init();
		
	int max_height=sum/(n*m);
	for(int i=max_height; i>=0; i--){
		int t_time=calc(i);
//		cout << t_time << ' ' << i << '\n';
		if(time>t_time){
			time=t_time;
			height=i;
		}
	}	
	
	cout << time << ' ' << height;
	
	return 0;
}