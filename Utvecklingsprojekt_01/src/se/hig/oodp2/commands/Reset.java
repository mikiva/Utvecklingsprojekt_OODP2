package se.hig.oodp2.commands;

import java.util.List;

import se.hig.oodp2.shapes.GroupShape;
import se.hig.oodp2.shapes.SelectedShapes;
import se.hig.oodp2.shapes.Shape;
import se.hig.oodp2.shapes.ShapeList;

public class Reset implements Command
	{
		List<Shape> list;
		List<Shape> tempList;
		GroupShape gShape;
		SelectedShapes selShape;

		public Reset()
			{
				selShape = SelectedShapes.getInstance();
				this.list = ShapeList.getInstance();
				tempList = new ShapeList<>();
			}

		@Override
		public void execute()
			{
				for(Shape s : list)
					tempList.add(s);
				
				selShape.reset();
				list.clear();
			//	list.add(selShape);

			}

		@Override
		public void undo()
			{
				for(Shape s : tempList)
					list.add(s);

			}

	}
