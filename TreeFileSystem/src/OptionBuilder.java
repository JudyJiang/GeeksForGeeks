import org.apache.commons.cli.*;

public class OptionBuilder {
	
	public CommandLine line;
	public Options options;
	
	/*
	 * List of options available
	 */
	public final static Option help = new Option("h", "help", false,"Show commands available");
	public final static Option listFile = new Option("", "l", false, "Command File List");//TODO
	public final static Option regular = new Option("r", "regular", false, "List Files Match Regular Expression");//TODO
	public final static Option find = new Option("f", "find", false, "Find File in current or specific directory");
	//TODO, this needs full name or regular expression's help//Show full directory?

	
	public OptionBuilder(String[] args){
		initialCommands(args);
	}
	
	public void initialCommands(String[] args){
		this.options = new Options();
		this.options.addOption(help);
		this.options.addOption(regular);
		this.options.addOption(listFile);
	}
	
	/*
	 * Help will print all the options available
	 */
	public void help(){
		HelpFormatter formatter = new HelpFormatter();
		formatter.printHelp("Main", options);
		System.exit(0);
	}
	
	/**
	 * TODO:
	 * @param args: Tree Directory
	 */
	public void ListFile(String[] args){
		if(args == null || args.length < 1){
			FileTree.FileSearch();
		}
		else{
			if(args.length < 2)
				FileTree.FileSearch(args[0]);
			
			else{
				/*
				 * Need additional Things to make sure what it is!
				 */
				ListRegularMatchFile(args);
			}
		}
	}
	
	
	/**
	 * TODO:
	 * @param args: Tree Directory, Regular Expression format
	 * May need to further implement regular simplified task
	 */
	public void ListRegularMatchFile(String[] args){
		/*
		 * 
		 */
		for(String s : args)
			System.out.println(s);
	}
	
	
	public void parse(String[] args){
		CommandLineParser parser = new BasicParser();
		CommandLine cmd = null;
		try{
			cmd = parser.parse(options, args);
			String[] addArgs = cmd.getArgs();
			if(cmd.hasOption("h"))
				help();
			
			/*
			 *Call Regular Expression Function
			 */
			else if(cmd.hasOption("r")){
				ListRegularMatchFile(addArgs);
			}
			
			/*
			 * Simply list files within current or specified directory.
			 */
			else if(cmd.hasOption("l")){
				ListFile(addArgs);
			}
			
			
			else{
				help();
			}
			
		} catch (ParseException e){
			System.out.println("Wrong Command.");
		}
	}
	
	public static void main(String[] args){
		/*
		 * Just for try
		 */
		OptionBuilder op = new OptionBuilder(args);
		op.parse(args);
	}
}
