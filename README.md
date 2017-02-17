#算法学习总结 
### 排序算法

![排序算法](https://github.com/LinLshare/algorithms/blob/master/img/%E6%8E%92%E5%BA%8F%E7%AE%97%E6%B3%95.png?raw=true)

#### 直接插入排序

思路：

使用直接遍历方法在有序区找到插入位置。

算法实现：

```java
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
```

#### 折半插入排序

思路：

使用折半查找方法在有序区找到插入位置。

算法实现：

```java
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
```

#### 冒泡排序

思路：

从右到左相邻两元素两两比较，小者上浮到有序区。

算法实现：

```java
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
```

#### 快速排序

思路：

任取一元素将无序区分割成两个，然后两个无序区分别再选取一元素进行分割，直到剩余元素为1。

算法实现：

```java
void quickSort(int[] R, int s, int t) {
	if (s >= t) {
		return;
	}
	// 取一元素为基准，R[s]位置空余
	int tmp = R[s];
	int i = s, j = t;
	while (i != j) {
      //从右到左比较
		while (j > i && R[j] >= tmp) {
			j--;
		}
      //找到一个小于tmp的放到左边
		R[i] = R[j];
      //从左到右比较
		while (i < j && R[i] <= tmp) {
			i++;
		}
      //找到一个大于tmp的放到右边
		R[j] = R[i];
	}
	//插入
	R[i] = tmp;
	quickSort(R, s, i - 1);
	quickSort(R, i + 1, t);
}

void quickSort2(int[] R, int s, int t) {
	if (s >= t) {
		return;
	}
	int q = s;
	for (int u = s; u < t; u++) {
      //将小于或等于最右边的基准元素的放置在最左边，并用q确定边界
		if (R[u] <= R[t]) {
			int tmp = R[u];
			R[u] = R[q];
			R[q] = tmp;
			q++;
		}
	}
  //插入基准元素
	int tmp = R[t];
	R[t] = R[q];
	R[q] = tmp;
	quickSort2(R, s, q - 1);
	quickSort2(R, q + 1, t);
}
```

#### 直接选择排序

思路：

每次从无序区选出一个最小的放置到有序区。

算法实现：

```java
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
```



