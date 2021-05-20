package geetime.link;

import java.util.Scanner;

//注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine().toLowerCase();
		String s = sc.nextLine().toLowerCase();
		System.out.print(str.length() - str.replaceAll(s, "").length());
	}
}
