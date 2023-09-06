package com.example;
import java.util.List;
import java.util.Scanner;
import com.example.classes.AutomatoFinito;
import com.example.classes.ImpressaoAutomato;
import com.example.classes.ValidacaoDados;
import com.example.classes.TestePalavra;
import com.example.classes.LeituraArquivoTxt;

public class Main {
    public static void main(String[] args) {
        List<String[]> vetores = LeituraArquivoTxt.lerArquivo("arquivo.txt");
        
        if (ValidacaoDados.validarVetores(vetores)) {
            char[] alfabeto = LeituraArquivoTxt.obterAlfabeto(vetores);
            
            System.out.println("Alfabeto: ");
            for (char c : alfabeto) {
                System.out.print(c + " ");
            }
            
            System.out.println();
            
            String[] estadosFinais = obterEstadosFinais();
            
            ImpressaoAutomato.imprimirAutomato(vetores, estadosFinais);
            
            AutomatoFinito automato = new AutomatoFinito(vetores, estadosFinais);
            
            TestePalavra.testarPalavra(automato);
        } else {
            System.out.println("Os dados do arquivo estão incorretos.");
        }
    }
    
    private static String[] obterEstadosFinais() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Digite os estados finais separados por vírgula: ");
            String estadosFinaisStr = scanner.nextLine();
            
            return estadosFinaisStr.split(",");
        }
    }
}
