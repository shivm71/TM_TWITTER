package com.twitter.model;

// Entity
// Comparator method also can be used
public class HTags implements Comparable<HTags> {

    // id
    private String name;
    private int freq;

    // if two freq is equal than we will provide more recent
    private int time;
    // for uniqueness
    private static int TIME = 1;

    public HTags(String name) {

        // one more layer of validation can be add
        setName(name);
        this.freq = 1;
        setTime();
    }

    // id can be set only once
    private void setName(String name) {
        this.name = name;
    }

    public void setTime() {
        this.time = TIME++;
    }

    public String getName() {
        return name;
    }

    public int getFreq() {
        return freq;
    }

    public void setFreq(int freq) {
        this.freq = freq;
    }

    public int getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "HashTag{" +
                "name='" + name + '\'' +
                ", freq=" + freq +
                ", time=" + time +
                '}';
    }

    // compareTo method will used in TreeSet for comparing the objects
    @Override
    public int compareTo(HTags obj) {

        if (this.name.equals(obj.getName())) {
            return 0;
        }

        if (this.freq == obj.freq) {
            return obj.time - this.time;
        }
        return obj.getFreq() - this.getFreq();
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return name.equals(((HTags) obj).getName());
    }
}
