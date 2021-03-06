package se.hig.oodp2.commands;

import se.hig.oodp2.handlers.MouseHandler;
import se.hig.oodp2.shapes.SelectedShapes;
import se.hig.oodp2.shapes.Shape;
import se.hig.oodp2.states.SelectedState;

public class Select implements Command
	{
		
		Shape shape;
		SelectedShapes shapes = SelectedShapes.getInstance();
		SelectedState state;
		MouseHandler handler;
		
		
		public Select(Shape s, MouseHandler hand){
			this.shape = s;
			this.handler = hand;
			this.state = handler.getSelectState();
		}

	@Override
	public void execute()
		{
			
			shapes.selectShape(shape);
			
			
		}

	@Override
	public void undo()
		{
			
			System.out.println("Undo select");
			shapes.deselectShape(shape);
			handler.setState(state);
			
		}

	}
