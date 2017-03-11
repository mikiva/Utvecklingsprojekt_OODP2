package se.hig.oodp2.states;

import java.util.List;

import se.hig.oodp2.handlers.MouseHandler;
import se.hig.oodp2.shapes.SelectedShapes;
import se.hig.oodp2.shapes.Shape;
import se.hig.oodp2.shapes.ShapeList;

public class SelectedShapesState implements SelectedState
	{

		private SelectedShapes selShape;
		private MouseHandler handler;
		private ShapeList<Shape> list;

		public SelectedShapesState(MouseHandler handler, SelectedShapes s, Shape shap)
			{
				System.out.println("Multiple selected");
				list = ShapeList.getInstance();
				selShape = s;
				this.handler = handler;
				select(shap);
				System.out.println("Selected State");
			}

		@Override
		public void select(Shape s)
			{

				selShape.addShape(s);
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
							shape = s;
						break;
					}
				if (shape != null)
					{
						selShape.getShapesFromComp().remove(shape);
						list.add(shape);
						if (selShape.getShapesFromComp().size() == 1)
							handler.setState(new OneSelectedState(handler, selShape.getShapesFromComp().get(0)));
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
