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
		private Command redo;

		public static CommandStack commandStack = new CommandStack();

		public void doCommand(Command command)
			{

				checkIfNewCommand(command);

				macro.add(command);
				commands.push(command);
				command.execute();

				System.out.println("Command  " + command.getClass());
			}

		public void undoCommand()
			{

				try
					{
						Command command = commands.pop();
						redoCommands.push(command);
						macro.remove(macro.size() - 1);
						command.undo();
						System.out.println("Undo  " + command.toString());
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
						redo = redoCommands.pop();
						doCommand(redo);
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

		private void checkIfNewCommand(Command comm)
			{

				if (redoCommands.isEmpty())
					{
						return;
					}
				else
					{
						if (!comm.equals(redo))
							redoCommands.clear();
					}

			}
	}
