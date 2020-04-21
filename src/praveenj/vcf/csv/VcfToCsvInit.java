package praveenj.vcf.csv;

import java.io.IOException;

public class VcfToCsvInit {
	public static void main(String[] args) {
		String folderPaths = args[0];
		String csv = args[1];

		try {

			String[] listFolders = folderPaths.split(",");
			String vcfPath = "";
			int i = 0;
			for (String str : listFolders) {
				vcfPath = str;
				csv = args[1] + "_" + (i++) + CsvContactWriter.CSV_EXTENSION;
				new VcfToCsvConverter(vcfPath, csv).convert();

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
