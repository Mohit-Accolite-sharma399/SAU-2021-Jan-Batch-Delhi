//             Java Advanced Assignment (Mohit Sharma)
package mohit;

import java.util.* ; 
import java.text.SimpleDateFormat;
import java.io.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class Annotations {
	
	public static void main(String[] args) {
		try {
	         File inputFile1 = new File("C:\Users\This PC\Desktop\Accolite Assignments\SAU-2021-Jan-Batch-Delhi/Java-EveningSession/file1.txt");
	         File inputFile2 = new File("C:\Users\This PC\Desktop\Accolite Assignments\SAU-2021-Jan-Batch-Delhi/Java-EveningSession/file2.txt");
	         
	         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	         
	         Document doc1 = dBuilder.parse(inputFile1);
	         Document doc2 = dBuilder.parse(inputFile2);
	         
	         Document merged_doc = dBuilder.newDocument() ;
	         Document validDoc = dBuilder.newDocument() ;
	         Document invalidDoc = dBuilder.newDocument() ;
	         
	         doc1.getDocumentElement().normalize();
	         doc2.getDocumentElement().normalize();
	         

	         NodeList doc1_CSR = doc1.getElementsByTagName("CSR_Producer");
	         NodeList doc2_CSR = doc2.getElementsByTagName("CSR_Producer");
	         
	         Element root = merged_doc.createElement("CSR_Producer");
	         merged_doc.appendChild(root);
	         
	         System.out.println(); 
	         for(int temp = 0; temp < doc1_CSR.getLength(); temp++) {
	             Node curr_CSR1 = doc1_CSR.item(temp);
	             
	             for(int i = 0 ; i < doc2_CSR.getLength() ; i++){
	            	 Node curr_CSR2 = doc2_CSR.item(i) ; 
	            	 Element curr_Element1 = (Element) curr_CSR1 ; 
	            	 Element curr_Element2 = (Element) curr_CSR2 ;
	            	 
	            	 if( curr_Ele1.getAttribute("NIPR_Number").equals(curr_Ele2.getAttribute("NIPR_Number")) ){
	            		 NodeList arr1 = curr_Element1.getElementsByTagName("License");
	            		 
	            		 for(int j = 0 ; j < arr1.getLength() ; j++){
	            			 Element license_element1 = (Element)arr1.item(j);
	            			 NodeList arr2 = curr_Element2.getElementsByTagName("License");
	            			 
	            			 for(int k = 0 ; k < arr2.getLength() ; k++){
	            				 Element license_element2 = (Element)arr2.item(k) ; 
	            				 
	            				 if(license_element1.getAttribute("State_Code").equals(license_element2.getAttribute("State_Code")) 
	            						 && license_element1.getAttribute("License_Number").equals(license_element2.getAttribute("License_Number"))
	            						 && license_element1.getAttribute("License_Expiration_Date").equals(license_element2.getAttribute("License_Expiration_Date"))){

	            					 Node newEle = merged_doc.importNode(license_element2, true) ;  
	            					 root.appendChild(newEle) ;
	            					 System.out.println("After Copying");
	            					 prettyPrint(merged_doc,"C:\Users\This PC\Desktop\Accolite Assignments\SAU-2021-Jan-Batch-Delhi/Java-EveningSession/merged_file.txt");
	            			         
	            				 }
	            			 }
	            		 }
	            	 }     	 
	             }
	         }
	         
	         Element valid = validDoc.createElement("CSR_Producer");
	         validDoc.appendChild(valid);
	         
	         Element invalid = invalidDoc.createElement("CSR_Producer");
	         invalidDoc.appendChild(invalid);
	         
	         NodeList mergedDoc_CSR = merged_doc.getElementsByTagName("CSR_Producer");
	         for(int i = 0 ; i < mergedDoc_CSR.getLength() ; i++){
	        	 Element curr_element = (Element)mergedDoc_CSR.item(i) ; 
	        	 NodeList license_list = curr_element.getElementsByTagName("License") ; 
	        	 
	        	 for(int j = 0 ; j < license_list.getLength() ; j++){
	        		 Element curr_license =  (Element)license_list.item(j) ; 
	        		 String date = curr_license.getAttribute("License_Expiration_Date");
	        		 Date expiry = new SimpleDateFormat("dd/MM/yyyy").parse(date);  
	        		 Date curr = new Date() ; 
	        		 
	        		 if(expiry.compareTo(curr) > 0){
	        			 Node newEle = validDoc.importNode(curr_license, true) ;  
    					 valid.appendChild(newEle) ;
    					 prettyPrint(validDoc,"C:\Users\This PC\Desktop\Accolite Assignments\SAU-2021-Jan-Batch-Delhi/Java-EveningSession/ValidEntries.txt");
	        		 }else{
	        			 Node newEle = invalidDoc.importNode(curr_license, true) ;  
    					 invalid.appendChild(newEle) ;
    					 prettyPrint(invalidDoc,"C:\Users\This PC\Desktop\Accolite Assignments\SAU-2021-Jan-Batch-Delhi/Java-EveningSession/InvalidEntries.txt");
	        		 }
	        	 }
	         }
	         
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println() ; 
		}
	}
	
	public static final void prettyPrint(Document xml , String filename)  throws Exception {
        Transformer tf = TransformerFactory.newInstance().newTransformer();
        tf.transform(new DOMSource(xml), new StreamResult(new File(filename)));
    }

}
