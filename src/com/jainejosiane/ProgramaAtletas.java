package com.jainejosiane;

import java.util.Locale;
import java.util.Scanner;

public class ProgramaAtletas {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite a quantidade de atletas: ");
        double atletas = sc.nextInt();

        int quantidade = 0;
        double pesoTotal = 0;
        double alturaMaior = 0;
        String atletaAlto = null;
        double sexoM = 0;
        double sexoF= 0;
        double alturasF = 0;

        for (int i = 1; i <= atletas; i++) {
            System.out.println("Digite os dados do atleta " + i + ": ");
            System.out.print("Nome: ");
            String nome = sc.next();

            System.out.print("Sexo: ");
            String sexo = sc.next().toLowerCase();
            if (!sexo.contains( "f") && !sexo.contains("m")) {
                System.out.println("Valor inválido! Favor digitar F ou M: ");
                sexo = sc.next();
            }
            if(sexo.contains("m")) {
                sexoM++;
            } else {
                sexoF++;
            }

            System.out.print("Altura: ");
            double altura = sc.nextDouble();
            while (altura < 0) {
                System.out.println("Valor inválido! Favor digitar um valor positivo: ");
                altura = sc.nextDouble();
            }
            if (altura>alturaMaior) {
                alturaMaior = altura;
                atletaAlto = nome;
            } if (sexo.contains("f")) {
               alturasF+=altura;
            }

            System.out.print("Peso: ");
            double peso = sc.nextDouble();

            while (peso < 0) {
                System.out.println("Valor inválido! Favor digitar um valor positivo: ");
                peso = sc.nextDouble();
            }
            pesoTotal= pesoTotal + peso;
            quantidade ++;
        }

        System.out.println();
        System.out.println("RELATÓRIO");

        double mediaPesos = pesoTotal / quantidade;
        System.out.printf("Peso médio dos atletas:  %.2f",mediaPesos);

        System.out.println();
        System.out.println("Atleta com a maior altura: " + atletaAlto);

        double porcentagemHomens = (sexoM / atletas) * 100;
        System.out.printf("Porcentagem de homens: %.2f",porcentagemHomens);

        double alturaMediaMulheres = alturasF / sexoF;
        System.out.println();
        System.out.printf("Altura média das mulheres: %.2f",alturaMediaMulheres);

    }
}