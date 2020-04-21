package praveenj.vcf.csv;

import java.io.IOException;

public interface ContactWriter {
    public void writeContact(Contact contact) throws IOException;
}
