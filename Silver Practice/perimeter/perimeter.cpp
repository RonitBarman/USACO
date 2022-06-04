#include <bits/stdc++.h>
using namespace std;
vector<int> adj;
int n;
int di[] = {1, 0, -1, 0};
int dj[] = {0, 1, 0, -1};
bool visited[1001][1001];
char grid[1001][1001];

pair<int, int> floodfill(int i, int j) {
	stack<pair<int, int>> points;
	int peri = 0;
	int area = 0;
	points.push(make_pair(i, j));
	while (!points.empty()) {
		pair<int, int> temp = points.top();
		points.pop();
		i = temp.first;
		j = temp.second;
		if (i >= n || i < 0 || n <= j || j < 0 || grid[i][j] == '.' || visited[i][j]) 
			continue;
		visited[i][j] = true;
		area++;

		for (int t = 0; t < 4; ++t) {
			int ii = i + di[t];
			int jj = j + dj[t];
			if (ii >= n || ii < 0 || jj < 0 || jj >= n) peri++;
			else if (grid[ii][jj] == '.') peri++;
			points.push(make_pair(ii, jj));
		}
	}
	return make_pair(area, peri);
}

int main(int argc, char const *argv[]) {
	
	ifstream fin("perimeter.in");
	fin >> n;
	string s;
	for (int i = 0; i < n; ++i) {
		fin >> s;
		for (int j = 0; j < n; ++j) {
			grid[i][j] = s[j];
		}
	}
	int maxA = -1;
	int peri = 0;
	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < n; ++j) {
			if (!visited[i][j]) {
				pair<int, int> temp = floodfill(i, j);
				int na = temp.first;
				int np = temp.second;
				if (na > maxA) peri = np;
				else if (na == maxA) peri = min(peri, np);
				maxA = max(maxA, na);
			}
		}
	}
	ofstream fout("perimeter.out");
	fout << maxA << " " << peri << "\n";
	return 0;
}