package problemas;


public class Main{
    public Stack<Operation> obtenerUltimasConfirmadas(Stack<Operation> historial, int n) {
        if(n<= 0 || historial.isEmpty()){
            return new Stack<>();
        }
        Stack<Operation> aux = new Stack<>();
        recursividad(historial.getTop(), aux, n);
        return aux;
    }
    public void recursividad(Node<Operation> historial, Stack<Operation> aux, int n){
        if(historial == null || n == 0 ){
            return;
        }
        if(historial.getData().isConfirmed()){
            recursividad(historial.getNext() ,aux, --n);
            aux.push(historial.getData());
        }else {
            recursividad(historial.getNext(), aux, n);
        }
    }
    public Stack<Operation> obtenerUltimasConfirmadas2(Stack<Operation> historial, int n) {
        if(n<= 0 || historial.isEmpty()){
            return new Stack<>();
        }
        Stack<Operation> aux = historial.clone();
        recursividad2(aux, n);
        return aux;
    }
    public void recursividad2 (Stack<Operation> aux, int n){
        if(aux.isEmpty() || n == 0){
            aux.eraseStack();
            return;
        }
        if(aux.getValueTop().isConfirmed()){
            Operation v = aux.pop();
            recursividad2(aux, --n);
            aux.push(v);
        }else{
            Operation basura = aux.pop();
            recursividad2(aux, n);
        }
    }
}
