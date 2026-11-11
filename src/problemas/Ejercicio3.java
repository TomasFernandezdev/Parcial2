package problemas;

public class Ejercicio3 {
    public Queue<Request> SeleccionarSolicitudes(Queue<Request> pendientes, int minutosDisponibles){
        if(minutosDisponibles <= 0 || pendientes.isEmpty()){
            return new Queue<>();
        }
        int s = pendientes.size();
        Queue<Request> atendido = new Queue<>();
        for(int i = 0; i< s; i++){
            Request rq = pendientes.desencolar();
            if(rq.getDuration()<=minutosDisponibles && rq.getPriority().equals(Priority.ALTA)){
                atendido.encolar(rq);
                minutosDisponibles -= rq.getDuration();
            }else{
                pendientes.encolar(rq);
            }
        }if(minutosDisponibles >= 0){
            s = pendientes.size();
            for(int i = 0; i< s; i++){
                Request rq = pendientes.desencolar();
                if(rq.getDuration()<=minutosDisponibles){
                    atendido.encolar(rq);
                    minutosDisponibles -= rq.getDuration();
                }else{
                    pendientes.encolar(rq);
                }
            }
        }
        printQueue(atendido);
        printQueue(pendientes);
        return atendido;

    }
    private void printQueue(Queue<Request> queue){
        for (Request req : queue) {
            System.out.print(req.toString() + " -> ");
        }
        System.out.println();
    }
}
