package ejercicio1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Clase lista
class Lista {
    int val; // Valor del nodo
    Lista next;

    Lista(int val) {
        this.val = val;
    }
}


// Clase que contiene el método main
public class primer_ejercicio {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Preguntar al usuario el tamaño de lprimera lista
        System.out.print("¿Cuántos nodos tendrá la primera lista? ");
        int tamaño1 = Integer.parseInt(br.readLine());
        Lista l1 = crearLista(tamaño1, br, "primera");// Crear la primera lista

        // Preguntar al usuario el tamaño de la segunda lista
        System.out.print("¿Cuántos nodos tendrá la segunda lista? ");
        int tamaño2 = Integer.parseInt(br.readLine());
        Lista l2 = crearLista(tamaño2, br, "segunda");// Crear la segunda lista

        // Para mostrar las listas
        System.out.print("Lista 1: ");
        mostrarLista(l1);
        System.out.print("Lista 2: ");
        mostrarLista(l2);

        // Para sumar las listas y mostrar resultado
        Lista resultado = addTwoNumbers(l1, l2);
        System.out.print("Resultado de la suma: ");
        mostrarLista(resultado);
    }

    // Para crear una lista a partir de los valores ingresados por el usuario
    public static Lista crearLista(int tamaño, BufferedReader br, String nombre) throws IOException {
        if (tamaño <= 0) return null;

        //Preguntar al usuario los valores de la lista
        System.out.println("Ingresa los valores de la " + nombre + " lista:");
        System.out.print("Nodo 1: ");
        Lista cabeza = new Lista(Integer.parseInt(br.readLine()));
        Lista actual = cabeza;

        
        for (int i = 2; i <= tamaño; i++) {
            System.out.print("Nodo " + i + ": ");
            actual.next = new Lista(Integer.parseInt(br.readLine()));
            actual = actual.next;// Avanzar al siguiente nodo
        }

        return cabeza; // Devolver la cabeza de la lista
    }

    // Suma de dos listas 
    public static Lista addTwoNumbers(Lista l1, Lista l2) {
        Lista dummy = new Lista(0);
        Lista actual = dummy;
        int carry = 0;// Variable para llevar el acarreo

        // Mientras haya nodos en l1 o l2 o haya un acarreo
        // Se suman los valores de los nodos y el acarreo
        // Se crea un nuevo nodo con el resultado de la suma
        // Se avanza a los siguientes nodos de l1 y l2
        // Se actualiza el acarreo
        while (l1 != null || l2 != null || carry != 0) {
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            int suma = val1 + val2 + carry;
            carry = suma / 10;

            actual.next = new Lista(suma % 10);
            actual = actual.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummy.next;
    }

    // Para mostrar la lista
    // Se recorre la lista y se imprime el valor de cada nodo
    public static void mostrarLista(Lista nodo) {
        if (nodo == null) {
            System.out.println("Lista vacía.");
            return;
        }

        // Se recorre la lista y se imprime el valor de cada nodo
        while (nodo != null) {
            System.out.print(nodo.val);
            if (nodo.next != null) System.out.print(" -> ");
            nodo = nodo.next;
        }
        System.out.println();
    }
}