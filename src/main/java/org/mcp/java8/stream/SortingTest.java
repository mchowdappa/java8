/**
 * 
 */
package org.mcp.java8.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author cm1
 *
 */
public class SortingTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Comparator<Document> docComparator = Comparator.comparing(Document::getName).thenComparingInt(Document::getDocId);

		List<Document> documentList = new ArrayList<>();
		documentList.add(new Document("abcd", 123));
		documentList.add(new Document("xyzz", 13));
		documentList.add(new Document("str", 45));
		documentList.add(new Document("str", 46));
		documentList.add(new Document("xyzz", 130));
		documentList.add(new Document("abce", 56));

		for (Document document : documentList) {
			System.out.println(document.getDocId() +"  "+document.getName());
		}
		
		System.out.println("---------------------------");
		Collections.sort(documentList, new MyComparator());
		for (Document document : documentList) {
			System.out.println(document.getDocId() +"  "+document.getName());
		}
	}
 
}

class MyComparator implements Comparator<Document>{
	public int compare(Document d1, Document d2, int empty) {
	    int nameComp = d1.getName().compareTo(d2.getName());
	    return ((nameComp == 0) ? d1.getDocId().compareTo(d2.getDocId()) : nameComp);
	  }
	
	public int compare(Document d1, Document d2) {
		
		int compareId = d1.getDocId().compareTo(d2.getDocId());
		int compareName = d1.getName().compareTo(d2.getName());
		
		if(compareId==0) {
			return compareName;
		}else return compareId;
	}
	
}
class Document{
	private String name;
	private Integer docId;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getDocId() {
		return docId;
	}
	public void setDocId(Integer docId) {
		this.docId = docId;
	}
	
	public Document(String name, int id) {
		this.name = name;
		this.docId = id;
	}
}