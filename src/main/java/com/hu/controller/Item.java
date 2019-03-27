package com.hu.controller;

import java.util.Objects;

public class Item implements Comparable<Item> {

    private String description;

    private int partNumber;

    public Item(String description, int partNumber) {
        this.description = description;
        this.partNumber = partNumber;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Item{" +
                "description='" + description + '\'' +
                ", partNumber=" + partNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
       if (this == o){
           return true;
       }
        if (o == null) {
           return false;
        }
        if (getClass() != o.getClass()) {
           return false;
        }
        Item other = (Item) o;
       return Objects.equals(description,other.description) && partNumber == other.partNumber;

    }

    @Override
    public int hashCode() {

        return Objects.hash(description, partNumber);
    }

    @Override
    public int compareTo(Item other) {
        int diff = Integer.compare(partNumber,other.partNumber);
        return diff != 0 ? diff : description.compareTo(other.description);
    }
}
