package ku.util;

/**
 * Created by PaiizZ on 4/21/2017 AD.
 */
public class DummyStack implements Stack<String>{
    private int capacity;

    DummyStack(int capacity){
        this.capacity = capacity;
    }

    @Override
    public String pop() {
        return null;
    }

    @Override
    public String peek() {
        return null;
    }

    @Override
    public void push(String obj) {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public int capacity() {
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }
}
