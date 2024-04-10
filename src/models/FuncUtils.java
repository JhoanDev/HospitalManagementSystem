package src.models;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FuncUtils {
    public static Scanner input = new Scanner(System.in);

    public static void clearScreen() {
        String os = System.getProperty("os.name").toLowerCase();
        try {
            if (os.contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else if (os.contains("nix") || os.contains("nux") || os.contains("aix")) {
                // Unix-like OS (Linux/Unix)
                System.out.print("\033[H\033[2J");
                System.out.flush();
            } else if (os.contains("mac")) {
                // Mac OS
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            } else {
                // OS not supported
                throw new RuntimeException("Sistema operacional não suportado.");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String dateToString(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        // Convertendo a data em uma string formatada
        String strDate = formatter.format(date);
        return strDate;
    }

    public static int readInt() {
        while (true) {
            try {
                System.out.println("Digite um número inteiro:");
                return input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Por favor, digite um número inteiro válido.");
                input.nextLine(); // Limpa o buffer do scanner
            }
        }
    }

    public static String readOnlyLettersAndSpaces() {
        while (true) {
            System.out.println("Digite uma string:");
            String entrada = input.nextLine().trim(); // Remover espaços em branco no início e no final

            // Verificar se a entrada é vazia
            if (entrada.isEmpty()) {
                System.out.println("Por favor, digite algo.");
                continue;
            }

            // Verificar se a entrada contém apenas letras e espaços
            if (entrada.matches("[a-zA-Z ]+")) {
                return entrada;
            } else {
                System.out.println("Por favor, digite apenas letras e espaços.");
            }
        }
    }

    public static String readCPF() {
        while (true) {
            System.out.println("Digite um CPF (apenas números):");
            String cpf = input.nextLine().trim();

            // Remover caracteres de pontuação do CPF, se houver
            cpf = cpf.replaceAll("[^0-9]", "");

            // Verificar se o CPF tem 11 dígitos
            if (cpf.length() != 11) {
                System.out.println("CPF inválido. Por favor, digite exatamente 11 números.");
                continue;
            }

            // Verificar se o CPF contém apenas dígitos
            if (cpf.matches("[0-9]+")) {
                return cpf;
            } else {
                System.out.println("CPF inválido. Por favor, digite apenas números.");
            }
        }
    }
}
