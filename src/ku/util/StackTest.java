package ku.util;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by PaiizZ on 4/21/2017 AD.
 */
public class StackTest {
    private Stack stack;

    @Before
    public void setUp() {
        StackFactory.setStackType(0);
        stack = StackFactory.makeStack(5);
    }

    @Test
    public void newStackIsEmpty(){
        assertTrue(stack.isEmpty());
        assertFalse(stack.isFull());
        assertEquals(0,stack.size());
    }

    @Test( expected = java.util.EmptyStackException.class)
    public void testPopEmptyStack(){
        Assume.assumeTrue(stack.isEmpty());
        stack.pop();
    }

    @Test
    public void testStackSize(){
        stack.push(1);
        stack.push(2);
        assertEquals(2,stack.size());
        stack.peek();
        stack.push(3);
        stack.pop();
        assertEquals(2,stack.size());
    }

    @Test
    public void testStackPush(){
        stack.push("Net");
        assertEquals("Net",stack.peek());
        stack.push("Not");
        assertEquals("Not",stack.peek());
        stack.push("Nick");
        stack.push("Nik");
        stack.push("Nook");
        assertEquals("Nook",stack.peek());
    }

    @Test
    public void testStackFull(){
        assertFalse(stack.isFull());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertFalse(stack.isFull());
        stack.push(4);
        stack.push(5);
        assertTrue(stack.isFull());
    }

    @Test
    public void testStackEmpty(){
        assertTrue(stack.isEmpty());
        stack.push(1);
        assertFalse(stack.isEmpty());
        stack.push(2);
        stack.push(3);
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testStackPeek(){
        assertEquals(null,stack.peek());
        stack.push(1);
        stack.push(2);
        assertEquals(2,stack.peek());
        assertEquals(2,stack.peek());
        stack.push(3);
        assertEquals(3,stack.peek());
    }

    @Test
    public void testCapacity(){
        assertEquals(5,stack.capacity());
    }

    @Test( expected = IllegalStateException.class)
    public void testOverFlow(){
        stack.push(1);
        stack.push(2);
        stack.push(1);
        stack.push(2);
        stack.push(1);
        stack.push(2);
    }

    @Test( expected = IllegalArgumentException.class)
    public void testPushNull(){
        stack.push(null);
    }

    private Stack makeStack(int capacity){
        //a dummy stack
        return new DummyStack(capacity);
    }
}
