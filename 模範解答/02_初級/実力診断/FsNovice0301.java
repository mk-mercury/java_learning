package novice;

public class FsNovice0301 {

	public static void main(String[] args) {

		String text = encode("AAAAABBBBBBBBBBCDDDDDDDDDEEFFFFFG");
		System.out.println(text);

	}

	/**
	 同じの文字が続く場合、文字+連続する文字数に置き換える関数
	 @param input 文字列
	 @return 文字+連続する文字数
	 */
	private static String encode(String input) {

		// ループ内で文字列を結合する為に使用する
		StringBuilder sb = new StringBuilder();
		char last = input.charAt(0);
		int count = 1;

		// 文字数分の繰り返し処理を行う
		for(int i = 1; i < input.length(); i++){

			// 同じの文字が続く場合、カウントを増やす
		    if(last == input.charAt(i)){
		    	count++;
		    } else {
		    	// 同じ文字ではない場合、文字列を連結させて次の文字へ
				sb.append(last);

				// 1文字のみだったの場合、1は表示させない
				if(count != 1)
				{
					sb.append(count);
				}

				last = input.charAt(i);
				count = 1;
		    }
		}

		// 最後の文字列を格納する
		sb.append(last);
		// 1文字のみだったの場合、1は表示させない
		if(count != 1)
		{
			sb.append(count);
		}

		return sb.toString();
	}

}
