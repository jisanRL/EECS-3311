package analyzer;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import util.Message;
import util.Utils;

/**
 * @desc entrance of lab2
 * @author wangs and you
 *
 */
public class Main {
	private String path;  /** path to the method to be analyzed */
	private boolean help; /** show help info; true: show, false: no*/
	private boolean cfg;  /** show CFG or not; true: show, false: no */
	private boolean nBranch; /** show the number of branches; true: show, false: no */
	private boolean showBranch; /** show each branch; true: show, false: no */
	
	public boolean isCfg() {
		return cfg;
	}

	public void setCfg(boolean cfg) {
		this.cfg = cfg;
	}

	public boolean isShowBranch() {
		return showBranch;
	}

	public void setShowBranch(boolean showBranch) {
		this.showBranch = showBranch;
	}

	public boolean isnBranch() {
		return nBranch;
	}

	public void setnBranch(boolean nBranch) {
		this.nBranch = nBranch;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public boolean isHelp() {
		return help;
	}

	public void setHelp(boolean help) {
		this.help = help;
	}
    
	/**
	 * Options of analyzer: 
	 * `p` is the path of method to be analyzed, this is a required option;
	 * `g` indicates building CGF and print matrix, this is an optional option;
	 * `n` indicates showing the number of branches in the CGF, this is an optional option;
	 * `d` indicates showing each branch, this is an optional option;
	 */
	private Options createOptions(){
		// create Options object
		Options options = new Options();
		// add options
		options.addOption(Option.builder("p").desc("path of the method to be analyzed")
				.hasArg()
				.argName("input path")
				.required() //this is a required option
				.build());
		
		options.addOption(Option.builder("g").desc("build CFG and print the adjacency matrix")
				.build());
		
		options.addOption(Option.builder("n").desc("show the number of branches")
				.build());
		
		options.addOption(Option.builder("d").desc("show each branch")
				.build());
		
		options.addOption(Option.builder("h").desc("show help information")
				.build());

		return options;
	}
	/**
	 * parse options in the arguments.
	 * @param options
	 * @param args
	 * @return
	 */
	private boolean parseOptions(Options options, String[] args){
		
		CommandLineParser parser = new DefaultParser();
		try{
			CommandLine cmd = parser.parse(options, args);
			this.setPath(cmd.getOptionValue("p")); // get the path of the method to be analyzed
			this.setCfg(cmd.hasOption("g")); // whether `g` is in the arguments
			this.setnBranch(cmd.hasOption("n")); // whether `n` is in the arguments
			this.setShowBranch(cmd.hasOption("d")); // whether `d` is in the arguments
			this.setHelp(cmd.hasOption("h")); // whether `h` is in the arguments
		} catch (Exception e) {
			Utils.log(e.toString());
			return false;
		}
		return true;
	}
	
    /**
     * @return `true` if the path exists, otherwise return `false`;
     */
	private boolean isPathExist() {
		/**
		 * TODO: check whether the path exists or not;
		 */
		
		
		return true;
	}
	
	private void printHelp(Options options) {
		// automatically generate the help statement
		HelpFormatter formatter = new HelpFormatter();
		String header = "Build and analyze the CFG for a Python-- method.";
		String footer ="";
		formatter.printHelp("analyzer", header, options, footer, true);
	}	
	
	public static void main (String [] args) throws Exception {
		Main scan = new Main();
		
		/**
		 * If program argument has `help` option: print help information and return;
		 */
		Options options = scan.createOptions();
		if(scan.parseOptions(options, args)){
			if (scan.isHelp()){
				scan.printHelp(options);
				return;
			}
		}
		
		/**
		 * Check whether the path of the method to be analyzed exists;
		 * if path does not exit: print message M1 and return;
		 */
		if(!scan.isPathExist()) {
			Utils.log(Message.M1);
			return;
		}
		
		//System.out.print(scan.getPath());
		
		/**
		 * @TODO:
		 * 		  1. has option `g` (i.e., cfg is true): 
		 * 									Task: build the CFG and print adjacency matrix of the CFG;
		 * 
		 * 		  2. has option `n` (i.e., nBranch is true): 
		 * 									Task: show the number of branches in the CFG;
		 * 
		 * 		  3. has option 'd' (i.e., showBranch is true): 
		 * 									Task: print each branch;
		 */
	}
}
