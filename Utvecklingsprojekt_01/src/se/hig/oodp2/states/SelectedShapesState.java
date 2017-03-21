package se.hig.oodp2.states;

import java.util.List;

import se.hig.oodp2.commands.CommandStack;
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

		public SelectedShapesState(MouseHandler handler, Shape shap)
			{
				System.out.println("Multiple selected");
				list = ShapeList.getInstance();
				this.selShape = SelectedShapes.getInstance();
				this.handler = handler;
				select(shap);
				System.out.println("Selected State");
			}

		@Override
		public void select(Shape s)
			{

				commands.doCommand(new Select(s));
				list.remove(s);
				list.add(selShape);

			}

		@Override
		public SelectedShapes getSelected()
			{

				return selShape;
			}

		@Override
		public void deSelect()
			{

				for (Shape s : selShape.getShapesFromComp())
					list.add(s);

				selShape.getShapesFromComp().clear();

				handler.setState(new NoSelected(handler));

			}

		@Override
		public void deSelect(int x, int y)
			{
				// List<Shape> sList = selShape.getShapesFromComp();
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
						selShape.deselectShape(shape);
						list.add(shape);
						if (selShape.getShapesFromComp().isEmpty())
							handler.setState(new NoSelected(handler));
					}

			}

		@Override
		public boolean isSelected()
			{
				// TODO Auto-generated method stub
				return true;
			}

		@Override
		public boolean isSelected(Shape shape)
			{
				return selShape.getShapesFromComp().contains(shape);
			}

	}
