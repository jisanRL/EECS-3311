package AdminOperationsModel;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class AdminTest {
	Admin admin;
	private static String userPath = "../eecs3311_proj/CSVs/database.csv";	

	@Test
	public void test() throws Exception {
		admin = new Admin();		
//		fail("Not yet implemented");
	}
	
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
//	@Test
	public void add_space(String userPath) throws IOException {
		if (userPath != null && this.userPath.equals(userPath)) {
			admin.writeUser("Ralf drew", "PEO", "ralf@yorku.ca", "ralf12", "313411141", "14 apple st", "admin4");
			expectedEx.expectMessage("Success");
		} else {
			expectedEx.expectMessage("Path is null");
		}
	}
	
	@Rule
	public ExpectedException expectedEx2 = ExpectedException.none();
//	@Test
	public void remove_space(String userPath) throws IOException {
		if (userPath != null && this.userPath.equals(userPath)) {
			admin.removeUser("Ralf drew", "PEO", "ralf@yorku.ca", "ralf12", "313411141", "14 apple st", "admin4");
			expectedEx2.expectMessage("Success");
		} else {
			expectedEx2.expectMessage("Path is null");
		}
	}
	

}
