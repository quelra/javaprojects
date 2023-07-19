Teamba 3.0 - Applications Development
===========================================================================================================================================
STEPS:
COMMANDS                 DESCRIPTION:                                                             DESTINATION:

1) "ant jar"             = to compile and jar                   (type filename "Solutions")       = /build/classes, /build/jar
2) "ant run"             = to compile, jar and run java file    (type filename "Solutions")       = /build/jar
3) "ant jarDoc"          = to create documentation and jar doc  (type filename "Solutions")       = /docs/Solutions.html, /build/jar/
4) "ant test-junit"      = to compile java files and generate junit test xml report               = /lib/junit/junitreports
5) "ant junit-report"    = to generate junit test html report                                     = /lib/junit/htmlreports
6) [command to use jacoco]


===========================================================================================================================================
A. build.xml CONTENTS

    1) COMPILING AND RUNNING A JAVA FILE [Raquel Bautista]
        ***To easily compile input command "ant jar". 

            ***SOURCE: src/
            ***DESTINATION: build/classes, build/jar

            ***Ant Tasks:
                "ant compile"  = (depends on inputFileName) - will require input of file name e.g. "Solutions"
                "ant jar"      = (depends on compile)
                "ant run"      = (depends on jar)
                "ant clean-build" = delete build

    2) JAVA DOCUMENTATION [Rodolfo Aaron Mercado]
        ***To compile the documentation use, "ant jarDoc"

            *** SOURCE: src/
            *** DOCUMENTATION: doc/

            ***Ant Tasks:
                "ant createDocumentation"  = Create documentation classes used in the project 
                "ant jarDoc"               = depends on createDocumentation

    3) JUNIT TEST 
        2.1. Generating JUnit Test reports [Leonardo Gavino III]
        *** To generate xml report use, "ant test-junit"

            ***Ant Tasks:
                "ant test-compile"
                "ant test-junit"        = depends on test-compile

        2.2. Generating JUnit Test HTML report [Raquel Bautista]
        *** To generate html report from the xml report use, "ant junit-report"

            ***Ant Tasks:
                "ant junit-report"

    4) JACOCO TEST [Karl Adrian Laroya]
        [add here]

===========================================================================================================================================
B. JUNIT Testing on console [Heidi Batara] [Rianne Justine Policarpio]
CURRENT DIRECTORY: ..\TeamBa3.0
                                                                                                                                             
1) COMMAND: javac -cp lib\junit\jar\junit.jar;src\;. src\Solutions.java src\SolutionsTest.java                                                   
   DESCRIPTION: Compiles the files "Solutions.java" and "SolutionsTest.java"
2) COMMAND: java -cp .\lib\junit\jar\junit.jar;.\lib\junit\jar\hamcrest-core-1.3.jar;.\src\ org.junit.runner.JUnitCore SolutionsTest
   DESCRIPTION: Executes the file "SolutionsTest"

===========================================================================================================================================
C. Solutions.java (/src)
    Methods:
        1) Main
        2) passwordCheck                    [Raquel Bautista]
        3) luckyTicket                      [Raquel Bautista]
        4) spyDetected                      [Leonardo Gavino III] modified: [Raquel]
        5) boyOrGirl                        [Leonardo Gavino III] modified: [Raquel]
        6) theSumOf2050                     [Heidi Batara]
        7) splits                           [Heidi Batara]
        8) dislikeOfThrees                  [Rodolfo Aaron Mercado]
        9) Watermelon                       [Rodolfo Aaron Mercado]
        10) aNewPassword                    [Rianne Justin Policarpio]
        11) helpFarAwayKingdom              [Rianne Justin Policarpio]
        12) theMiracleAndTheSleeper         [Karl Adian Laroya]  modified: [Raquel]
        13) elections                       [Karl Adian Laroya]  modified: [Raquel]
    
===========================================================================================================================================
D. SolutionsTest.java
    Methods:
        1) passwordCheck                    [Raquel Bautista]
        2) luckyTicket                      [Raquel Bautista]
        3) spyDetected                      [Leonardo Gavino III] 
        4) boyOrGirl                        [Leonardo Gavino III] 
        5) theSumOf2050                     [Heidi Batara]
        6) splits                           [Heidi Batara]
        7) dislikeOfThrees                  [Rodolfo Aaron Mercado]
        8) Watermelon                       [Rodolfo Aaron Mercado]
        9) aNewPassword                     [Rianne Justin Policarpio]
        10) helpFarAwayKingdom              [Rianne Justin Policarpio]
        11) theMiracleAndTheSleeper         [Karl Adian Laroya]  
        12) elections                       [Karl Adian Laroya] 

===========================================================================================================================================
(Application Development)
Teamba 3.0