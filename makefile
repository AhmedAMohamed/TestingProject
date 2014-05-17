
all : FileGenerator.java Graph.java Main.java ProcessGraph.java YacConvertor.java YAK2Graph.java input.yak
  javac FileGenerator.java Graph.java Main.java ProcessGraph.java YacConvertor.java YAK2Graph.java
	java Main --fulreport input.yak
	java Main --showGraph input.yak
	@echo "****************** DONE **********************"

HelpMe : 
	javac FileGenerator.java Graph.java Main.java ProcessGraph.java YacConvertor.java YAK2Graph.java
	java Main --help	
	@echo "****************** you have already got your help ********************"

GenInputFile :
	@echo "****************** to save the file it must be at the name of input.yak in the same directory *******************"
	gedit &

Report : FileGenerator.java Graph.java Main.java ProcessGraph.java YacConvertor.java YAK2Graph.java input.yak
	javac FileGenerator.java Graph.java Main.java ProcessGraph.java YacConvertor.java YAK2Graph.java
	java Main --fulreport input.yak
	@echo "****************** DONE **********************"

GraphShower : FileGenerator.java Graph.java Main.java ProcessGraph.java YacConvertor.java YAK2Graph.java input.yak
	javac FileGenerator.java Graph.java Main.java ProcessGraph.java YacConvertor.java YAK2Graph.java
	java Main --showGraph input.yak

Cleen  : 
	rm -f FileGenerator.class Graph.class Main.class ProcessGraph.class YacConvertor.class YAK2Graph.class
	rm -f yacFile.yakA
	rm -f graphInput.dot
	@echo "***************** All un-needed files has already removed *************************"

