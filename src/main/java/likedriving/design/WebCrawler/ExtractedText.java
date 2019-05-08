package likedriving.design.WebCrawler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 *   ExtractedText.processText() gives the desired output which is the processed text
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExtractedText implements TextProcessing{

    private String rawText;
    private TagStorageQueue storageQueue;

    public String processText(TagStorageQueue storageQueue) {
        AbstractExtractedTag tag;
        StringBuilder processedText = new StringBuilder(rawText);
        while (!storageQueue.isEmpty()) {
             tag = storageQueue.poll();
             String processedTag = tag.process(rawText);
             processedText.insert(tag.getBegin(), processedTag);
        }
        return processedText.toString();
    }
}
