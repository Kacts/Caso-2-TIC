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

            GeneradorRef gen = new GeneradorRef(filas, columnas, nv, tp, numPasadas, archivoSalida);

            System.out.println(gen.getNP());
            System.out.println(gen.getNR());

            gen.generar();

        } else {

            String error = "el numero de argumentos no es el esperado";
            System.out.println(error);
            System.exit(1);
        }
        
  
        
    }
}
