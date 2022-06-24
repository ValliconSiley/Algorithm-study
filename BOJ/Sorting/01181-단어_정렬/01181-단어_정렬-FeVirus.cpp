// git commit -m "code: Solve boj 01181 단어 정렬 (FeVirus)"

#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int n;
vector<pair<string, int> > v;

bool compare(pair<string, int> p1, pair<string, int> p2){
	if(p1.second==p2.second) return p1.first<p2.first;
	return p1.second<p2.second;
}

int main(){
	cin >> n;
	string s;
	for(int i=0; i<n; i++){
		cin >> s;
		v.push_back({s, s.size()});
	}
	
	sort(v.begin(), v.end(), compare);
	for(int i=0; i<n; i++){
		cout << v[i].first << '\n';
		if(i!=n-1){
			while(v[i]==v[i+1]) i++; 
		}
	}
		
	return 0;
}