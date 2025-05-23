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
        String[] palavras = {(new Palavra()).palavraEscolhida, (new Palavra()).palavraEscolhida};


            preencherTabuleiro();
            //Passos para incluir multiplas palavras
            //Rodar o metodo colocar palavra dentro de um loop
            //Colocar as palavras na horizontal e na vertical
            //Certificar que ele não impacte as outras palavras
            //Aumentar o número de tentativas em relação ao tanto de palavras colocadas
            for (String palavra : palavras) {
                if ((new Random()).nextInt(2) == 1) {
                    colocarPalavraHorizontal(palavra);
                } else {
                    colocarPalavraVertical(palavra);
                }

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

    }

    private void preencherTabuleiro() {
        Random random = new Random();
        for (int i = 0; i < tamanho; i++)
            for (int j = 0; j < tamanho; j++)
                tabuleiro[i][j] = (char) ('A' + random.nextInt(26));
    }


    private void colocarPalavraVertical(String palavra) {
        System.out.println("Palavra: " + palavra);

        int linha = new Random().nextInt(tamanho - palavra.length());
        int coluna = new Random().nextInt(tamanho);
        for (int i = 0; i < palavra.length(); i++) {
            tabuleiro[linha + i][coluna] = palavra.charAt(i);
        }
    }


    private void colocarPalavraHorizontal(String palavra) {
        System.out.println("Palavra: " + palavra);

        int linha = new Random().nextInt(tamanho);
        int coluna = new Random().nextInt(tamanho - palavra.length());
        for (int i = 0; i < palavra.length(); i++) {
            tabuleiro[linha][coluna + i] = palavra.charAt(i);
        }
    }

    private void colocarPalavra(String[] palavras) {
        int[] guardarPosicoesOcupadas = new int[tamanho];
    }

    private void imprimirTabuleiro() {
        for (char[] linha : tabuleiro) {
            for (char c : linha)
                System.out.print(c + " ");
            System.out.println();
        }
    }
}