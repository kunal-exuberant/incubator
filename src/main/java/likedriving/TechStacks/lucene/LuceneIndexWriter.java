/*
package likedriving.TechStacks.lucene;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.clas*/
/**//*
sic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.BytesRef;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LuceneIndexWriter {

    private static final String LUCENE_PATH = "/Users/kunal.singh1/Documents/lucene";

    private static final String FILE_PATH = "/Users/kunal.singh1/Documents/ITComputaion.pdf";


    public Document createDocument(String firstName, String lastName, String description){

        Document document = new Document();
        document.add(new TextField("firstName", firstName, Field.Store.YES));
        document.add(new TextField("lastName", lastName, Field.Store.YES));
        document.add(new TextField("description", description, Field.Store.YES));
        return document;
    }

    public IndexWriter createIndex() throws IOException {

        FSDirectory fsDirectory = FSDirectory.open(Paths.get(LUCENE_PATH));
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(new StandardAnalyzer());
        IndexWriter indexWriter = new IndexWriter(fsDirectory, indexWriterConfig);
        return indexWriter;
    }

    public List<Document> searchIndex(Query query) throws IOException, ParseException {
        FSDirectory fsDirectory = FSDirectory.open(Paths.get(LUCENE_PATH));
        IndexReader indexReader = DirectoryReader.open(fsDirectory);
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);

        TopDocs topDocs = indexSearcher.search(query, 10);
        List<Document> documents = new ArrayList<>();

        for (ScoreDoc scoreDoc : topDocs.scoreDocs) {
            System.out.println(indexSearcher.doc(scoreDoc.doc));
            documents.add(indexSearcher.doc(scoreDoc.doc));
        }

        return documents;
    }

    public static void main(String[] args) throws IOException, ParseException {

        LuceneIndexWriter luceneIndexWriter = new LuceneIndexWriter();

        Document document = luceneIndexWriter.createDocument("Kunal", "Singh", "Kunal is a software engineer");
        IndexWriter indexWriter = luceneIndexWriter.createIndex();

        indexWriter.deleteAll();

        Document documentStream = new Document();

        FileReader fileReader = new FileReader((FILE_PATH));
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        documentStream.add(new TextField("firstName", "Manoj", Field.Store.YES));
        documentStream.add(new TextField("lastName", "Tiwari", Field.Store.YES));
        documentStream.add(new TextField("description", bufferedReader));

        indexWriter.addDocument(documentStream);
        indexWriter.commit();
        indexWriter.close();


        luceneIndexWriter.searchQueryTest();
        luceneIndexWriter.phraseQueryTest();
        luceneIndexWriter.fuzzyQueryTest();

    }

    public List<Document> searchQueryTest() throws IOException, ParseException {
        System.out.println("Searching the document using term query: ");
        Query query = new QueryParser("firstName", new StandardAnalyzer()).parse("kunal");
        List<Document> documents = searchIndex(query);
        documents.forEach(doc -> {
            System.out.println(doc.getField("description").stringValue());
        });
        return documents;
    }

    public List<Document> phraseQueryTest() throws IOException, ParseException {
        System.out.println("Searching the document using phrase query: ");
        Query query = new PhraseQuery(5, "description", new BytesRef("software"), new BytesRef("engineer"));
        List<Document> documents = searchIndex(query);
        documents.forEach(doc -> {
            System.out.println(doc.getField("firstName").stringValue());
        });
        return documents;
    }

    public List<Document> fuzzyQueryTest() throws IOException, ParseException {
        System.out.println("Searching the document using fuzzy query: ");
        Query query = new FuzzyQuery(new Term("firstName", "manoj"));
        List<Document> documents = searchIndex(query);
        documents.forEach(doc -> {
            System.out.println(doc.getField("firstName").stringValue());
        });
        return documents;
    }
}
*/
