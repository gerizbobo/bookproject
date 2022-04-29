package repository;

import java.util.List;

public interface Repository<T,ID> {
    T create(T t);

    List<T> readAll();

    T read(ID id);

    T update(T t);

    void delete(T t);


}
