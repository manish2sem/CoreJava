package ProblemFaced.gs;

import java.net.URL;

public class ReadResource {

	public static void main(String[] args) {
		String RESOURCE = "docs";
		URL url = Thread.currentThread().getContextClassLoader().getResource(RESOURCE);
		if (url == null){
			System.out.println("Resource not found");
		} else {
			System.out.println("Resource loaded");
		}
	}

}
