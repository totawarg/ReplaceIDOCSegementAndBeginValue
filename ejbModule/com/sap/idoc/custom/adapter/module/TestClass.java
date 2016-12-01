package com.sap.idoc.custom.adapter.module;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class TestClass {
	
	public static void main(String[] a) throws FileNotFoundException, ReplaceIDOCSegementAndBeginValueException{
		/**
		String segement="hello SEGMENT=\"a\"";
		String regExpressionNum="[0-9&&[^SEGMENT]]";
		String regExpressionA1="[A-Z&&[^SEGMENT]]";
		String regExpressionA2="[a-z&&[^SEGMENT]]";

		String regExpression1="[\\*&&[^SEGMENT]]";
		String regExpression3="[\\?&&[^SEGMENT]]";
		
		String regExpression4="[[^SEGMENT=]]";
		System.out.println(segement);
		System.out.println(segement.(regExpressionA2, "1"));;
		
		private static String segmentRegExpressionNumber = "[0-9&&[^SEGMENT]]";
	private static String beginRegExpressionNumber = "[0-9&&[^BEGIN]]";
	
	private static String segmentRegExpressionUA = "[A-Z&&[^SEGMENT]]";
	private static String beginRegExpressionUA = "[A-Z&&[^BEGIN]]";
	
	private static String segmentRegExpressionLA = "[a-z&&[^SEGMENT]]";
	private static String beginRegExpressionLA = "[a-z&&[^BEGIN]]";
	
	private static String segmentRegExpressionStar = "[\\*&&[^SEGMENT]]";
	private static String beginRegExpressionStar = "[\\*&&[^BEGIN]]";
	
	private static String segmentRegExpressionQ = "[\\?&&[^SEGMENT]]";
	private static String beginRegExpressionQ = "[\\?&&[^BEGIN]]";
	
	private static String replacementValue="1";
	 String text = "SEGMENT=\"*\" Exact String Replace In Java SEGEMENT=\"1\"";
		   
		    text = text.replaceAll("\\bSEGMENT=\"\\*\"\\B", "SEGMENT=\"1\"");
		   
		    System.out.println(text);
		
		**/
	
	String path="C:/Users/i045193/Documents/Richard/MainDocument.xml";
	FileInputStream in=new FileInputStream(path);
	ByteArrayOutputStream out=new ByteArrayOutputStream();
	
	/**
	 * private static String[] SEARCH = {"\\bSEGMENT=\"\\W*\"\\B",
			   							"\\bSEGMENT=\"\\w*\"\\B",
			   							"\\bSEGMENT=\"\\d*\"\\B",
			   							"\\bSEGMENT=\"\\D*\"\\B",
			   							"\\bSEGMENT=\"\\s*\"\\B",
			   							"\\bSEGMENT=\"\\S*\"\\B",
			   							"SEGEMENT=\"\"",
			   							"\\bBEGIN=\"\\W*\"\\B",
			   							"\\bBEGIN=\"\\w*\"\\B",
			   							"\\bBEGIN=\"\\d*\"\\B",
			   							"\\bBEGIN=\"\\D*\"\\B",
			   							"\\bBEGIN=\"\\s*\"\\B",
			   							"\\bBEGIN=\"\\S*\"\\B",
			   							"BEGIN=\"\""};;
			   							
	 */
	String [] search ={"\\bSEGMENT=\"\\W*\"\\B" +"|"+ 
					   "\\bSEGMENT=\"\\w*\"\\B" +"|"+
					   "\\bSEGMENT=\"\\d*\"\\B" +"|"+
					   "\\bSEGMENT=\"\\D*\"\\B" +"|"+
					   "\\bSEGMENT=\"\\s*\"\\B" +"|"+
					   "\\bSEGMENT=\"\\S*\"\\B" +"|"+
					   "SEGEMENT=\"\"",
					   "\\bBEGIN=\"\\W*\"\\B" +"|"+
					   "\\bBEGIN=\"\\w*\"\\B" +"|"+
					   "\\bBEGIN=\"\\d*\"\\B" +"|"+
					   "\\bBEGIN=\"\\D*\"\\B" +"|"+
					   "\\bBEGIN=\"\\s*\"\\B" +"|"+
					   "\\bBEGIN=\"\\S*\"\\B" +"|"+
					   "BEGIN=\"\""};
					   
	
	//String search[] ={"\\bSEGMENT=\"\\W*\"\\B | \\bSEGMENT=\"\\w*\"\\B | \\bSEGMENT=\"\\d*\"\\B | \\bSEGMENT=\"\\D*\"\\B | \\bSEGMENT=\"\\s*\"\\B |\\bSEGMENT=\"\\S*\"\\B|SEGEMENT=\"\" , \""\\bBEGIN=\"\\W*\"\\B  |\\bBEGIN=\"\\w*\"\\B |\\bBEGIN=\"\\d*\"\\B|\\bBEGIN=\"\\D*\"\\B|\\bBEGIN=\"\\s*\"\\B|\\bBEGIN=\"\\S*\"\\B|BEGIN=\"\"\"};
	ReplaceIDOCSegmentAndBeginValue replace=new ReplaceIDOCSegmentAndBeginValue();
	replace.execute(in, out, search);
	System.out.println(out);
	
		
		
	}

}
