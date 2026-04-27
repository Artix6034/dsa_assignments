#include <iostream>
#include <cstring>
using namespace std;

int firs(int n)
{
	if (n == 1) {
		return n;
	}
	return firs(n - 1) + (n * n);
}

int secon(int n, int * arr) {
	if (n == 0) {
		return arr[0];
	}
	return secon(n - 1, arr) + arr[n];
}

int third(int n) {
	if (n == 1) {
		return n;
	}
	return third(n - 1) + n;
}

int fourth(int n, int b) {
	if (n == 0) {
		return 1;
	}
	return fourth(n - 1, b) + (int)pow(b, n);  
}

void fifth(int n) {
	int a;
	cin >> a;
	if (n == 1) {
		cout << a << " ";
		return;
	}
	fifth(n - 1);
	cout << a << " ";
}

void sixth(int n) {
	char a[100];
	cin >> a;
	if (n == 1) {
		cout << a << endl;
		return;
	}
	sixth(n - 1);
	cout << a << endl;
}

void seventh(int* grid, int n, int row, int col, int num, int size) {
	if (size <= 0) return;

	if (size == 1) {
		grid[row * n + col] = num;
		return;
	}

	for (int i = 0; i < size - 1; i++)
		grid[row * n + (col + i)] = num++;

	for (int i = 0; i < size - 1; i++)
		grid[(row + i) * n + (col + size - 1)] = num++;

	for (int i = size - 1; i > 0; i--)
		grid[(row + size - 1) * n + (col + i)] = num++;

	for (int i = size - 1; i > 0; i--)
		grid[(row + i) * n + col] = num++;

	seventh(grid, n, row + 1, col + 1, num, size - 2);
}

void eigth(int* seq, int pos, int n, int k) {
	if (pos == n) {
		for (int i = 0; i < n; i++) {
			cout << seq[i];
			if (i < n - 1) cout << " ";
		}
		cout << "\n";
		return;
	}
	for (int v = 1; v <= k; v++) {
		seq[pos] = v;
		eigth(seq, pos + 1, n, k);
	}
}
void nine(char* str, int left, int len) {
	if (left == len - 1) {
		cout << str << "\n";
		return;
	}
	for (int i = left; i < len; i++) {
		swap(str[left], str[i]);
		nine(str, left + 1, len);
		swap(str[left], str[i]); 
	}
}

bool ten(int n) {
	if (n <= 0) return false;  
	if (n == 1) return true;   
	if (n % 2 != 0) return false; 
	return ten(n / 2); 
}

int main() {
	int n = 3;

	// Task 1
	cout << firs(4) << endl;

	// Task 2
	int arr[] = { 1, 2, 3 };
	cout << secon(n - 1, arr) << endl;

	// Task 3
	cout << third(5) << endl;

	// Task 4
	cout << fourth(3, 4) << endl;

	// Task 5
	fifth(3);
	cout << endl;

	// Task 6
	sixth(3);

	// Task 7
	int m[3][3] = { 0 };
	seventh(&m[0][0], 3, 0, 0, 1, 3);
	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < n; ++j) {
			cout << m[i][j] << " ";
		}
		cout << endl;
	} 

	// Task 8
	int seq[100];
	eigth(seq, 0, 2, 3);

	// Task 9
	char str[21];
	cin >> str;
	nine(str, 0, strlen(str));

	// Task 10
	for (int i = 0; i <= 9; i++) {
		cout << i << " is "
			<< (ten(i) ? "" : "not ")
			<< "a power of two\n";
	}
	cout << "----------------------\n";
	for (int i = 10; i <= 32; i += 2) {
		cout << i << " is "
			<< (ten(i) ? "" : "not ")
			<< "a power of two\n";
	}

	return 0;
}

// 0 0  0 1  0 2  if n == n - 1 return func i =+ 1 j = n
// 1 0  1 1  1 2 also if for moving to down
// 2 0  2 1  2 2 check if i and j == n-1 then you need to return each time until j = 0 and make if to move up


// 0 0  0 1  0 2  0 3
// 1 0  1 1  1 2  1 3 
// 2 0  2 1  2 2  2 3
// 3 0  3 1  3 2  3 3