package Demo;
//�ݹ麯�������ӣ�Ӳ�ҵĸ�������
public class Demo05 {
private static int calcT(int n,int m) {
	int[] c= {1,2,4,7};
	int count=0;
	if(m>=c[n]) {
		count=m/c[n];
		//�ݹ�
	   if(m%c[n]!=0) {
		   count += calcT(n-1,m%c[n]);
	   }
	}else{
			return calcT(n-1,m);
			}
	return count;
}
public static void main(String[] args) {
	System.out.println(calcT(3,29));
}
}

