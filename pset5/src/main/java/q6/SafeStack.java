package q6;


class testSafeStack {

    public static void main(String[] args) {
        SafeStack stack = new SafeStack();

        Thread[] T = new Thread[10];

        for (Thread t : T) {
            t = new Thread(() -> stack.push(System.nanoTime()));
        }
    }

}

public class SafeStack<E> {

    private Stack<E> s;

    public SafeStack() {
        s = new Stack<>();
    }

    /**
     * TODO
     * @param nanoTime
     */
    public void push(E nanoTime) {
        //...
        synchronized (s){
            s.push(nanoTime);
        }
    }

    public E pop(){
        synchronized (s){
            return s.pop();
        }
    }

    public int size(){
        synchronized (s){
            return s.size();
        }
    }

    public int capacity(){ //doesn't really have to be synchronized because accessing immutable value
        synchronized (s){
            return s.capacity();
        }
    }

    public boolean isEmpty(){
        synchronized (s){
            return s.isEmpty();
        }
    }

    public boolean isFull(){
        synchronized (s){
            return s.isFull();
        }
    }

    public void pushIfNotFull(E e){
        synchronized (s){
            if (!s.isFull()){
                s.push(e);
            }
        }
    }

    public E popIfNotEmpty(){
        synchronized (s){
            if (!s.isEmpty()){
                return s.pop();
            }
            else{
                return null;
            }
        }
    }
}
