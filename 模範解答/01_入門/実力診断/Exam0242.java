package introduction;

import java.util.Scanner;

public class Exam0242 {

	public static void main(String[] args) {

		// キーボード入力を行うための Scanner の準備
		Scanner stdin = new Scanner(System.in);
		int data1 = 0, data2 = 0, menu = 0;

		System.out.println("** MENU **");
		System.out.println("1. A + B");
		System.out.println("2. A - B");
		System.out.println("3. A * B");
		System.out.println("4. A / B");
		System.out.println("5. A % B");
		System.out.println("");
		System.out.println("メニュー番号を入力してください");

		// 1～5までのメニュー番号が入力されるまで繰り返す
		while(true)
		{
			menu = stdin.nextInt();

			if(1 <= menu && menu <=5)
			{
				System.out.println("Select menu: " + menu);
				break;
			}
			else
			{
				System.out.println("input numger 1-5.");
			}
		}

		System.out.println("整数を入力してください");

		// １つ目の値を入力する
		data1 = stdin.nextInt();

		// ２つ目の値を入力する
		while(true)
		{
			System.out.println("２つ目の整数を入力してください");

			data2 = stdin.nextInt();

			// 入力された値が0かつメニュー番号が4：割り算または5：剰余の場合、再入力させる
			if(data2 == 0 &&  (menu == 4 || menu == 5))
			{
				System.out.println("input another data.");
			}
			else
			{
				break;
			}
		}

		if (menu == 1)
		{
			System.out.println(data1 + "+" + data2 + "=" + (data1 + data2));
		}
		else if(menu == 2)
		{
			System.out.println(data1 + "-" + data2 + "=" + (data1 - data2));
		}
		else if(menu == 3)
		{
			System.out.println(data1 + "*" + data2 + "=" + (data1 * data2));
		}
		else if(menu == 4)
		{
			System.out.println(data1 + "/" + data2 + "=" + (data1 / data2));
		}
		else if(menu == 5)
		{
			System.out.println(data1 + "%" + data2 + "=" + (data1 % data2));
		}

		// プログラム終了前の後片付け
		stdin.close();
	}
}
