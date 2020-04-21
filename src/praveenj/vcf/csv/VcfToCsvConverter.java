package praveenj.vcf.csv;

import java.io.File;
import java.io.IOException;

public class VcfToCsvConverter {
	private String vcfFilesPath;
	private String cvsFile;

	public VcfToCsvConverter(String vcfFilesPath, String cvsFile) {
		this.vcfFilesPath = vcfFilesPath;
		this.cvsFile = cvsFile;
	}

	public void convert() throws IOException {
		VcfFolderReader reader = new VcfFolderReader(new File(vcfFilesPath));
		CsvContactWriter writer = new CsvContactWriter(cvsFile);
		reader.readContact(writer.getConsumer());
		writer.close();
	}

}
