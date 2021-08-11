package DS.String.Z_tricky;
/**
 * What is the running time of this code?
 * 
 *
 */
public class A_RunningTime {

	public String makeSentence(String[] words) {
		StringBuffer sentence = new StringBuffer();
		for (String w : words) sentence.append(w);
		return sentence.toString();
	}

}
