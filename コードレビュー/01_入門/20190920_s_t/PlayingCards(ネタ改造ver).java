package fs01_GettingStarted_ProgramCreation;

import java.util.Random;
import java.util.Scanner;

public class PlayingCards {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		Random random = new Random();
		Scanner stdin = new Scanner(System.in);
		int count = 0;	//図柄用の入力カウント

		String[] mark = {"ハート","ダイヤ","スペード","クローバー"};
		String[] number = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};

		System.out.println
		("** カイジ VS 利根川 ** トランプ当て勝負 (利根川が心の中でヒントを出してくれるよ(ﾟ∀ﾟ ))");
		System.out.println("");
		System.out.println("「利根川」 トランプを選んだぞ。");
		System.out.println
		("「利根川」 さあ、カイジよ、トランプの図柄を当てみろ。答えられるのは 2回 だ！");
		System.out.println("");

		//入力回数 ～「図柄：2回」「数字：3回」
		for(int i = 0; i<1; i++){
			int x = random.nextInt(4);	//図柄の要素番号のランダム生成
			mark[i] = mark[x];			//生成した数字を代入
			System.out.println("0:ハート");
			System.out.println("1:ダイヤ");
			System.out.println("2:スペード");
			System.out.println("3:クローバー");
			System.out.println("「利根川」 どれだと思う？");
			System.out.println("「モブ達」 ざわ・・");
			System.out.print
			("「カイジ」 (確率は1/4・・クソっ！ どれなんだ？)：");
			String m = stdin.next();	//1回目の入力(図柄)

			while(true){
				switch(m){
				case "0": m = "ハート";
				break;
				case "1": m = "ダイヤ";
				break;
				case "2": m = "スペード";
				break;
				case "3": m = "クローバー";
				}

				//図柄は2回まで入力出来る
				if(mark[i].equals(m)){
					System.out.println("");
					System.out.println("「利根川」 チッッ、正解だ! 図柄は「" + m + "」だ。。");
					System.out.println("「モブ達」 ざわざわ・・");
					System.out.println("「カイジ」 (よし！当たったぜ！)");
					break;
				} else if(count==1){
					System.out.println("");
					System.out.println("「利根川」 ハズレだ！「" + m + "」ではない！");
					System.out.println("「利根川」 正解は「" + mark[i] + "」だ！");
					System.out.println("「モブ達」 ざわ・・ざわ・・");
					System.out.println("「カイジ」 ヂグジョーー！！ ありえねぇ～～～！？");
					System.out.println("");
					System.out.println("--BAD END--（地下労働施設行き）");
					break;
				} else {
					count++;
					System.out.println("");
					System.out.println("「利根川」 ハズレだ!「" + m + "」ではない！");
					System.out.println("「モブ達」 ざわ・・");
					System.out.println("「カイジ」 (グゾーー！外しちまった！！)");
					System.out.println("「利根川」 答えられるのはあと" + count + "回だ。");
					System.out.print("「利根川」 どれだと思う？：");
					m = stdin.next();
				}
			}

			//ここから数字当て（図柄が合ってたら実行）
			if(mark[i].equals(m)){
				System.out.println("");
				System.out.println
				("「利根川」 次は数字だ。答えられるのは 3回 だ！");
				System.out.println("「利根川」 どれだと思う？");
				System.out.println("「モブ達」 ざわ・・");
				System.out.print("「カイジ」 (落ち着け。。落ち着け、俺！！)：");
				int y = random.nextInt(13);		//数字のランダム生成

				for(int j = 0; j<3; j++){
					number[j] = number[y];		//生成した数字を代入
					String n = stdin.next();	//1回目の入力(数字)

					int z;	//「文字列→数字」変換用変数

					//入力した数字が[1][11][12][13]のいずれかの場合
					//それぞれ[A][J][Q][K]へ置き換える
					switch(n){
					case "1": n = "A";
					break;
					case "11": n = "J";
					break;
					case "12": n = "Q";
					break;
					case "13": n = "K";
					}

					//数字は3回まで入力出来る
					if(number[j].equals(n)){
						System.out.println("");
						System.out.println
						("「利根川」 なっっ！「" + mark[i] + "」の「" + number[j] + "」！ 正解だと！！");
						System.out.println("「モブ達」 ざわっ、ざっわ～～");
						System.out.println("「カイジ」 やっだぞぉぉーー！！");
						System.out.println("");
						System.out.println("--CLEAR--（このあと利根川が焼き土下座）");
						break;
					} else {
						switch(n){
						case "A": n = "1";	//不正解の場合はヒント用に中身を全て数字へ置き換える（この時点ではString型）
						break;
						case "2": n = "2";
						break;
						case "3": n = "3";
						break;
						case "4": n = "4";
						break;
						case "5": n = "5";
						break;
						case "6": n = "6";
						break;
						case "7": n = "7";
						break;
						case "8": n = "8";
						break;
						case "9": n = "9";
						break;
						case "10": n = "10";
						break;
						case "J": n = "11";
						break;
						case "Q": n = "12";
						break;
						case "K": n = "13";
						}

						//3回とも不正解なら終了
						if(j==2){
							System.out.println("");
							System.out.println
							("「利根川」 ハズレだ!「" + n + "」ではない！");
							System.out.println("「利根川」 正解は「" + mark[i] + "」の「" + number[j] + "」だ！");
							System.out.println("「モブ達」 ざわ・・ざわ・・");
							System.out.println("「カイジ」 ヂグジョーー！！ ありえねぇ～～～！？");
							System.out.println("");
							System.out.println("--BAD END--（地下労働施設行き）");
							break;
						}

						//不正解の場合、数字が大きいか小さいかのヒント
						//数字へ置き換えて判定
						if((z = Integer.parseInt(n))<y){
							System.out.println("");
							System.out.println
							("「利根川」 ハズレだ!「" + n + "」ではない！(もっと大きい数字だ。馬鹿め！)");
							System.out.println("「モブ達」 ざわ・・ざわ・・");
							System.out.println
							("「利根川」 答えられるのはあと " + (2-j) + "回 だ！");
							System.out.println("「モブ達」 ざわ・・");
							System.out.println("「利根川」 どれだと思う？：");
							System.out.print
							("「カイジ」 (はずしちまったぁぁ～～。どれなんだ？ クソっ！！)：");
						} else {
							System.out.println("");
							System.out.println
							("「利根川」 ハズレだ!「" + n + "」ではない！(もっと小さい数字だ。馬鹿め！)");
							System.out.println("「モブ達」 ざわ・・ざわ・・");
							System.out.println
							("「利根川」 答えられるのはあと " + (2-j) + "回 だ！");
							System.out.println("「モブ達」 ざわ・・");
							System.out.println("「利根川」 どれだと思う？：");
							System.out.print
							("「カイジ」 (はずしちまったぁぁ～～。どれなんだ？ クソっ！！)：");
						}
					}

				}

			}

		}


	}

}

//<仕様変更>
//(済み) １．数字が大きいか小さいかヒントを出すようにする
//(済み) ２．回答できる回数を制限する
