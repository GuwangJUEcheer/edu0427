package Demo;

public class Demo03 {
private static void getTwoSum(int[] num,int target) {
	for(int i=0;i<num.length;i++) {
		for(int j=1;j<num.length-i-1;j++) {
			if((num[i]+num[i+j])==target) {
				System.out.println(i);
				System.out.println(i+j);
			}
		}
	}
}
public static void main(String[] args) {
	int[] a= {1,3,7,9,11,12};
	getTwoSum(a,12);
}
}
