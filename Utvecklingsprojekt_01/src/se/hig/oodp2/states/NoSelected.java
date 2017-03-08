package se.hig.oodp2.states;

import se.hig.oodp2.handlers.MouseHandler;
import se.hig.oodp2.shapes.Shape;

public class NoSelected implements SelectedState
	{
		private MouseHandler handler;

		public NoSelected(MouseHandler hand)
			{
				this.handler = hand;
				System.out.println("No selectedState");
			}

		@Override
		public void select(Shape s)
			{
				handler.setState(new SelectedShapesState(handler, s));

			}

		@Override
		public Shape getSelected()
			{

				return null;
			}

		@Override
		public void deSelect()
			{

			}

	}
