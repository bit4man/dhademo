package com.sample.dha;

import java.util.Date;

import org.dits.proj1.TestResult;
import org.kie.api.runtime.KieSession;

import com.sample.utils.BRMSUtil;

public class DhaTest {

	private BRMSUtil brmsUtil = new BRMSUtil();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DhaTest test = new DhaTest();
		test.run();
	}
	
	void run() {
		KieSession ksession = brmsUtil.getStatefulSession();
		TestResult result = new TestResult();
		result.setCertDate(new Date());
		result.setSystem("test");
		
		ksession.insert(result);
		ksession.fireAllRules();
		
		ksession.dispose();
	}

}
