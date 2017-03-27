package se.hig.oodp2.commands;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JColorChooser;

import se.hig.oodp2.projekt.DrawPanel;
import se.hig.oodp2.shapes.SelectedShapes;
import se.hig.oodp2.shapes.Shape;

public class ChangeColor implements Command
	{

		DrawPanel panel = DrawPanel.getInstance();
		SelectedShapes sel = SelectedShapes.getInstance();
		List<Color> colorList = new LinkedList<>();
		Color color = null;

		@Override
		public void execute()
			{

				for (Shape s : sel.getShapesFromComp())
					colorList.add(s.getColor());

				if (color == null)
					color = JColorChooser.showDialog(panel, "color", Color.black);
				
				sel.setColor(color);

			}

		@Override
		public void undo()
			{
				if (!colorList.isEmpty())
					{
						for (int i = 0; i < colorList.size(); i++)
							{
								sel.getShapesFromComp().get(i).setColor(colorList.get(i));
							}

					}
			}

	}
