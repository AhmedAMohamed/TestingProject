import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class YakConvertor {
	private File yacAFile;
	private File yacFile;
	public File getYacFile() {
		return yacFile;
	}

	public void setYacFile(File yacFile) {
		this.yacFile = yacFile;
	}

	private File meddileWare;
	
	public YakConvertor(String inputFilePath){
		yacAFile = new File(inputFilePath);
		yacFile = new File("yacFile.yakA");
		deleteComments();
	}
	
	private void deleteComments(){
		meddileWare = new File("meddileWare.a");
		try {
			String temporaryLine = null;
			Scanner reader = new Scanner(yacAFile);
			PrintWriter writer = new PrintWriter(meddileWare);
			while(reader.hasNext()){
				temporaryLine = reader.nextLine();
				if(temporaryLine.charAt(0) == '/' && temporaryLine.charAt(1) == '/'){
					continue;
				}
				else{
					//System.out.println(temporaryLine);
					writer.write(temporaryLine + '\n');
				}
			}
			writer.close();
			reader.close();
			copyToYacFile();
		} catch (FileNotFoundException e) {
			System.out.println("the file hjhh input not found (try again later)");
			System.exit(0);
		} 
	}
	
	private void copyToYacFile() throws FileNotFoundException {
		Scanner reader = new Scanner(meddileWare);
		PrintWriter writer = new PrintWriter(yacFile);
		String Line = new String();
		while(reader.hasNext()){
			Line = reader.nextLine();
			writer.write(Line + '\n');
		}
		writer.close();
		reader.close();
		meddileWare.delete();
	}
	
}
