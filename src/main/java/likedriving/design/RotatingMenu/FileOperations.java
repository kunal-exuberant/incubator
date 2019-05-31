package likedriving.design.RotatingMenu;

import java.io.IOException;

public interface FileOperations<T> {

    T read() throws IOException;
    void write(T tuples) throws IOException ;
    MenuItem scan(int itemId) throws IOException;
    int getLastMenuItemId() throws IOException;
}
