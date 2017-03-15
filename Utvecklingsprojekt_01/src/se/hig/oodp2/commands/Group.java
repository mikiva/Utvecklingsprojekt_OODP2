package se.hig.oodp2.commands;

import java.util.List;

import se.hig.oodp2.shapes.GroupShape;
import se.hig.oodp2.shapes.SelectedShapes;
import se.hig.oodp2.shapes.Shape;
import se.hig.oodp2.shapes.ShapeList;

public class Group implements Command
	{

		private SelectedShapes shapes = SelectedShapes.getInstance();
		private List<Shape> compList;
		private List<Shape> list = ShapeList.getInstance();
		private GroupShape group;

		public Group()
			{
				compList = new ShapeList<>();
				group = new GroupShape();
			}

		@Override
		public void execute()
			{
				List<Shape> selShapes = shapes.getShapesFromComp();
				for (Shape s : selShapes)
					{
						group.selectShape(s);
					}
				list.add(group);
				shapes.clear();

			}

		@Override
		public void undo()
			{
				for (Shape s : compList)
					shapes.addShape(s);

				group.clear();

			}

	}
