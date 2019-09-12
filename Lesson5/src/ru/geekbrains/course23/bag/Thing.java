package ru.geekbrains.course23.bag;

public class Thing {
    private int weight;     //вес предмета
    private int price;      //цена предмета

    public Thing(int weight, int price) {
        this.weight = weight;
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public boolean putInABag(Bag bag) {
        if( (bag.getBagLoaded()+this.weight) <= bag.getBagCapacity() ) {
            bag.setBagLoaded(bag.getBagLoaded() + this.weight);
            bag.setBagPrice(bag.getBagPrice() + this.price);
            return true;
        }
        return false;
    }
}
