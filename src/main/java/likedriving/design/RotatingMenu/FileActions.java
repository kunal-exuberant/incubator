package likedriving.design.RotatingMenu;

import lombok.NoArgsConstructor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

@NoArgsConstructor
public class FileActions implements FileOperations {

    private String fileUrl;
    private Scanner sc;

    public FileActions(String fileUrl) throws IOException{
        this.fileUrl = fileUrl;
        this.sc = new Scanner(new File(fileUrl));
    }

    @Override
    public Object read() throws IOException {
        String fileContent ="";

        while(sc.hasNext()){
            fileContent +=  sc.nextLine() + "\n";
        }
        return fileContent;
    }

    @Override
    public void write(Object tuples) throws IOException{
        FileWriter fileWriter = new FileWriter(new File(fileUrl), true);
        fileWriter.append((String)tuples.toString());
        fileWriter.close();
    }

    public MenuItem scan(int itemId) throws IOException {
        String fileContent ="";

        while(sc.hasNextInt()){
            if(itemId ==  sc.nextInt()){
                fileContent = sc.next();
                return new MenuItem(itemId, fileContent);
            }
        }
        return null;
    }
}
