package utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
	
	int mintry=0;
	int Maxtty=1;

	@Override
	public boolean retry(ITestResult result) {
		
		Log.info("This now rerun the failed "+result.getName()+"for check");
		if (mintry<Maxtty) {
			mintry++;
			return true;
		}
		
		return false;
	}

	
}
