package com.academy.telesens.lesson11.ht.task3;

import io.cucumber.java.it.Ma;
import org.openqa.selenium.InvalidArgumentException;

public enum Gender {
        MALE ("m"),
        FEMALE ("f");

        private String ru;

        Gender (String ru) {
                this.ru = ru;
        }

        public String getRu() {
                return ru;
        }

        public static Gender parseGender (String g) {
           if (g.equals("m")) {
                   return MALE;
           }
           if (g.equals("f")) {
                   return FEMALE;
           }
           throw new InvalidArgumentException("Unknown gender value " + g);
        }

        public String toValue () {
            if (this == MALE) {
                return "m";
            }
            if (this == FEMALE) {
                return "f";
            }
            return  null;
        }
}
