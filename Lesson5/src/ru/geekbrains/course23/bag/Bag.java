package ru.geekbrains.course23.bag;

public class Bag {
    private int capacity;           //вместимость сумки
    private int loaded;             //суммарный вес, поместившийся в сумку
    private int price;              //суммарная стоймость груза, уместившегося в сумку

    public Bag(int capacity) {
        this.capacity = capacity;
        this.loaded = 0;
        this.price = 0;
    }

    public int getBagCapacity() {
        return capacity;
    }

    public int getBagLoaded() {
        return loaded;
    }

    public int getBagPrice() {
        return price;
    }

    public void setBagLoaded(int loaded) {
        this.loaded = this.loaded + loaded;
    }

    public void setBagPrice(int price) {
        this.price = this.price + price;
    }

    public void bagReset() {
       this.loaded = 0;             //суммарный вес, поместившийся в сумку
        this.price = 0;             //суммарная стоймость груза, уместившегося в сумку
    }
}
