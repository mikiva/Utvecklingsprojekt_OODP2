package se.hig.oodp2.states;

import se.hig.oodp2.handlers.MouseHandler;
import se.hig.oodp2.shapes.Shape;

public interface SelectedState
	{

		public void select(Shape s);
		public Shape getSelected();
		public void deSelect();
		
	}
