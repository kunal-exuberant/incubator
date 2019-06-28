package likedriving.Java;

public class Indentation {

    public static void main(String args[]) {
        System.out.println("Hello World");
        String input = "public class PrettyPrint { public static void main(String args[]) { System.out.println(\"Hello World\"); String input = \"This is a sample code\"; System.out.println(Indent(input)); } public static String Indent(String input) { return \"Indented: \" + input; } }";
        String indentedString = Indent(input);
        System.out.println(indentedString);
    }

    public static String Indent(String input) {

        String indentedOutput = "";
        char []  chars = input.toCharArray();
        int tabCounter = 0;

        boolean newLine = false;
        for(char c: chars){

            String tabSpace = "";
            switch (c){

                case '{':

                    while(tabCounter > 0){
                        tabSpace += "\t";
                        tabCounter--;
                    }

                    indentedOutput +=    "\n\r" + tabSpace + c + "\n\r";
                    tabCounter += 4;
                    newLine = true;
                    break;
                case '}':

                    while(tabCounter > 0){
                        tabSpace += "\t";
                        tabCounter--;
                    }

                    indentedOutput +=   "\n\r" +tabSpace  + c + "\n\r";
                    //tabCounter -= 4;
                    newLine = true;

                    break;
                case ';':
                    indentedOutput +=   tabSpace + c + "\n\r";
                    newLine = true;

                break;

                default:
                    if(newLine) {
                        int tempTabCouter = tabCounter;
                        String tempTabSpace = "";
                        while(tempTabCouter > 0){
                            tempTabSpace += "\t";
                            tempTabCouter--;
                        }
                        indentedOutput += tempTabSpace + c;
                        newLine = false;
                    }
                    else
                        indentedOutput += tabSpace + c;
                break;
            }
        }

        //Code goes here
        return indentedOutput;
    }
}