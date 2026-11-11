package problemas;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<T> implements Iterable<T> {
    private int size;
    private Node<T> firstNode;
    private Node<T> lastNode;

    public Queue() {
        this.size =0;
        this.firstNode = null;
        this.lastNode = null;
    }

    public void encolar(T data){
        Node<T> newNode = new Node(data);
        if (isEmpty()){
            firstNode = newNode;
            lastNode = newNode;
        }else {
            lastNode.setNext(newNode);
            lastNode = newNode;
        }
        size++;
    }

    public T desencolar(){
        if(isEmpty()){
            throw new RuntimeException("La cola está vacía");
        }else{
            T data = firstNode.getData();
            firstNode = firstNode.getNext();
            if(firstNode == null){
                lastNode = null;
            }
            size--;
            return data;
        }
    }
    public T getFirst(){
        return firstNode.getData();
    }
    public T getLast(){
        return lastNode.getData();
    }
    public int size(){
        return size;
    }


    public boolean isEmpty(){
        return size == 0;
    }


    public void clear(){
        size = 0;
        firstNode = null;
        lastNode = null;
    }

    public void invertirColaRecursivo(){
        if (isEmpty()){
            return;
        }
        T dato = desencolar();
        invertirColaRecursivo();
        encolar(dato);
    }

    public void invertirCola(){
        if (isEmpty()) {
            return;
        }
        Stack<T> pila = new Stack<>();

        while(!isEmpty()){
            pila.push(desencolar());
        }
        while(!pila.isEmpty()){
            encolar(pila.pop());
        }
    }
    @Override
    protected Queue<T> clone() {

        Queue<T> nueva = new Queue<>();
        Node<T> aux = firstNode;

        while(aux!=null) {
            nueva.encolar( aux.getData() );
            aux = aux.getNext();
        }

        return nueva;
    }
    @Override
    public Iterator<T> iterator() {

        QueueIterator iterator = new QueueIterator();

        return iterator;
    }

    private class QueueIterator implements Iterator<T>{

        Node<T> actualNode;

        QueueIterator(){
            this.actualNode = firstNode;
        }

        @Override
        public boolean hasNext() {
            return actualNode != null;
        }

        @Override
        public T next() {

            if(!hasNext()){
                throw new NoSuchElementException("No hay elementos en la lista");
            }

            T value = actualNode.getData();
            actualNode = actualNode.getNext();

            return value;
        }
    }
}
