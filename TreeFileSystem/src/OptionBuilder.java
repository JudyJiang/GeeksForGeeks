import org.apache.commons.cli.*;

public class OptionBuilder {
	
	public CommandLine line;
	public Options options;
	
	/*
	 * List of options available
	 */
	public final static Option help = new Option("h", "help", false,"Show commands available");

	
	public OptionBuilder(String[] args){
		initialCommands(args);
	}
	
	public void initialCommands(String[] args){
		this.options = new Options();
		this.options.addOption(help);
		
	}
	
	public static void main(String[] args){
		/*
		 * Just for try
		 */
		OptionBuilder op = new OptionBuilder(args);
		
	}
}
