package likedriving.design.WebCrawler;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.LinkedList;

@AllArgsConstructor
@Data
public class TagStorageQueue extends LinkedList<AbstractExtractedTag> {

}
