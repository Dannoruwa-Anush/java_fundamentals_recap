package utils;

import java.util.Iterator;

import repository.IRepository;

public class RepositoryUtil {

    public static <T> void printRepo(IRepository<T> repo) {
        if (repo.getAll().isEmpty()) {
            System.out.println("No records found.");
            return;
        }

        Iterator<T> iterator = repo.getAll().iterator();
        
        while (iterator.hasNext()) {
            T item = iterator.next();
            System.out.println(item);
        }
    }
}
