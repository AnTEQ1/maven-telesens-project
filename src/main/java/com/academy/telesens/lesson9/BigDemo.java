package com.academy.telesens.lesson9;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class BigDemo {
    public static void main(String[] args) {
        BigInteger number1 = new BigInteger("468846468460464624646131318787676313133546413544");
        BigInteger result = number1.add(new BigInteger("1"));
        BigInteger result2 = number1.multiply(number1);
        System.out.println(number1);
        System.out.println(result);
        System.out.println(result2);

        BigDecimal b1 = new BigDecimal("1");
        BigDecimal b2 = new BigDecimal("3");
        System.out.println(b1.add(b2));
        System.out.println(b1.divide(b2,5, RoundingMode.CEILING));

        BigDecimal b3 = new BigDecimal("2");
        BigDecimal b4 = new BigDecimal("2.0");
        System.out.println(b3.equals(b4));
        System.out.println(b3.compareTo(b4)); // возвращает 0 - если равны
        System.out.println(b1.compareTo(b4)); // -1 если меньше
        System.out.println(b4.compareTo(b1)); // 1 если больше
    }
}
