# Copyright (c) Martin Ueding <dev@martin-ueding.de>

sierpinskigen.jar: Mvkm.class
	jar -cfm sierpinskigen.jar manifest.txt *.class

Mvkm.class: *.java
	javac Mvkm.java
