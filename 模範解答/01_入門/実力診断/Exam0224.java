package introduction;

import java.util.Scanner;

public class Exam0224 {

	public static void main(String[] args) {

		// キーボード入力を行うための Scanner の準備
		Scanner stdin = new Scanner(System.in);

		System.out.println("整数を入力してください");
		int number = stdin.nextInt();

		if(number > 0)
		{
			for (int i = 1; i <= number; i++ )
			{
				System.out.print(i + " ");
			}
		}
		else
		{
			System.out.println("input number more than 0.");
		}

		// プログラム終了前の後片付け
		stdin.close();
	}
}
