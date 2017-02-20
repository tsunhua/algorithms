package sort;

public class Sort {
	// 基本插入排序
	void insertSort(int[] R) {
		for (int i = 1; i < R.length; i++) {
			int tmp = R[i];
			int j = i - 1;
			while (j >= 0 && R[j] > tmp) {
				R[j + 1] = R[j];
				j--;
			}
			R[j + 1] = tmp;
		}
	}

	// 折半插入排序
	void insertSort2(int[] R) {
		for (int i = 0; i < R.length; i++) {
			int tmp = R[i];
			int low = 0;
			int high = i - 1;
			while (low <= high) {
				int mid = (low + high) / 2;
				if (tmp < R[mid]) {
					high = mid - 1;
				} else { // 大于或等于的时候请在后面插入，特别是等于的情况不能影响排序的稳定性
					low = mid + 1;
				}
			}
			for (int j = i - 1; j >= high + 1; j--) {
				R[j + 1] = R[j];
			}
			R[high + 1] = tmp;
		}
	}

	// 基本插入排序2
	void insertSort3(int[] R) {
		if (R == null || R.length < 2) {
			return;
		}
		for (int i = 1; i < R.length; i++) {
			int tmp = R[i];
			int j = i - 1;
			for (; j >= 0; j--) {
				if (tmp < R[j]) {
					R[j + 1] = R[j];
				} else {
					break;
				}
			}
			R[j + 1] = tmp;
		}
	}

	// 等价写法
	void insertSort4(int[] R) {
		if (R == null || R.length < 2) {
			return;
		}
		for (int i = 1; i < R.length; i++) {
			int tmp = R[i];
			int j = i - 1;
			for (; j >= 0 && tmp < R[j]; j--) {
				R[j + 1] = R[j];
			}
			R[j + 1] = tmp;
		}
	}

	// 冒泡排序
	void bubbleSort(int[] R) {
		boolean isExchange = false;
		for (int i = 0; i < R.length - 1; i++) {
			// 从后面将小的冒起
			for (int j = R.length - 1; j > i; j--) {
				if (R[j] < R[j - 1]) {
					int tmp = R[j];
					R[j] = R[j - 1];
					R[j - 1] = tmp;
					isExchange = true;
				}
			}
			if (!isExchange) {
				return;
			}
		}
	}

	// 快速排序
	void quickSort(int[] R, int s, int t) {
		if (s >= t) {
			return;
		}
		// 取一元素为基准
		int tmp = R[s];
		int i = s, j = t;
		while (i != j) {
			while (j > i && R[j] >= tmp) {
				j--;
			}
			R[i] = R[j];
			while (i < j && R[i] <= tmp) {
				i++;
			}
			R[j] = R[i];
		}

		R[i] = tmp;
		quickSort(R, s, i - 1);
		quickSort(R, i + 1, t);
	}

	// 快速排序2
	void quickSort2(int[] R, int s, int t) {
		if (s >= t) {
			return;
		}
		int q = s;
		for (int u = s; u < t; u++) {
			if (R[u] <= R[t]) {
				int tmp = R[u];
				R[u] = R[q];
				R[q] = tmp;
				q++;
			}
		}
		int tmp = R[t];
		R[t] = R[q];
		R[q] = tmp;
		quickSort2(R, s, q - 1);
		quickSort2(R, q + 1, t);
	}

	// 选择排序
	void selectSort(int[] R) {
		for (int i = 0; i < R.length; i++) {
			int k = i;
			for (int j = i + 1; j < R.length; j++) {
				if (R[j] < R[k]) {
					k = j;
				}
			}
			if (k != i) {
				int tmp = R[k];
				R[k] = R[i];
				R[i] = tmp;
			}
		}
	}

	// -------------------------堆排序 start----------------
	// 筛选算法：目的在于将两子堆与父节点一起构成大堆。
	// 当发生子节点与父节点交换时，该子节点原先的堆可能被打破，需要向下迭代建堆。
	void sift(int[] R, int low, int high) {
		int i = low, j = 2 * i + 1; // R[j]为R[i]左孩
		int tmp = R[i];
		while (j <= high) { // j = high时只有左孩
			if (j < high && R[j + 1] > R[j]) {
				j++;
			}
			if (R[j] > tmp) {
				// 有子节点大于父节点，继续向下遍历
				R[i] = R[j];
				i = j; // 指向被置换的孩子
				j = 2 * i;
			} else {
				// 没有子节点大于父节点，结束向下遍历
				break;
			}
			R[i] = tmp;
		}
	}

	// 堆排序算法
	void heapSort(int[] R, int n) {
		// 从叶子节点开始建堆
		for (int i = n / 2; i >= 0; i--) {
			sift(R, i, n);
		}
		// 将大根堆的首位与无序区的最后一位互换
		for (int j = n; j >= 1; j--) {
			int tmp = R[j];
			R[j] = R[0];
			R[0] = tmp;
			sift(R, 0, j - 1);
		}
	}
	// -------------------------堆排序 end----------------

	// -------------------------归并排序 start----------------
	// 归并两个表,表1：low~mid,表2：mid+1~high
	void merge(int R[], int low, int mid, int high) {
		// i指向表1开始，j指向表2开始，k指向新表开始
		int i = low, j = mid + 1, k = 0;
		int T[] = new int[high - low + 1];

		// 遍历比较
		while (i <= mid && j <= high) {
			if (R[i] <= R[j]) {
				T[k] = R[i];
				i++;
				k++;
			} else {
				T[k] = R[j];
				j++;
				k++;
			}
		}
		// 处理剩余元素
		while (i <= mid) {
			T[k] = R[i];
			i++;
			k++;
		}
		while (j <= high) {
			T[k] = R[j];
			j++;
			k++;
		}
		// 复制元素
		for (k = 0, i = low; i <= high; k++, i++) {
			R[i] = T[k];
		}
	}

	// 对整个表进行一趟归并
	void mergePass(int[] R, int length, int n) {
		int i;
		// 表1：i ~ i+length-1
		// 表2：i+length ~ i+2*length-1
		// 表3：i+2*length ~ i+3*length-1
		for (i = 0; i + 2 * length - 1 < n; i = i + 2 * length) {
			// 当下两个相邻表的末尾一个元素大于等于n时跳出循环
			merge(R, i, i + length - 1, i + 2 * length);
		}

		if (i + length - 1 < n) {// 此时剩下最后的两个相邻表
			merge(R, i, i + length - 1, n - 1);
		} // 否则，只剩下最后一张表，不用归并
	}

	// 从小表合并到大表
	void mergeSort(int[] R, int n) {
		int length;
		for (length = 1; length < n; length = 2 * length) {
			mergePass(R, length, n);
		}
	}
	// -------------------------归并排序 end----------------

}
