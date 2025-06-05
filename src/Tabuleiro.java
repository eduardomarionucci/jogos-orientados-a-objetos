import java.util.Random;

public class Tabuleiro {
    private int tamanho;
    private char[][] matriz;
    private Random random = new Random();

    public Tabuleiro(int tamanho) {
        this.tamanho = tamanho;
        this.matriz = new char[tamanho][tamanho];
        preencher();
    }

    public void preencher() {
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                matriz[i][j] = ' '; // vazio por enquanto
            }
        }
    }

    public void colocarPalavraVertical(String palavra) {
        System.out.println("Palavra: " + palavra);

        int linha = new Random().nextInt(tamanho - palavra.length());
        int coluna = new Random().nextInt(tamanho);
        for (int i = 0; i < palavra.length(); i++) {
            matriz[linha + i][coluna] = palavra.charAt(i);
        }
    }


    public void colocarPalavraHorizontal(String palavra) {
        System.out.println("Palavra: " + palavra);

        int linha = new Random().nextInt(tamanho);
        int coluna = new Random().nextInt(tamanho - palavra.length());
        for (int i = 0; i < palavra.length(); i++) {
            matriz[linha][coluna + i] = palavra.charAt(i);
        }
    }


    public void imprimir() {
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                char c = matriz[i][j];
                if (c == ' ') {
                    c = (char) ('A' + random.nextInt(26)); // preenche com letras aleatórias
                }
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}
