package likedriving.design.WebCrawler;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Entity extends AbstractExtractedTag{

    @Override
    public String process(String text) {
        String tag = extractTag(text);
        return "<strong>"+tag+"</strong>";
    }
}
