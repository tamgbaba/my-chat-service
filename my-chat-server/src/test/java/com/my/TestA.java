package com.my;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author kejie
 * @Date 2023/3/12 12:26
 * @PackageName:com.my
 * @ClassName: Test
 * @Description: TODO
 * @Version 1.0
 */
public class TestA {

    @Test
    public void test() {
        for (int i = 0; i < 999; i++) {
            if (fun(i)) {
                System.out.println(i);
            }
        }
    }

    //求三位数的水仙花数
    public boolean fun(int n) {
        int x, y, z;
        x = n % 100 / 10;
        y = n % 10;
        z = n / 100;
        return x * x * x + y * y * y + z * z * z == n;
    }

    @Test
    public void testIp() {
        String str = "qwertyuiopasdfghjklzxcvbnm1234唐仲科";

        StringBuilder strBuilder = new StringBuilder();
        char[] chars = str.toCharArray();
        int[] arr;
        for (int i = 0; i < chars.length; i++) {
            if ((int) chars[i] <= 122 && (int) chars[i] >= 97) {
                strBuilder.append(chars[i]);
            }
        }
        String intern = strBuilder.toString().intern();

        arr = new int[intern.length()];

        for (int i = 0; i < intern.length(); i++) {
            arr[i] = intern.charAt(i);
        }


        char aa[] = new char[arr.length];
        int temp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }


        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            builder.append((char) arr[i]);
        }
        System.out.println(builder.toString());
    }
}
