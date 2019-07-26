package introduction;

import java.util.Scanner;

public class Exam0232 {

	public static void main(String[] args) {

		// キーボード入力を行うための Scanner の準備
		Scanner stdin = new Scanner(System.in);

		int number = 0;

		while(true) {
			System.out.println("1-10の数字を入力してください");
			number = stdin.nextInt();

			if (number > 0 && number <= 10)
			{
				// 1～10までが入力された場合
				break;
			}

			// 1～10以外が入力された場合
			System.out.println("input number 1-10.");
		}

		// 1～10までが入力された場合
		for (int i = 1; i <= number; i++)
		{
			System.out.print("*");
		}

		// プログラム終了前の後片付け
		stdin.close();
	}
}