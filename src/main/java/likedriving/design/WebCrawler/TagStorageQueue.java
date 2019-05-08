package likedriving.design.WebCrawler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TagStorageQueue extends LinkedList<AbstractExtractedTag> {

}
