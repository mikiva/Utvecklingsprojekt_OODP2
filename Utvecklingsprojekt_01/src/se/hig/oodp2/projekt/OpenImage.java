package se.hig.oodp2.projekt;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import se.hig.oodp2.shapes.GroupShape;

public class OpenImage
	{

		public GroupShape deserialize(String filename)
			{

				GroupShape s = null;
				FileInputStream fin = null;
				ObjectInputStream ois = null;

				try
					{
						fin = new FileInputStream("shapes/"+filename);
						ois = new ObjectInputStream(fin);
						s = (GroupShape)ois.readObject();

					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
				return  s;
			}
		
	}
