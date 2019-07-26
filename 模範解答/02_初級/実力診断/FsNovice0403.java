package novice;

import java.util.ArrayList;

public class FsNovice0403 {

	public static void main(String[] args) {

		ArrayList<String> lines = lineSeparatedString("このプログラムは\n、文字列を指定された幅で改行するサンプルプログラムです。", 6);

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

		// 分割した文字列を格納する配列
		ArrayList<String> lines = new ArrayList<String>();

		// １行分の文字をためておく変数
		String line = "";

		// 文字毎に分割
		String[] chars = str.split("");

		for (String s : chars) {
			if (s.equals("\n")) {
				// 改行
				lines.add(line);
				line = "";
			}
			else
			{
				if (line.length() == cut) {
					// １行分の文字数を超えた
					lines.add(line);
					line = "";
				}

				// 文字を追加
				line += s;
			}
		}

		// 最後の行が処理されていない可能性があるので line に文字が残ってたら追加
		if (line.length() >= 1) {
			lines.add(line);
		}

		return lines;
	}
}
