package introduction;

import java.util.Scanner;

public class Exam0231 {

	public static void main(String[] args) {

		// キーボード入力を行うための Scanner の準備
		Scanner stdin = new Scanner(System.in);

		int data1, data2;

		System.out.println("整数を入力してください");
		data1 = stdin.nextInt();

		while(true)
		{
			System.out.println("整数を入力してください");

			data2 = stdin.nextInt();
			if (data2 == 0)
			{
				System.out.println("input anather data.");
			}
			else
			{
				// 0以外が入力された場合、while文を抜ける
				break;
			}
		}

		System.out.println(data1 + " + " + data2 + "=" + (data1 + data2));
		System.out.println(data1 + " - " + data2 + "=" + (data1 - data2));
		System.out.println(data1 + " * " + data2 + "=" + (data1 * data2));
		System.out.println(data1 + " / " + data2 + "=" + (data1 / data2));
		System.out.println(data1 + " % " + data2 + "=" + (data1 % data2));

		// プログラム終了前の後片付け
		stdin.close();
	}
}
