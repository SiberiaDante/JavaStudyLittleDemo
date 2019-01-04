package com.dante.demo01;

import org.junit.Test;

import java.util.Scanner;

public class TestZJ {

    public static void main(String[] args) {
        Scanner content = new Scanner(System.in);
        String str;
        while (true) {
            str = content.next();
            str = str.replace("谁", "张军");
            str = str.replace("吗", "");
            str = str.replace("？", "!");
            System.out.print(str);
        }
    }
}
