package se.hig.oodp2.states;

import se.hig.oodp2.handlers.MouseHandler;
import se.hig.oodp2.shapes.SelectedShapes;
import se.hig.oodp2.shapes.Shape;
import se.hig.oodp2.shapes.ShapeList;

public class SelectedShapesState implements SelectedState
	{

		private SelectedShapes selShape;
		private MouseHandler handler;
		private ShapeList<Shape> list;

		public SelectedShapesState(MouseHandler handler, Shape s)
			{
				list = ShapeList.getInstance();
				selShape = new SelectedShapes();
				this.handler = handler;
				select(s);
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
		public boolean isSelected()
			{
				// TODO Auto-generated method stub
				return true;
			}
		
		@Override
		public boolean isSelected(Shape shape)
			{
				return list.contains(shape);
			}



	}
