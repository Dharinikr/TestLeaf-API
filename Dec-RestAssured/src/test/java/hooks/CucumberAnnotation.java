package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CucumberAnnotation {
	
@Before
	public void preScript() {
		System.out.println("This is the preScript from hooks");
	}
	
@After
	public void postScript() {
		System.out.println("This is the postScript from hooks");
	}
}
