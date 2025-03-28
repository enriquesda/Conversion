
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class App {

    public static Scanner sc = new Scanner(System.in);

    public static Menu menu = new Menu();

    public static void main(String[] args) throws Exception {
        limpiarPantalla();
        boolean funcionando = true;
        mostrarIntro();
        do {
            mostrarLogoSinAnimacion();
            System.out.println(imprimirMenu());
            System.out.print("Selecciona una opcion: ");

            int numero = 0;
            boolean entradaValida = false;

            while (!entradaValida) {
                try {
                    numero = Integer.parseInt(sc.nextLine());
                    entradaValida = true;
                } catch (NumberFormatException e) {
                    System.out.print("¡Entrada inválida! Por favor, ingresa un número válido: ");
                }
            }

            switch (numero) {
                case 1 ->
                    ejercicio1();
                case 2 ->
                    ejercicio2();
                case 3 ->
                    convertirEn();
                default ->
                    funcionando = false;
            }
        } while (funcionando);
        sc.close();

        String path = "Conversion/src/archivos";
        if (menu.selecRuta(path)) {
            System.out.println("Ruta valida");
            System.out.println(menu.getRuta());
            System.out.println(menu.imprimirArchivos());
            if (menu.selecFichero("coches.xml")) {
                Archivo a = menu.getSelec();
                a.imprimirContenido();
            }

        } else {
            System.out.println("Ruta no valida");
        }

    }

    public static void ejercicio1() throws InterruptedException {
        System.out.print("Introduce la ruta en la que quieres buscar: ");
        if (menu.selecRuta(sc.nextLine().trim())) {
            System.out.println("Ruta seleccionada con exito");
        } else {
            System.out.println("La ruta seleccionada no existe o es erronea");
        }
        Thread.sleep(2000);
        limpiarPantalla();
    }

    public static void ejercicio2() throws InterruptedException {
        if (menu.getRuta().equals(" ")) {
            System.out.println("Primero selecciona una ruta.");
        } else {
            System.out.print("Introduce el nombre con su extension del fichero que deseeas seleccionar: ");
            if (menu.selecFichero(sc.nextLine().trim())) {
                System.out.println("Archivo seleccionada con exito.");
            } else {
                System.out.println("El archivo seleccionado no existe o es erroneo.");
            }
        }
        Thread.sleep(2000);
        limpiarPantalla();

    }

    public static void mostrarLogoSinAnimacion() {
        String RESET = "\u001B[0m";
        String BLUE = "\u001B[34m";
        String BOLD = "\u001B[1m";

        String[] logo = {
            "   ██████╗ ██████╗ ███╗   ██╗██╗   ██╗███████╗██████╗  ███████╗  ██████╗ ██████╗ ",
            "  ██╔════╝██╔═══██╗████╗  ██║██║   ██║██╔════╝██╔══██╗██╔═════╝ ██╔═══██╗██╔══██╗",
            "  ██║     ██║   ██║██╔██╗ ██║██║   ██║█████╗  ██████╔╝███████╗  ██║   ██║██████╔╝",
            "  ██║     ██║   ██║██║╚██╗██║██║   ██║██╔══╝  ██╔══██╗╚══════██╗██║   ██║██╔══██╗",
            "  ╚██████╗╚██████╔╝██║ ╚████║╚██████╔╝███████╗██║  ██║███████╔╝ ╚██████╔╝██║  ██║",
            "   ╚═════╝ ╚═════╝ ╚═╝  ╚═══╝ ╚═════╝ ╚══════╝╚═╝  ╚═╝╚══════╝   ╚═════╝ ╚═╝  ╚═╝"
        };

        for (String line : logo) {
            System.out.println(BOLD + BLUE + line + RESET);
        }
    }

    public static void mostrarIntro() throws InterruptedException {
        String RESET = "\u001B[0m";
        String BLUE = "\u001B[34m";
        String BOLD = "\u001B[1m";

        String[] logo = {
            "   ██████╗ ██████╗ ███╗   ██╗██╗   ██╗███████╗██████╗  ███████╗  ██████╗ ██████╗ ",
            "  ██╔════╝██╔═══██╗████╗  ██║██║   ██║██╔════╝██╔══██╗██╔═════╝ ██╔═══██╗██╔══██╗",
            "  ██║     ██║   ██║██╔██╗ ██║██║   ██║█████╗  ██████╔╝███████╗  ██║   ██║██████╔╝",
            "  ██║     ██║   ██║██║╚██╗██║██║   ██║██╔══╝  ██╔══██╗╚══════██╗██║   ██║██╔══██╗",
            "  ╚██████╗╚██████╔╝██║ ╚████║╚██████╔╝███████╗██║  ██║███████╔╝ ╚██████╔╝██║  ██║",
            "   ╚═════╝ ╚═════╝ ╚═╝  ╚═══╝ ╚═════╝ ╚══════╝╚═╝  ╚═╝╚══════╝   ╚═════╝ ╚═╝  ╚═╝"
        };

        System.out.println("\n\n");
        for (String line : logo) {
            System.out.println(BOLD + BLUE + line + RESET);
            Thread.sleep(300);
        }

        Thread.sleep(1000);
        limpiarPantalla();

        System.out.println("\n\n");
    }

    public static void limpiarPantalla() {
        System.out.print("\u001B[H\u001B[2J");
        System.out.flush();
    }

    public static String imprimirMenu() {
        StringBuilder impresion = new StringBuilder();
        int ancho = 60;

        String RESET = "\u001B[0m";
        String BOLD = "\u001B[1m";
        String BLUE = "\u001B[34m";
        String GREEN = "\u001B[32m";
        String CYAN = "\u001B[36m";
        String YELLOW = "\u001B[33m";
        String RED = "\u001B[31m";

        String border = BLUE + "╔" + "═".repeat(ancho - 2) + "╗" + RESET;
        String separator = BLUE + "╠" + "═".repeat(ancho - 2) + "╣" + RESET;
        String bottomBorder = BLUE + "╚" + "═".repeat(ancho - 2) + "╝" + RESET;

        impresion.append(border).append("\n");
        impresion.append(BLUE).append(formatoLinea(BOLD + "MENÚ PRINCIPAL" + RESET, ancho)).append("\n");
        impresion.append(separator).append("\n");

        String ruta = menu.getRuta().trim().isEmpty() ? YELLOW + "[ No seleccionada ]" + RESET : GREEN + new File(menu.getRuta()).getName() + RESET;
        impresion.append(BLUE).append(formatoLinea("Ruta: " + ruta, ancho)).append("\n");

        impresion.append(separator).append("\n");
        if (menu.getArchivos() == null || menu.getArchivos().isEmpty()) {
            impresion.append(BLUE).append(formatoLinea("Archivos: " + YELLOW + "[ No hay archivos ]" + RESET, ancho)).append("\n");
        } else {
            impresion.append(BLUE).append(formatoLinea("Archivos:", ancho)).append("\n");
            int cont = 1;
            for (File file : menu.getArchivos()) {
                impresion.append(BLUE).append(formatoLinea(cont + "º Archivo: " + CYAN + file.getName() + RESET, ancho)).append("\n");
                cont++;
            }
        }

        impresion.append(separator).append("\n");
        String archivoSeleccionado = (menu.getSelec() == null) ? YELLOW + "[ Ninguno ]" + RESET : GREEN + new File(menu.getSelec().getRuta()).getName() + RESET;
        impresion.append(BLUE).append(formatoLinea("Archivo seleccionado: " + archivoSeleccionado, ancho)).append("\n");

        impresion.append(separator).append("\n");
        impresion.append(BLUE).append(formatoLinea(RED + "Selecciona una opción del menú" + RESET, ancho)).append("\n");
        impresion.append(BLUE).append(formatoLinea("1: " + CYAN + "Seleccionar carpeta" + RESET, ancho)).append("\n");
        impresion.append(BLUE).append(formatoLinea("2: " + CYAN + "Lectura de archivos" + RESET, ancho)).append("\n");
        impresion.append(BLUE).append(formatoLinea("3: " + CYAN + "Conversión" + RESET, ancho)).append("\n");
        impresion.append(BLUE).append(formatoLinea("0: " + RED + "SALIR" + RESET, ancho)).append("\n");
        impresion.append(bottomBorder).append("\n");

        return impresion.toString();
    }

    private static String formatoLinea(String texto, int ancho) {
        int longitudVisible = texto.replaceAll("\u001B\\[[;\\d]*m", "").length();
        int espacioExtra = ancho - 4 - longitudVisible;
        return "║ " + texto + " ".repeat(Math.max(0, espacioExtra)) + " ║";
    }

    public static void convertirEn() throws IOException {
        boolean funcionando = true;
        do {

            System.out.println("A qué formato quieres convertir?");
            System.out.println("1: Convertir a JSON");
            System.out.println("2: Convertir a XML");
            System.out.println("3: Convertir a CSV");
            System.out.println("0: SALIR");

            int numero = Integer.parseInt(sc.nextLine());
            switch (numero) {
                case 1:
                    System.out.println("Convirtiendo a JSON...");
                    // Aquí deberías implementar la lógica para convertir a JSON
                    break;
                case 2:
                    System.out.println("Convirtiendo a XML...");
                    // Aquí deberías implementar la lógica para convertir a XML
                    break;
                case 3:
                    System.out.println("Convirtiendo a CSV...");
                    // Aquí deberías implementar la lógica para convertir a CSV
                    break;
                default:
                    funcionando = false;
                    System.out.println("Saliendo del menú de conversión...");
            }
        } while (funcionando);
        sc.close();
    }
}
