import java.io.IOException;
import java.io.PrintWriter;

/**
 * Genera el archivo con la lista de direcciones virtuales (dvs) que produciria
 * el algoritmo de cifrado Hill Modificado al recorrer la matriz y el vector.
 *
 * Supuestos de organizacion en memoria (dados por el enunciado):
 *  - La matriz se almacena por filas (row-major order), empezando en la
 *    direccion 0.
 *  - El vector se almacena inmediatamente despues de la matriz.
 *  - Matriz y vector son de bytes, por lo que 1 elemento = 1 direccion.
 */
public class GeneradorRef {

    // ------------------------------------------------------------------
    // Atributos: parametros de entrada del problema
    // ------------------------------------------------------------------

    private final int filas;
    private final int columnas;
    private final int nv;
    private final int tp;
    private final int numPasadas;
    private final String archivoSalida;

    /**
     * Escritor del archivo de salida. Se abre en generar() y lo usan los
     * metodos de escritura. Se deja como atributo para que
     * escribirReferencia(...) no tenga que recibirlo en cada llamada.
     */
    private PrintWriter writer;

    // ------------------------------------------------------------------
    // Constructor
    // ------------------------------------------------------------------

    public GeneradorRef(int filas, int columnas, int nv,
                                int tp, int numPasadas, String archivoSalida) {
        this.filas = filas;
        this.columnas = columnas;
        this.nv = nv;
        this.tp = tp;
        this.numPasadas = numPasadas;
        this.archivoSalida = archivoSalida;
    }

    // ------------------------------------------------------------------
    // Valores del encabezado: NP y NR
    // ------------------------------------------------------------------

    /**
     * Numero de paginas virtuales necesarias para almacenar la matriz y el
     * vector. Se redondea hacia arriba porque una pagina parcialmente usada
     * sigue siendo una pagina.
     */
    public int getNP() {

        int total_bytes = filas*columnas + nv; 

        int total_pag = (int) Math.ceil((double) total_bytes/ tp );

        return total_pag; 
    }

    /**
     * Numero total de referencias (dvs) que se escribiran en el archivo.
     *
     * Cada celda genera 3 referencias (lee m, lee v, escribe m), y en cada
     * pasada se hacen 2 recorridos completos de la matriz (filas y columnas).
     * Con 300x20 y 5 pasadas da 180000, igual al Anexo A.
     */
    public int getNR() {

        int tam_matriz = filas*columnas; 
        int ref_cel = 3*numPasadas; 

        int total_NR = (tam_matriz*ref_cel)*2; 

        return total_NR; 
    }

    // ------------------------------------------------------------------
    // Traduccion de direccion virtual -> (pagina, desplazamiento)
    // ------------------------------------------------------------------

    /**
     * Pagina virtual en la que cae una direccion lineal (division entera).
     */
    private int calcularPagina(int direccion) {

        int num_pag = direccion/tp; 
        return num_pag;
    }

    /**
     * Desplazamiento (offset) de una direccion lineal dentro de su pagina
     * (residuo de la division).
     */
    private int calcularDesplazamiento(int direccion) {

        int despla = direccion%tp;
        return despla;
    }

    /**
     * Direccion lineal de m[i][j] en row-major order: se saltan i filas
     * completas de 'columnas' bytes y luego se avanzan j posiciones.
     */
    private int direccionMatriz(int i, int j) {
        
        int posicion = i*columnas + j; 
        return posicion;
    }

    /**
     * Direccion lineal de v[k]. El vector arranca justo despues del ultimo
     * byte de la matriz, es decir en la posicion filas * columnas.
     */
    private int direccionVector(int k) {

        int tamMatriz = filas * columnas; 
        return k + tamMatriz; 
    }

    // ------------------------------------------------------------------
    // Encabezado del archivo
    // ------------------------------------------------------------------

    /**
     * Escribe las 7 lineas de encabezado con las etiquetas exactas del
     * Anexo A: TP, NF1, NC1, NV, numPasadas, NR, NP.
     */
    private void escribirEncabezado() {

        writer.println("TP=" + tp + "\n"+
            "NF1=" + filas + "\n"+
            "NC1=" + columnas + "\n"+
            "NV=" + nv + "\n"+
            "numPasadas=" + numPasadas + "\n"+
            "NR=" + getNR() + "\n"+
            "NP=" + getNP()
        ); 
       
    }

    // ------------------------------------------------------------------
    // PASO 4: escritura de una referencia individual
    // ------------------------------------------------------------------

    /**
     * Escribe una linea de referencia en el archivo, con el formato:
     *   [etiqueta],pagina,desplazamiento
     *
     * @param etiqueta texto que identifica el elemento referenciado,
     *                 por ejemplo "mat1-0-1" o "v-0-0"
     * @param direccion direccion lineal (en bytes) del elemento
     *
     * TODO: traducir la direccion a pagina y desplazamiento usando los
     *       helpers de arriba, y escribir la linea con el formato exacto.
     */
    private void escribirReferencia(String etiqueta, int direccion) {
        // TODO
    }

    // ------------------------------------------------------------------
    // PASO 5: recorrido por filas (operacion de suma)
    // ------------------------------------------------------------------

    /**
     * Registra las referencias del recorrido por filas, que corresponde a:
     *   m[i][j] = (byte) ((m[i][j] + v[j % v.length]) & 0xFF);
     *
     * TODO: replicar los bucles anidados del enunciado (i sobre filas,
     *       j sobre columnas) y, por cada celda, escribir las referencias
     *       en el MISMO orden en que el codigo accede a memoria.
     *       Fijate en el Anexo A para confirmar ese orden.
     */
    private void recorridoPorFilas() {
        // TODO
    }

    // ------------------------------------------------------------------
    // PASO 6: recorrido por columnas (operacion XOR)
    // ------------------------------------------------------------------

    /**
     * Registra las referencias del recorrido por columnas, que corresponde a:
     *   m[i][j] = (byte) ((m[i][j] ^ v[i % v.length]) & 0xFF);
     *
     * TODO: replicar los bucles del enunciado, con j en el bucle externo
     *       e i en el interno. Observa que aqui el indice del vector
     *       depende de i, no de j.
     */
    private void recorridoPorColumnas() {
        // TODO
    }

    // ------------------------------------------------------------------
    // PASO 7 y 8: orquestacion
    // ------------------------------------------------------------------

    /**
     * Abre el archivo, escribe el encabezado y ejecuta los recorridos.
     *
     * El try-with-resources cierra el writer automaticamente al terminar,
     * incluso si ocurre un error.
     */
    public void generar() {
        try (PrintWriter w = new PrintWriter(archivoSalida)) {
            this.writer = w;

            escribirEncabezado();

            // ----------------------------------------------------------
            // TODO: aqui va el ciclo de pasadas.
            //
            // DECISION DE DISENO QUE DEBES TOMAR Y JUSTIFICAR:
            // en el codigo del enunciado el bucle de numPasadas envuelve
            // SOLO el recorrido por filas; el recorrido por columnas queda
            // afuera. Decide si lo replicas literalmente o si asumes que
            // ambos recorridos van dentro del bucle, y deja constancia de
            // la decision en el informe. El valor de getNR() debe ser
            // coherente con lo que implementes aqui.
            // ----------------------------------------------------------

        } catch (IOException e) {
            System.out.println("Error escribiendo el archivo: " + e.getMessage());
        } finally {
            this.writer = null;
        }
    }
}
