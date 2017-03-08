package se.hig.oodp2.states;

import se.hig.oodp2.handlers.MouseHandler;
import se.hig.oodp2.shapes.SelectedShapes;
import se.hig.oodp2.shapes.Shape;

public class SelectedShapesState implements SelectedState
	{

		private SelectedShapes selShape;
		private MouseHandler handler;

		public SelectedShapesState(MouseHandler handler, Shape s)
			{
				selShape = new SelectedShapes();
				this.handler = handler;
				selShape.addShape(s);
			}

		@Override
		public void select(Shape s)
			{

				selShape.addShape(s);
			}

		@Override
		public Shape getSelected()
			{

				return selShape;
			}

		@Override
		public void deSelect()
			{
				handler.setState(new NoSelected(handler));
				
			}

	}
