package se.hig.oodp2.states;

import java.util.List;

import se.hig.oodp2.handlers.MouseHandler;
import se.hig.oodp2.shapes.SelectedShapes;
import se.hig.oodp2.shapes.Shape;
import se.hig.oodp2.shapes.ShapeList;

public class OneSelectedState implements SelectedState
	{
		MouseHandler handler;
		Shape shape;
		SelectedShapes selShape;
		List<Shape> list;

		public OneSelectedState(MouseHandler handler, Shape s)
			{
				this.handler = handler;
				list = ShapeList.getInstance();
				this.selShape = new SelectedShapes();
				selShape.addShape(s);
				selShape.setSize(s.getWidth(), s.getHeight());
				list.remove(s);
				list.add(selShape);
			}

		@Override
		public void select(Shape s)
			{
				handler.setState(new SelectedShapesState(handler, selShape, s));
			}

		@Override
		public SelectedShapes getSelected()
			{

				return selShape;
			}

		@Override
		public void deSelect()
			{
				list.add(selShape.getShapesFromComp().get(0));
				selShape.getShapesFromComp().clear();
				handler.setState(new NoSelected(handler));

			}

		@Override
		public void deSelect(int x, int y)
			{
				deSelect();

			}

		@Override
		public boolean isSelected()
			{
				// TODO Auto-generated method stub
				return true;
			}

		@Override
		public boolean isSelected(Shape s)
			{

				return selShape.getShapesFromComp().contains(s);
			}

	}
