package likedriving.design.LibraryManagementSystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {
    private long id;
    private User placedBy;
    private List<Book> bookList;
    private Long timestamp;
}
