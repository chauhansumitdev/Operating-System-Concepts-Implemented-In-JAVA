package com.example;

public class SuperKey extends Empty {
    public static void main(String[] args) {
        new SuperKey();
    }
}

class Empty {
    Empty() {
        System.out.println("this is something");
    }
}
