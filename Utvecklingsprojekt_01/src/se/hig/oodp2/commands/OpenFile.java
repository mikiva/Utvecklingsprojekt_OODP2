package se.hig.oodp2.commands;

import se.hig.oodp2.shapes.GroupShape;
import se.hig.oodp2.shapes.Shape;
import se.hig.oopd2.projekt.DrawPanel;
import se.hig.oopd2.projekt.OpenObject;

public class OpenFile implements Command
	{
		String filename;
		GroupShape obj;
		DrawPanel panel = DrawPanel.getInstance();
		OpenObject open = OpenObject.getInstance();
		GroupShape shape;

		public OpenFile(String name)
			{
				panel.clearSelected();
				this.obj = null;
				this.filename = name;
				this.obj = open.deserialize(filename);
			}

		@Override
		public void execute()
			{
				
				System.out.println("Open file");
				if (obj != null)
					{
						shape = new GroupShape();
						for (Shape s : obj.getShapesFromComp())
							{
								shape.selectShape(s);
								shape.setX(s.getX());
								shape.setY(s.getY());
							}

						shape.setSize(0,0);
						panel.addToList(shape);
					}
				else
					System.out.println("obj is null");

				panel.open();
			}

		@Override
		public void undo()
			{
				panel.remove(shape);

			}

	}
