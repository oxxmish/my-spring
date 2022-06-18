import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import ru.sberbank.consumers.FileDocumentConsumer;
import ru.sberbank.model.CommonDocument;
import ru.sberbank.model.Document;
import ru.sberbank.model.DocumentInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(BlockJUnit4ClassRunner.class)
public class ConsumersTest {

    @Test
    public void test() {
        var fields = new HashMap<>(Map.of("type", "LETTER",
                "sender", "Michail",
                "recipient", "Maria",
                "text", "I need a doctor"));
        Document testDoc = new CommonDocument(new DocumentInfo(fields));
        var docs = List.of(testDoc, testDoc, testDoc);
        FileDocumentConsumer consumer = new FileDocumentConsumer();
        consumer.saveDocuments(docs);
    }
}
