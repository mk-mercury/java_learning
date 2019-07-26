package com.wixsite.mkmercury0.superior.namebattler.magic;

import java.util.HashMap;
import java.util.Map;

/**
 * 僧侶(Priest)の魔法を表す enumuration
 */
public enum PriestMagic implements Magic {

        HEAL(0, "ヒール",
            20), // 消費MP
        PARIZE(1, "パライズ",
            10), // 消費MP
        POISON(2, "ポイズン",
            10), // 消費MP
            ;

    /* ====================
     * PriestMagic: フィールド
     * ==================== */

    private static Map<Integer, PriestMagic> sMap = new HashMap<>();

    private int mId; // インデックス
    private String mJaLang; // 日本語説明

    private int mSpendMp; // 消費MP

    static {
        for (PriestMagic magic : PriestMagic.values()) {
            sMap.put(magic.getId(), magic);
        }
    }

    public static PriestMagic of(int id) {
        return (PriestMagic) sMap.get(id);
    }

    /* ====================
     * PriestMagic: コンストラクタ
     * ==================== */

    PriestMagic(int id, String jaLang, int spendMp) {
        mId = id;
        mJaLang = jaLang;
        mSpendMp = spendMp;
    }

    /* ====================
     * PriestMagic: getter
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
