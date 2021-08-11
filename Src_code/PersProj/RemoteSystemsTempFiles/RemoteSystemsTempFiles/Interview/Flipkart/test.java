package Interview.Flipkart;

public class HomeController implements Controller {
	private String greeting;
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return new ModelAndView("home", "message", greeting);
	}
}