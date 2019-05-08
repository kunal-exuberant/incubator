package likedriving.design.WebCrawler;

public interface TagProcessing {
    String process(String text);
    String extractTag(String text);
}
