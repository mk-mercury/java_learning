package com.wixsite.mkmercury0.superior.namebattler.character;

/**
 * プレーヤーの職業を表す enumuration
 */
public enum Job {

        FIGHTER(0, "戦士",
            100, 300, // HP
            0, 0, // MP
            30, 100, // STR
            30, 100, // DEF
            1, 100, // LUCK
            1, 50), // AGI
        WIZARD(1, "魔法使い",
            50, 150, // HP
            30, 80, // MP
            1, 50, // STR
            1, 50, // DEF
            1, 100, // LUCK
            20, 60), // AGI
        PRIEST(2, "僧侶",
            80, 200, // HP
            20, 50, // MP
            10, 70, // STR
            10, 70, // DEF
            1, 100, // LUCK
            20, 60), // AGI
        NINJA(3, "忍者",
            80, 180, // HP
            10, 80, // MP
            30, 160, // STR
            30, 60, // DEF
            1, 100, // LUCK
            1, 20), // AGI
            ;

    /* ====================
     * Job: フィールド
     * ==================== */

    private int mId; // インデックス
    private String mJaLang; // 日本語説明

    private int mHpMin; // HPの最小値
    private int mHpMax; // HPの最大値

    private int mMpMin; // MPの最小値
    private int mMpMax; // MPの最大値

    private int mStrMin; // STRの最小値
    private int mStrMax; // STRの最大値

    private int mDefMin; // DEFの最小値
    private int mDefMax; // DEFの最大値

    private int mLuckMin; // LUCKの最小値
    private int mLuckMax; // LUCKの最大値

    private int mAgiMin; // AGIの最小値
    private int mAgiMax; // AGIの最大値

    /* ====================
     * Job: コンストラクタ
     * ==================== */

    Job(int id, String jaLang, int hpMin, int hpMax, int mpMin, int mpMax,
        int strMin, int strMax, int defMin, int defMax,
        int luckMin, int luckMax, int agiMin, int agiMax) {
        mId = id;
        mJaLang = jaLang;
        mHpMin = hpMin;
        mHpMax = hpMax;
        mMpMin = mpMin;
        mMpMax = mpMax;
        mStrMin = strMin;
        mStrMax = strMax;
        mDefMin = defMin;
        mDefMax = defMax;
        mLuckMin = luckMin;
        mLuckMax = luckMax;
        mAgiMin = agiMin;
        mAgiMax = agiMax;
    }

    /* ====================
     * Job: public ビジネスロジック
     * ==================== */

    public static String toStringJobList() {

        StringBuilder sb = new StringBuilder();

        Job[] jobsArray = Job.values();

        for (Job job : jobsArray) {

            sb.append(job.getId());
            sb.append(":");
            sb.append(job.getJaLang());

            if (job != jobsArray[jobsArray.length - 1]) {
                sb.append("  ");
            }
        }
        return sb.toString();
    }

    /* ====================
     * Job: getter
     * ==================== */

    public int getId() {
        return mId;
    }

    public String getJaLang() {
        return mJaLang;
    }

    public int getHpMin() {
        return mHpMin;
    }

    public int getHpMax() {
        return mHpMax;
    }

    public int getMpMin() {
        return mMpMin;
    }

    public int getMpMax() {
        return mMpMax;
    }

    public int getStrMin() {
        return mStrMin;
    }

    public int getStrMax() {
        return mStrMax;
    }

    public int getDefMin() {
        return mDefMin;
    }

    public int getDefMax() {
        return mDefMax;
    }

    public int getLuckMin() {
        return mLuckMin;
    }

    public int getLuckMax() {
        return mLuckMax;
    }

    public int getAgiMin() {
        return mAgiMin;
    }

    public int getAgiMax() {
        return mAgiMax;
    }
}
