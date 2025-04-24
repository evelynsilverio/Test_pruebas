package ejercicio2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

// Clase que contiene el método para encontrar la longitud de la subcadena más larga
public class segundo_ejercicio {
    // Método que calcula la longitud de la subcadena más larga
    public static int longitudSubcadenaMasLarga(String s) {
        HashSet<Character> caracteres = new HashSet<>();
        // Variable que apunta al inicio de la subcadena
        int inicio = 0;
        // Variable para almacenar la longitud máxima
        int maximo = 0;

        // Recorrer la cadena
        for (int fin = 0; fin < s.length(); fin++) {
            char actual = s.charAt(fin);

            // Si el carácter ya está en el conjunto, significa que hay un duplicado
            // y se debe mover el inicio de la subcadena hacia adelante
            while (caracteres.contains(actual)) {
                // Eliminar el carácter en la posición de inicio del conjunto
                caracteres.remove(s.charAt(inicio));
                // Mover el inicio hacia adelante
                inicio++;
            }

            // Agregar el carácter actual al conjunto
            caracteres.add(actual);

            // Actualizar la longitud máxima
            maximo = Math.max(maximo, fin - inicio + 1);
        }

        return maximo;
    }

    public static void main(String[] args) {
        // Crear un BufferedReader para leer la entrada del usuario
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        try {
            // Pedir al usuario que ingrese una cadena
            System.out.print("Introduce una cadena de texto: ");
            String s = reader.readLine();  // Leer la línea de texto que introduce el usuario

            // Llamar al método para calcular la longitud de la subcadena más larga sin repetidos
            int resultado = longitudSubcadenaMasLarga(s);

            // Mostrar el resultado
            System.out.println("La longitud de la subcadena más larga es: " + resultado);
        } catch (IOException e) {
            System.out.println("Hubo un error al leer la entrada.");
        }
    }
}
