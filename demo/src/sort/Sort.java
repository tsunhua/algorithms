package sort;

public class Sort {
	// ������������
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

	// �۰��������
	void insertSort2(int[] R) {
		for (int i = 0; i < R.length; i++) {
			int tmp = R[i];
			int low = 0;
			int high = i - 1;
			while (low <= high) {
				int mid = (low + high) / 2;
				if (tmp > R[mid]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
			for (int j = i - 1; j >= high + 1; j--) {
				R[j + 1] = R[j];
			}
			R[high + 1] = tmp;
		}
	}

	// ð������
	void bubbleSort(int[] R) {
		boolean isExchange = false;
		for (int i = 0; i < R.length - 1; i++) {
			// �Ӻ��潫С��ð��
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

	// ��������
	void quickSort(int[] R, int s, int t) {
		if (s >= t) {
			return;
		}
		// ȡһԪ��Ϊ��׼
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

	// ��������2
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

	// ѡ������
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

	// -------------------------������ start----------------
	// ɸѡ�㷨��Ŀ�����ڽ����Ӷ��븸�ڵ�һ�𹹳ɴ�ѡ�
	// �������ӽڵ��븸�ڵ㽻��ʱ�����ӽڵ�ԭ�ȵĶѿ��ܱ����ƣ���Ҫ���µ������ѡ�
	void sift(int[] R, int low, int high) {
		int i = low, j = 2 * i+1; //R[j]ΪR[i]��
		int  tmp = R[i];
		while (j <= high) { // j = highʱֻ����
			if (j < high && R[j + 1] > R[j]) {
				j++;
			}
			if (R[j] > tmp) {
				// ���ӽڵ���ڸ��ڵ㣬�������±���
				R[i] = R[j];
				i = j; // ָ���û��ĺ���
				j = 2 * i;
			} else {
				// û���ӽڵ���ڸ��ڵ㣬�������±���
				break;
			}
			R[i] = tmp;
		}
	}

	// �������㷨
	void heapSort(int[] R, int n) {
		// ��Ҷ�ӽڵ㿪ʼ����
		for (int i = n / 2; i >= 0; i--) {
			sift(R, i, n);
		}
		// ������ѵ���λ�������������һλ����
		for (int j = n; j >= 1; j--) {
			int tmp = R[j];
			R[j] = R[0];
			R[0] = tmp;
			sift(R, 0, j-1);
		}
	}
	// -------------------------������ end----------------
}