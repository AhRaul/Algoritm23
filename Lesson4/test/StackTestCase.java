import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.geekbrains.course23.linkedlist.stack.LinkedStackImpl;
import ru.geekbrains.course23.stack.Stack;
import ru.geekbrains.course23.stack.StackImpl;
import ru.geekbrains.course23.stack.StackOverloadException;

public class StackTestCase {

    private Stack<Integer> stack;

    @BeforeEach
    public void prepare() {
        stack = new LinkedStackImpl<>();
    }

    @Test
    public void test_create_stack(){
        Assertions.assertNotNull(stack);            //проверка, что при создании стека, он не null
    }

    @Test
    public void test_add_to_stack(){
        stack.push(1);
        Assertions.assertEquals(1, (int)stack.peek());            //проверка на равенство
    }

    @Test
    public void test_remove() {
        stack.push(1);
        Assertions.assertEquals(1, (int)stack.pop());
        Assertions.assertEquals(0, stack.getSize());
        Assertions.assertTrue(stack.isEmpty());
        Assertions.assertFalse(stack.isFull());
    }

    @Test
    public void test_display() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        Assertions.assertEquals("54321", sb.toString());
    }
}
