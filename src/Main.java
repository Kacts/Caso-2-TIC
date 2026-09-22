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
        // TODO 1: validar que args.length == NUM_ARGS. Si no, imprimir un
        //         mensaje de uso y terminar.
        //
        // TODO 2: convertir los argumentos numericos con Integer.parseInt
        //         y guardar el ultimo como String (nombre del archivo).
        //         Orden: filas, columnas, nv, tp, numPasadas, archivoSalida
        //
        // TODO 3: imprimir los seis valores para verificar el paso 1.
        // ---------------------------------------------------------------


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
