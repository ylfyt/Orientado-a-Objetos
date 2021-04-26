package application.classes;

import java.util.*;

public class Inventory<U> {
    private static int max_capacity = 50;
    protected static int current_capacity;
    protected List<U> bag;
    protected List<Integer> bagCount;

    Inventory() {
        bag = new ArrayList<>();
        bagCount = new ArrayList<>();
        current_capacity = 0;
    }

    public int get_max_capacity() {
        return max_capacity;
    }

    public int get_total_stored_item() {
        return current_capacity;
    }

    public void set_max_capacity(int newmax) {
        max_capacity = newmax;
    }

    public List<U> getInventory() {
        return this.bag;
    }

    public List<Integer> getInventoryCount() {
        return this.bagCount;
    }

    public U getInventory(int index) {
        return this.bag.get(index);
    }

    public Integer getInventoryCount(int index) {
        return this.bagCount.get(index);
    }

    public void addInventory(U items) throws Exception {
        if (current_capacity >= max_capacity) {
            throw new Exception("Inventory Penuh!");
        } else if (current_capacity > 0) {
            for (int i = 0; i < this.bag.size(); i++) {
                if (isEqual(this.bag.get(i), items)) {
                    int temp = this.bagCount.get(i);
                    this.bagCount.set(i, (temp + 1));
                    current_capacity++;
                    return;
                }
            }
        }
        current_capacity++;
        this.bagCount.add(1);
        this.bag.add(items);
    }

    public boolean isEqual(U item1, U item2)
    {
        if (item1 instanceof Engimon)
        {
            return Engimon.isEqual((Engimon) item1, (Engimon) item2);
        }
        else
        {
            return Skill.isEqual((Skill) item1, (Skill) item2);
        }
    }

    public void removeInventory(int index) {
        if (bagCount.get(index) > 1) {
            bagCount.set(index, (bagCount.get(index) - 1));
            return;
        }
        bag.remove(index);
        bagCount.remove(index);
    }

    public void removeInventory(int index, int amount) {
        int res = bagCount.get(index) - amount;

        if (res > 0) {
            bagCount.set(index, (bagCount.get(index) - amount));
            return;
        }
        bag.remove(index);
        bagCount.remove(index);
    }

    public boolean isEmpty() {
        return this.bag.isEmpty();
    }
}