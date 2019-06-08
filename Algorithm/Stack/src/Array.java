
public class Array<T> {
    private T[] data;
    private int size;

    /**
     * @param capacity
     */
    //数组构造函数，传入数组的容量
    public Array(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public Array() {
        this(10);
    }

    //获取数组中元素的个数
    public int getSize() {
        return size;
    }

    //获取数组的容量
    public int getCapacity() {
        return data.length;
    }

    //返回数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //在数组的第一位添加新的元素
    public void addFirst(T e) {
        add(0, e);
    }

    //向数组中添加新的元素
    public void addLast(T e) {
        add(size, e);
    }

    //向数组中指定位置index添加元素e
    public void add(int index, T e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("AddLast failed,Require index>0 or index<size");
        }
        if (size == data.length) {
            //throw new IllegalArgumentException("AddLast failed,Array is full");
            resize(2 * data.length);
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    //获取index位置的元素
    public T get(int index) {
        if (index < 0 || index > size - 1)
            throw new IllegalArgumentException("Get failed,Index out of bound");
        return data[index];
    }
    public T getLast(){
        return get(size-1);
    }
    public T getFirst(){
        return get(0);
    }
    //指定index位置的元素更新
    public void set(int index, T e) {
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException("Get failed,Index out of bound");
        }
        data[index] = e;
    }

    //查询数组中是否有元素e
    public boolean contain(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    //数组中查找元素e所在的索引，不存在返回-1
    public int find(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    //删除指定index位置的元素,返回删除的元素
    public T remove(int index) {
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException("Delete failed,Index out of bound");
        }
        T res = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;    //维护数组的长度
        data[size] = null;
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return res;
    }

    //删除第一个位置的元素,返回删除的元素
    public T removeFirst() {
        return remove(0);
    }

    //删除最后一个位置的元素,返回删除的元素
    public T removeLast() {
        return remove(size - 1);
    }

    //从数组中删除元素e
    public boolean removeElement(T e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    private void resize(int newCapicity) {
        T[] newData = (T[]) new Object[newCapicity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;

    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size=%d, Capacity=%d\n", size, data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }

}

