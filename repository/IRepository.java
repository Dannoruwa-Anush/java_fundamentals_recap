package repository;

import java.util.Collection;

public interface IRepository<T> {
    /**
     * This is a Generic interface (can work with different data types while providing type safety and reducing code duplication)
     */
    
    public abstract void add(T item);
    public abstract void remove (T item);
    public abstract Collection<T> getAll();
}
