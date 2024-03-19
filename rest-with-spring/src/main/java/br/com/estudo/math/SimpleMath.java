package br.com.estudo.math;

public class SimpleMath {

    public static Double sum(Double numberOne, Double numberTwo) {
        return numberOne + numberTwo;
    }

    public static Double sub(Double numberOne, Double numberTwo) {
        return numberOne - numberTwo;
    }

    public static Double mult(Double numberOne, Double numberTwo) {
        return numberOne * numberTwo;
    }

    public static Double divi(Double numberOne, Double numberTwo) {
        return numberOne / numberTwo;
    }

    public static Double avarage(Double numberOne, Double numberTwo) {
        return (numberOne + numberTwo) / 2;
    }

    public static Double sqrt(Double numberOne, Double numberTwo) {
        Double soma = numberOne + numberTwo;
        return Math.sqrt(soma);
    }
}