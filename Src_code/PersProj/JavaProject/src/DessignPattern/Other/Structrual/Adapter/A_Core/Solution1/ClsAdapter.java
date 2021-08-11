package DessignPattern.Other.Structrual.Adapter.A_Core.Solution1;

import DessignPattern.Other.Structrual.Adapter.A_Core.ExistingSystem.Line;
import DessignPattern.Other.Structrual.Adapter.A_Core.ExistingSystem.Point;
import DessignPattern.Other.Structrual.Adapter.A_Core.ExistingSystem.Square;
import DessignPattern.Other.Structrual.Adapter.A_Core.IF.Shape;

public class ClsAdapter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Now our solution circle will adapt vendorCircle and can be used here.
		System.out.println(" After adapting vendorCircle");
		Shape[] newShapes = new Shape[4];
		newShapes[0] = new Point();
		newShapes[1] = new Line();
		newShapes[2] = new Square();
		newShapes[3] = new SolutionCircle();


		for (Shape shape : newShapes){
			shape.fill();
			shape.display();
			shape.unDisplay();
		}

	}

}
