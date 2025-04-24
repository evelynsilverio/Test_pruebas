package ejercicio3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// Clase que tiene el método para verificar la validez de una cadena de paréntesis
public class tercer_ejercicio {

    // Método que verifica si la cadena de paréntesis es válida
    // Utiliza una pila para almacenar los paréntesis de apertura
    public static boolean esValida(String s) {
        Stack<Character> pila = new Stack<>();

        // Recorrer cada carácter de la cadena
        for (char c : s.toCharArray()) {
            // Si es paréntesis de apertura, lo meto a la pila
            if (c == '(' || c == '[' || c == '{') {
                pila.push(c);
            } else {
                // Si la pila está vacía, no hay nada que cerrar y no es válida
                if (pila.isEmpty()) return false;

                // Ultimo carácter de la pila
                char tope = pila.pop();

                // Verificamos que coincidan los paréntesis
                // Si no coinciden, la cadena no es válida
                if ((c == ')' && tope != '(') ||
                    (c == ']' && tope != '[') ||
                    (c == '}' && tope != '{')) {
                    return false;
                }
            }
        }

        // Si la pila está vacía al final, es válida
        return pila.isEmpty();
    }

    // Método para ejecutar el programa
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            // Pedir al usuario que ingrese una cadena de paréntesis
            System.out.print("Introduce una cadena de paréntesis: ");
            String s = reader.readLine();// Leer la línea de texto que introduce el usuario

            // Llamar al método para verificar la validez de la cadena
            boolean resultado = esValida(s);
            System.out.println("La cadena " + (resultado ? "es válida" : "no es válida")); // Mostrar el resultado

        } catch (IOException e) {
            // Si algo falla mostrar un mensaje de error
            System.out.println("Hubo un error al leer la entrada.");
        }
    }
}
