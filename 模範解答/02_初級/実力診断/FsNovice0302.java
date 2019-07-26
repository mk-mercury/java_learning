package novice;

public class FsNovice0302 {

	public static void main(String[] args) {

		String text = decode("A5B10CD9E2F5G");
		System.out.println(text);

	}

	/**
	 同じの文字が続く場合、文字+連続する文字数に置き換える関数
	 @param input 文字列
	 @return 文字+連続する文字数
	 */
	private static String decode(String input) {

		StringBuilder sb = new StringBuilder();

		// 先頭から解析する（文字＋連続する文字数のペアで処理していく）
		int offset = 0;
		while(offset < input.length())
		{
			// 文字を読み取る
			String chara = input.substring(offset, offset+1);

			// オフセットを進める
			offset++;

			// 文字数を読み取る
			// 数字が省略されている場合や、最後が文字で終わっている場合を考慮する
			int length = 1;
			if (offset < input.length())
			{
				// 連続した数字を取得する
				String numberString = "";

				while(offset < input.length())
				{
					String str = input.substring(offset, offset+1);

					// 取得した文字が数字かを正規表現を使用して判定を行う
					Boolean numCheck = str.matches("[0-9]");

					if (numCheck == true) {
						// 数字だった
						numberString += str;

						// オフセットを進める
						offset++;
					}
					else {
						// 数字ではなかった
						break;
					}
				}

				// 数字指定されていた場合
				if (numberString.length() >= 1)
				{
					// 取得した数字の文字列を数値に変換
					length = Integer.parseInt(numberString);
				}
			}

			// chara を length 回追加する
			for(int j = 0; j < length; j++)
			{
				sb.append(chara);
			}
		}

		return sb.toString();
	}

}
