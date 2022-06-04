#include <bits/stdc++.h>
using namespace std;

int points[200][3];
vector<vector<int>> adj;
bool visited[200];
int cnt;
float dist(int a, int b, int c, int d) {
	return sqrt(pow(a - c, 2) + pow(b - d, 2));
}
int dfs(int node) {
	if (!visited[node]) {
		cnt++;
		visited[node] = true;
	}
	for (int i : adj[node]) {
		if (!visited[i]) dfs(i);
	}
	return cnt;
}
int main(int argc, char const *argv[]) {
	ifstream fin("moocast.in");
	int x, y, p, n;
	fin >> n;
	adj.resize(n);
	for (int i = 0; i < n; ++i) {
		fin >> x >> y >> p;
		points[i][0] = x;
		points[i][1] = y;
		points[i][2] = p;
	}
	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < n; ++j) {
			if (i != j) {
				if (dist(points[i][0], points[i][1], points[j][0], points[j][1]) <= ((float) points[i][2])) {
					adj[i].push_back(j);
				}
			}
		}
	}
	int maxc = -1;
	for (int i = 0; i < n; ++i) {
		cnt = 0;
		maxc = max(maxc, dfs(i));
		fill(visited, visited + 200, false);
	}
	ofstream fout("moocast.out");
	fout << maxc << endl;
}