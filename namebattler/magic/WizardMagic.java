package com.wixsite.mkmercury0.superior.namebattler.magic;

import java.util.HashMap;
import java.util.Map;

/**
 * 魔法使い(Wizard)の魔法を表す
 */
public enum WizardMagic implements Magic {

        FIRE(0, "ファイア",
            10), // 消費MP
        THUNDER(1, "サンダー",
            20), // 消費MP
            ;

    /* ====================
     * WizardMagic: フィールド
     * ==================== */

    private static Map<Integer, WizardMagic> sMap = new HashMap<>();

    private int mId; // インデックス
    private String mJaLang; // 日本語説明

    private int mSpendMp; // 消費MP

    static {
        for (WizardMagic magic : WizardMagic.values()) {
            sMap.put(magic.getId(), magic);
        }
    }

    public static WizardMagic of(int id) {
        return (WizardMagic) sMap.get(id);
    }

    /* ====================
     * WizardMagic: コンストラクタ
     * ==================== */

    WizardMagic(int id, String jaLang, int spendMp) {
        mId = id;
        mJaLang = jaLang;
        mSpendMp = spendMp;
    }

    /* ====================
     * WizardMagic: getter
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
