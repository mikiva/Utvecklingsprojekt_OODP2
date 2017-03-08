package se.hig.oodp2.commands;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class CommandStack
	{
		private List<Command> macro = new LinkedList<>();
		private Stack<Command> commands = new Stack<>();
		private Stack<Command> redoCommands = new Stack<>();

		public static CommandStack commandStack = new CommandStack();

		public void doCommand(Command command)
			{

				macro.add(command);
				commands.push(command);
				command.execute();
			}

		public void undoCommand()
			{

				try
					{
						Command command = commands.pop();
						redoCommands.push(command);
						macro.remove(macro.size() - 1);
						command.undo();
					}
				catch (EmptyStackException e)
					{
						System.out.println("No more undo");
					}

			}

		public void redoCommand()
			{

				try
					{
						Command command = redoCommands.pop();
						doCommand(command);
					}
				catch (EmptyStackException e)
					{
						System.out.println("No more redo");
					}
			}

		public static CommandStack getInstance()
			{
				return commandStack;
			}
	}
