package ch3;

import java.util.LinkedList;

public class Solution36 {


    // maintain two LinkedList catList and DogList
    // attached each Animal with a name and a index, which indicated when this animal was added
    // when dequeueAny(), we compare two first Animal's index and return the Animal with least index;

    class Animal {
        private String name;
        private int index;
        private LinkedList<Animal> list;

        public Animal(String name) {
            this.name = name;
        }
    }

    private LinkedList<Animal> dogList;
    private LinkedList<Animal> catList;
    private int currentIndex = 0;

    public Solution36() {
        dogList = new LinkedList<>();
        catList = new LinkedList<>();
    }

    public void enqueue(String str) {
        Animal current = new Animal(str);
        current.index = currentIndex++;

        if (str.substring(0,3).equals("cat")) {
            current.list = catList;
            catList.add(current);
        } else {
            current.list = dogList;
            dogList.add(current);
        }
    }

    public String dequeueAny() {
        Animal cat = catList.getFirst();
        Animal dog = dogList.getFirst();

        Animal dequeue = cat.index < dog.index ? cat : dog;
        return dequeue.list.remove(0).name;

    }

    public String dequeueDog() {
        return dogList.pop().name;
    }

    public String dequeueCat() {
        return catList.pop().name;
    }

    // Test Method Below

    public static void main(String[] args) {
        Solution36 shelter = new Solution36();

        for (int i = 0; i < 40; i++) {
            if (i % 3 == 0) {
                shelter.enqueue("dog -> " + i);
                System.out.println("enqueued dog -> " +i);
            } else {
                shelter.enqueue("cat -> " + i);
                System.out.println("enqueued cat -> " + i);
            }
        }


        System.out.println("dequeueAny");
        System.out.println(shelter.dequeueAny());
        System.out.println(shelter.dequeueAny());
        System.out.println(shelter.dequeueAny());
        System.out.println(shelter.dequeueAny());
        System.out.println(shelter.dequeueAny());
        System.out.println(shelter.dequeueAny());
        System.out.println(shelter.dequeueAny());
        System.out.println(shelter.dequeueAny());
        System.out.println(shelter.dequeueAny());
        System.out.println(shelter.dequeueAny());
        System.out.println(shelter.dequeueAny());
        System.out.println(shelter.dequeueAny());
        System.out.println("dequeueCat");
        System.out.println(shelter.dequeueCat());
        System.out.println(shelter.dequeueCat());
        System.out.println(shelter.dequeueCat());
        System.out.println(shelter.dequeueCat());
        System.out.println(shelter.dequeueCat());
        System.out.println("dequeueDog");
        System.out.println(shelter.dequeueDog());
        System.out.println(shelter.dequeueDog());
        System.out.println(shelter.dequeueDog());
        System.out.println(shelter.dequeueDog());
        System.out.println(shelter.dequeueDog());
        System.out.println(shelter.dequeueDog());
        System.out.println(shelter.dequeueDog());
        System.out.println(shelter.dequeueDog());

    }
}
