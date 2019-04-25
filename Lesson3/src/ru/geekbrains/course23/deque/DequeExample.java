package ru.geekbrains.course23.deque;

public class DequeExample {
    public static void main(String[] args) {
        DequeImpl deq = new DequeImpl(5);

        deq.insertFront(1);
        deq.insertFront(2);
        deq.insertFront(3);
        deq.insertFront(4);
        deq.insertFront(5);
        deq.insertFront(6);               //Overflow

        System.out.println(deq.deleteFront() + "\n"+
                deq.deleteFront() + "\n"+
                deq.deleteFront() + "\n"+
                deq.deleteFront() + "\n"+
                deq.deleteFront() + "\n"+
                deq.deleteFront() + "\n");      //Queue Underflow , null

//Haotic removal order
//        System.out.println(deq.deleteFront() + "\n"+
//                deq.deleteFront() + "\n"+
//                deq.deleteFront() + "\n"+
//                deq.deleteRear() + "\n"+
//                deq.deleteRear() + "\n"+
//                deq.deleteFront() + "\n");      //Queue Underflow , null

        DequeImpl deq2 = new DequeImpl(5);

        deq2.insertRear(7);
        deq2.insertRear(8);
        deq2.insertRear(9);
        deq2.insertRear(10);
        deq2.insertRear(11);
        deq2.insertRear(12);              //Overflow

        System.out.println(deq2.deleteRear() + "\n"+
                deq2.deleteRear() + "\n"+
                deq2.deleteRear() + "\n"+
                deq2.deleteRear() + "\n"+
                deq2.deleteRear() + "\n"+
                deq2.deleteRear() + "\n");      //Underflow , null
    }
}
