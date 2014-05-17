import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.omg.SendingContext.RunTime;


public class FileGenerator {
	private File inputFile;
	private File outputFile;

	public File getOutputFile() {
		return outputFile;
	}


	public void setOutputFile(File outputFile) {
		this.outputFile = outputFile;
	}


	public FileGenerator(File input) throws FileNotFoundException{
		inputFile = input;
		outputFile = new File("graphInput.dot");
		convertToDot();
	}
	
	
	private void convertToDot() throws FileNotFoundException{
		String theLine;
		int index = 0;
		PrintWriter writer = new PrintWriter(outputFile);
		String graphName = null;
		String startNode = null;
		String endNode = null;
	
		try {
			Scanner reader = new Scanner(inputFile);
			while(reader.hasNextLine()){
				theLine = reader.nextLine();
				String [] tokens = theLine.split(" ");
				if(checkTokens(tokens, index)){
					if(index == 0){
						graphName = tokens[1];
						writer.write("digraph " + graphName + "{" + '\n' + "size = \"4,4\"; \n" );
						/*
						 	digraph G {
						 	size = "4,4" ;
						 */

					}
					else if(index == 1){
						
					}
					else if(index == 2){
						 
					}
					else if(index == 3){
						startNode = tokens[1];
						writer.write(startNode + "[shape = circle, style = filled, color = lightgrey];\n");
					}
					else if(index == 4){
						endNode = tokens[1];
						writer.write(endNode + "[shape = circle, style = bold, color = black];\n");
						writer.write("node[shape = circle; color = black];\n");
					}
					else if(index > 4 && theLine.equalsIgnoreCase("@begin")){
						theLine = reader.nextLine();
						tokens = theLine.split(" ");
						while(!theLine.equalsIgnoreCase("@end")){
							if(checkCodesCorrect(tokens, startNode, endNode)){
								writer.write(tokens[0] + " -> " + tokens[2] + " \n");
								//System.out.println(theLine);
								theLine = reader.nextLine();
								tokens = theLine.split(" ");
							}
						}
							index++;
					}
					else{
						//if(theLine.equalsIgnoreCase("@end " + graphName)){
							writer.write("}" + '\n');
							writer.close();
						//}
					}
					
				}
				else{
				//	System.out.println("bad syntax in line" + index+1 + " \n");
				}
				index++;
			}
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("the file input not found (try again later)");
			System.exit(0);
		}
		
	}
	private boolean checkCodesCorrect(String[] tokens, String startNode,String endNode) {
		if(tokens[0].equalsIgnoreCase(endNode)){
			System.out.println("You have made a mistake the final node can not be a start node to another node ");
			System.exit(0);
			return false;
		}
		else{
			return true;
		}
	}


	private boolean checkTokens(String[] tokens, int index) {
		return true;
	}


	public String getOutputFileName() {
		String fileName = "graphInput.dot";
		return fileName;
	}
}
