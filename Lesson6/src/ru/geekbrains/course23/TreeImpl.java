package ru.geekbrains.course23;

import java.util.Stack;

public class TreeImpl<E extends Comparable<? super E>> implements Tree<E> {

    private Node<E> root;   //корень

    @Override
    public boolean add(E value) {
        if ( isEmpty() ) {
            root = new Node<> (value);
            return true;
        }

        NodeAndPrevious nodeAndPrevious = doFind(value);
        Node<E> previous = nodeAndPrevious.previous;


        if(previous.shouldBeLeft(value)) {
            previous.setLeftChild(new Node<> (value));
        } else {
            previous.setRightChild(new Node<> (value));
        }

        return true;
    }

    @Override
    public boolean remove(E value) {
        NodeAndPrevious nodeAndPrevious = doFind(value);
        Node<E> removedNode = nodeAndPrevious.current;
        Node<E> parent = nodeAndPrevious.previous;

        if(removedNode == null) {
            return false;
        }

        if( removedNode.isLeaf() ) {                           //если узел пустой
            if( removedNode == root ) { //если это корень
                root = null;
            } else if ( parent.getLeftChild() == removedNode ) {
                parent.setLeftChild(null);
            } else{
                parent.setRightChild(null);
            }
        } else if (hasOnlySingleChildNode(removedNode)) {      //если есть только один дочерний элемент
            Node<E> childNode = removedNode.getLeftChild() != null
                    ? removedNode.getLeftChild()
                    : removedNode.getRightChild();

            if( removedNode == root ) {  //если это корень
                root = childNode;
            } else if ( parent.getLeftChild() == removedNode ) {
                parent.setLeftChild(childNode);
            } else{
                parent.setRightChild(childNode);
            }
        } else {                                            //если дочерних элементов несколько
            Node<E> successor = getSuccessor(removedNode);  //идеальный кандидат под замену удаляемого элемента
            if (removedNode == root) {                      //если удаляемый элемент - корень
                root = successor;
            }
            else if (parent.getLeftChild() == removedNode) {
                parent.setLeftChild(successor);
            }
            else {
                parent.setRightChild(successor);
            }
            successor.setLeftChild(removedNode.getLeftChild());
        }

        return true;
    }

    //метод подбора идеального кандидата для замены удаляемого элемента
    private Node<E> getSuccessor(Node<E> removedNode) {
        Node<E> successor = removedNode;
        Node<E> successorParent = null;  //сохранение правого child удаляемого элемента
        Node<E> current = removedNode.getRightChild();

        while(current != null) {            //переход к самому нижнему лемому элементу
            successorParent = successor;
            successor = current;
            current = current.getLeftChild();
        }
        if (successor != removedNode.getRightChild()) {
            successorParent.setLeftChild(successor.getRightChild());    //перенос правых элементов из перенесенного левого
            successor.setRightChild(removedNode.getRightChild());       //изменение rightChild для перенесенного наверх элемента вместо удаленного
        }

        return successor;
    }

    //проверка, один ли дочерний элемент у удаляемого элемента
    private boolean hasOnlySingleChildNode(Node<E> currentNode) {
        return currentNode.getLeftChild() != null ^ currentNode.getRightChild() != null;
    }

    @Override
    public boolean find(E value) {
        NodeAndPrevious nodeAndPrevious = doFind(value);
        return nodeAndPrevious.current != null;
    }

    private NodeAndPrevious doFind(E value) {
        Node<E> previous = null;
        Node<E> current = root;
        while(current != null) {
            if( current.getValue().equals(value) ) {        //если встретился эквивалентный элемент, добавить не удастся
                return new NodeAndPrevious(current, previous);
            }

            previous = current;
            if (current.shouldBeLeft(value)) {
                current = current.getLeftChild();
            }
            else {
                current = current.getRightChild();
            }
        }

        return new NodeAndPrevious(null, previous);
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public void display() {
        Stack<Node> globalStack = new Stack<>();
        globalStack.push(root);
        int nBlanks = 64;

        boolean isRowEmpty = false;
        System.out.println("......................................................");

        while (!isRowEmpty) {
            Stack<Node> localStack = new Stack<>();

            isRowEmpty = true;
            for(int i=0; i<nBlanks; i++){
                System.out.print(" ");
            }

            while (!globalStack.isEmpty()) {
                Node tempNode = globalStack.pop();
                if (tempNode != null){
                    System.out.print(tempNode.getValue());
                    localStack.push(tempNode.getLeftChild());
                    localStack.push(tempNode.getRightChild());
                    if(tempNode.getLeftChild() != null || tempNode.getRightChild() != null){
                        isRowEmpty = false;
                    }
                }else{
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for(int j=0; j < nBlanks * 2 - 2; j++) {
                    System.out.print(" ");
                }
            }
            System.out.println();

            while (!localStack.isEmpty()) {
                globalStack.push(localStack.pop());
            }

            nBlanks /= 2;
        }
        System.out.println("......................................................");
    }

    @Override
    public void traverse(TraverseMode traverseMode) {
        switch (traverseMode) {
            case IN_ORDER:
                inOrder(root);
                break;
            case PRE_ORDER:
                preOrder(root);
                break;
            case POST_ORDER:
                postOrder(root);
                break;
            default:
                throw new IllegalArgumentException("Unknown traverse mode " + traverseMode);
        }
    }

    private void inOrder(Node<E> node) {
        if(node == null) {
            return;
        }
        inOrder(node.getLeftChild());
        System.out.println(node);
        inOrder(node.getRightChild());
    }

    private void preOrder(Node<E> node) {
        if(node == null) {
            return;
        }
        System.out.println(node);
        inOrder(node.getLeftChild());
        inOrder(node.getRightChild());
    }

    private void postOrder(Node<E> node) {
        if(node == null) {
            return;
        }
        inOrder(node.getLeftChild());
        inOrder(node.getRightChild());
        System.out.println(node);
    }

    class NodeAndPrevious {
        Node<E> current;
        Node<E> previous;

        public NodeAndPrevious(Node<E> current, Node<E> previous) {
            this.current = current;
            this.previous = previous;
        }
    }
}
