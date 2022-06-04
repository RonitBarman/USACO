#include<bits/stdc++.h>
using namespace std;

int c[1000];
int main(int argc, char const *argv[]) {
	int n, z = 0;
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> c[i];
		if (!c[i]) z++;
	}
	int ans = 0;
	while (z > 0) {
		for (int i = 0; i < n; i++) {
			int j = i + 1;
			while (c[i] > 1) {
				if (!c[j]) {
					if (j > i) {
						ans += (j - i)*(j - i);
					} else {
						ans += (i + n - 1 - j)*(i + n - 1 - j);
					}
					cout << j << " " << i << endl;
					c[j]++;
					c[i]--;
					z--;
				}
				j++;
				j %= n;
				cout << ans << endl;
			}
		}
	}
	cout << ans << endl;
}