package src.models;

import java.io.IOException;

public class FuncUtils {

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
}
