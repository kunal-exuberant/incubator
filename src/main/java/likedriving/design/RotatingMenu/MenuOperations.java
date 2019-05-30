package likedriving.design.RotatingMenu;

import java.io.IOException;

public interface MenuOperations<T> {

    void add(T item);
    void display() throws IOException;
    void commit() throws IOException;

}
