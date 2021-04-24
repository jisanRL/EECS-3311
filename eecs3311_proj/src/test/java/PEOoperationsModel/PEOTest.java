package PEOoperationsModel;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PEOTest {
	
	PEO peo;
	private static String path = "../eecs3311_proj/CSVs/bookingpeo.csv";				

	@Test
	public void test() {
		peo = new PEO();
//		fail("Not yet implemented");
	}
	
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	@SuppressWarnings("unused")
	public void add_spaces() throws IOException {
		String spotName = "";
		if (spotName == null) {
			expectedEx.expectMessage("spotName is null");
		} else {
			peo.addSpaces(spotName);
			expectedEx.expectMessage("spotName is not null");
		}
	}
	
	@Rule
	public ExpectedException expectedEx2 = ExpectedException.none();
	@SuppressWarnings("unused")
	public void remove_spaces() {
		String spotName = "";
		if (spotName == null) {
			expectedEx.expectMessage("spotName is null");
		} else {
			peo.removeSpaces(spotName);
			expectedEx.expectMessage("spotName is not null");
		}
	}
	
	@Rule
	public ExpectedException expectedEx3 = ExpectedException.none();
	@SuppressWarnings("unused")
	public void checkSpaces() {
		String spotName = "";
		if (spotName == null) {
			expectedEx.expectMessage("spotName is null");
		} else {
			peo.removeSpaces(spotName);
			expectedEx.expectMessage("spotName is not null");
		}
	}
}
