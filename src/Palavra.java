import java.util.Random;

public class Palavra {
    public final String[] palavras = {"BRASIL", "RUSSIA", "INGLATERRA", "ISRAEL", "MEXICO", "JAVA", "VENEZUELA", "SURINAME"};
    public String palavraEscolhida;

    public Palavra() {
        this.palavraEscolhida = this.escolherPalavras();
    }


    public String embaralharPalavra(String palavra) {
        char[] letras = palavra.toCharArray();
        Random random = new Random();

        for (int i = 0; i < letras.length; i++) {
            int j = random.nextInt(letras.length);
            char temp = letras[i];
            letras[i] = letras[j];
            letras[j] = temp;
        }

        return new String(letras);
    }

    private String escolherPalavras() {
        new Random().nextInt(palavras.length);
        boolean contains = false;
        for (int i = 0; i < palavras.length; i++) {
            if (!contains) {
                this.palavraEscolhida = palavras[(new Random().nextInt(palavras.length))];
            }
        }

        return palavraEscolhida;
    }
}
