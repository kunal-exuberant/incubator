package likedriving.design.TravelDestination;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class DataCrawler {

    private static String url = "http://www.bangaloreorbit.com/trekking-in-karnataka/index.html";
    private static String baseUrl = "http://www.bangaloreorbit.com/trekking-in-karnataka/";

    public static Document getRemoteDocument(String url) throws IOException {
        return Jsoup.connect(url).get();
    }

    public static void main(String[] args) throws IOException{
        String remoteDocument = getRemoteDocument(url).toString();
       // System.out.println(remoteDocument);

        Document document = Jsoup.parse(remoteDocument);
        //System.out.println(document);
        Elements elements = document.getElementsByTag("tbody");

        Map<String, Destination> hrefs = new HashMap<>();

        elements.forEach(x->x.getElementsByTag("tr")
                    .forEach(y->y.getElementsByTag("td")
                        .forEach(z->z.getElementsByTag("a")
                            .forEach(a->a.getElementsByAttribute("href")
                                .forEach(b-> hrefs.put(b.attr("href"),null))))));


        int lookUpLimit = 3;
        int counter = 0;
        for(Map.Entry<String, Destination> mapEntry: hrefs.entrySet()){
            if(counter < lookUpLimit) {
                Document remoteDoc = getRemoteDocument(baseUrl + mapEntry.getKey());

                Elements elem = remoteDoc.getElementsByTag("tbody");

                Destination destination = new Destination();
                destination.setId(++Destination.DESTINATION_ID);
                destination.setName(remoteDoc.getElementsByTag("title").text());

     /*           elem.forEach(x->x.getElementsByTag("tr")
                        .forEach(y->y.getElementsByTag("td")
                                .forEach(z->z.getElementsByTag("p")
                                        .forEach(t-> destination.setDescription(t.text()))))); */

                elem.forEach(x->x.getElementsByTag("tr")
                        .forEach(y->y.getElementsByTag("td")
                                .forEach(z->z.getElementsContainingText("Distances:")
                                        .forEach(t-> System.out.println(t.text())))));

                System.out.println("********");

                String kmPattern = "(\\d+)\\s*((kilometers)|(km)|(kms)|(kilometres))*s(\\d+)";
                Pattern kmP = Pattern.compile(kmPattern);


                elem.forEach(x->x.getElementsByTag("tr")
                        .forEach(y->y.getElementsByTag("td")
                                .forEach(z->z.getElementsMatchingText (kmP)
                                        .forEach(t-> System.out.println(t.text())))));

                mapEntry.setValue(destination);
                System.out.println(destination);
                counter++;
            }
        }




        //System.out.println(elements);
    }
}
