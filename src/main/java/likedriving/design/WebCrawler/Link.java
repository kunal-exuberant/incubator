package likedriving.design.WebCrawler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Link extends AbstractExtractedTag{

    @Override
    public String process(String text) {
        String tag = extractTag(text);
        return "<a href="+ tag +">"+tag+"</a>";
    }
}