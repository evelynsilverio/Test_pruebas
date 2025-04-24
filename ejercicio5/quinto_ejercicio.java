package ejercicio5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Clase que contiene el método para encontrar la primera ocurrencia de una subcadena
public class quinto_ejercicio {

    // Método que busca una subcadena dentro de otra
    public static int buscarSubcadena(String haystack, String needle) {
        int largoHaystack = haystack.length();
        int largoNeedle = needle.length();

        // Si la subcadena está vacía está en el índice 0
        if (needle.isEmpty()) return 0;

        // Si la subcadena es más grande que el texto principal no existe
        if (largoNeedle > largoHaystack) return -1;

        // Recorrer el haystack para buscar alguna coincidencia
        for (int i = 0; i <= largoHaystack - largoNeedle; i++) {
            int j = 0;
            while (j < largoNeedle && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }
            if (j == largoNeedle) {
                return i; // Si se encuentra la subcadena devolver el índice
            }
        }

        return -1; // Si termina el ciclo y no se encuentra nada
    }

    // Método para ejecutar el programa
    public static void main(String[] args) {
        // Crear un BufferedReader para leer la entrada del usuario
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

        try {
            // Pedir al usuario que ingrese el texto donde buscará que sería una cadena
            System.out.print("Ingresa el texto donde buscarás (haystack): ");
            String haystack = lector.readLine();

            // Pedir al usuario que ingrese el texto que buscará que sería una subcadena
            System.out.print("Ingresa la palabra o parte que buscarás (needle): ");
            String needle = lector.readLine();

            // Llamar al método para buscar la subcadena
            int resultado = buscarSubcadena(haystack, needle);
            System.out.println("Índice de la primera ocurrencia: " + resultado);

        } catch (IOException e) {
            // Si algo falla mostrar un mensaje de error
            System.out.println("Hubo un error al leer los datos.");
        }
    }
}
