package introduction;

import java.util.Scanner;

public class Exam0205 {

	public static void main(String[] args) {

		// キーボード入力を行うための Scanner の準備
		Scanner stdin = new Scanner(System.in);

		int point;

		System.out.println("整数を入力してください");
		point = stdin.nextInt();

		if(0 <= point && point < 70)
		{
			// 0～69の場合、不合格
			System.out.println("Unsuccess.");
		}
		else if(70 <= point && point < 90)
		{
			// 70～89の場合、合格
			System.out.println("Success.");
		}
		else if(90 <= point && point <= 100)
		{
			// 90～100の場合、優秀
			System.out.println("Excellent.");
		}
		else
		{
			// 上記以外の場合、0～100までを入力してください。
			System.out.println("input point 0-100.");
		}

		// プログラム終了前の後片付け
		stdin.close();
	}
}
