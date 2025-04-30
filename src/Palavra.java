import java.util.Random;

public class Palavra {
    public final String[] palavras = {"BRASIL", "RUSSIA", "INGLATERRA", "ISRAEL", "MEXICO","JAVA", "VENEZUELA", "SURINAME"};
    public String palavraEscolhida = palavras[(new Random().nextInt(palavras.length))];

    public Palavra() {
        // Construtor padrão
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
}
