public class ArrayQueue<T> implements Queue<T> {
    private Array<T> array;
    public ArrayQueue(int capacity){
        array=new Array<>(capacity);
    }
    public ArrayQueue(){
        array=new Array<>();
    }
    public int getCapacity(){
        return array.getCapacity();
    }
    @Override
    public void enqueue(T e) {
        array.addLast(e);
    }

    @Override
    public T dequeue() {

        return array.removeFirst();
    }

    @Override
    public T getFront() {
        return array.getFirst();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }
    @Override
    public String toString(){
        StringBuilder res=new StringBuilder();
        res.append("Queue front:[");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if(i!=array.getSize()-1){
                res.append(", ");
            }
        }
        res.append("]tail");
        return res.toString();
    }
}
