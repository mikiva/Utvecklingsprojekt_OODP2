package se.hig.oodp2.shapes;

import java.util.LinkedList;

import se.hig.oodp2.projekt.DrawPanel;

public class ShapeList<T> extends LinkedList<T>
	{

		private static final long serialVersionUID = 1L;

		private static ShapeList<Shape> shapeList = new ShapeList<>();
		private static SelectedShapes selShape = SelectedShapes.getInstance();

		public static ShapeList<Shape> getInstance()
			{
				return shapeList;
			}

		static
			{
				//shapeList.add(selShape);
			}

		// @Override
		// public void clear()
		// {
		// shapeList.clear();
		// selList.reset();
		// shapeList.add(selList);
		// }

	}
