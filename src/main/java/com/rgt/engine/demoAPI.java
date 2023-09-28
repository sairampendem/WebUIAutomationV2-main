package com.rgt.engine;

import com.rgt.utils.CommonUntils;
import com.rgt.utils.ExcelUtils;

public class demoAPI 
{
	
	 public static void main(String args[]) throws Exception
	 { CommonUntils td= new CommonUntils();
		 ExcelUtils e = new ExcelUtils("C:\\WebAutomation\\WebUIAutomationV2-main\\TC_Master.xlsx");
		 for(int i=0;i<e.getTCMaster().size();i++) {
			String s= e.getTestSteps(e.getTCMaster().get(i).getTC_ID()).get(i).getTestSteps();
			 //String decrypted=td.decrypt(s);
			 //System.out.println("Decrypted String:" + decrypted);
		 }
		
		// PPtzM23g+xDBNCPpSvMvHQ==
			//	 rgttestautomatio
	        String target="Sairam@123";
	       // String encrypted=td.encrypt(target);
//	       
        String decrypted=CommonUntils.decrypt("cMtKh3AGIy8nXIEO4jVLog==","rgttestautomationrgttestautomati");
//
//	        System.out.println("String To Encrypt: "+ target);
	        System.out.println("Encrypted String:" + decrypted);
	        
	 }

}
