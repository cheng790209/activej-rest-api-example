To get an executable jar with all dependencies inside, use
`mvn clean package shade:shade`
Then, execute the shaded.jar file in targets/

To execute a jar file, use:
`java -jar  the_shaded_one.jar`