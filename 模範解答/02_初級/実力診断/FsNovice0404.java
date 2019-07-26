package novice;

import java.util.ArrayList;
import java.util.Arrays;

public class FsNovice0404 {

	public static void main(String[] args) {

		ArrayList<String> lines = lineSeparatedString("このプログラムは、句読点を行頭禁則処理するサンプル。\n最後の行です", 8);

		for (String line : lines) {
			System.out.println(line);
		}
	}

	/**
	複数行の文字列を改行コードで分割して、１行毎の文字列に分解する関数
	@param str 文字列
	@param cut １行の文字数
	@return １行毎に文字列を分解したデータが格納してあるリスト
	*/
	public static ArrayList<String> lineSeparatedString(String str, int cut) {
		String[] chars = str.split("");
		String st = "";
		int count = 1;
		int flag = 0;
		int i = 1;

		for (String s : chars) {
			if (count == (cut + 1) * i) {
				// 9文字目に何が入るかによって処理を変更
				i++;
				if (s.equals("、") || s.equals("。")) {
					st += s + "\n";
					flag++;
				} else if (flag == 1 && s.equals("\n")) {
					// 句読点と句点のあとに改行が続くときは改行
					st += "\n";
					flag = 0;
				} else {
					st += "\n" + s;
				}
			} else {
				// 8文字目までは文字を足していく
				st += s;
			}

			count++;
		}

		// 改行毎に分割
		String[] lines = st.split("\n");

		// 配列から ArrayList を作成
		return new ArrayList<String>(Arrays.asList(lines));
	}
}
