package string;

public class StringMatcher {
	
	//BF算法
	//s为源字符串，t为模板串
	int index(String s,String t){
		int i = 0,j=0;
		char [] sCharArray =s.toCharArray();
		char [] tCharArray = t.toCharArray();
		while(i<=sCharArray.length && j<=tCharArray.length){
			if(sCharArray[i] == tCharArray[j]){
				j++;
				i++;
			}else{
				i = i-j+1;
				j =0;
			}
			if(j>=tCharArray.length){
				return i-tCharArray.length;
			}else{
				return -1;
			}
		}
 		return -1;
	}
}
