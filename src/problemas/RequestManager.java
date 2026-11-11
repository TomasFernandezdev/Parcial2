package problemas;

import java.util.LinkedList;
import java.util.Queue;

/*
* 1. Primero se consideran las solicitudes de prioridad alta en su orden de llegada. Después se
consideran las de prioridad normal, también en su orden de llegada.
2. Si una solicitud cabe en el tiempo restante, se selecciona y se descuenta su duración. Si no
cabe, permanece pendiente y se sigue evaluando la siguiente.
3. Al terminar, las solicitudes pendientes deben conservar su orden de llegada relativo. Si el tiempo
disponible es menor o igual a cero, se retorna una cola vacía y se conserva la cola de
pendientes.
* */

public class RequestManager {


    public Queue<Request> selectRequest(Queue<Request> pendingQueue, int availableMinutes){

        Queue<Request> selectedQueue = new LinkedList<>();
        int remainingTime = availableMinutes;


        if (availableMinutes <= 0 || pendingQueue == null || pendingQueue.isEmpty()) {
            return selectedQueue;
        }

        int size = pendingQueue.size();

        /*Despachamos los de prioridad alta, en caso tal no quepan por tiempo y demás, vuelven a la cola
        conservando su orden de llegada
        */
        for(int i = 0; i < size; i++){

            Request request = pendingQueue.poll();

            boolean isHigh = request.getPriority().equalsIgnoreCase("HIGH");

            if(isHigh && request.getDuration() <= remainingTime){
                selectedQueue.add(request);
                remainingTime -= request.getDuration();
            }else pendingQueue.add(request);
        }

        //Igualmente acá pero despachando los que quedan
        size =  pendingQueue.size();

        for(int i = 0; i < size; i++){
            Request request = pendingQueue.poll();

            boolean isNormal = !(request.getPriority().equalsIgnoreCase("HIGH"));

            if(isNormal && request.getDuration() <= remainingTime){
                selectedQueue.add(request);
                remainingTime -= request.getDuration();
            }else  pendingQueue.add(request);
        }

        printQueue(selectedQueue);
        printQueue(pendingQueue);
        return selectedQueue;
    }


    private void printQueue(Queue<Request> queue){
        for (Request req : queue) {
            System.out.print(req.toString() + " -> ");
        }
        System.out.println();
    }


}
