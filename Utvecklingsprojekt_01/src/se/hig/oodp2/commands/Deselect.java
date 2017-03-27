package se.hig.oodp2.commands;

import se.hig.oodp2.handlers.MouseHandler;
import se.hig.oodp2.shapes.SelectedShapes;
import se.hig.oodp2.shapes.Shape;
import se.hig.oodp2.states.SelectedState;

public class Deselect implements Command
	{

		SelectedShapes selShape = SelectedShapes.getInstance();
		Shape tempShape;
		SelectedState state;
		MouseHandler handler;
		
		public Deselect(MouseHandler han, Shape s){
			this.tempShape = s;
			this.handler = han;
			this.state = handler.getSelectState();
		}
		
	@Override
	public void execute()
		{
			selShape.deselectShape(tempShape);
			
		}

	@Override
	public void undo()
		{
			selShape.selectShape(tempShape);
			handler.setState(state);
			
			
			
		}

	}
