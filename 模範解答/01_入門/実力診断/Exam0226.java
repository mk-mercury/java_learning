package introduction;

import java.util.Scanner;

public class Exam0226 {

	public static void main(String[] args) {

		// キーボード入力を行うための Scanner の準備
		Scanner stdin = new Scanner(System.in);

		System.out.println("整数を入力してください");
		int number = stdin.nextInt();

		System.out.println("べき乗を入力してください");
		int power = stdin.nextInt();

		// べき乗に負の値が入力されていない場合
		if (power >= 0)
		{
			int answer = 1;

			for (int i = 0; i < power; i++)
			{
				answer = answer * number;
			}

			System.out.println(number + " ^ " + power + " = " + answer);
		}
		else
		{
			// べき乗に負の値が入力された場合
			System.out.println("input power more than -1.");
		}

		// プログラム終了前の後片付け
		stdin.close();
	}
}
