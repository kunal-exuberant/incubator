package likedriving.design.LibraryManagementSystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book {

    private long id;
    private String title;
    private String author;

    public boolean equals(Object book){

        if(this.getClass().equals(book.getClass()) && this.id == ((Book)book).getId()){
            return true;
        }
        return false;
    }
}

