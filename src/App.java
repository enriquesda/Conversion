/**
 * @author Alberto Vera y Enrique Ambrona
 */

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
                    if(numero<0 || numero>3){
                        System.out.print("¡Entrada inválida! Por favor, ingresa un número válido positivo: ");
                    }else{
                        entradaValida = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.print("¡Entrada inválida! Por favor, ingresa un número válido positivo: ");
                }
            }

            switch (numero) {
                case 1 ->
                    seleccionarDIR();
                case 2 ->
                    leerArchivo();
                case 3 ->
                    convertirEn();
                default ->
                    funcionando = false;
            }
        } while (funcionando);
        sc.close();

    }

    public static void seleccionarDIR() throws InterruptedException {
        System.out.print("Introduce la ruta en la que quieres buscar: ");
        if (menu.selecRuta(sc.nextLine().trim())) {
            System.out.println("Ruta seleccionada con exito");
        } else {
            System.out.println("La ruta seleccionada no existe o es erronea");
        }
        Thread.sleep(2000);
        limpiarPantalla();
    }

    public static void leerArchivo() throws InterruptedException {
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

    public static void convertirEn() throws IOException, InterruptedException {
        if(menu.getSelec()==null){
            System.out.println("Selecciona primero un archivo");
            Thread.sleep(2000);
            limpiarPantalla();
        }else{
            limpiarPantalla();
        if (menu.getSelec().getFormato() == 3 ) {
            System.out.println("Este fichero no se puede transformar");
            Thread.sleep(2000);
            limpiarPantalla();
        } else {
            boolean funcionando = true;
            do {
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
                impresion.append(BLUE).append(formatoLinea(BOLD + "MENÚ DE CONVERSIÓN" + RESET, ancho)).append("\n");
                impresion.append(separator).append("\n");
                impresion.append(BLUE).append(formatoLinea(RED + "Selecciona un formato de conversión" + RESET, ancho)).append("\n");
                impresion.append(BLUE).append(formatoLinea("1: " + CYAN + "Convertir a JSON" + RESET, ancho)).append("\n");
                impresion.append(BLUE).append(formatoLinea("2: " + CYAN + "Convertir a XML" + RESET, ancho)).append("\n");
                impresion.append(BLUE).append(formatoLinea("3: " + CYAN + "Convertir a CSV" + RESET, ancho)).append("\n");
                impresion.append(BLUE).append(formatoLinea("0: " + RED + "SALIR" + RESET, ancho)).append("\n");
                impresion.append(bottomBorder).append("\n");
    
                System.out.println(impresion.toString());
    
                int numero = 0;
                boolean entradaValida = false;
                System.out.print("Selecciona una opcion: ");
                while (!entradaValida) {
                    try {
                        numero = Integer.parseInt(sc.nextLine());
                        if(numero<0 || numero>3){
                            System.out.print("¡Entrada inválida! Por favor, ingresa un número válido positivo: ");
                        }else{
                            entradaValida = true;
                        }
                    } catch (NumberFormatException e) {
                        System.out.print("¡Entrada inválida! Por favor, ingresa un número válido positivo: ");
                    }
                }
                
                String nombre;
                switch (numero) {
                    case 1:
                        System.out.println("Introduce un nombre para el nuevo archivo JSON: ");
                        nombre = sc.nextLine().trim();
                        if (menu.getSelec().getFormato() == 1) {
                            System.out.println("El archivo ya es un JSON.");
                        } else {
                            System.out.println("Convirtiendo a JSON...");
                            menu.conversion(1, nombre);
                            System.out.println("Archivo convertido a JSON con éxito.");
                        }
                        break;
                    case 2:
                        System.out.println("Introduce un nombre para el nuevo archivo XML: ");
                        nombre = sc.nextLine().trim();
                        if (menu.getSelec().getFormato() == 2) {
                            System.out.println("El archivo ya es un XML.");
                        } else {
                            System.out.println("Convirtiendo a XML...");
                            menu.conversion(2, nombre);
                            System.out.println("Archivo convertido a XML con éxito.");
                        }
                        break;
                    case 3:
                        System.out.println("Introduce un nombre para el nuevo archivo CSV: ");
                        nombre = sc.nextLine().trim();
                        if (menu.getSelec().getFormato() == 0) {
                            System.out.println("El archivo ya es un CSV.");
                        } else {
                            System.out.println("Convirtiendo a CSV...");
                            menu.conversion(0, nombre);
                            System.out.println("Archivo convertido a CSV con éxito.");
                        }
                        break;
                    default:
                        funcionando = false;
                        System.out.println("Saliendo del menú de conversión...");
                }
                Thread.sleep(2000);
                limpiarPantalla();
            } while (funcionando);
        }
        }
        
    }
    
}
