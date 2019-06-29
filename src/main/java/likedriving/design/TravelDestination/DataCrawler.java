package likedriving.design.TravelDestination;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Files;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class DataCrawler {

    private static String baseDocumentDirectory
            = "/Users/kunalsingh.k/likedriving/src/main/java/likedriving/design/TravelDestination/documents";

    private static String url = "http://www.bangaloreorbit.com/trekking-in-karnataka/index.html";
    private static String baseUrl = "http://www.bangaloreorbit.com/trekking-in-karnataka/";

    public static Document getRemoteDocument(String url) throws IOException {

        File file = new File(getQualifiedFileName(url));
        if(file.exists()){
            //System.out.println("File exists. Fetching document from local");
            if(file.canRead()){
                return Jsoup.parse(Files.toString(new File(getQualifiedFileName(url)), Charsets.UTF_8));
            }else
            {
                //System.out.println("Unable to read the file");
                throw new IOException();
            }
        }
        else
        {
            System.out.println("File does not exists. Fetching document from remote");
            Document document = Jsoup.connect(url).get();

            File directory = new File(baseDocumentDirectory);

            if(directory.exists()) {
                File newFile = new File(directory, url.substring(url.lastIndexOf("/")));
                if (newFile.createNewFile()) {
                    System.out.println("new file created");
                }
                if (newFile.exists()) {
                    FileWriter fileWriter = new FileWriter(newFile);
                    if (newFile.canWrite()) {
                        System.out.println("able to write to new file");
                        fileWriter.write(document.toString());
                        fileWriter.close();
                    } else {
                        System.out.println("Unable to write to file");
                    }
                } else {
                    System.out.println("Unable to create new file");
                }
            }
            else{
                System.out.println("Base directory does not exists. Please create the directory");
            }
            return document;
        }
    }

    @Test
    public void createFile() throws IOException{
        System.out.println("trying to create a new file");
        File directory = new File("/Users/kunalsingh.k/likedriving/src/main/java/likedriving/design/TravelDestination/documents");
        if(directory.exists()){
            System.out.println("directory exists");
            File newFile = new File(directory, "web-Content");
            if(newFile.createNewFile()){
                System.out.println("new file created");
            }
            if(newFile.canWrite()){
                System.out.println("able to write to new file");
            }
            System.out.println(newFile);
        }
        else{
            System.out.println("directory does not exist");
        }
    }

    public static void main(String[] args) throws IOException{
        ESOperations.getClient();
        Document document = getRemoteDocument(url);
        Map<String, Destination> uniqueDesinationHrefs = DataExtractor.destinationHrefs(document);

        int lookUpLimit = 4000;
        int counter = 0;
        for(Map.Entry<String, Destination> mapEntry: uniqueDesinationHrefs.entrySet()){
            if(counter < lookUpLimit) {
                Document remoteDoc = getRemoteDocument(baseUrl + mapEntry.getKey());
                Destination.DESTINATION_ID =  RedisOperations.loadDestinationId();
                Destination destination = new Destination();
                destination.setId(++Destination.DESTINATION_ID);
                destination.setName(mapEntry.getKey().substring(0,mapEntry.getKey().indexOf("/")).replaceAll("-"," "));
                //destination.setDistance(DataExtractor.textBasedOnPattern(remoteDoc));

                DataExtractor.textBasedOnTag(remoteDoc, "p", destination);

                DataExtractor.textBasedOnString(remoteDoc, "Distances:", destination);

                destination.setAddress(new Address("Bangalore", "Karnataka"));

                destination.setType(Type.TREKKING);

                mapEntry.setValue(destination);
                //System.out.println(mapEntry.getKey());
                //System.out.println(destination);

                ObjectMapper objectMapper = new ObjectMapper();
                String destinationString = objectMapper.writeValueAsString(destination);

                System.out.println(destinationString);

                ESOperations.addDocument(destination.getName(), destinationString);
                RedisOperations.saveDestinationId();
                counter++;
            }
        }
        //System.out.println(elements);
    }


    public static String getFileName(String url){
        return url.substring(url.lastIndexOf("/"));
    }

    public static String getQualifiedFileName(String url){
        return baseDocumentDirectory+getFileName(url);
    }
}
