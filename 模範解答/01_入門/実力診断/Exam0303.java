package introduction;

import java.util.Scanner;

public class Exam0303 {

	public static void main(String[] args) {

		// キーボード入力を行うための Scanner の準備
		Scanner stdin = new Scanner(System.in);
		int number[] = new int[5];
		int total = 0;

		System.out.println("５つ整数を入力してください");

		for (int i = 0; i < 5; i++)
		{
			number[i] = stdin.nextInt();
			while (number[i] < 0) {
				// 入力された値が負の値の場合、エラーメッセージを表示して再入力をさせる
				System.out.println("input number more than 0.");

				number[i] = stdin.nextInt();
			}
		}

		for (int i = 0; i < 5; i++) {
			System.out.println("input number" + i + " : " + number[i]);
			total += number[i];
		}
		System.out.println("");

		// 合計値を出力
		System.out.println(number[0] + " + " + number[1] + " + " + number[2] + " + " + number[3] + " + " + number[4] + " = " + total);
		// 平均値を出力
		double average = (double)total / (double)5;
		System.out.println("(" + number[0] + " + " + number[1] + " + " + number[2] + " + " + number[3] + " + " + number[4] + ") / 5 = " + String.format("%.2f", average));

		// プログラム終了前の後片付け
		stdin.close();
	}
}
