package se.hig.oodp2.states;

import se.hig.oodp2.shapes.Shape;
import se.hig.oodp2.shapes.StickMan;

public class StickManState implements ShapeState
	{

	@Override
	public Shape createShape(double x, double y, double w, double h)
		{
			
			return new StickMan(x, y, w, h);
		}

	@Override
	public Shape createShape(double x, double y)
		{
			// TODO Auto-generated method stub
			return new StickMan(x,y);
		}

	}
