package se.hig.oodp2.commands;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import se.hig.oodp2.shapes.SelectedShapes;
import se.hig.oodp2.shapes.Shape;

public class ChangeStroke implements Command
	{

		SelectedShapes sel = SelectedShapes.getInstance();
		List<Integer> strokeList = new LinkedList<>();
		int stroke = -1;

		@Override
		public void execute()
			{

				for (Shape s : sel.getShapesFromComp())
					strokeList.add(s.getStroke());

				if (stroke < 0)
					stroke = Integer.parseInt(JOptionPane.showInputDialog("Change Stroke"));
				sel.setStroke(stroke);

			}

		@Override
		public void undo()
			{
				if (!strokeList.isEmpty())
					{
						for (int i = 0; i < strokeList.size(); i++)
							{
								sel.getShapesFromComp().get(i).setStroke(strokeList.get(i));
							}
					}
			}

	}
