package se.hig.oodp2.commands;

import se.hig.oodp2.projekt.DrawPanel;
import se.hig.oodp2.shapes.Shape;

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
