package introduction;

import java.util.Scanner;

public class Exam0501 {

	public static void main(String[] args) {

		// キーボード入力を行うための Scanner の準備
		Scanner stdin = new Scanner(System.in);

		int data1, data2;

		System.out.println("整数を入力してください");

		data1 = stdin.nextInt();

		System.out.println("２つ目の整数を入力してください");

		data2 = stdin.nextInt();

		calc(data1 , data2);

		// プログラム終了前の後片付け
		stdin.close();
	}

	/**
	 加算、減算、乗算結果を出力する関数
	 @param data1 1つ目に入力した値
	 @param data2 2つ目に入力した値
	 */
	private static void calc(int data1, int data2) {
		System.out.println("** Calculation **");
		System.out.println(data1 + " + " + data2 + " = " + (data1 + data2));
		System.out.println(data1 + " - " + data2 + " = " + (data1 - data2));
		System.out.println(data1 + " * " + data2 + " = " + (data1 * data2));
	}
}
