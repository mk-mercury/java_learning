package introduction;

import java.util.Scanner;

public class Exam0233 {

	public static void main(String[] args) {

		// キーボード入力を行うための Scanner の準備
		Scanner stdin = new Scanner(System.in);

		int total = 0;

		System.out.println("整数を入力してください。");
		System.out.println("0を入力すると終了します。");

		while(true)
		{
			int data = stdin.nextInt();
			System.out.println("input data : " + data);

			// 0が入力された場合、while文を抜ける
			if(data == 0)
			{
				break;
			}

			// 入力された値を合計に加算する
			total += data;
		}

		System.out.println("Total is " + total + ".");

		// プログラム終了前の後片付け
		stdin.close();
	}
}
