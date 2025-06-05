import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("Escolha um jogo:");
            System.out.println("1. Caça-Palavras");
            System.out.println("2. Jogo da Descoberta");
            System.out.print("Opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                new JogoCacaPalavras();
            } else if (opcao == 2) {
                new JogoDescoberta();
            } else {
                System.out.println("Opção inválida.");
            }

            System.out.print("Deseja jogar novamente? (s/n): ");
            String resposta = scanner.nextLine().trim().toLowerCase();
            continuar = resposta.equals("s");
        }

        System.out.println("Obrigado por jogar!");
    }
}