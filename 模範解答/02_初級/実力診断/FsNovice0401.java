package novice;

import java.util.ArrayList;

public class FsNovice0401 {

	public static void main(String[] args) {

		ArrayList<String> lines = lineSeparatedString("１行目。¥n２行目。¥n３行目。¥n４行目。¥n¥n５行目¥n");

		for (String line : lines)
		{
			System.out.println(line);
		}
	}

	/**
	 複数行の文字列を改行コードで分割して、１行毎の文字列に分解する関数
	 @param str 文字列
	 @return １行毎に文字列を分解したデータが格納してあるリスト
	 */
	private static ArrayList<String> lineSeparatedString(String str)
	{
		// 正規表現（\n）で文字を分割する。
		String[] splitStr = str.split("¥n",0);

		System.out.println();

		ArrayList<String> lines = new ArrayList<>();

		// 配列からリストへ移し変える
		for (String string : splitStr) {
			lines.add(string);
		}

		return lines;
	}

}
