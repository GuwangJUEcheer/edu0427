package Demo;
public class Demo01 {
	public static int[] moveArray(int k, int[] a) {
		int[] b = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			if (i < a.length - k) {
				b[i + k] = a[i];
			} else {
				b[i + k - a.length] = a[i];
			}
		}
		return b;
	}

	public static void main(String[] args) {
		int[] a= {1,2,3,4};
			 for(int i:moveArray(1,a)) {
				 System.out.println(i);
		 }
}
}
