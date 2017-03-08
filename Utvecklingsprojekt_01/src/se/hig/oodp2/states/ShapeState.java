package se.hig.oodp2.states;

import se.hig.oodp2.shapes.Shape;

public interface ShapeState
	{
		public Shape createShape(double x, double y, double w, double h);
		public Shape createShape(double x, double y);
		

	}
