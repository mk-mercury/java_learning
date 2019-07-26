package introduction;

import java.util.Scanner;

public class Exam0211 {

	public static void main(String[] args) {

		// キーボード入力を行うための Scanner の準備
		Scanner stdin = new Scanner(System.in);

		System.out.println("1～3の整数を入力してください");

		// 入力された数字を保持する変数
		int number = stdin.nextInt();

		if(number == 1)
		{
			// 1の場合
			System.out.println("First.");
		}
		else if (number == 2)
		{
			// 2の場合
			System.out.println("Second.");
		}
		else if (number == 3)
		{
			// 3の場合
			System.out.println("Third.");
		}
		else
		{
			System.out.println("input number 1-3.");
		}

		// プログラム終了前の後片付け
		stdin.close();
	}
}
