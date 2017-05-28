package exercise;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public aspect Findit {

	/**
	 * @param args
	 */
	private ArrayList<String> allMethod;
	private boolean cont=false;
	private String nowMethod;
	private boolean saved=false;
	pointcut wayCut():(call(* *(..))&&!within(Findit));
	pointcut methodCut():(execution(* *(..))&&!within(Findit));
	private void saveFile(){
		//write all methods to the file 
		File file=new File("check.txt");
		try {
			FileWriter fw=new FileWriter(file,true);
			for(String one:allMethod){
				fw.write(one+"\r\n");
			}
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private boolean checkDefen(String methodName){
		//judge any method to defend the malware
		if(methodName.indexOf("prompt")!=-1||methodName.indexOf("onLoadResource")!=-1||methodName.indexOf("doUpdateVisitedHistory")!=-1
			||methodName.indexOf("onPageStarted")!=-1||methodName.indexOf("onPageFinished")!=-1||methodName.indexOf("onReceivedTitle")!=-1
			||methodName.indexOf("onProgressChanged")!=-1)
			return true;
		return false;
	}
	before():wayCut(){
		//record the method called by webview and judge the dangous exist or not
		String className=thisJoinPoint.getSignature().getDeclaringTypeName();
		if(className.indexOf("WebView")!=-1)
			cont=true;
		String methodName=thisJoinPoint.getSignature().getName();
		//record the begining of webview
		if(nowMethod==null)
			nowMethod=className+methodName;
		if(cont){
			allMethod.add(className+"->"+methodName);
			if(methodName.toLowerCase().indexOf("javascript")!=-1&&(methodName+className).toLowerCase()!="javascriptinterface")
				//judge the malware exists or not
				saved=true;
			else if(checkDefen(methodName)&&saved)
				//judge the defend method exists or not 
				saved=false;
		}
	}
	after():methodCut(){
		//reset all params and record if the malware exists
		String className=thisJoinPoint.getSignature().getDeclaringTypeName();
		className=className.substring(className.lastIndexOf(".")+1, className.length());
		String methodName=thisJoinPoint.getSignature().getName();
		if(nowMethod!=null&&nowMethod.equals(className+methodName)){
			//the method finished and if the malware exists then record it
			cont=false;
			if(saved)
				saveFile();
			allMethod.clear();
			saved=false;
		}
	}
}
