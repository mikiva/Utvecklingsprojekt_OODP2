package se.hig.oodp2.commands;

import java.util.LinkedList;
import java.util.List;

import se.hig.oodp2.handlers.MouseHandler;
import se.hig.oodp2.shapes.SelectedShapes;
import se.hig.oodp2.shapes.Shape;
import se.hig.oodp2.states.NoSelected;
import se.hig.oodp2.states.SelectedState;

public class DeselectAll implements Command
	{

		List<Shape> tempList = new LinkedList<>();
		SelectedShapes selShape = SelectedShapes.getInstance();
		MouseHandler handler;
		SelectedState state;
		
		public DeselectAll(MouseHandler hand)
			{
				this.handler = hand;
				this.state = handler.getSelectState();
			}

		@Override
		public void execute()
			{

				for (Shape s : selShape.getShapesFromComp())
					tempList.add(s);

				System.out.println(tempList.size() + " templist deselectAll");
				selShape.clear();
				handler.setState(new NoSelected(handler));

			}

		@Override
		public void undo()
			{
				for(Shape s : tempList)
					selShape.selectShape(s);
				
				
				handler.setState(state);
			}

	}
