# Copyright (c) Martin Ueding <dev@martin-ueding.de>

sierpinskigen.jar: Mvkm.class
	jar -cfm $@ manifest.txt *.class

Mvkm.class: *.java
	javac -encoding UTF-8 Mvkm.java

clean:
	rm -rf *.class *.jar
