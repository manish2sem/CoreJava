package EffectiveJava.C_ClsIf.Item20;

/**
 * Occasionally a class represents two or more flavors and 
 * contains a tag field indicating the flavor of the instance.
 *
 */
// Tagged class - vastly inferior to a class hierarchy!
class A_Figure {
	enum Shape { RECTANGLE, CIRCLE };
	// Tag field - the shape of this figure
	final Shape shape;
	// These fields are used only if shape is RECTANGLE
	double length;
	double width;
	// This field is used only if shape is CIRCLE
	double radius;
	// Constructor for circle
	A_Figure(double radius) {
		shape = Shape.CIRCLE;
		this.radius = radius;
	}
	// Constructor for rectangle
	A_Figure(double length, double width) {
		shape = Shape.RECTANGLE;
		this.length = length;
		this.width = width;
	}
	
	double area() {
		switch(shape) {
		case RECTANGLE:
			return length * width;
		case CIRCLE:
			return Math.PI * (radius * radius);
		default:
			throw new AssertionError();
		}
	}
}