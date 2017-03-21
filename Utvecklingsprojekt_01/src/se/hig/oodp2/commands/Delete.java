package se.hig.oodp2.commands;

import java.util.List;

import se.hig.oodp2.shapes.SelectedShapes;
import se.hig.oodp2.shapes.Shape;
import se.hig.oodp2.shapes.ShapeList;
import se.hig.oopd2.projekt.DrawPanel;

public class Delete implements Command
	{
		List<Shape> list;
		List<Shape> tempList;
		DrawPanel panel;
		Shape shape;
		SelectedShapes selShape = SelectedShapes.getInstance();

		public Delete()
			{
				list = ShapeList.getInstance();
				tempList = new ShapeList<>();

			}

		@Override
		public void execute()
			{
				for (Shape s : selShape.getShapesFromComp())
					tempList.add(s);

				selShape.delete();

			}

		@Override
		public void undo()
			{
				for(Shape s : tempList)
					selShape.selectShape(s);

			}

	}
