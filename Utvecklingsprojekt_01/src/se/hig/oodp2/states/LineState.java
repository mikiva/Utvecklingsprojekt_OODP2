package se.hig.oodp2.states;

import se.hig.oodp2.shapes.Line;
import se.hig.oodp2.shapes.Shape;

public class LineState implements ShapeState
	{

	@Override
	public Shape createShape(double x, double y, double w, double h)
		{
			return new Line(x,y, w, h);
		}

	@Override
	public Shape createShape(double x, double y)
		{
			return new Line(x, y);
		}

	}
