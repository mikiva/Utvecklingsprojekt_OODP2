package se.hig.oodp2.commands;

import java.util.LinkedList;
import java.util.List;

import se.hig.oodp2.shapes.GroupShape;
import se.hig.oodp2.shapes.SelectedShapes;
import se.hig.oodp2.shapes.Shape;
import se.hig.oodp2.shapes.ShapeList;

public class Ungroup implements Command
	{
		
		private SelectedShapes shapes = SelectedShapes.getInstance();
		private List<Shape> compList;
		private List<Shape> list = ShapeList.getInstance();
		private GroupShape group;
		
		public Ungroup(GroupShape sh){
			
			this.group = sh;
		}

	@Override
	public void execute()
		{
			List<Shape> tempList = new LinkedList<>();
			
			for(Shape s : group.getShapesFromComp())
				tempList.add(s);
			
			for(Shape s: tempList){
				shapes.selectShape(s);
			s.setColor();
			}

			list.remove(group);
			
		}

	@Override
	public void undo()
		{
			// TODO Auto-generated method stub
			
		}

	}
