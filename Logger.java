import java.io.FileWriter;         // Para escribir en archivos
import java.io.IOException;        // Para manejar errores de entrada/salida
import java.io.PrintWriter;        // Para escribir líneas completas en un archivo
import java.time.LocalDateTime;    // Para obtener la fecha y hora actual
import java.time.format.DateTimeFormatter; // Para dar formato a la fecha y hora

// Clase Logger para guardar acciones en un archivo de texto
class Logger {
    private static final String FILE_NAME = "acciones.log"; // Nombre del archivo de logs

    // Método para registrar un mensaje en el archivo log
    public static void log(String mensaje) {
        try (FileWriter fw = new FileWriter(FILE_NAME, true); // Abrimos el archivo en modo append
             PrintWriter pw = new PrintWriter(fw)) {          // Creamos un escritor de texto
            LocalDateTime ahora = LocalDateTime.now();        // Obtenemos fecha y hora actual
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"); // Formato
            pw.println("[" + ahora.format(formato) + "] " + mensaje); // Guardamos en archivo
        } catch (IOException e) { // Si ocurre un error al escribir en el archivo
            System.out.println("Error al escribir en el log: " + e.getMessage());
        }
    }
}
