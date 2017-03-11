package se.hig.oodp2.states;

import se.hig.oodp2.handlers.MouseHandler;
import se.hig.oodp2.shapes.SelectedShapes;
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
				handler.setState(new OneSelectedState(handler, s));

			}

		@Override
		public SelectedShapes getSelected()
			{

				return null;
			}

		@Override
		public void deSelect()
			{

			}

		@Override
		public boolean isSelected()
			{

				return false;
			}

		@Override
		public boolean isSelected(Shape s)
			{
				
				return false;
			}

		@Override
		public void deSelect(int x, int y)
			{
				// TODO Auto-generated method stub
				
			}
		

	}
