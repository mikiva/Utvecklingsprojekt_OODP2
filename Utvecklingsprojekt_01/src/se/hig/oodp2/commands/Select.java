package se.hig.oodp2.commands;

import se.hig.oodp2.handlers.MouseHandler;
import se.hig.oodp2.shapes.SelectedShapes;
import se.hig.oodp2.shapes.Shape;

public class Select implements Command
	{
		
		Shape shape;
		MouseHandler handler;
		SelectedShapes shapes = SelectedShapes.getInstance();
		public Select(Shape s, MouseHandler handler){
			this.shape = s;
			this.handler = handler;
		}

	@Override
	public void execute()
		{
			
			shapes.addShape(shape);
			
			
		}

	@Override
	public void undo()
		{
			shapes.removeShape(shape);
			
		}

	}
