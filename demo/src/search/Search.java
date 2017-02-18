package search;

public class Search {

	// 顺序查找
	int seqSearch(int R[], int n, int key) {
		int i = 0;
		while (i < n && R[i] != key) {
			i++;
		}
		if (i >= n) {
			return -1;
		} else {
			return i;
		}
	}

	// 顺序查找2
	int seqSearch2(int R[], int n, int key) {
		for (int i = 0; i < n; i++) {
			if (R[i] == key) {
				return i;
			}
		}
		return -1;
	}

	// 折半查找，假定该表使递增的有序表
	int binarySearch(int R[], int n, int key) {
		int low = 0, high = n - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (R[mid] == key) {
				return mid;
			} else if (R[mid] > key) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}
}
