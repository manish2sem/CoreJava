package DessignPattern.Other.Structrual.Adapter.A_Core.Solution2;

import DessignPattern.Other.Structrual.Adapter.A_Core.ExistingSystem.Line;
import DessignPattern.Other.Structrual.Adapter.A_Core.ExistingSystem.Point;
import DessignPattern.Other.Structrual.Adapter.A_Core.ExistingSystem.Square;
import DessignPattern.Other.Structrual.Adapter.A_Core.IF.Shape;

public class ObjAdapter {

	public static void main(String[] args) {

		//Now our solution circle will adapt vendorCircle and can be used here.
		System.out.println(" After adapting vendorCircle as object Adapter");
		Shape[] AgainNewShapes = new Shape[4];
		AgainNewShapes[0] = new Point();
		AgainNewShapes[1] = new Line();
		AgainNewShapes[2] = new Square();
		AgainNewShapes[3] = new SolutionCircle2();

		for (Shape shape : AgainNewShapes){
			shape.fill();
			shape.display();
			shape.unDisplay();
		}
	}
}
