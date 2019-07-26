package com.wixsite.mkmercury0.superior.namebattler.util;

public class ConsoleHandler {

    /* ====================
     * ConsoleHandler: フィールド
     * ==================== */

    private ConsoleHandler own; // 自身を表すフィールド

    public ConsoleConfigHelper config; // 設定用ヘルパークラス

    private Pad mPad; // 余白値
    private SlowPrintTime mSlowPrintTime; // 文字出力速度
    private String mFormatTemplate; // 出力テンプレート
    private int mFixedTextLength; // テキスト固定長

    /* ====================
     * ConsoleHandler: コンストラクタ
     * ==================== */

    public ConsoleHandler() {
        this.config = new ConsoleConfigHelper(this);
        mPad = Pad.NONE;
        mSlowPrintTime = SlowPrintTime.NO_SLOW;
        mFormatTemplate = "%s";
        mFixedTextLength = 0;
    }

    public ConsoleHandler(Pad pad, SlowPrintTime time, String template,
        int length) {
        this.config = new ConsoleConfigHelper(this);
        mPad = pad;
        mSlowPrintTime = time;
        mFormatTemplate = template;
        mFixedTextLength = length;
    }

    /* ====================
     * ConsoleHandler: ビューロジック
     * ==================== */

    public void out(String string) {
        printPadds();

        StringBuilder message = new StringBuilder();
        message.append(string);
        int length = NbUtils.getHan1Zen2(string);
        for (int i = 0; i < 80 - length; i++) {
            message.append(" ");
        }

        String out = String.format(mFormatTemplate, message.toString());

        typeWriterWithTime(out);

        System.out.print("\n");
    }

    public void outWithoutLf(String string) {
        printPadds();

        StringBuilder message = new StringBuilder();
        message.append(string);

        String out = String.format(mFormatTemplate, message.toString());

        typeWriterWithTime(out);
    }

    private void printPadds() {
        for (int i = 0; i < mPad.getSpaceSize(); i++) {
            System.out.print(" ");
        }
    }

    public void typeWriterWithTime(String string) {

        for (char c : string.toCharArray()) {
            System.out.print(c);
            if (c != ' ') {
                try {
                    Thread
                        .sleep(NbUtils.getRandomNums(mSlowPrintTime.getTime()));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 内部クラス： コンソール設定用ヘルパークラス
     */
    public class ConsoleConfigHelper {

        /* ====================
         * ConsoleConfigHelper: コンストラクタ
         * ==================== */

        public ConsoleConfigHelper(ConsoleHandler _own) {
            own = _own;
        }

        /* ====================
         * ConsoleConfigHelper: 各種コンソール設定メソッド
         * ==================== */

        public ConsoleHandler padding(Pad pad) {
            return new ConsoleHandler(pad, own.mSlowPrintTime,
                own.mFormatTemplate, own.mFixedTextLength);
        }

        public ConsoleHandler slowPrintTime(SlowPrintTime time) {
            return new ConsoleHandler(own.mPad, time, own.mFormatTemplate,
                own.mFixedTextLength);
        }

        public ConsoleHandler formatTemplate(String template) {
            return new ConsoleHandler(own.mPad, own.mSlowPrintTime, template,
                own.mFixedTextLength);
        }

        public ConsoleHandler fixedTextLength(int length) {
            return new ConsoleHandler(own.mPad, own.mSlowPrintTime,
                own.mFormatTemplate, length);
        }

    }

    /**
     * 内部 Enumuration： 文字出力速度
     */
    public enum SlowPrintTime {

            NO_SLOW(0, "表示時差なし", 1),
            FAST(1, "表示速い", 40),
            LITTLE_SLOW(2, "表示少し遅い", 100),
            MIDDLE_SLOW(3, "表示中速", 300),
            MORE_SLOW(4, "表示かなり遅い", 400),;

        /* ====================
         * SlowPrintTime: フィールド
         * ==================== */

        private int mId; // インデックス
        private String mJaLang; // 日本語説明
        private int mTime; // 出力待ち時間

        /* ====================
         * SlowPrintTime: コンストラクタ
         * ==================== */

        SlowPrintTime(int id, String jaLang, int time) {
            mId = id;
            mJaLang = jaLang;
            mTime = time;
        }

        /* ====================
         * SlowPrintTime: getter
         * ==================== */

        public int getId() {
            return mId;
        }

        public String getJaLang() {
            return mJaLang;
        }

        public int getTime() {
            return mTime;
        }
    }

    /**
     * 内部 Enumuration： 余白値
     */
    public enum Pad {

            NONE(0, "余白なし", 0),
            LITTE(1, "余白少し", 2),
            MIDDLE(2, "余白中程度", 4),
            MORE(3, "余白多め", 6),;

        /* ====================
         * Pad: フィールド
         * ==================== */

        private int mId; // インデックス
        private String mJaLang; // 日本語説明
        private int mSpaceSize; // 余白値

        /* ====================
         * Pad: フィールド
         * ==================== */

        Pad(int id, String jaLang, int spaceSize) {
            mId = id;
            mJaLang = jaLang;
            mSpaceSize = spaceSize;
        }

        /* ====================
         * Pad: フィールド
         * ==================== */

        public int getId() {
            return mId;
        }

        public String getJaLang() {
            return mJaLang;
        }

        public int getSpaceSize() {
            return mSpaceSize;
        }
    }
}
