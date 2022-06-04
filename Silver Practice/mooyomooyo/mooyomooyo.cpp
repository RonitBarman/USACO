#include <bits/stdc++.h>
using namespace std;

int grid[100][10];

int main(int argc, char const *argv[]) {
	ifstream fin("mooyomooyo.in");
	int n, k;
	fin >> n >> k;
	for (int i = 0; i < n; ++i) {
		string s;
		fin >> s;
		for (int j = 0; j < 10; ++j) {
			grid[i][j] = s[j] - '0';
			cout << grid[i][j];
		}
	}

}