package praveenj.vcf.csv;

import java.io.IOException;

public interface ContactReader {
	public void readContact(ContactConsumer consumer) throws IOException;
}
