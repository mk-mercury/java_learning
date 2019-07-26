package introduction;

import java.util.Scanner;

public class Exam0504 {

	public static void main(String[] args) {

		// キーボード入力を行うための Scanner の準備
		Scanner stdin = new Scanner(System.in);

		String character;

		System.out.println("数字か文字を入力してください");
		character = stdin.nextLine();

		if (is_num(character) == 0)
		{
			// is_num()の返り値が0：文字の場合
			System.out.println("'" + character + "' is not a numeral.");
		}
		else
		{
			// is_num()の返り値が1：数字の場合
			System.out.println("'" + character + "' is a numeral.");
		}

		// プログラム終了前の後片付け
		stdin.close();
	}

	/**
	 入力した値が数字か数値以外かを判定する関数
	 @param character 入力した値
	 @return 0：数字以外、1：数字
	 */
	private static int is_num(String character) {
		try
		{
			// 文字→整数に変換できる場合は1：数字を返す
			Integer.parseInt(character);
			return 1;
		}
		catch(NumberFormatException e)
		{
			// 文字→整数に変換できなかった場合は0：文字を返す
			return 0;
		}
	}
}
