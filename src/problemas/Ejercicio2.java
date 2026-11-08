package problemas;

public class Ejercicio2 {
    public Stack<Operation> obtenerSegmento(Stack<Operation> original, int inicio, int fin){
        if(original.isEmpty() || inicio<1 || inicio>fin || fin > original.getSize()){
            return new Stack<>();
        }
        Stack<Operation> aux = original.clone();
        recursivo(aux, inicio, fin , 1);
        return aux;
    }
    public void recursivo(Stack<Operation> aux, int inicio, int fin, int n){
        if(n > fin){
            aux.eraseStack();
            return;
        }
        if(n>=inicio && n<=fin){
            Operation obj = aux.pop();
            recursivo(aux, inicio, fin, ++n);
            aux.push(obj);
        }else{
            Operation basura = aux.pop();
            recursivo(aux, inicio, fin, ++n);
        }
    }
}
