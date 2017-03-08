package se.hig.oodp2.commands;

import se.hig.oodp2.shapes.Shape;

public class Move implements Command
	{

		private int fromX;
		private int fromY;
		private int toX;
		private int toY;
		private Shape shape;

		public Move(int x1, int y1, int x2, int y2, Shape s)
			{
				this.fromX = x1;
				this.fromY = y1;
				this.toX = x2;
				this.toY = y2;
				this.shape = s;
			}

		@Override
		public void execute()
			{
				shape.move(toX, toY);
			}

		@Override
		public void undo()
			{
				shape.move(fromX, fromY);

			}

	}
