import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
//6 tests - 2 for blob, 3 for index 
//check file content 
//check file location
//check index and objects
//adds blob to index file 
//removes blob from index file
//multiple adds and at least 1 remove
class JUnitBlobTest {
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		File foldert = new File("test");
		foldert.mkdirs();
		File foldero = new File("test/objects");
		foldero.mkdirs();
		PrintWriter writer = new PrintWriter("test/txt.txt");
		writer.println("some content");
		writer.close();
		PrintWriter writer1 = new PrintWriter("test/txt1.txt", "UTF-8");
		writer1.println("some content1");
		writer1.close();
		PrintWriter writer2 = new PrintWriter("test/txt2.txt", "UTF-8");
		writer2.println("some content2");
		writer2.close();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
//		File f = new File("test/txt.txt");
//		f.delete();
//		File f1 = new File("test/txt1.txt");
//		f1.delete();
//		File f2 = new File("test/txt2.txt");
//		f2.delete();
//		File index = new File("test/index.txt");
//		index.delete();
//		File folder = new File("test/objects");
//		folder.delete();
	}

	@Test
	void blobFileContent() {
//		Blob b = new Blob("txt.txt");
//		File f = new File("test/objects/94e66df8cd09d410c62d9e0dc59d3a884e458e05");
//		assertTrue(f.exists());//checks if file named the sha1 of some content exists in objects
	}
	
	@Test
	void checkIndexAndObjects() throws IOException {
		Index index = new Index();
		index.openFile();//maybe write this into the index.java class initiator/add method
		index.init();
		index.add("txt1.txt");
		index.add("txt.txt");
		index.add("txt2.txt");
		assertTrue(new File("94e66df8cd09d410c62d9e0dc59d3a884e458e05.txt").exists());
		assertTrue(new File("e2a34d27ec895d3921f201a107386c9fc67b9885.txt").exists());
		assertTrue(new File("79eec2bd89a58604dc3f0537108b07200e894d79.txt").exists());
//		index.closeFile();
		index.remove("txt.txt");
		index.remove("txt1.txt");
		index.remove("txt2.txt");
		assertTrue(!new File("94e66df8cd09d410c62d9e0dc59d3a884e458e05.txt").exists());
		assertTrue(!new File("e2a34d27ec895d3921f201a107386c9fc67b9885.txt").exists());
		assertTrue(!new File("79eec2bd89a58604dc3f0537108b07200e894d79.txt").exists());
	}
	
	@Test
	void test() {
		System.out.println("hello2");
	}

}
