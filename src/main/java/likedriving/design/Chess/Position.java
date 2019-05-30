package likedriving.design.Chess;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Position {
    private int x;
    private int y;

    public boolean equals(Object object){
        return this.getX() == ((Position)object).getX() && this.getY() == ((Position)object).getY();
    }
}
