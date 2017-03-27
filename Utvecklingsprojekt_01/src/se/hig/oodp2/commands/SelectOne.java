package se.hig.oodp2.commands;

import java.util.LinkedList;
import java.util.List;

import se.hig.oodp2.handlers.MouseHandler;
import se.hig.oodp2.shapes.SelectedShapes;
import se.hig.oodp2.shapes.Shape;
import se.hig.oodp2.states.SelectedShapesState;
import se.hig.oodp2.states.SelectedState;

public class SelectOne implements Command
	{

		List<Shape> tempList = new LinkedList<>();
		SelectedShapes sel = SelectedShapes.getInstance();
		MouseHandler handler;
		Shape shape;
		SelectedState state;
		List<Shape> temp;

		public SelectOne(MouseHandler hand, Shape s)
			{

				this.handler = hand;
				this.shape = s;
				this.state = handler.getSelectState();
//				for (Shape sh : sel.getShapesFromComp())
//					tempList.add(s);

			}

		@Override
		public void execute()
			{

				for (Shape s : sel.getShapesFromComp())
					tempList.add(s);

				sel.clear();
				System.out.println(tempList.size());
				// state.select(shape);
				sel.selectShape(shape);
				handler.setState(new SelectedShapesState(handler));

			}

		@Override
		public void undo()
			{
				sel.clear();
				for (Shape s : tempList)
					sel.selectShape(s);

				System.out.println(tempList.size());
				handler.setState(state);
			}

	}
