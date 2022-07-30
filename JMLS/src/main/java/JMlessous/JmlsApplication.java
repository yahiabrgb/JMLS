package JMlessous;

import org.springframework.boot.SpringApplication; 
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.python.util.PythonInterpreter;

@SpringBootApplication
public class JmlsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JmlsApplication.class, args);
		try(PythonInterpreter pyInterp = new PythonInterpreter()) {
		      pyInterp.exec("print('Hello Python World!')");
		      pyInterp.exec("import numpy as np");}
	}

}
