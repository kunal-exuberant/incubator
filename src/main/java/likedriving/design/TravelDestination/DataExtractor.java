package likedriving.design.TravelDestination;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.HashMap;
import java.util.Map;

public class DataExtractor {

    public static void distance() {
/*

                    elem.forEach(x->x.getElementsByTag("tr")
            .

    forEach(y->y.getElementsByTag("td")
            .

    forEach(d->d.getElementsByTag("b").

    next().
*/

    //forEach(System.out::println))));
    //.forEach(z->z.getElementsByTag("p")
    //      .forEach(t -> System.out.println("\n"+t.text())))));
    }


    public static void destinationHrefs(Document document){

        Elements elements = document.getElementsByTag("tbody");

        Map<String, String> hrefs = new HashMap<>();

        elements.forEach(x->x.getElementsByTag("tr")
                .forEach(y->y.getElementsByTag("td")
                        .forEach(z->z.getElementsByTag("a")
                                .forEach(a->a.getElementsByAttribute("href")
                                        .forEach(b-> hrefs.put(b.attr("href"),null))))));

    }
}
