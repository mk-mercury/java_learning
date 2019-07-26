package introduction;

import java.util.Scanner;

public class Exam0243 {

	public static void main(String[] args) {

		// キーボード入力を行うための Scanner の準備
		Scanner stdin = new Scanner(System.in);
		int point;

		System.out.println("0-40までの数字を入力してください");

		while(true)
		{
			point = stdin.nextInt();

			if(0 <= point && point <= 40)
			{
				break;
			}
			else
			{
				System.out.println("input point 0-40.");
			}
		}

		System.out.println("input point : " + point);

		if (0 <= point && point < 10)
		{
			System.out.println("Go home!");
		}
		else if (10 <= point && point < 20)
		{
			System.out.println("Bad!");
		}
		else if (20 <= point && point < 30)
		{
			System.out.println("Make more effort!");
		}
		else if (30 <= point && point < 40)
		{
			System.out.println("Good job!");
		}
		else if (point == 40)
		{
			System.out.println("Excellent!");
		}

		// プログラム終了前の後片付け
		stdin.close();
	}
}
