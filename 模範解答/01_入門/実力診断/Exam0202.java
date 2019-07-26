package introduction;

import java.util.Scanner;

public class Exam0202 {

	public static void main(String[] args) {

		// キーボード入力を行うための Scanner の準備
		Scanner stdin = new Scanner(System.in);

		int number1, number2;

		System.out.println("整数を入力してください");
		number1 = stdin.nextInt();
		System.out.println("整数を入力してください");
		number2 = stdin.nextInt();

		// 入力された整数値が等しい場合、メッセージを出力する。
		if (number1 == number2)
		{
			System.out.println("number1(" + number1 + ") is equal to number2(" + number2 + ").");
		}

		// プログラム終了前の後片付け
		stdin.close();
	}
}
