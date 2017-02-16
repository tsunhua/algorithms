#算法学习总结 
### 排序算法

![排序算法](https://github.com/LinLshare/algorithms/blob/master/img/%E6%8E%92%E5%BA%8F%E7%AE%97%E6%B3%95.png?raw=true)

#### 直接插入排序

思路：

（1）划分有序区和无序区；

（2）遍历无序区，每取得一元素就再遍历无序区，将大于该元素的后移；循环退出时插入该元素。

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

（1）使用折半查找方法在有序区找到插入位置；

（2）同上。

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



