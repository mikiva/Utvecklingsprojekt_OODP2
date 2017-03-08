package se.hig.oodp2.commands;

import java.util.List;

import se.hig.oodp2.shapes.Shape;
import se.hig.oodp2.shapes.ShapeList;

public class Clear implements Command
	{
		List<Shape> list;
		List<Shape> tempList;

		public Clear()
			{
				this.list = ShapeList.getInstance();
				tempList = new ShapeList<>();
			}

		@Override
		public void execute()
			{
				for(Shape s : list)
					tempList.add(s);
				
				list.clear();

			}

		@Override
		public void undo()
			{
				for(Shape s : tempList)
					list.add(s);

			}

	}
