#include <iostream>
#include <vector>
using namespace std;

void bubblesort(vector<int>& arr) {
    int n = arr.size();
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j+1]) {
                swap(arr[j], arr[j+1]);
            }
        }
    }
}

int main() {
    vector<int> arr(5);
    int n = 5;
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    bubblesort(arr);

    for (int i = 0; i < n; i++) {
        cout << arr[i] << " ";
        }
    return 0;
}