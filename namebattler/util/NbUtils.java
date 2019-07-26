package com.wixsite.mkmercury0.superior.namebattler.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Random;

/**
 * ネームバトラー用ユーティリティクラス
 */
public class NbUtils {

    /**
     * ハッシュダイジェストから数値を取り出す
     * @param name 名前
     * @param index 何番目の数値を取り出すか
     * @return 数値(0~255)
     */
    public static Integer GetNumber(String name, Integer index) {
        try {
            byte[] result
                = MessageDigest.getInstance("SHA-1").digest(name.getBytes());
            String digest = String.format("%040x", new BigInteger(1, result));
            String hex = digest.substring(index * 2, index * 2 + 2);
            return Integer.parseInt(hex, 16);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /** 乱数を生成
     * 例) maxNum で 4 を指定すると 0 ～ 3 の int が返却される */
    public static int getRandomNums(int maxNums) {
        Random random = new SecureRandom();
        random.setSeed(getLocalDateTimeMillis());
        return random.nextInt(maxNums);
    }

    public static int getRandomNums(int minNums, int maxNums) {

        int rangeWidth = maxNums - minNums;
        Random random = new SecureRandom();
        random.setSeed(getLocalDateTimeMillis());

        int result = random.nextInt(rangeWidth);
        return result + minNums;
    }

    public static int getRandomNumsWithoutZero(int maxNums) {
        Random random = new SecureRandom();
        random.setSeed(getLocalDateTimeMillis());
        int result = random.nextInt(maxNums);
        return result != 0 ? result : 1;
    }

    /** 日時をミリ秒で取得 */
    public static long getLocalDateTimeMillis() {
        LocalDateTime ldt = LocalDateTime.now();
        ZonedDateTime zdt = ldt
            .atZone(ZoneId.of("Asia/Tokyo"));
        return zdt.toInstant().toEpochMilli();
    }

    public static int getDigit(int argNum, int argDig) {

        //対象数値の桁数を求める
        int len = String.valueOf(argNum).length();

        //べき乗で、対象の数値と同じ桁の10の倍数を求める
        int d = (int) Math.pow(10, len - 1);

        int intCrntDig = 0;

        for (int i = 1; i <= len; i++) {
            intCrntDig = argNum / d;

            //指定桁になったらforを抜ける
            if (len - i + 1 == argDig) {
                break;
            }

            argNum %= d; //<例>3255/1000=3あまり255で、一番上の桁を落とせる
            d /= 10; //次の桁チェックのため一桁落とす
        }
        return intCrntDig;
    }

    /**
     * 全角文字は２桁、半角文字は１桁として文字数をカウントする
     * @param str 対象文字列
     * @return 文字数
     */
    public static int getHan1Zen2(String str) {

        //戻り値
        int ret = 0;

        //全角半角判定
        char[] c = str.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (String.valueOf(c[i]).getBytes().length <= 1) {
                ret += 1; //半角文字なら＋１
            } else {
                ret += 2; //全角文字なら＋２
            }
        }

        return ret;
    }
}
