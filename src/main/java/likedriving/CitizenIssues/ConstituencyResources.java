package likedriving.CitizenIssues;

import org.junit.Test;
import javax.ws.rs.Path;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

@Path("/constituency")
public class ConstituencyResources {

    @Test
    public void getConstituencyInfo() throws IOException {
        //return elasticSearch.getConstituencyInfo(constituencyId);

        File constituencyDataFile = new File("/Users/kunalsingh.k/likedriving/src/main/java/likedriving/CitizenIssues/data/States.yml");

        //FileHandler f ileHandler = new FileHandler("/data/States.yml");



        System.out.println(constituencyDataFile.canRead());

        Scanner scanner = new Scanner(constituencyDataFile);

        while (scanner.hasNext()){
            System.out.println(scanner.next());
        }

       // return null;
    }

}
