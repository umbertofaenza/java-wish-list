package org.learning.javawishlist;

public class Gift implements Comparable<Gift>{
    private String name;

    public Gift(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Gift{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Gift g) {
        return this.getName().compareTo(g.getName());
    }
}
