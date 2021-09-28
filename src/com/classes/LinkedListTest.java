package com.classes;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @org.junit.jupiter.api.Test
    void testAddFirst() {
        LinkedList<Integer> driver = new LinkedList<>();
        for (int i = 0; i < 20; i += 3) {
            driver.addFirst(i);
        }
        assertEquals("18 15 12 9 6 3 0", driver.toString());
        assertEquals(7, driver.size());
    }

    @org.junit.jupiter.api.Test
    void testAddLast() {
        LinkedList<Integer> manager = new LinkedList<>();
        for (int i = 0; i < 20; i += 3) {
            manager.addLast(i);
        }
        assertEquals("0 3 6 9 12 15 18", manager.toString());
        assertEquals(7, manager.size());
    }

    @org.junit.jupiter.api.Test
    void testAdd() {
        try {
            LinkedList<String> names = new LinkedList<>();
            names.addLast("Raya");
            names.addLast("Tina");
            names.addLast("Nika");
            names.addLast("Sharlin");
            names.add(10, "Melissa");
            assertEquals("Raya Tina Nika Sharlin", names.toString());
            assertEquals(4, names.size());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @org.junit.jupiter.api.Test
    void testRemove() {
        try {
            LinkedList<String> names = new LinkedList<>();
            names.addLast("Raya");
            names.addLast("Tina");
            names.addLast("Nika");
            names.addLast("Sharlin");
            names.remove("Sharlin");
            assertEquals("Raya Tina Nika", names.toString());
            assertEquals(3, names.size());
            names.remove("Angelina");
            assertEquals("Raya Tina Nika", names.toString());
            assertEquals(3, names.size());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @org.junit.jupiter.api.Test
    void testRemoveFirst() {
        try {
            LinkedList<Integer> age = new LinkedList<>();
            age.addLast(15);
            age.addLast(22);
            age.addFirst(17);
            age.add(1, 145);
            age.removeFirst();
            assertEquals("145 15 22", age.toString());
            assertEquals(3, age.size());
            LinkedList<Integer> ageClear = new LinkedList<>();
            ageClear.removeFirst();
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    @org.junit.jupiter.api.Test
    void testRemoveLast() {
        try {
            LinkedList<Integer> age = new LinkedList<>();
            age.addLast(15);
            age.addLast(22);
            age.addFirst(17);
            age.add(1, 145);
            age.removeLast();
            assertEquals("17 145 15", age.toString());
            assertEquals(3, age.size());
            LinkedList<Integer> ageClear = new LinkedList<>();
            ageClear.removeLast();
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @org.junit.jupiter.api.Test
    void testRemoveByIndex() {
        try {
            LinkedList<Double> height = new LinkedList<>();
            height.addLast(167.3);
            height.addLast(162.1);
            height.addLast(190.19);
            height.addLast(150.84);
            height.removeByIndex(3);
            height.removeByIndex(1);
            height.removeByIndex(10);
            assertEquals("167.3 190.19", height.toString());
            assertEquals(2, height.size());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @org.junit.jupiter.api.Test
    void clear() {
        LinkedList<Double> height = new LinkedList<>();
        height.addLast(167.3);
        height.addLast(162.1);
        height.addLast(190.19);
        height.addLast(150.84);
        height.clear();
        assertEquals("", height.toString());
        assertEquals(0, height.size());
        height.clear();
    }

    @org.junit.jupiter.api.Test
    void get() {
        try {
            LinkedList<String> names = new LinkedList<>();
            names.addLast("Raya");
            names.addLast("Tina");
            names.addLast("Nika");
            names.addLast("Sharlin");
            assertEquals("Nika",names.get(2));
            names.get(15);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}