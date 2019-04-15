package likedriving;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WebCrawler {

    private static String url = "https://www.thrillophilia.com/night-trekking-in-bangalore";

    public static Document getRemoteDocument() throws IOException {
        return Jsoup.connect(url).get();
    }

    public static void main(String[] args) throws IOException{
        String remoteDocument = getRemoteDocument().toString();
        //System.out.println(remoteDocument);
        //String sentence = remoteDocument.substring(remoteDocument.indexOf("Skandgiri"), remoteDocument.indexOf("Skandgiri") + 40);
        //System.out.println(sentence);

        List<String> imgUrlList = new ArrayList<String>();

        //for()
        String imgUrl;
        for(String word: remoteDocument.split(" ")) {
            imgUrl = extractString(word, "<img src=\"", "\">");
            if(!imgUrl.isEmpty()) {
                imgUrlList.add(imgUrl);
            }
        }
        //imgUrlList.add(extractString(remoteDocument, "alt=\"", "\">"));

        printList(imgUrlList);
    }

    private static String extractString(String word, String startString, String endString){
        int startIndex = 0, endIndex = 0;
        if(word.indexOf(startString) > 0){
            startIndex = word.indexOf(startString);
        }
        if(word.substring(startIndex).indexOf(endString) > 0) {
            endIndex = startIndex + word.substring(startIndex).indexOf(endString);
        }

        return word.substring(startIndex, endIndex);
    }

    private static void printList(List<String> list){
        for(String imgUrl: list) {
            System.out.println(imgUrl);
        }
    }
}
