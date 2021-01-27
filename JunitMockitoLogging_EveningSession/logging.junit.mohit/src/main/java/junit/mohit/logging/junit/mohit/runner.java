package junit.mohit.logging.junit.mohit;

import Mohit.Appender;
import Mohit.ConsoleAppender;
import Mohit.Failure;
import Mohit.Layout;
import Mohit.Logger;
import Mohit.PatternLayout;
import Mohit.Result;
import Mohit.runner;
import Mohit.tester;

public class runner {
	private static Logger log= Logger.getLogger(runner.class);
	   public static void main(String[] args) {
		  Layout layout=new PatternLayout("%p %d %C %M %n");
		  Appender app=new ConsoleAppender(layout);
		  log.addAppender(app);
		  log.info("from info");
		  log.debug("from debug");
		  log.fatal("from fatal");
	      Result result = JUnitCore.runClasses(tester.class);
	      for (Failure failure : result.getFailures()) {
	         System.out.println(failure.toString());
	      }
	      System.out.println(result.wasSuccessful());
	   }

}
