package introduction;

import java.util.Scanner;

public class Exam0214 {

	public static void main(String[] args) {

		// キーボード入力を行うための Scanner の準備
		Scanner stdin = new Scanner(System.in);

		System.out.println("1以上の整数を入力してください");

		// 入力された数字を保持する変数
		int number = stdin.nextInt();

		// 0より大きい値が入力された場合
		if (number > 0)
		{
			// 10～19までの場合は「th」をつけて表示する
			if(10 <= number && number <= 19)
			{
				System.out.println(number + "th");
			}
			else
			{
				// 10～19以外の場合
				// 下1桁の数字を保持する変数
				int lastNumber = number % 10;

				if(lastNumber == 1)
				{
					// 下一桁が1の場合、「st」をつけて表示する
					System.out.println(number + "st");
				}
				else if (lastNumber == 2)
				{
					// 下一桁が2の場合、「nd」をつけて表示する
					System.out.println(number + "nd");
				}
				else if (lastNumber == 3)
				{
					// 下一桁が3の場合、「rd」をつけて表示する
					System.out.println(number + "rd");
				}
				else
				{
					// 下一桁が上記以外の場合、「th」をつけて表示する
					System.out.println(number + "th");
				}
			}
		}
		else
		{
			System.out.println("input number more than 1.");
		}

		// プログラム終了前の後片付け
		stdin.close();
	}
}
