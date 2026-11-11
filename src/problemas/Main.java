package problemas;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {

        // ==========================================
        // =============== PUNTO 1 ==================
        // ==========================================
        System.out.println("=============== PUNTO 1 ===============\n");
        Ejercicio1 ej1 = new Ejercicio1();

        // Creamos historial de operaciones:
        // Se apilan desde OP1 (más antigua) hasta OP6 (más reciente, en el tope).
        Stack<Operation> historial = new Stack<>();
        historial.push(new Operation("OP1", true));   // Fondo
        historial.push(new Operation("OP2", false));
        historial.push(new Operation("OP3", true));
        historial.push(new Operation("OP4", true));
        historial.push(new Operation("OP5", false));
        historial.push(new Operation("OP6", true));   // Tope

        imprimirPila("Historial original (Tope a Fondo)", historial);

        // Prueba 1.1: Obtener las últimas 2 operaciones confirmadas (Método 1)
        // Esperado: OP6 y OP4 (conservando orden relativo en la pila)
        System.out.println("\n--- Prueba 1.1: Obtener las últimas 2 confirmadas (Método 1) ---");
        Stack<Operation> ultimas2_m1 = ej1.obtenerUltimasConfirmadas2(historial, 2);
        imprimirPila("Resultado Método 1 (n=2)", ultimas2_m1);

        // Prueba 1.2: Obtener las últimas 2 operaciones confirmadas (Método 2 con clon)
        // Esperado: OP6 y OP4
        System.out.println("\n--- Prueba 1.2: Obtener las últimas 2 confirmadas (Método 2) ---");
        Stack<Operation> ultimas2_m2 = ej1.obtenerUltimasConfirmadas2(historial, 2);
        imprimirPila("Resultado Método 2 (n=2)", ultimas2_m2);

        // Prueba 1.3: Solicitar más confirmadas de las que existen (n=10, existen 4 confirmadas)
        // Esperado: Las 4 confirmadas (OP6, OP4, OP3, OP1)
        System.out.println("\n--- Prueba 1.3: Solicitar n mayor al total de confirmadas (n=10) ---");
        Stack<Operation> todasConfirmadas = ej1.obtenerUltimasConfirmadas2(historial, 10);
        imprimirPila("Resultado (n=10)", todasConfirmadas);

        // Prueba 1.4: Caso límite con n <= 0
        // Esperado: Pila vacía
        System.out.println("\n--- Prueba 1.4: Caso límite n <= 0 (n=0) ---");
        Stack<Operation> casoCero = ej1.obtenerUltimasConfirmadas2(historial, 0);
        imprimirPila("Resultado (n=0)", casoCero);

        // Verificar integridad de la pila original
        System.out.println("\n--- Verificación de integridad de la pila original ---");
        imprimirPila("Historial tras operaciones (debe mantenerse intacto)", historial);


        // ==========================================
        // =============== PUNTO 2 ==================
        // ==========================================
        System.out.println("\n\n=============== PUNTO 2 ===============\n");
        Ejercicio2 ej2 = new Ejercicio2();

        // Creamos pila de prueba para segmento (posiciones 1 a 6 de tope a fondo)
        Stack<Operation> pilaSegmento = new Stack<>();
        pilaSegmento.push(new Operation("OP1", true));  // Pos 6 (fondo)
        pilaSegmento.push(new Operation("OP2", false)); // Pos 5
        pilaSegmento.push(new Operation("OP3", true));  // Pos 4
        pilaSegmento.push(new Operation("OP4", true));  // Pos 3
        pilaSegmento.push(new Operation("OP5", false)); // Pos 2
        pilaSegmento.push(new Operation("OP6", true));  // Pos 1 (tope)

        imprimirPila("Pila original para segmento (Posición 1 en el Tope)", pilaSegmento);

        // Prueba 2.1: Segmento intermedio [2, 4]
        // Esperado: OP5 (pos 2), OP4 (pos 3), OP3 (pos 4)
        System.out.println("\n--- Prueba 2.1: Segmento intermedio [inicio=2, fin=4] ---");
        Stack<Operation> segIntermedio = ej2.obtenerSegmento(pilaSegmento, 2, 4);
        imprimirPila("Segmento [2, 4]", segIntermedio);

        // Prueba 2.2: Segmento desde el tope [1, 2]
        // Esperado: OP6 (pos 1), OP5 (pos 2)
        System.out.println("\n--- Prueba 2.2: Segmento inicial [inicio=1, fin=2] ---");
        Stack<Operation> segInicial = ej2.obtenerSegmento(pilaSegmento, 1, 2);
        imprimirPila("Segmento [1, 2]", segInicial);

        // Prueba 2.3: Segmento de un único elemento [3, 3]
        // Esperado: OP4 (pos 3)
        System.out.println("\n--- Prueba 2.3: Segmento de un solo elemento [inicio=3, fin=3] ---");
        Stack<Operation> segUnico = ej2.obtenerSegmento(pilaSegmento, 3, 3);
        imprimirPila("Segmento [3, 3]", segUnico);

        // Prueba 2.4: Casos límite e inválidos (inicio > fin, fin > size, inicio < 1)
        // Esperado: Pilas vacías
        System.out.println("\n--- Prueba 2.4: Casos límite / inválidos ---");
        Stack<Operation> casoInvalido1 = ej2.obtenerSegmento(pilaSegmento, 5, 2); // inicio > fin
        imprimirPila("Caso inválido (inicio > fin: [5, 2])", casoInvalido1);

        Stack<Operation> casoInvalido2 = ej2.obtenerSegmento(pilaSegmento, 1, 10); // fin > size
        imprimirPila("Caso inválido (fin > size: [1, 10])", casoInvalido2);

        Stack<Operation> casoInvalido3 = ej2.obtenerSegmento(pilaSegmento, 0, 3); // inicio < 1
        imprimirPila("Caso inválido (inicio < 1: [0, 3])", casoInvalido3);

        // Verificar integridad de la pila original
        System.out.println("\n--- Verificación de integridad de la pila original ---");
        imprimirPila("Pila original tras obtener segmentos (debe mantenerse intacta)", pilaSegmento);


        // ==========================================
        // =============== PUNTO 3 ==================
        // ==========================================
        System.out.println("\n\n=============== PUNTO 3 ===============\n");
        Queue<Request> puntoTres = new LinkedList<>();

        puntoTres.add(new Request("S1", "NORMAL", 10));
        puntoTres.add(new Request("S2", "HIGH", 30));
        puntoTres.add(new Request("S3", "HIGH", 15));
        puntoTres.add(new Request("S4", "NORMAL", 5));

        RequestManager requestManager = new RequestManager();

        requestManager.selectRequest(puntoTres, 25);


        // ==========================================
        // =============== PUNTO 4A =================
        // ==========================================
        System.out.println("\n\n=============== PUNTO 4A ===============\n");

        BestEquipment bestEquipment = new BestEquipment();
        bestEquipment.insert(50);
        bestEquipment.insert(30);
        bestEquipment.insert(70);
        bestEquipment.insert(20);
        bestEquipment.insert(40);
        bestEquipment.insert(60);
        bestEquipment.insert(80);
        bestEquipment.insert(55);
        bestEquipment.insert(65);

        //Retorna 5
        int total1 = bestEquipment.countEquipmentInRange(bestEquipment.getRoot(), 35, 65);
        System.out.println("Equipos en rango [" + 35 + ", " + 65 + "]: " + total1);

        //Retorna 3
        int total2 = bestEquipment.countEquipmentInRange(bestEquipment.getRoot(), 20, 40);
        System.out.println("Equipos en rango [" + 20 + ", " + 40 + "]: " + total2);

        //Retorna 0 (el minimo es mayor al máxim, o sea, caso base)
        int total3 = bestEquipment.countEquipmentInRange(bestEquipment.getRoot(), 80, 20);
        System.out.println("Caso límite (min > max): " + total3);

    }

    private static void imprimirPila(String titulo, Stack<Operation> pila) {
        System.out.println(titulo + " (Tamaño: " + pila.getSize() + "):");
        if (pila.isEmpty()) {
            System.out.println("  [Pila vacía]");
        } else {
            System.out.print("  TOPE -> ");
            pila.print();
        }
    }

}
