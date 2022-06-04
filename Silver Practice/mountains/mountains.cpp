#include <bits/stdc++.h>
using namespace std;


bool compare(pair<int, int> a, pair<int, int>b) {
	return a.second < b.second;
}


int main(int argc, char const *argv[]) {
	ifstream fin("mountains.in");
	int n;
	fin >> n;
	pair<int, int> peaks[n];
	for (int i = 0; i < n; ++i) {
		int a, b;
		fin >> a >> b;
		peaks[i] = make_pair(a, b);
	}

	bool done[n];
	int vis = n;
	sort(peaks, peaks + n, compare);
	for (int i = 0; i < n; ++i) {
		done[i] = false;
	}
	// for (int i = 0; i < n; ++i) {
	// 	cerr << peaks[i].first << " " << peaks[i].second << endl;
	// }

  for (int i = n - 1; i >= 0; i--) {
      if (done[i]) continue;
      for (int j = i - 1; j >= 0; j--) {
          if (done[j]) continue;
          int d = peaks[i].second - peaks[j].second;
          // cout << (peaks[j].first >= (peaks[i].first - d)) << "hh" << (peaks[j].first <= (peaks[i].first + d)) << endl;
          if ((peaks[j].first >= (peaks[i].first - d)) && (peaks[j].first <= (peaks[i].first + d))) { vis--; done[j] = true; }
      }
  }
	cout << vis << endl;
	ofstream fout("mountains.out");
	fout << vis << endl;
	return 0;
}