#include <bits/stdc++.h>
using namespace std;

int m, n, c;
int elev[501][501];
int way[501][501];
bool visited[501][501];
int di[] = {1, 0, -1, 0};
int dj[] = {0, -1, 0, 1};
int wpts;

void floodfill(int i, int j, int d) {
	visited[i][j] = true;
	c += way[i][j];
	for (int t = 0; t < 4; ++t) {
		int ni = i + di[t];
		int nj = j + dj[t];
		if (ni >= 0 && ni < m && nj >= 0 && nj < n && !visited[ni][nj]) {
			if (abs(elev[i][j] - elev[ni][nj]) <= d) floodfill(ni, nj, d);
		}
	}
}

int main(int argc, char const *argv[]) {
	ifstream fin("ccski.in");
	fin >> m >> n;
	int maxE = -1;
	for (int i = 0; i < m; ++i) {
		for (int j = 0; j < n; ++j) {
			int a;
			fin >> a;
			elev[i][j] = a;
			maxE = max(maxE, a);
		}
	}
	int wi, wj;
	for (int i = 0; i < m; ++i) {
		for (int j = 0; j < n; ++j) {
			int a;
			fin >> a;
			way[i][j] = a;
			if (way[i][j]) {wi = i; wj = j; wpts++;}
		}
	}

	int h = maxE;
	int l = 0;
	while (l < h) {
		int mi = l + (h - l)/2;
		c = 0;
		floodfill(wi, wj, mi);
		if (c == wpts) h = mi;
		else l = mi + 1;
		memset(visited, false, sizeof(visited));
	}
	cout << h << endl;
	ofstream fout("ccski.out");
	fout << h << endl;
	return 0;
}