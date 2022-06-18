import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import ru.sberbank.producers.FileDocumentProducer;

@RunWith(BlockJUnit4ClassRunner.class)
public class ProducersTest {

    @Test
    public void test() {
        FileDocumentProducer fileDocumentProducer = new FileDocumentProducer();
        fileDocumentProducer.getDocuments();
    }
}
