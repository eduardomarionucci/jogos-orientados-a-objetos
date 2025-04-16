import java.util.Random;
import java.util.Scanner;

public class JogoCacaPalavras {
    private final String[] palavras = {"JAVA", "MOTEL", "CARTAO"};
    private final int tamanho = 10;
    private final char[][] tabuleiro = new char[tamanho][tamanho];
    private final Scanner scanner = new Scanner(System.in);

    public void iniciarJogo() {
        String palavra = palavras[new Random().nextInt(palavras.length)];
        preencherTabuleiro();
        colocarPalavra(palavra);
        imprimirTabuleiro();

        String tentativa;
        do {
            System.out.print("Digite a palavra encontrada: ");
            tentativa = scanner.nextLine().toUpperCase();

            if (!tentativa.equals(palavra)) {
                System.out.println("Dica: começa com '" + palavra.charAt(0) + "' e termina com '" + palavra.charAt(palavra.length() - 1) + "'");
            }
        } while (!tentativa.equals(palavra));

        System.out.println("ACERTOU!");
    }

    private void preencherTabuleiro() {
        Random random = new Random();
        for (int i = 0; i < tamanho; i++)
            for (int j = 0; j < tamanho; j++)
                tabuleiro[i][j] = (char) ('A' + random.nextInt(26));
    }

    private void colocarPalavra(String palavra) {
        int linha = new Random().nextInt(tamanho);
        int coluna = new Random().nextInt(tamanho - palavra.length());
        for (int i = 0; i < palavra.length(); i++) {
            tabuleiro[linha][coluna + i] = palavra.charAt(i);
        }
    }

    private void imprimirTabuleiro() {
        for (char[] linha : tabuleiro) {
            for (char c : linha)
                System.out.print(c + " ");
            System.out.println();
        }
    }
}