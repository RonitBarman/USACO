#include <bits/stdc++.h>
using namespace std;

void floodfill(int x, int y, bool visited[4001][4001]) {
	visited[x][y] = true;
}
int main(int argc, char const *argv[]) {
	int N;
	cin >> N;
	string in;
	cin >> in;
	int n, s, e, w, x, y = 0;
	int fences[4001][4001] = {};
	bool visited[4001][4001] = {};
	// int mix, miy = 10000;
	// int maxx, may = -10000;
	for (int i = 0; i < N; i++) {
		
		// maxx = max(maxx, x);
		// may = max(may, y);
		// mix = min(mix, x);
		// miy = min(miy, y);
	}
	x = 2000;
	y = 2000;
	for (int i = 0; i < N; i++) {
		fences[x][y] = 1;
		if (in[i] == 'N') {y--;}
		if (in[i] == 'S') {y++;}
		if (in[i] == 'E') {x++;}
		if (in[i] == 'W') {x--;}
	}


	return 0;
}