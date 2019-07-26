package introduction;

import java.util.Scanner;

public class Exam0204 {

	public static void main(String[] args) {

		// キーボード入力を行うための Scanner の準備
		Scanner stdin = new Scanner(System.in);
		int number;

		System.out.println("整数を入力してください");
		number = stdin.nextInt();

		if (number > 0)
		{
			System.out.println(number + " is Positive");
		}
		else if (number < 0)
		{
			System.out.println(number + " is Negative");
		}

		// プログラム終了前の後片付け
		stdin.close();
	}
}
