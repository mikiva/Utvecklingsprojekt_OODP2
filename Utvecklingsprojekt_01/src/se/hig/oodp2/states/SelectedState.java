package se.hig.oodp2.states;

import se.hig.oodp2.shapes.SelectedShapes;
import se.hig.oodp2.shapes.Shape;

public interface SelectedState
	{

		public void select(Shape s);
		public SelectedShapes getSelected();
		public void deSelect();
		public boolean isSelected();
		public boolean isSelected(Shape s);
		
	}
