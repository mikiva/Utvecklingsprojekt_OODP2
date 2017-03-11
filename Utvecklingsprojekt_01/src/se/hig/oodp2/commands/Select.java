package se.hig.oodp2.commands;

import se.hig.oodp2.handlers.MouseHandler;
import se.hig.oodp2.shapes.Shape;

public class Select implements Command
	{
		
		Shape shape;
		MouseHandler handler;
		public Select(Shape s, MouseHandler handler){
			this.shape = s;
			this.handler = handler;
		}

	@Override
	public void execute()
		{
			
			handler.selectShape(shape);
			
		}

	@Override
	public void undo()
		{
			//handler.deSelectShape(shape);
			
		}

	}
