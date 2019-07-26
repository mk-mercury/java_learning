package com.wixsite.mkmercury0.superior.namebattler.magic;

import java.util.HashMap;
import java.util.Map;

/**
 * 忍者(Ninja)の魔法を表す enumuration
 */
public enum NinjaMagic implements Magic {

        KAKUREMINO(0, "隠れ身の術",
            10), // 消費MP
        MAKIBISI(1, "まきびし",
            10), // 消費MP
            ;

    /* ====================
     * NinjaMagic: フィールド
     * ==================== */

    private static Map<Integer, NinjaMagic> sMap = new HashMap<>();

    private int mId; // インデックス
    private String mJaLang; // 日本語説明

    private int mSpendMp; // 消費MP

    static {
        for (NinjaMagic magic : NinjaMagic.values()) {
            sMap.put(magic.getId(), magic);
        }
    }

    public static NinjaMagic of(int id) {
        return (NinjaMagic) sMap.get(id);
    }

    /* ====================
     * NinjaMagic: コンストラクタ
     * ==================== */

    NinjaMagic(int id, String jaLang, int spendMp) {
        mId = id;
        mJaLang = jaLang;
        mSpendMp = spendMp;
    }

    /* ====================
     * NinjaMagic: getter
     * ==================== */

    public int getId() {
        return mId;
    }

    public String getJaLang() {
        return mJaLang;
    }

    public int getSpendMp() {
        return mSpendMp;
    }
}
