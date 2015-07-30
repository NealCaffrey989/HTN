echo basic
:begin
e:
if exist E:\³ÌÐò\Java\jshop2\src\JSHOP2\doc\jshopresult.xml del E:\³ÌÐò\Java\jshop2\src\JSHOP2\doc\jshopresult.xml
cd E:\³ÌÐò\Java\jshop2\src\JSHOP2\bin
del *.txt
del *.java
del Axiom*.class
del Method*.class
del Operator*.class
del Precondition*.class
del basic.class
if not exist problem goto end
if not exist basic goto end
if not exist CodeComple.class goto end
java CodeComple basic
java CodeComple -r
if not exist problem.java  goto end
javac problem.java
if not exist basic.java goto end
javac basic.java
java MainJSHOP2
del problem
del basic
:end 
pause