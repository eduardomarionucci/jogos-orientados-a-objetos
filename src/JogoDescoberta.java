import java.util.Random;
import java.util.Scanner;


public class JogoDescoberta {
    public Scanner scanner = new Scanner(System.in);
    public Ansi ansi = new Ansi();

    public JogoDescoberta() {
        iniciarJogo();
    }

    public void iniciarJogo() {
        Palavra palavra = new Palavra();
        String embaralhada = palavra.embaralharPalavra(palavra.palavraEscolhida);

        System.out.println("Palavra embaralhada: " + Ansi.ANSI_CODES[(new Random().nextInt(Ansi.ANSI_CODES.length))] +  embaralhada + Ansi.ANSI_RESET);
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


}
