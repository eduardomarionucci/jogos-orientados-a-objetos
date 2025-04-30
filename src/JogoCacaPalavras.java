import java.util.Random;
import java.util.Scanner;

public class JogoCacaPalavras {

    public int tamanho = 10;
    public char[][] tabuleiro = new char[tamanho][tamanho];
    public Scanner scanner = new Scanner(System.in);

    public JogoCacaPalavras() {
        iniciarJogo();
    }

    public void iniciarJogo() {
        Palavra palavra = new Palavra();

        preencherTabuleiro();
        colocarPalavra(palavra.palavraEscolhida);
        imprimirTabuleiro();

        String tentativa;
        do {
            System.out.print("Digite a palavra encontrada: ");
            tentativa = scanner.nextLine().toUpperCase();

            if (!tentativa.equals(palavra.palavraEscolhida)) {
                System.out.println("Dica: começa com '" + palavra.palavraEscolhida.charAt(0) + "' e termina com '" + palavra.palavraEscolhida.charAt(palavra.palavraEscolhida.length() - 1) + "'");
            }
        } while (!tentativa.equals(palavra.palavraEscolhida));

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