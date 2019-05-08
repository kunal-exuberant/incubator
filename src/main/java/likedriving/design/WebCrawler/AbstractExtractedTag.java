package likedriving.design.WebCrawler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/*
* A common class to support all tags which needs to be captured like links, entities and user names.
*
*/
@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class AbstractExtractedTag implements TagProcessing{
    private int begin;
    private int end;
    public String extractTag(String text) {
        return text.substring(this.getBegin(), this.getEnd()+1);
    }
}
