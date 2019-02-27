package org.tcmfile.hbase.script;

import java.io.IOException;

import org.tcmfile.hbase.SaveFiles;

public class SaveFileScript {
	public static void main(String args[]) throws IOException {
		new SaveFiles().saveFolderFiles("book", "book-holder", "content", "json");
	}
}
