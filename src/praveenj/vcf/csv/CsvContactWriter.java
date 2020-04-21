package praveenj.vcf.csv;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class CsvContactWriter implements ContactWriter {
    public static final String CSV_EXTENSION = ".csv";

    private File file;
    private PrintWriter writer;
    private FileOutputStream output;

    public CsvContactWriter(String cvsFile) throws FileNotFoundException {
        if (!cvsFile.endsWith(CSV_EXTENSION)) {
            cvsFile += CSV_EXTENSION;
        }
        this.file = new File(cvsFile);

        createNewCvs();
    }

    private void createNewCvs() throws FileNotFoundException {
        output = new FileOutputStream(file);
        writer = new PrintWriter(this.output);
        writer.println("First;Last;Mobile;Birthday");
        writer.flush();
    }

    @Override
    public void writeContact(Contact contact) throws IOException {
        writer.println(contact.toCsv());
        writer.flush();
    }

    public void close() throws IOException {
        output.close();
    }

    public ContactConsumer getConsumer() {
        return contact -> {
            try {
                CsvContactWriter.this.writeContact(contact);
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
    }

}
