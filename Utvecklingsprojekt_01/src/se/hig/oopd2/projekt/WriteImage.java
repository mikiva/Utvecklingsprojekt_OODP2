package se.hig.oopd2.projekt;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import se.hig.oodp2.shapes.GroupShape;
import se.hig.oodp2.shapes.Shape;
import se.hig.oodp2.shapes.ShapeList;

public class WriteImage
	{

		GroupShape shape;
		List<Shape> list = ShapeList.getInstance();

		public WriteImage(List<Shape> list)
			{
				shape = new GroupShape();
				makeGroup();
				this.serialize();

			}

		public void serialize()
			{

				FileOutputStream fout = null;
				ObjectOutputStream oos = null;

				try
					{

						String filename = "image_01.ser";

						fout = new FileOutputStream("shapes/" + filename);
						oos = new ObjectOutputStream(fout);
						oos.writeObject(shape);
						System.out.println("done");
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}

			}

		private void makeGroup()
			{

				for (Shape s : list)
					shape.selectShape(s);
			}

	}
