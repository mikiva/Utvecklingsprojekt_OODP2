package se.hig.oodp2.states;

import se.hig.oodp2.commands.CommandStack;
import se.hig.oodp2.commands.Deselect;
import se.hig.oodp2.commands.DeselectAll;
import se.hig.oodp2.commands.Select;
import se.hig.oodp2.handlers.MouseHandler;
import se.hig.oodp2.shapes.SelectedShapes;
import se.hig.oodp2.shapes.Shape;
import se.hig.oodp2.shapes.ShapeList;

public class SelectedShapesState implements SelectedState
	{

		private SelectedShapes selShape;
		private MouseHandler handler;
		private ShapeList<Shape> list;
		private CommandStack commands = CommandStack.getInstance();

		public SelectedShapesState(MouseHandler handler)
			{
				// System.out.println("Multiple selected");
				list = ShapeList.getInstance();
				this.selShape = SelectedShapes.getInstance();
				this.handler = handler;
				list.add(selShape);
				// select(shap);
				// System.out.println("Selected State");
			}

		@Override
		public void select(Shape s)
			{

				commands.doCommand(new Select(s, handler));
				// list.remove(s);

				// list.add(selShape);

			}

		@Override
		public SelectedShapes getSelected()
			{

				return selShape;
			}

		@Override
		public void deSelect()
			{

				commands.doCommand(new DeselectAll(handler));
				handler.setState(new NoSelected(handler));

			}

		@Override
		public void deSelect(int x, int y)
			{
				Shape shape = null;
				for (Shape s : selShape.getShapesFromComp())
					{
						if (s.inside(x, y))
							{
								shape = s;
								break;
							}
					}
				if (shape != null)
					{
						commands.doCommand(new Deselect(handler, shape));
						// list.add(shape);
						if (selShape.getShapesFromComp().isEmpty())
							handler.setState(new NoSelected(handler));
					}

			}

		@Override
		public boolean isSelected()
			{
				return true;
			}

		@Override
		public boolean isSelected(Shape shape)
			{

				return shape.equals(selShape);

				// return selShape.getShapesFromComp().contains(shape);
			}

	}
