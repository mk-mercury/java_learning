package introduction;

import java.util.Scanner;

public class Exam0112 {

	public static void main(String[] args) {
		// キーボード入力を行うための Scanner の準備
		Scanner stdin = new Scanner(System.in);

		// 複数宣言をまとめて行う。
		int data1, data2;

		System.out.println("整数を入力してください");
		data1 = stdin.nextInt();

		System.out.println("整数を入力してください");
		data2 = stdin.nextInt();

		// 足し算の計算結果を表示する
		System.out.println(data1 + "+" + data2 + "=" + (data1 + data2));

		// 引き算の計算結果を表示する
		System.out.println(data1 + "-" + data2 + "=" + (data1 - data2));

		// 掛け算の計算結果を表示する
		System.out.println(data1 + "*" + data2 + "=" + (data1 * data2));

		// 割り算の計算結果を表示する
		System.out.println(data1 + "/" + data2 + "=" + (data1 / data2));

		// 剰余算の計算結果を表示する
		System.out.println(data1 + "%" + data2 + "=" + (data1 % data2));

		// プログラム終了前の後片付け
		stdin.close();
	}
}
