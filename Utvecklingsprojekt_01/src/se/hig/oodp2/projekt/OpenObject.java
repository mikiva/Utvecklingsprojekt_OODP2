package se.hig.oodp2.projekt;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import se.hig.oodp2.shapes.GroupShape;
import se.hig.oodp2.shapes.Shape;

public  class OpenObject
	{

		Shape shape;

		private static OpenObject openObj = new OpenObject();
		
		
		public OpenObject()
			{
			
			}
		public static OpenObject getInstance(){
			return openObj;
		}

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
		
		public Shape getShape(){
			return shape;
		}

	}
