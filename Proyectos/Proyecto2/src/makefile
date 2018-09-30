all:
	jflex atomos.flex && byaccj -v -Jclass=Parser ${source}
	javac Atomos.java && javac Parser.java

test:
	java Parser ${file}

clean:
	rm -f *.class  *.java* y.tab.c
