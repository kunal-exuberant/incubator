package likedriving.JavaFundamentals;

import lombok.Data;

public class PassByValueOrReference {

    Life [] lifeArray = new Life[2];

    void createLife() {
        Life materialLife = new Life(Dimension.MATERIAL);
        modifyDimension(materialLife);
        printDimension(materialLife);
    }

    void modifyDimension(Life life){

        System.out.println(life.getDimension());
        life.setDimension(Dimension.SPIRITUAL);
    }

    void printDimension(Life life){
        System.out.println(life.getDimension());
    }

    public static void main(String[] args) {
        new PassByValueOrReference().createLife();
    }
}

@Data
class Life {
    private Dimension dimension;
    public Life(Dimension dimension){
        this.dimension = dimension;
    }
}

enum Dimension {
    MATERIAL,
    SPIRITUAL
}
