package Demo;

import java.util.Stack;
public class Demo04 {
	private static int rqn(String equ) {
		char[] charArray = equ.toCharArray();
		Stack<Integer> s = new Stack<Integer>();
		for (char c:charArray) {
			if (isNum(c)) {
				s.push(Character.getNumericValue(c));
			} else {
				switch(c){
				case '+':
				int x=s.pop();
				int y=s.pop();
				s.push(y+x);
				break;
				case '-':
					int x1=s.pop();
					int y1=s.pop();
					s.push(y1-x1);
					break;
				case '*':
					int x2=s.pop();
					int y2=s.pop();
					s.push(y2*x2);
					break;
				case '/':
					int x3=s.pop();
					int y3=s.pop();
					s.push(y3/x3);
					break;
					default:
						break;
			}
		}
		}
			return (int)s.pop();
	}
	
	private static boolean isNum(char c) {
		if (c < 48 || c > 57)
			return false;
		return true;
	}
	public static void main(String[] args) {
		System.out.println(rqn("32-"));
	}
}
