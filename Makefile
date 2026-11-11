all:
	javac -d classes -sourcepath src src/org/ioopm/calculator/Calculator.java

run:
	java -cp classes org.ioopm.calculator.Calculator

test:
	javac -d src -sourcepath src src/Test.java
	java -cp src -enableassertions Test

clean:
	rm -rf classes