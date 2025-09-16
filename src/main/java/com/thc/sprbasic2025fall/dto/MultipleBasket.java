package com.thc.sprbasic2025fall.dto;

public class MultipleBasket {
    // MyltipleBasket은 a, b라는 필드를 가진 클래스
    int a;
    int b;

    public MultipleBasket() {}
    public MultipleBasket(int a, int b) { // 생성자
        this.a = a;
        this.b = b;
    }

    public int getA() { // getter
        return a;
    }

    public void setA(int a) { // setter
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}
