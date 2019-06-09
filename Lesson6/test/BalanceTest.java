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
        Assertions.assertEquals(true, myTree.find(23));
        Assertions.assertEquals(true, myTree.find(22));
        Assertions.assertEquals(true, myTree.find(24));
        Assertions.assertEquals(true, myTree.find(68));
        Assertions.assertEquals(true, myTree.find(69));

        Assertions.assertEquals(false, myTree.find(100));
        Assertions.assertEquals(false, myTree.find(0));
    }

    //различные варианты проветки баланса древьев
    @Test
    public void test_balance1_empty_tree(){                                                   //пустое древо
        Assertions.assertEquals(true, myTree.totalBalanced());            //проверка на равенство
    }

    @Test
    public void test_balance2_just_root(){                                                    //корень без потомков
        myTree.add(66);
        Assertions.assertEquals(true, myTree.totalBalanced());
    }

    @Test
    public void test_balance3(){
        myTree.add(66);

        myTree.add(65);             //Left

        Assertions.assertEquals(true, myTree.totalBalanced());
    }

    @Test
    public void test_balance4(){   //Mirror 3
        myTree.add(66);

        myTree.add(67);             //Right

        Assertions.assertEquals(true, myTree.totalBalanced());
    }

    @Test
    public void test_balance5(){
        myTree.add(66);

        myTree.add(65);             //Left
        myTree.add(67);

        Assertions.assertEquals(true, myTree.totalBalanced());
    }

    @Test
    public void test_balance6(){
        myTree.add(66);

        myTree.add(65);             //Left
        myTree.add(64);

        Assertions.assertEquals(false, myTree.totalBalanced());
    }

    @Test
    public void test_balance7(){   //Mirror 6
        myTree.add(66);

        myTree.add(67);             //Right
        myTree.add(68);

        Assertions.assertEquals(false, myTree.totalBalanced());
    }

    @Test
    public void test_balance8(){
        myTree.add(66);

        myTree.add(65);             //Left
        myTree.add(64);

        myTree.add(67);             //Right

        Assertions.assertEquals(true, myTree.totalBalanced());
    }

    @Test
    public void test_balance9(){   //Mirror 8
        myTree.add(66);

        myTree.add(65);             //Left
        myTree.add(67);

        myTree.add(68);             //Right

        Assertions.assertEquals(true, myTree.totalBalanced());
    }

    @Test
    public void test_balance10(){
        myTree.add(66);

        myTree.add(64);             //Left
        myTree.add(65);
        myTree.add(63);

        myTree.add(67);             //Right

        Assertions.assertEquals(false, myTree.totalBalanced());
    }

    @Test
    public void test_balance11(){   //Mirror 10
        myTree.add(66);

        myTree.add(65);             //Left

        myTree.add(68);             //Right
        myTree.add(67);
        myTree.add(69);

        Assertions.assertEquals(false, myTree.totalBalanced());
    }

    @Test
    public void test_balance12(){
        myTree.add(66);

        myTree.add(65);             //Left
        myTree.add(64);
        myTree.add(63);

        myTree.add(68);             //Right
        myTree.add(67);

        Assertions.assertEquals(false, myTree.totalBalanced());
    }

    @Test
    public void test_balance13(){
        myTree.add(66);

        myTree.add(65);             //Left
        myTree.add(63);
        myTree.add(64);

        myTree.add(68);             //Right
        myTree.add(67);

        Assertions.assertEquals(false, myTree.totalBalanced());
    }

    @Test
    public void test_balance14(){
        myTree.add(66);

        myTree.add(63);             //Left
        myTree.add(65);
        myTree.add(64);

        myTree.add(67);             //Right
        myTree.add(68);

        Assertions.assertEquals(false, myTree.totalBalanced());
    }

    @Test
    public void test_balance15(){   //Mirror 12
        myTree.add(66);

        myTree.add(64);             //Left
        myTree.add(65);

        myTree.add(67);             //Right
        myTree.add(68);
        myTree.add(69);

        Assertions.assertEquals(false, myTree.totalBalanced());
    }

    @Test
    public void test_balance16(){   //Mirror 13
        myTree.add(66);

        myTree.add(64);             //Left
        myTree.add(65);

        myTree.add(67);             //Right
        myTree.add(68);
        myTree.add(69);

        Assertions.assertEquals(false, myTree.totalBalanced());
    }

    @Test
    public void test_balance17(){   //Mirror 14
        myTree.add(66);

        myTree.add(65);             //Left
        myTree.add(64);

        myTree.add(69);             //Right
        myTree.add(67);
        myTree.add(68);

        Assertions.assertEquals(false, myTree.totalBalanced());
    }
}
