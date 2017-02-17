package sort;

public class Main {
	public static void main(String[] args) {
		int R[] = {
				2,5,3,34,12,1,98,45,4
		};
		Sort sort = new Sort();
//		sort.insertSort(R);
//		sort.insertSort2(R);
//		sort.bubbleSort(R);
//		sort.quickSort(R, 0, R.length-1);
//		sort.quickSort2(R, 0, R.length-1);
//		sort.selectSort(R);
//		sort.heapSort(R, R.length-1);
		sort.mergeSort(R, R.length);
		log(R);
	}
	
	public static void log(int[] arr){
		System.out.println();
		for (int i : arr) {
			System.out.print(i+",");
		}
		System.out.println();
	}
}
