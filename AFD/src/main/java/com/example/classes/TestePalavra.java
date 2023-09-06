package com.example.classes;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TestePalavra {
    public static void testarPalavra(AutomatoFinito automato) {
        try (Scanner scanner = new Scanner(System.in)) {
            
            System.out.println("Digite a palavra a ser testada: ");
            String palavra = scanner.nextLine();
            
            boolean resultado = automato.testarPalavra(palavra, "0");
            
            if (resultado) {
                System.out.println("A palavra foi aceita!");
            } else {
                System.out.println("A palavra não foi aceita.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Digite uma palavra válida.");
            testarPalavra(automato);
        }
    }
}
