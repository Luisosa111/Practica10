import java.io.*;
import java.util.*;

public class MisionPosibleMain {
    public static void main(String[] args) {
        Escenario escenario = new Escenario("Nostromo", 10);

        //R01
        try (Scanner fileScanner = new Scanner(new File("configuracion.txt"))) {
            while (fileScanner.hasNextLine()) {
                String[] parts = fileScanner.nextLine().split(" ");
                String tipo = parts[0];
                int r = Integer.parseInt(parts[1]);
                int c = Integer.parseInt(parts[2]);
                Posicion pos = new Posicion(r, c);

                switch (tipo) {
                    case "Roca":
                        escenario.addElemento(new Roca(escenario, pos));
                        break;
                    case "Extraterrestre":
                        escenario.addElemento(new Extraterrestre("Alien", escenario, pos));
                        break;
                    case "Terricola":
                        String nombre = parts[3];
                        escenario.addElemento(new Terricola(nombre, escenario, pos));
                        break;
                    case "Bomba":
                        int radio = Integer.parseInt(parts[3]);
                        escenario.addElemento(new Bomba(escenario, pos, radio));
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error al leer archivo: " + e.getMessage());
        }

        // R02
        System.out.println("\n--- Escenario actual ---");
        System.out.println(escenario);

        // R03
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese la posición de la bomba a detonar renglo y columna: ");
        int r = sc.nextInt();
        int c = sc.nextInt();

        boolean encontrada = false;
        for (Elemento e : escenario.getElementos()) {
            if (e instanceof Bomba) {
                Posicion p = e.getPosicion();
                if (p.getRenglon() == r && p.getColumna() == c) {
                    ((Bomba) e).explotar();
                    encontrada = true;
                    break;
                }
            }
        }

        if (!encontrada) {
            System.out.println("No se encontró bomba en esa posición.");
        }

        // R4
        System.out.println("\n--- Escenario actualizado ---");
        System.out.println(escenario);

        // R5
        try (PrintWriter pw = new PrintWriter("config.txt")) {
            for (Elemento e : escenario.getElementos()) {
                int ren = e.getPosicion().getRenglon();
                int col = e.getPosicion().getColumna();
                if (e instanceof Roca)
                    pw.printf("Roca %d %d\n", ren, col);
                else if (e instanceof Extraterrestre)
                    pw.printf("Extraterrestre %d %d\n", ren, col);
                else if (e instanceof Terricola)
                    pw.printf("Terricola %d %d %s\n", ren, col, ((Terricola) e).getNombre());
                else if (e instanceof Bomba)
                    pw.printf("Bomba %d %d %d\n", ren, col, ((Bomba) e).getRadio());
            }
        } catch (IOException e) {
            System.out.println("Error al guardar archivo: " + e.getMessage());
        }
    }
}
