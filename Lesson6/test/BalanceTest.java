import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.geekbrains.course23.dz6.MyTree;
import ru.geekbrains.course23.dz6.MyTreeImpl;

public class BalanceTest {

    MyTree<Integer> myTree;

    @BeforeEach
    public void setUp() {
        myTree = new MyTreeImpl<>();
    }

    @Test
    public void test_create_tree(){
        Assertions.assertNotNull(myTree);            //проверка, что при создании древа, он не null
    }

    @Test
    public void test_value_exists(){                //проверка наличия введенных в дерево элементов
        myTree.add(66);
        myTree.add(23);
        myTree.add(22);
        myTree.add(24);
//        myTree.add(25);
        myTree.add(68);
//        myTree.add(66);
        myTree.add(69);
        Assertions.assertEquals(true, myTree.find(66));            //проверка на равенство
        Assertions.assertEquals(true, myTree.find(23));            //проверка на равенство
        Assertions.assertEquals(true, myTree.find(22));            //проверка на равенство
        Assertions.assertEquals(true, myTree.find(24));            //проверка на равенство
        Assertions.assertEquals(true, myTree.find(68));            //проверка на равенство
        Assertions.assertEquals(true, myTree.find(69));            //проверка на равенство

        Assertions.assertEquals(false, myTree.find(100));            //проверка на равенство
        Assertions.assertEquals(false, myTree.find(0));            //проверка на равенство
    }

    //различные варианты проветки баланса древьев
    @Test
    public void test_balance1(){
        myTree.add(66);
        myTree.add(23);
        myTree.add(68);
        Assertions.assertEquals(true, myTree.totalBalanced());            //проверка на равенство
    }

    @Test
    public void test_balance2(){
        myTree.add(66);
        myTree.add(23);
        myTree.add(68);
        myTree.add(69);
        myTree.add(67);
        Assertions.assertEquals(false, myTree.totalBalanced());            //проверка на равенство
    }

    @Test
    public void test_balance3(){
        myTree.add(66);
        myTree.add(23);
        myTree.add(68);
        myTree.add(67);
        Assertions.assertEquals(true, myTree.totalBalanced());            //проверка на равенство
    }

    @Test
    public void test_balance4(){
        myTree.add(66);
        myTree.add(23);
        myTree.add(68);
        myTree.add(69);
        Assertions.assertEquals(true, myTree.totalBalanced());            //проверка на равенство
    }

    @Test
    public void test_balance5(){
        myTree.add(66);
        myTree.add(23);
        myTree.add(68);
        myTree.add(22);
        Assertions.assertEquals(true, myTree.totalBalanced());            //проверка на равенство
    }

    @Test
    public void test_balance6(){
        myTree.add(66);
        myTree.add(23);
        myTree.add(68);
        myTree.add(24);
        Assertions.assertEquals(true, myTree.totalBalanced());            //проверка на равенство
    }

    @Test
    public void test_balance7(){
        myTree.add(66);
        myTree.add(23);
        myTree.add(68);
        myTree.add(24);
        myTree.add(25);
        Assertions.assertEquals(false, myTree.totalBalanced());            //проверка на равенство
    }
}
