package ru.geekbrains.course23.hw5onlesson6;

public class Item {

    String name;
    int weight;
    int price;

    public Item(String name, int weight, int price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (weight != item.weight) return false;
        if (price != item.price) return false;
        return name != null ? name.equals(item.name) : item.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + weight;
        result = 31 * result + price;
        return result;
    }
}
