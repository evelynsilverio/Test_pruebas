package ejercicio4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Clase que contiene el método para eliminar duplicados en un arreglo ordenado
public class cuarto_ejercicio {

    // Método para eliminar duplicados en un arreglo ordenado
    public static int eliminarDuplicados(int[] nums) {
        // Si el arreglo está vacío, no hay números duplicados que eliminar
        if (nums.length == 0) return 0;

        //Variable que guarda el índice del último número único encontrado
        int indiceUnico = 0;
        // Recorrer el arreglo
        for (int i = 1; i < nums.length; i++) {
            // Si el número actual es diferente al último número único encontrado
            if (nums[i] != nums[indiceUnico]) {
                indiceUnico++;//Avanzar el índice
                nums[indiceUnico] = nums[i];// Asignar el número único al nuevo índice
            }
        }
        return indiceUnico + 1;
    }

    // Método para imprimir el arreglo
    public static void imprimirArreglo(int[] nums, int k) {
        System.out.print(k + ", números = [");
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                System.out.print(nums[i]);
            } else {
                System.out.print("_");
            }

            if (i < nums.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    // Método para ejecutar el programa
    public static void main(String[] args) {
        // Crear un BufferedReader para leer la entrada del usuario
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            // Pedir al usuario que ingrese una lista de números pero que vayan separados por comas
            System.out.print("Ingresa una lista de números separados por comas: ");
            String linea = reader.readLine();

            // Dividir la línea de entrada en partes usando la coma como separador
            String[] partes = linea.split(",");
            int[] nums = new int[partes.length];

            // Convertir cada parte a un número entero y almacenarlo en el arreglo
            for (int i = 0; i < partes.length; i++) {
                nums[i] = Integer.parseInt(partes[i].trim());
            }

            // Llamar al método para eliminar duplicados y obtener el tamaño del arreglo sin duplicados
            int k = eliminarDuplicados(nums);
            imprimirArreglo(nums, k);// Imprimir el arreglo con los números únicos
            System.out.println("El tamaño del arreglo sin números duplicados es: " + k);

            
        } catch (IOException e) {
            System.out.println("Error al leer la entrada.");
        } catch (NumberFormatException e) {
            System.out.println("Debes ingresar solo números válidos separados por comas.");
        }
    }
}
