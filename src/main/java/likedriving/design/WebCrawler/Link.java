package likedriving.design.WebCrawler;

public class Link extends AbstractExtractedTag{

    public Link(){
        super();
    }

    @Override
    public String process(String text) {
        String tag = extractTag(text);
        return "<a href="+ tag +">"+tag+"</a>";
    }
}