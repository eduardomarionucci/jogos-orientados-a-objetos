import java.util.Random;
import java.util.Scanner;

public class JogoDescoberta {
    public String[] palavras = {"BRASIL", "RUSSIA", "INGLATERRA", "ISRAEL", "MEXICO"};
    public Scanner scanner = new Scanner(System.in);

    public JogoDescoberta() {
        iniciarJogo();
    }

    public void iniciarJogo() {
        Palavra palavra = new Palavra();
        String embaralhada = embaralhar(palavra.palavraEscolhida);

        System.out.println("Palavra embaralhada: " + embaralhada);
        System.out.println("Tente adivinhar a palavra ou digite 'dica' para obter uma dica ou 'sair' para desistir.");

        String tentativa;

        while (true) {
            System.out.print("DIGITE SEU PALPITE: ");
            tentativa = scanner.nextLine().trim().toUpperCase();

            if (tentativa.equals("DICA")) {
                System.out.println("PRIMEIRA LETRA: '" + palavra.palavraEscolhida.charAt(0) + "', ULTIMA LETRA: '" + palavra.palavraEscolhida.charAt(palavra.palavraEscolhida.length() - 1) + "'");
            } else if (tentativa.equals("SAIR")) {
                System.out.println("A palavra era: " + palavra.palavraEscolhida);
                break;
            } else if (tentativa.equals(palavra.palavraEscolhida)) {
                System.out.println("Parabéns!");
                break;
            } else {
                System.out.println("Errado! Tente novamente ou digite 'dica' ou 'sair'.");
            }
        }
    }

    private String embaralhar(String palavra) {
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
