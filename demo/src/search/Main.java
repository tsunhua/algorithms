package search;

public class Main {

	public static void main(String[] args) {
		int R[] = { 2, 5, 3, 34, 12, 1, 98, 45, 4 };
		Search search = new Search();
		int index =-1;
//		index = search.seqSearch(R, R.length, 3);
		index = search.seqSearch2(R, R.length, 3);
		
		
		System.out.println("index: " + index);
	}

}
