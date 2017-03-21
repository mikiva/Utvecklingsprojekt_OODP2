package se.hig.oopd2.projekt;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import java.util.Observable;

import se.hig.oodp2.shapes.GroupShape;

public class WriteObject extends Observable
	{
		WriteObject obj;
		GroupShape shape;

		public WriteObject(GroupShape s)
			{

				this.shape = s;
				this.serialize();
			}

		public void serialize()
			{

				FileOutputStream fout = null;
				ObjectOutputStream oos = null;

				try
					{

						String filename = getNewName();

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

		private String getNewName()
			{

				String name = "";
				boolean b = false;
				int i = 0;
				while (b == false)
					{

						name = String.format("shape_%03d.ser", i);
						System.out.println(name);
						try
							{
								if (new File("shapes/" + name).exists())
									i++;
								else
									b = true;
							}
						catch (Exception e)
							{
								b = true;
							}

					}
				return name;

			}
	}
