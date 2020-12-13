import Helpers.ReaderCSVFiles;
import org.junit.Test;

public class task3 {

    @Test
    public void readCSV() throws Exception {
        ReaderCSVFiles reader = new ReaderCSVFiles();
        reader.readCSVFiles();
        reader.getContracts().PrintContracts(reader.getContracts().getAll());
    }
}
