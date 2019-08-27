���O�F��� �B��
���t�F19/08/04

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class  Main { 
    public static void main(String[] args) {

		// ���͗p�N���X
		Scanner stdin = new Scanner(System.in);

		// �J�[�h�̏��̒�`
		String[] card = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10",
				"J", "Q", "K" };

		// �J�[�h���������߂̗��������p�N���X
		Random random = new Random();

		// �R�C����0�ɂȂ�܂ŌJ��Ԃ�
		for (int myCoin = 100; myCoin >= 0;) {

			// �����̏��ێ��ϐ�
			int myScore = 0;
			ArrayList<String> myCard = new ArrayList<String>();

			// �f�B�[���[�̏��ێ��ϐ�
			int yourScore = 0;
			ArrayList<String> yourCard = new ArrayList<String>();

			// ���݂̃R�C������
			System.out.println("���݂̃R�C���F" + myCoin + "��");
			System.out.println();

			// �Q�[���J�n�p�R�C���̎x����
			myCoin -= 10;
			System.out.println("10�R�C�����x����ꂽ���߁A�Q�[�����J�n���܂��B");
			System.out.println("���݂̃R�C���F" + myCoin + "��");
			System.out.println();

			// ������D(2���Â�)��z��
			for (int i = 0; i < 2; i++) {

				// �z��J�[�h�ԍ�(index)
				int no;

				// �����̃J�[�hi����
				// ���������@0�`12
				no = random.nextInt(13);
				System.out.println("���Ȃ��Ɂu" + card[no] + "�v���z���܂����B");
				// �����̎�D���X�g�ɒǉ�
				myCard.add(card[no]);

				// �f�B�[���[�̃J�[�hi����
				no = random.nextInt(13);
				System.out.println("�f�B�[���[�Ɂu" + card[no] + "�v���z���܂����B");
				yourCard.add(card[no]);
			}
			System.out.println();

			// �X�R�A�̌v�Z
			myScore = GetScore(myCard);
			yourScore = GetScore(yourCard);

			// ������D�̃X�R�A�̕\��
			if (myScore == 21) {
				System.out.println("�u���b�N�W���b�N����!");
			} else if (yourScore == 21) {
				System.out.println("�u���b�N�W���b�N����!");
			} else {
				System.out.println("�f�B�[���[�̍��v��" + yourScore + "�ł��B");
				System.out.println("���݂̍��v��" + myScore + "�ł��B\n");
			}

			// �����̃J�[�h�������܂� 21�����̎�
			while (myScore < 21) {
				System.out.println("�����ꖇ�J�[�h�������܂���?(Y/N)\n");

				// ������󂯎�� (Y/N)
				// �����񂪓������ǂ����� == ���g�킸�� equals ���g��
				if (stdin.next().equals("Y")) {

					// �J�[�h������
					int no = random.nextInt(13);
					System.out.println("���Ȃ��Ɂu" + card[no] + "�v���z���܂����B");
					myCard.add(card[no]);

					// �X�R�A�̌v�Z
					myScore = GetScore(myCard);
					System.out.println("���݂̍��v��" + myScore + "�ł��B \n");

				} else {
					// N������
					break;
				}
			}

			// �f�B�[���[���J�[�h������ (17�ȉ��̏ꍇ)
			while (yourScore <= 17) {

				// �J�[�h������
				int no = random.nextInt(13);
				System.out.println("�f�B�[���[�Ɂu" + card[no] + "�v���z���܂����B");
				yourCard.add(card[no]);

				// �X�R�A�̌v�Z
				yourScore = GetScore(yourCard);
				System.out.println("�f�B�[���[�̍��v��" + yourScore + "�ł��B\n");
			}

			// �������傫����������
			// �o�[�X�g����
			if (myScore > 21) {
				myScore = -1;
			}

			if (yourScore > 21) {
				yourScore = -1;
			}

			// ���s����
			// ���X�R�A���傫����������!(�o�[�X�g��-1�ɋ����I�ɏ��������Ă��邩��)
			if (myScore > yourScore) {
				System.out.println("���Ȃ��̏����ł��B");
				if (myScore == 21) {
					myCoin += 30;
					System.out.println("�R�C��30���l��!");
				} else {
					myCoin += 20;
					System.out.println("�R�C��20���l��!");
				}
			} else if (myScore == yourScore) {
				System.out.println("���������ł��B");
				System.out.println("�R�C��10���l��!");
			} else {
				System.out.println("���Ȃ��̕����ł��B");
			}

			System.out.println();

		}
		
		System.out.println("�Q�[���I��");

		// �I���������s��
		stdin.close();
	}

	// �X�R�A�̌v�Z ���X�g�ɑ΂���X�R�A��Ԃ�
	// ���@���Fcard ��D�̃J�[�h����ꂽ�z��
	// �߂�l�Fint card�̎�D�̏ꍇ�̓_��
	static int GetScore(ArrayList<String> card) {

		// �X�R�A�̕ێ��p�ϐ�
		int score = 0;
		// A�̕ێ��p�ϐ�
		int count = 0;

		// ��D�̖��������[�v
		for (String str : card) {
			// �J�[�h�̃X�R�A���v�Z����
			switch (str) {
			case "A":
				// A�̏ꍇ�́A��U�A11�Ƃ��ĉ��Z����
				score += 11;
				// 21�𒴂����ꍇ�� A �� 1 �Ƃ��Čv�Z�ł���悤�ɖ����𐔂��Ă���
				count++;
				break;
			case "J":
			case "Q":
			case "K":
				score += 10;
				break;
			default:
				// "2"�`"9"�̏ꍇ
				// parseInt() �͈����ɕ�������󂯎��A����𐔒l�ŕԂ����\�b�h
				score += Integer.parseInt(str);
			}
		}

		// A����D�ɂ���ꍇ�́AA��1�Ƃ��Čv�Z�ł���̂ł��̏ꍇ�̏���
		// �X�R�A��21���傫���ꍇ
		while (score > 21) {
			if (count > 0) {
				// 11�Ƃ��Đ����Ă���A��1�Ƃ��Đ��������̂ŁA��������(11-1=10)
				score -= 10;
				// �������Ă���uA�v1�������v�Z���������̂ŁuA�v�̐������炷
				count--;
			} else {
				// �������Ă���A��S��1�Ƃ��Đ����Ă�21�𒴂��Ă���ꍇ
				break;
			}
		}

		// �X�R�A��Ԃ�
		return score;
	}
}
