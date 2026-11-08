package problemas;

public class Stack<T> {
    private Node<T> top;
    private int size;


    public boolean isEmpty(){
        return top == null;
    }

    public void push(T data){
        Node<T> node = new Node<>(data);
        node.setNext(top);
        top = node;

        size++;
    }
    public T pop(){
        if(isEmpty()){
            throw new RuntimeException("The stack is empty");
        }
        T data = top.getData();
        top = top.getNext();
        size--;

        return data;
    }

    public void eraseStack(){
        top = null;
        size = 0;
    }
    public T getValueTop(){
        return top.getData();
    }

    public Node<T> getTop() {
        return top;
    }

    public int getSize() {
        return size;
    }
    public void add(Stack<T> stack){
        Stack<T> clon = stack.clone();
        Stack<T> aux = new Stack<>();

        while(!clon.isEmpty()){
            aux.push(clon.pop());
        }

        while(!aux.isEmpty()){
            push(aux.pop());
        }
    }
    public void print(){
        Node<T> aux = top;
        while(aux != null){
            System.out.print(aux.getData()+"\t");
            aux = aux.getNext();
        }
        System.out.println();
    }

    @Override
    protected Stack<T> clone(){
        Stack<T> finalStack = new Stack<>();
        Node<T> topNode = null;
        for(Node<T> aux = top; aux != null; aux = aux.getNext()){
            Node<T> newNode = new Node<>(aux.getData());
                if(finalStack.isEmpty()){
                    finalStack.top = newNode;
                    topNode = newNode;
            }else{
                    finalStack.top.setNext(newNode);
                    finalStack.top = newNode;
                }
                finalStack.size++;
        }
        finalStack.top = topNode;
        return finalStack;
    }
}

