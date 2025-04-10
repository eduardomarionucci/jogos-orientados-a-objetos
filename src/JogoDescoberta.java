import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class JogoDescoberta {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        /* O objetivo do jogo é desafiar o usuário a decifrar palavras embaralhadas. */
        String[] vetorPalavras = {"RUSSIA", "INGLATERRA", "BRASIL"};
        int indiceSelecionado = random.nextInt(vetorPalavras.length);


        String palavraEmbaralhada = embaralharPalavra(vetorPalavras[indiceSelecionado]);
        System.out.println(palavraEmbaralhada);

        System.out.print("DIGITE O SEU PALPITE: ");
        String input = scanner.nextLine().toUpperCase();

        if (input.equals(vetorPalavras[indiceSelecionado])) {
            System.out.println("Palavra descoberta!");
        }

        /*
        O sistema seleciona aleatoriamente uma palavra, embaralha suas letras e
            permite que o usuário tente adivinhar a versão correta.
        */
    }

    private static String embaralharPalavra(String palavra) {
        char[] caracteresPalavra = palavra.toCharArray();
        for (int i = 0; i < caracteresPalavra.length; i++) {
            int random = (new Random()).nextInt(caracteresPalavra.length);
            char temp = caracteresPalavra[random];
            caracteresPalavra[random] = caracteresPalavra[i];
            caracteresPalavra[i] = temp;
        }
        return new String(caracteresPalavra);
    }
}
