import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class JogoCacaPalavras {

    public int tamanho = 10;
    public Scanner scanner = new Scanner(System.in);
    private final Random random = new Random();

    public JogoCacaPalavras() {
        iniciarJogo();
    }

    public void iniciarJogo() {
        String[] palavras = {(new Palavra()).palavraEscolhida, (new Palavra()).palavraEscolhida};
        Tabuleiro tabuleiro = new Tabuleiro(tamanho);

        for (String palavra : palavras) {
            if (random.nextInt(2) == 1) {
                tabuleiro.colocarPalavraVertical(palavra);
            } else {
                tabuleiro.colocarPalavraHorizontal(palavra);
            }
        }

        tabuleiro.imprimir();

        String tentativa;
        boolean acertou = false;
        do {
            System.out.print("Digite a palavra encontrada: ");
            tentativa = scanner.nextLine().toUpperCase();

            if (Arrays.asList(palavras).contains(tentativa)) {
                acertou = true;
            } else {
                String dica = palavras[0];
                System.out.println("Dica: começa com '" + dica.charAt(0) + "' e termina com '" + dica.charAt(dica.length() - 1) + "'");
            }
        } while (!acertou);

        System.out.println("ACERTOU!");
    }
}