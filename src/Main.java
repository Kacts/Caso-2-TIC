/**
 * Punto de entrada del generador de referencias a memoria.
 *
 * Uso esperado:
 *   java -cp bin Main <filas> <columnas> <NV> <TP> <numPasadas> <archivoSalida>
 *
 * Ejemplo:
 *   java -cp bin Main 300 20 142 256 5 salida.txt
 */
public class Main {

    /** Cantidad de argumentos que espera el programa. */
    private static final int NUM_ARGS = 6;

    public static void main(String[] args) {

        // ---------------------------------------------------------------
        // PASO 1 de tu plan: leer los 6 argumentos e imprimirlos.
        //

        if (args.length == NUM_ARGS) {

            int filas = Integer.parseInt(args[0]); 
            int columnas = Integer.parseInt(args[1]);
            int nv = Integer.parseInt(args[2]);
            int tp = Integer.parseInt(args[3]);
            int numPasadas = Integer.parseInt(args[4]);
            String archivoSalida = args[5]; 
            
            System.out.println("filas="+filas 
            + " columnas="+columnas
            + " nv="+nv
            + " tp="+tp
            + " numPasadas="+ numPasadas
            + " archivoSalida="+archivoSalida);
        } else {

            String error = "el numero de argumentos no es el esperado";
            System.out.println(error);
            System.exit(1);
        }
        



        // ---------------------------------------------------------------
        // A partir del PASO 2: construir el generador y ejecutarlo.
        //
        // TODO 4: crear la instancia de GeneradorReferencias con los
        //         parametros leidos.
        //
        // TODO 5: para verificar el paso 2, imprimir getNP() y getNR()
        //         ANTES de escribir el archivo.
        //
        // TODO 6: cuando llegues al paso 8, llamar a generar().
        // ---------------------------------------------------------------
    }
}
