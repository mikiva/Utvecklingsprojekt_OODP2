package se.hig.oodp2.states;

import se.hig.oodp2.commands.CommandStack;
import se.hig.oodp2.commands.Select;
import se.hig.oodp2.handlers.MouseHandler;
import se.hig.oodp2.shapes.SelectedShapes;
import se.hig.oodp2.shapes.Shape;
import se.hig.oodp2.shapes.ShapeList;

public class NoSelected implements SelectedState
	{
		private MouseHandler handler;
		private CommandStack commands = CommandStack.getInstance();
		private ShapeList<Shape> list = ShapeList.getInstance();
		private SelectedShapes shapes = SelectedShapes.getInstance();

		public NoSelected(MouseHandler hand)
			{
				this.handler = hand;
				System.out.println("No selectedState");
				
			}

		@Override
		public void select(Shape s)
			{

				commands.doCommand(new Select(s, handler));

				handler.setState(new SelectedShapesState(handler));

			}

		@Override
		public SelectedShapes getSelected()
			{

				return null;
			}

		@Override
		public void deSelect()
			{
				System.out.println("Deselect no selected");
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

			}

	}
