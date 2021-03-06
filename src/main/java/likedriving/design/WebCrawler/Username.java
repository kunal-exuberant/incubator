package likedriving.design.WebCrawler;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Username extends AbstractExtractedTag{

    @Override
    public String process(String text) {
        String tag = extractTag(text);
        return "@<a href='http://twitter.com/'"+ tag +">"+tag+"</a>";
    }
}
