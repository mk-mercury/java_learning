package novice;

public class FsNovice0101 {

	public static void main(String[] args) {

		// 合計金額
		int totalPrice = 12000;
		// 男性の数
		int numberOfMale = 3;
		// 女性の数
		int numberOfFemale = 3;

		// 割り勘の金額
		// 合計金額 / (男性の数 + 女性の数)
		int price = totalPrice / (numberOfMale + numberOfFemale);

		System.out.println("男性：" + price);
		System.out.println("女性：" + price);

	}
}
