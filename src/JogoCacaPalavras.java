import java.util.Random;
import java.util.Scanner;

public class JogoCacaPalavras {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String palavras[] = {"CARTAO", "HOTEL", "PITEL, MOTEL"};
        int tamanho = 10;
        char tabuleiro[][] = new char[tamanho][tamanho];

        /* Selecionar uma palavra aleatória */
        String palavraSelecionada = selecionarPalavra(palavras);

        preencherTabuleiro(tabuleiro, tamanho);

        colocarPalavra(tabuleiro, tamanho, palavraSelecionada);

        imprimirTabuleiro(tabuleiro, tamanho);

        verificarPalavra(palavraSelecionada);
    }

    private static String selecionarPalavra(String vetor[]) {

        return vetor[new Random().nextInt(vetor.length)];
    }


    private static void preencherTabuleiro(char tabuleiro[][], int tamanho) {
        Random random = new Random();
        for (int x = 0; x < tamanho; x++) {
            for (int y = 0; y < tamanho; y++) {
                tabuleiro[x][y] = (char) ('a' + random.nextInt(25));
            }
        }
    }

    private static void colocarPalavra(char tabuleiro[][], int tamanho, String palavraSelecionada) {
        Random random = new Random();
        int linha = random.nextInt(tamanho);
        int coluna = random.nextInt(tamanho - palavraSelecionada.length());  // para nao dar divergencia no final da coluna

        for (int x = 0; x < palavraSelecionada.length(); x++) {
            tabuleiro[linha][coluna + x] = palavraSelecionada.charAt(x);  // CHATAT pega o char por palavra ex mauro chatat 0 = m
        }
    }

    private static void imprimirTabuleiro(char tabuleiro[][], int tamanho) {  // cria uma classe privada para melhor organizacao
        for (int x = 0; x < tamanho; x++) {
            for (int y = 0; y < tamanho; y++) {
                System.out.print(Character.toUpperCase(tabuleiro[x][y]) + " ");
            }
            System.out.println("");
        }
    }

    private static void verificarPalavra(String palavraSelecionada) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("DIGITE A PALAVRA ENCONTRADA: ");
        String opcao = scanner.nextLine();

        while (!opcao.equals(palavraSelecionada)) {
            char primeiraLetra = palavraSelecionada.charAt(0);
            char ultimaLetra = palavraSelecionada.charAt(palavraSelecionada.length() - 1);

            System.out.println("Errou! Tente novamente.");
            System.out.println("Dica: Primeira Letra: " + primeiraLetra);
            System.out.println("Dica: Última Letra: " + ultimaLetra);
            System.out.print("DIGITE A PALAVRA ENCONTRADA: ");
            opcao = scanner.nextLine();
        }
        System.out.println("ACERTOU!");
    }
}
