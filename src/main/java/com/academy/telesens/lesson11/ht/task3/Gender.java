package com.academy.telesens.lesson11.ht.task3;

public enum Gender {
        MALE ("м"),
        FEMALE ("ж");

        private String ru;

        Gender (String ru) {
                this.ru = ru;
        }

        public String getRu() {
                return ru;
        }
}
