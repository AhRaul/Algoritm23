import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.geekbrains.course23.queue.Queue;
import ru.geekbrains.course23.queue.QueueImpl;
import ru.geekbrains.course23.queue.QueueOverloadException;
import ru.geekbrains.course23.stack.Stack;
import ru.geekbrains.course23.stack.StackImpl;
import ru.geekbrains.course23.stack.StackOverloadException;

public class QueueTestCase {

    Queue<Integer> queue;

    @BeforeEach
    public void setUp() {
        queue = new QueueImpl<>(5);
    }

    @Test
    public void test_create_queue(){
        Assertions.assertNotNull(queue);            //проверка, что при создании стека, он не null
    }

    @Test
    public void test_add_to_queue(){
        queue.insert(1);
        Assertions.assertEquals(1, (int)queue.peek());            //проверка на равенство
    }

    @Test
    public void test_add_element_to_full_queue() {
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        queue.insert(5);
        Assertions.assertThrows(QueueOverloadException.class, () -> {
            queue.insert(6);
        });
    }

    @Test
    public void test_remove() {
        queue.insert(1);
        Assertions.assertEquals(1, (int)queue.remove());
        Assertions.assertEquals(0, queue.getSize());
        Assertions.assertTrue(queue.isEmpty());
        Assertions.assertFalse(queue.isFull());
    }

    @Test
    public void test_display() {
        Queue<Integer> queue1 = new QueueImpl<>(5);
        queue1.insert(1);
        queue1.insert(2);
        queue1.insert(3);
        queue1.insert(4);
        queue1.insert(5);

        StringBuilder sb = new StringBuilder();

        while (!queue1.isEmpty()) {
            sb.append(queue1.remove());
        }

        Assertions.assertEquals("12345", sb.toString());
    }
}
