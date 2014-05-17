

HelpMe : 

	javac -cp a.jar:b.jar:c.jar:d.jar:e.jar:f.jar:g.jar:l.jar:k.jar FileGenerator.java Graph.java Main.java ProcessGraph.java YacConvertor.java YAK2Graph.java Pdf
	java -cp a.jar:b.jar:c.jar:d.jar:e.jar:f.jar:g.jar:l.jar:k.jar Main --help
	@echo "****************** you have already got your help ********************"
MakeHelper :
	@echo "There are many options you can choose while using the YAK tool"
	@echo "First generate the input file but take good care that it should be in the same directory with makfile by using make GenInput"
	@echo "Second generate pdf report by using make Report"
	@echo "Third show te result png image by using make GraphShower "
	@echo "Forth All the previos tasks with only one command line make All"
	@echo "Fifth Clean the directory from unneaded files after finishing using the tool"
	@echo "Last show the tool helping command"

GenInput :
	@echo "****************** to save the file it must be at the name of input.yak in the same directory *******************"
	gedit &

Clean  : 
	rm -f FileGenerator.class Graph.class Main.class ProcessGraph.class YacConvertor.class YAK2Graph.class PdfJenerator.class
	rm -f yacFile.yakA
	rm -f graphInput.dot
	rm -f theGraph.png
	rm -f report.pdf

	@echo "***************** All un-needed files has already removed *************************"
All : FileGenerator.java Graph.java Main.java ProcessGraph.java YacConvertor.java YAK2Graph.java input.yak a.jar b.jar c.jar d.jar e.jar f.jar g.jar l.jar k.jar
	make Report
	make GraphShower
	clear

Report : FileGenerator.java Graph.java Main.java ProcessGraph.java YacConvertor.java YAK2Graph.java input.yak a.jar b.jar c.jar d.jar e.jar f.jar g.jar l.jar k.jar

	 javac -cp a.jar:b.jar:c.jar:d.jar:e.jar:f.jar:g.jar:k.jar:l.jar Main.java FileGenerator.java Graph.java ProcessGraph.java PdfJenerator.java YacConvertor.java YAK2Graph.java 
	java -cp .:a.jar:b.jar:c.jar:d.jar:e.jar:f.jar:l.jar:k.jar:g.jar Main --fullreport input.yak

	@echo "****************** DONE **********************"

GraphShower : FileGenerator.java Graph.java Main.java ProcessGraph.java YacConvertor.java YAK2Graph.java input.yak a.jar b.jar c.jar d.jar e.jar f.jar g.jar l.jar k.jar

	
	 javac -cp a.jar:b.jar:c.jar:d.jar:e.jar:f.jar:g.jar:k.jar:l.jar Main.java FileGenerator.java Graph.java ProcessGraph.java PdfJenerator.java YacConvertor.java YAK2Graph.java 
	java -cp .:a.jar:b.jar:c.jar:d.jar:e.jar:f.jar:l.jar:k.jar:g.jar Main --showGraph input.yak
	clear


