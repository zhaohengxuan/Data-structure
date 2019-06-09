import com.sun.xml.internal.bind.annotation.OverrideAnnotationOf;

public class LoopQueue<T> implements Queue<T> {
    private T[] data;
    private int front,tail;
    private int size;
    public LoopQueue(int capacity){
        data=(T[])new Object[capacity+1];
        front=0;
        tail=0;
        size=0;
    }
    public LoopQueue(){
        this(10);
    }
    public int getCapacity(){
        return data.length-1;
    }
    @Override
    public void enqueue(T e) {
        //入队之前判断队列是否满了
        if((tail+1)%data.length==front){
            resize(getCapacity()*2); //动态扩容
        }
        data[tail]=e;
        tail=(tail+1)%data.length;
        size++;
    }

    @Override
    public T dequeue() {
        if(isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue");
        T ret=data[front];
        data[front]=null;
        front=(front+1)%data.length;
        size--;
        if(size==getCapacity()/4&&getCapacity()/2!=0){//缩容时队列不能缩为0
            resize(getCapacity()/2);
        }
        return ret;
    }

    @Override
    public T getFront() {
        if(isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from a empty queue");
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front==tail;
    }
    //队列的扩容操作
    private void resize(int newCapacity){
        T[] newData=(T[])new Object[newCapacity+1];
        for (int i = 0; i < size; i++) {
            newData[i]=data[(i+front)%data.length];
        }
        data=newData;
        front=0;
        tail=size;
    }
    @Override
    public String toString(){
        StringBuilder res=new StringBuilder();
        res.append(String.format("LoopQueue: size=%d, Capacity=%d\n",size,getCapacity()));
        res.append("front[");
//        for (int i = front; i !=tail; i=(i+1)%data.length) {
//            res.append(data[i]);
//            if((i+1)%data.length!=tail){
//                res.append(", ");
//            }
//        }//两种实现方式均可，前一种不需要size
        for (int i = 0; i < size; i++) {
            res.append(data[(i+front)%data.length]);
            if(((i+front)+1)%data.length!=tail)
                res.append(", ");
        }
        res.append("]tail");
        return res.toString();
    }
}
