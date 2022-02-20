package com.company;

public class Main {
    public static void main(String[] args) {
        String input = "camelCasing[]Test";
        int afterC = input.indexOf('C');
        int beforeC = input.indexOf('c');
        int k = input.indexOf(']');
        String finale = input.substring(afterC, afterC + 7);
        String ff = input.substring(beforeC, afterC);
        String fff = input.substring(k);
        System.out.print(ff + " " + finale + " " + fff);
    }
}

