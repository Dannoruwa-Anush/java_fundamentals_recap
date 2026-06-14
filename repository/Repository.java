package repository;

import java.util.ArrayList;
import java.util.List;

public class Repository<T> {
    /**
     * This is a Generic class (can work with different data types while providing type safety and reducing code duplication)
     */

    private List<T> items;

    // all arg constrctor
    public Repository(){
        items = new ArrayList<>(); // polymorphism via an interface
    }

    public void add(T item){
        items.add(item);
    }

    public void remove(T item){
        items.remove(item);
    }

    public List<T> getAll(){
        return items;
    }
}
