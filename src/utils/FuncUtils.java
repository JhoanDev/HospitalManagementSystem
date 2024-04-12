package src.utils;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class FuncUtils {
    public static Scanner input = new Scanner(System.in);

    public static void fechaScanner() {
        input.close();
    }

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
                System.out.print("Digite um número inteiro: ");
                String inputStr = input.nextLine().trim();
                return Integer.parseInt(inputStr);
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite um número inteiro válido.");
            }
        }
    }

    public static String readOnlyLettersAndSpaces() {
        while (true) {
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
            System.out.print("Digite um CPF (apenas números): ");
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

    public static String readPhoneNumber() {
        while (true) {
            System.out.print("Digite um número de telefone (apenas números): ");
            String phoneNumber = input.nextLine().trim();

            // Remover caracteres que não sejam números do telefone
            phoneNumber = phoneNumber.replaceAll("[^0-9]", "");

            // Verificar se o número de telefone tem pelo menos 10 dígitos (formato brasileiro)
            if (phoneNumber.length() < 10) {
                System.out.println("Número de telefone inválido. Por favor, digite pelo menos 10 números.");
                continue;
            }

            // Verificar se o número de telefone contém apenas dígitos
            if (phoneNumber.matches("[0-9]+")) {
                return phoneNumber;
            } else {
                System.out.println("Número de telefone inválido. Por favor, digite apenas números.");
            }
        }
    }

    public static Date readDate() {
        while (true) {
            System.out.print("Digite uma data no formato YYYY-MM-DD: ");
            String dateInput = input.nextLine().trim();

            // Verifica se a entrada tem o formato correto
            if (dateInput.matches("\\d{4}-\\d{2}-\\d{2}")) {
                // Convertendo a string para java.sql.Date
                Date sqlDate = Date.valueOf(dateInput);
                return sqlDate;
            } else {
                System.out.println("Formato de data inválido. Por favor, digite no formato YYYY-MM-DD.");
            }
        }
    }

    public static boolean readSex(){
        while (true) {
            System.out.print("Digite o sexo (M/F): ");
            String sexo = input.nextLine().trim().toUpperCase();

            if (sexo.equals("M")) 
                return true;
            else if (sexo.equals("F")) {
                return false;
            } else {
                System.out.println("Sexo inválido. Por favor, digite M para masculino ou F para feminino.");
            }
        }
    }

    public static boolean readHospitalized(){
        while (true) {
            System.out.print("O paciente está internado? (S/N): ");
            String internado = input.nextLine().trim().toUpperCase();

            if (internado.equals("S")) 
                return true;
            else if (internado.equals("N")) {
                return false;
            } else {
                System.out.println("Resposta inválida. Por favor, digite S para sim ou N para não.");
            }
        }
    }   

    public static boolean readHealthPlan(){
        while (true) {
            System.out.print("O paciente possui plano de saúde? (S/N): ");
            String planoDeSaude = input.nextLine().trim().toUpperCase();

            if (planoDeSaude.equals("S")) 
                return true;
            else if (planoDeSaude.equals("N")) {
                return false;
            } else {
                System.out.println("Resposta inválida. Por favor, digite S para sim ou N para não.");
            }
        }
    }

    public static String readCod(){
        while (true) {
            String cod = input.nextLine().trim();

            if (cod.matches("[0-9]+")) {
                return cod;
            } else {
                System.out.println("Código inválido. Por favor, digite apenas números.");
            }
        }
    }

    public static String spacesGenerator(int n){
        return " ".repeat(n);
    }
}