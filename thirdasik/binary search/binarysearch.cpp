#include <iostream>
#include <vector>
using namespace std;

int binarysearch(vector<int>& arr, int key) {
    int n = arr.size();
    int l = 0;
    int r = n-1;
    while (l <=r ) {
        int mid = (l+r) / 2;
        if (arr[mid] == key) {
            return mid;
        } else if (arr[mid] < key) {
            l = mid +1;
        } else {
            r = mid - 1;
        }
    }
    return -1;
}

int main() {
    vector<int> arr = {2, 3, 4, 5, 6};
    int key = 3;
    int index = binarysearch(arr, key);
    if (index != -1) {
        cout << "found at index: " << index << endl;
    } else {
        cout << "not found" << endl;
    }
    return 0;
}