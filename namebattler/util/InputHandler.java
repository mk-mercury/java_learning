package com.wixsite.mkmercury0.superior.namebattler.util;

import java.util.Scanner;

/**
 * 標準入力補助クラス
 */
public class InputHandler {

    private Scanner scanner;

    public InputHandler() {
        scanner = new Scanner(System.in);
    }

    public Character getChar() {
        //return string in pos 0
        return this.scanner.next().charAt(0);
    }

    public String getString() {
        //return string
        return this.scanner.nextLine();
    }

    public void close() {
        this.scanner.close();
    }
}
