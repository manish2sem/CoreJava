package CoreJava.J_Basic.Clone.A_example;

/**
 * http://javarevisited.blogspot.in/2013/09/how-clone-method-works-in-java.html
 * @author Manish
 *
 */

public class Rectangle implements Cloneable{
	private int width;
	private int height;

	public Rectangle(int w, int h){
		width = w;
		height = h;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int area(){
		return width*height;
	}

	@Override
	public String toString(){
		return String.format("Rectangle [width: %d, height: %d, area: %d]", width, height, area());
	}

	@Override
	protected Rectangle clone() throws CloneNotSupportedException {
		return (Rectangle) super.clone();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Rectangle other = (Rectangle) obj;
		if (this.width != other.width) {
			return false;
		}
		if (this.height != other.height) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash =  hash + this.width;
		hash =  hash + this.height;
		return hash;
	}

}


