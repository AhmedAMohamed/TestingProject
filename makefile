

HelpMe : 
	javac FileGenerator.java Graph.java Main.java ProcessGraph.java YacConvertor.java YAK2Graph.java
	java Main --help	
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
	rm -f FileGenerator.class Graph.class Main.class ProcessGraph.class YacConvertor.class YAK2Graph.class
	rm -f yacFile.yakA
	rm -f graphInput.dot
	rm -f theGraph.png
	@echo "***************** All un-needed files has already removed *************************"
All : FileGenerator.java Graph.java Main.java ProcessGraph.java YacConvertor.java YAK2Graph.java input.yak
	make Report
	make GraphShower
	clear

Report : FileGenerator.java Graph.java Main.java ProcessGraph.java YacConvertor.java YAK2Graph.java input.yak
	javac FileGenerator.java Graph.java Main.java ProcessGraph.java YacConvertor.java YAK2Graph.java
	java Main --fullreport input.yak
	@echo "****************** DONE **********************"

GraphShower : FileGenerator.java Graph.java Main.java ProcessGraph.java YacConvertor.java YAK2Graph.java input.yak
	javac FileGenerator.java Graph.java Main.java ProcessGraph.java YacConvertor.java YAK2Graph.java
	java Main --showGraph input.yak
	clear


