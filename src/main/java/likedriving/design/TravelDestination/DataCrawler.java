package likedriving.design.TravelDestination;

import likedriving.HelpBharat.District;
import likedriving.HelpBharat.State;
import likedriving.design.NewsFeed.Status;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class DataCrawler {

    private static String url = "http://www.bangaloreorbit.com/trekking-in-karnataka/index.html";
    private static String baseUrl = "http://www.bangaloreorbit.com/trekking-in-karnataka/";

    public static Document getRemoteDocument(String url) throws IOException {
        return Jsoup.connect(url).get();
    }

    public static void main(String [] a) throws IOException {
        url = "http://vlist.in/";
        String remoteDocument = getRemoteDocument(url).toString();

        Document document = Jsoup.parse(remoteDocument);
        Elements elements = document.getElementsByTag("tbody");

        int stateId = 1;
        List<State> states = new ArrayList<>();
        for(Element element: elements) {
            for(Element tr: element.getElementsByTag("tr")){
                for(Element td: tr.getElementsByTag("td")) {
                    for(Element href: td.getElementsByAttribute("href")) {
                        //System.out.println(href.text());
                        System.out.println(href.attr("href"));
                        for(Element dist: Jsoup.parse(getRemoteDocument(url+href.attr("href")).toString()).getElementsByAttribute("href")){
                            System.out.println(dist.text());

                        }
                    }
                }
            }
        }
    }

    public static List<State> extractStatesWithDistricts() throws IOException {
        url = "http://vlist.in/";
        String remoteDocument = getRemoteDocument(url).toString();

        Document document = Jsoup.parse(remoteDocument);
        Elements elements = document.getElementsByTag("tbody");

        int stateId = 1;
        int districtId = 40;
        List<State> states = new ArrayList<>();
        List<District> districts = new ArrayList<>();
        for(Element element: elements) {
            for(Element tr: element.getElementsByTag("tr")){
                for(Element td: tr.getElementsByTag("td")) {
                    for(Element href: td.getElementsByAttribute("href")) {
                        System.out.println(href.text());
                        states.add(State.builder()
                                .id(stateId)
                                .name(href.text())
                                .districts(districts)
                                .build());
                        stateId++;
                        System.out.println(href.attr("href"));
                        for(Element dist: Jsoup.parse(getRemoteDocument(url+href.attr("href")).toString()).getElementsByAttribute("href")){
                            System.out.println(dist.text());
                            districts.add(District.builder()
                                    .id(districtId)
                                    .name(dist.text())
                                    .build());
                            districtId++;
                        }
                    }
                }
            }
        }
        return states;
    }

    public static List<State> extractStates() throws IOException {
        url = "http://vlist.in/";
        String remoteDocument = getRemoteDocument(url).toString();

        Document document = Jsoup.parse(remoteDocument);
        Elements elements = document.getElementsByTag("tbody");

        int stateId = 1;
        List<State> states = new ArrayList<>();
        for(Element element: elements) {
            for(Element tr: element.getElementsByTag("tr")){
                for(Element td: tr.getElementsByTag("td")) {
                    for(Element href: td.getElementsByAttribute("href")) {
                        System.out.println(href.text());
                        states.add(State.builder()
                                .id(stateId)
                                .name(href.text())
                                .build());
                                stateId++;
                    }
                }
            }
        }
        return states;
    }

    public static void main1(String[] args) throws IOException{
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
