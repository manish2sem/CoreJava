package DessignPattern.HeadFirst.Observer.Solution2.InterFace;
/**
 * This is the common interface implemented by all observer.
 * Need of this interface is common update method. 
 * for detail see - DesignPattern.HeadFirst.Observer.Solution2.InterFace.Subject comment
 * @author Manish
 *
 */
public interface Observer {
	
	public void update(float temp, float pressure, float humidity);

}
