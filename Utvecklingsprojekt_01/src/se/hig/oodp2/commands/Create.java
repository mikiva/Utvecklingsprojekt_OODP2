package se.hig.oodp2.commands;

import se.hig.oodp2.shapes.Shape;
import se.hig.oopd2.projekt.DrawPanel;

public class Create implements Command
	{

		Shape shape;
		DrawPanel panel;
		
		public Create(Shape s, DrawPanel p){
			this.shape = s;
			this.panel = p;
		}
		
	@Override
	public void execute()
		{
			panel.addToList(shape);
			
		}

	@Override
	public void undo()
		{
			panel.remove(shape);
			
		}

	}
