package se.hig.oodp2.shapes;

import java.util.LinkedList;


public class ShapeList<T> extends LinkedList<T> 
	{

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
		private static ShapeList<Shape> shapeList = new ShapeList<>();

		
		public static ShapeList<Shape> getInstance(){
			return shapeList;
		}
		

	}
