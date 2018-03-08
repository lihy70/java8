package net.java;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.landawn.abacus.util.Fn;
import com.landawn.abacus.util.IOUtil;

public class Java8 {
	
	@Test
	public void test_02() {
		File file = new File("/Users/haiyangl/java8/Search | Splunk 6.6.4.html");
		IOUtil.readLines(file).forEach(Fn.println());
	}

	@Test
	public void test_01() throws IOException {

		try (Closeable a = new ResourceA(); Closeable b = new ResourceB();) {
			System.out.println("doing something");
			throw new RuntimeException();
		}
	}

	public static class ResourceA implements Closeable {

		@Override
		public void close() throws IOException {
			System.out.println("Closing resource A");
		}
	}

	public static class ResourceB implements Closeable {

		public ResourceB() {
			// throw new RuntimeException();
		}

		@Override
		public void close() throws IOException {			 
			System.out.println("Closing resource B");
			throw new RuntimeException();
		}
	}
}
