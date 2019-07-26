package introduction;

import java.util.Scanner;

public class Exam0505 {
	public static void main(String[] args) {
		var stdin = new Scanner(System.in);
		char character;

		while (true) {
			System.out.printf("input character : ");
			character = stdin.nextLine().charAt(0);

			String message = letter_change(character);
			if (message == null) {
				break;
			}

			System.out.println(message);
			System.out.println();
		}

		// 終了処理
		stdin.close();
	}

	/**
	 文字型の値を受け取り、その値を加工して返す関数
	 @param character 入力した値
	 @return 加工した値
	 */
	public static String letter_change(char character) {
		String message = "'" + character + "' ";

		// 入力した値がアルファベットか判定を行う
		// true：アルファベット、false：アルファベット以外
		if (Character.isAlphabetic(character) == true) {
			// 入力した値が大文字か小文字か判定を行う
			// true：大文字、false：小文字
			if (Character.isUpperCase(character) == true) {
				// 大文字の場合は小文字に
				String s = String.valueOf(Character.toLowerCase(character));
				return message + "to lower -> '" + s + "'";
			} else {
				// 小文字の場合は大文字に(文字コードを-32)
				String s = String.valueOf(Character.toUpperCase(character));
				return message + "to upper -> '" + s + "'";
			}
		} else if (character == '.') {
			return null;
		} else {
			return message + "no changed";
		}
	}
}