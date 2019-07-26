package introduction;

import java.util.Scanner;

public class Exam0503 {

	public static void main(String[] args) {

		// キーボード入力を行うための Scanner の準備
		Scanner stdin = new Scanner(System.in);

		float data1, data2;

		System.out.println("小数を入力してください");

		data1 = stdin.nextFloat();

		System.out.println("２つ目の小数を入力してください");

		data2 = stdin.nextFloat();

		System.out.println("Average = " + Average(data1 , data2));

		// プログラム終了前の後片付け
		stdin.close();
	}

	/**
	 平均値を返す関数
	 @param data1 1つ目に入力した値
	 @param data2 1つ目に入力した値
	 @return 平均値
	 */
	private static String Average(float data1, float data2) {
		return String.format("%.4f", ((data1 + data2) / 2));
	}
}
