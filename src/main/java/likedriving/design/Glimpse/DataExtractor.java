package likedriving.design.Glimpse;

import likedriving.design.Glimpse.models.Destination;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataExtractor {

    public static Map<String, Destination> destinationHrefs(Document document){

        Elements elements = document.getElementsByTag("tbody");
        Map<String, Destination> hrefs = new HashMap<>();
        elements.forEach(x->x.getElementsByTag("tr")
                .forEach(y->y.getElementsByTag("td")
                        .forEach(z->z.getElementsByTag("a")
                                .forEach(a->a.getElementsByAttribute("href")
                                        .forEach(b-> hrefs.put(b.attr("href"),null))))));
        return hrefs;
    }

    public static int textBasedOnPattern(Document document){

        String kmPattern = "(\\d+)\\s*((kilometers)|(km)|(kms)|(kilometres))";
        Pattern kmP = Pattern.compile(kmPattern);

        Elements elem = document.getElementsByTag("tbody");
        elem.forEach(x->x.getElementsByTag("tr")
                .forEach(y->y.getElementsByTag("td")
                        .forEach(z->z.getElementsMatchingText (kmP)
                                .forEach(t-> System.out.println(t.text())))));
        return 0;
    }

    public static void textBasedOnString(Document document, String searchString, Destination d){
        String kmPattern = "(\\d+)\\s*((kilometers)|(km)|(kms)|(kilometres))";
        Pattern kmP = Pattern.compile(kmPattern);
        Elements elem = document.getElementsByTag("tbody");
        elem.forEach(x->x.getElementsByTag("tr")
                .forEach(y->y.getElementsByTag("td")
                        .forEach(z->z.getElementsContainingText(searchString)
                                .forEach(p->p.getElementsMatchingText(kmP)
                                        .stream()
                                        .forEach(t-> Arrays.stream(t.text().split(" "))
                                                .filter(s->s.matches(kmPattern))
                                                .map(r->r.replaceAll("[^0-9]", ""))
                                                .forEach(e->d.setDistance(Integer.parseInt(e))))
                                                  ))));
    }

    public static List<Object> textBased(Document document, String searchString){
        String kmPattern = "(\\d+)\\s*((kilometers)|(km)|(kms)|(kilometres))";
        Pattern kmP = Pattern.compile(kmPattern);
        Elements elem = document.getElementsByTag("tbody");
        //Stream<String> matchedTextList =

        Stream s1 =
                elem.stream()
                .map(x->x.getElementsByTag("tr")
                        .stream()
                        .map(y->y.getElementsByTag("td")
                        .stream()
                                .map(z->z.getElementsContainingText(searchString)
                                .stream().map(t-> Arrays.stream(t.text().split(" "))
                                                .filter(s->s.matches(kmPattern))
                                                .map(r->r.replaceAll("[^0-9]", ""))
                                                .collect(Collectors.toList())
                                )
                        )
                ));

       return Collections.singletonList(s1);
    }

    public static void textBasedOnTag(Document document, String tag, Destination d) {
        Elements elem = document.getElementsByTag("tbody");
        elem.forEach(x -> x.getElementsByTag("tr")
                .forEach(y -> y.getElementsByTag("td")
                        .forEach(z -> z.getElementsByTag("p")
                                .forEach(t-> d.setDescription(d.getDescription()+t.text())))));
        d.setDescription(d.getDescription().substring(4));
    }

    public static String getTitle(Document document){
        return document.getElementsByTag("title").text();
    }
}
