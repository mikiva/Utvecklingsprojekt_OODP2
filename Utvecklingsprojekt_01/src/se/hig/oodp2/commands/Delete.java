package se.hig.oodp2.commands;

import java.util.List;

import se.hig.oodp2.shapes.Shape;
import se.hig.oodp2.shapes.ShapeList;
import se.hig.oopd2.projekt.DrawPanel;

public class Delete implements Command
	{
		List<Shape> list;
		List<Shape> tempList;
		DrawPanel panel;
		Shape shape;

		public Delete(Shape s, DrawPanel pan)
			{
				list = ShapeList.getInstance();
				tempList = new ShapeList<>();
				this.panel = pan;
				this.shape = s;
			}

		@Override
		public void execute()
			{
				for (Shape s : list)
					tempList.add(s);

				list.remove(shape);

			}

		@Override
		public void undo()
			{

				list.clear();

				for (Shape s : tempList)
					list.add(s);

			}

	}
