
import java.io.File;
import java.io.IOException;
import com.itextpdf.text.DocumentException;


public class Main {
	
	private static File yakAFile;
	private static File dotFile;
	private static String imageName;
	
	
	public static File getYakAFile() {
		return yakAFile;
	}
	public static void setYakAFile(File yakAFil) {
		yakAFile = yakAFil;
	}
	
	
	@SuppressWarnings("unused")
	public static void main(String []args) throws IOException, DocumentException{
		
		imageName = "theGraph.png";
		Runtime rt = Runtime.getRuntime();
		Process excute;
		int switcher = -1;
		if(args[0].equalsIgnoreCase("--help")){
			switcher = 0;
		}
		else if(args[0].equalsIgnoreCase("--fullreport")){
			switcher = 1; 			
		}
		else if(args[0].equalsIgnoreCase("--showGraph")){
			switcher = 2;
		}
		
		switch(switcher){
		case 0: // help
			System.out.println();
			System.out.println();
			System.out.print("The YAK tool has three main process to achieve\n");
			System.out.print("1- drawing the graph from a source file that the user insert it\n");
			System.out.println("For example:\n Main [option] SourceFile.yac\n");
			System.out.println("The options \n1- --help\t for getting help to work with the tool\n"
					+ "2- --fullreport\t for generate a full report to the user should have a parameter source file name\n"
					+ "3- --showGraph\t for showing the graph after generating it, it also need a parameter source file name\n"
					+ "\tFor more information wathc the source code at ahmed3307023 reprosetory at github\t\nThe conributers are\n\t1-Yousef hamza\n\t2-Ahmed alaa\n\t3-Khaled Essam\n  ");
			break;
		case 1: // full report
			if(args[1].contains("yak")){
				YacConvertor convertor = new YacConvertor(args[1]);
				setYakAFile(convertor.getYacFile());
				FileGenerator dotFileGenerator = new FileGenerator(getYakAFile());
				setDotFile(dotFileGenerator.getOutputFile());
				excute = rt.exec("dot -Tpng " + dotFileGenerator.getOutputFileName() + " -o " + imageName);
				YAK2Graph dataStructureConvertor = new YAK2Graph(getYakAFile());
				ProcessGraph pathFinder = new ProcessGraph(dataStructureConvertor.getG().getGraph());
				pathFinder.generateSimplePaths();
				pathFinder.generatePrimePaths();
				pathFinder.generateTestPath();
				PdfJenerator report = new PdfJenerator(pathFinder , getImageName());
				
			}
			else{
				System.out.println("\t**********wrong input file extention**********");	
			}
			break;
		case 2:
			if(args[1].contains("yak")){
				YacConvertor convertor = new YacConvertor(args[1]);
				setYakAFile(convertor.getYacFile());
				FileGenerator dotFileGenerator = new FileGenerator(getYakAFile());
				setDotFile(dotFileGenerator.getOutputFile());
			excute = rt.exec("dot -Tpng " + dotFileGenerator.getOutputFileName() + " -o " + imageName);
				excute = rt.exec("shotwell theGraph.png");
			}
			else{
				System.out.println("\t**********wrong input file extention**********");
				break;
			}
			break;
		}
			
	}
	public static File getDotFile() {
		return dotFile;
	}
	public static void setDotFile(File dotFile) {
		Main.dotFile = dotFile;
	}
	public static String getImageName(){
		return imageName;
	}
}
