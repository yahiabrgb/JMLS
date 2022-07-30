package JMlessous;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import JMlessous.entities.TableMortalité;
import JMlessous.services.ITableMortaliteService;

@SpringBootTest
class JmlsApplicationTests {
	@Autowired
	ITableMortaliteService tr;	
	@Test
	void test() throws IOException {
	  try {
          Runtime runTime = Runtime.getRuntime();
          
          String executablePath = "C:\\Users\\Bourguiba\\SigDetect.exe";
          
          Process process = runTime.exec(executablePath);
         
          try {
			process.waitFor();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
          InputStream is = process.getInputStream();
          BufferedReader in = new BufferedReader(new InputStreamReader(is));
          String temp;

          while ((temp = in.readLine()) != null) {
              System.out.println(temp);
          }
          int n = 0;
          while(n != -1)
          {
          n = is.read();
          System.out.print(n);
          }
      } catch (IOException e) {
          e.printStackTrace();
      }
	  
  }
	}

