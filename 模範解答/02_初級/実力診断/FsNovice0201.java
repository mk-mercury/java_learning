package novice;

public class FsNovice0201 {

	public static void main(String[] args) {

		System.out.println(commaSeparatedString(123));
		System.out.println(commaSeparatedString(12345));
		System.out.println(commaSeparatedString(1234567));
		System.out.println(commaSeparatedString(-1234567));
		System.out.println(commaSeparatedString(123456789));
		System.out.println(commaSeparatedString(-123456789));
	}

	/**
	 数字からカンマ区切り文字列を作成する関数
	 @param number カンマ区切りをする数字
	 */
	private static String commaSeparatedString(int number)
	{
		// 文字列操作を行うために StringBuilder を用意
	    StringBuilder sb = new StringBuilder();

	    // number を文字列にして追加
	    sb.append(Integer.toString(number));

	    // 文字列の後ろから３桁毎にカンマを追加していく

	    // 文字列の長さの 3 文字前に初期値を設定
	    int offset = sb.length() - 3;

	    // 文字列の先頭まで繰り返す
	    while (offset > 0)
		{
			// -123456 等の場合に、"-,123,456" となってしまわないように
			// offset が 1 で number がマイナスの場合は、カンマを追加しないように対処する
			if (offset != 1 || number > 0)
			{
				sb.insert(offset, ",");
			}

			// 次のカンマの位置は 3 文字前
			offset -= 3;
		}

		return new String(sb);
	}
}
