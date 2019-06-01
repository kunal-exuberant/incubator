package likedriving.design.RotatingMenu;

import java.util.ArrayList;
import java.util.List;

public class MenuItemValidator {

    public static List<String> validate(String enteredMenuItem){

        List<String> validationError = new ArrayList<>();

        if(enteredMenuItem.length() > 25) {
            validationError.add("Error: Menu item length can be at most 25 characters");
        }
        if(!enteredMenuItem.matches("[a-z ]+")) {
            validationError.add("Error: Menu item must only contain alphabets");
        }

        return validationError;
    }

}
