package xpath;


import java.io.File;
import java.io.FileInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XPathDemo {
	private static Document doc;
	private static XPath xpath;

	public static void main(String[] args) throws Exception {
		init();
		getChildEles();
		getPartEles();
		getLangEles();
		haveChildsEles();
		getLevelEles();
		getAttrEles();
		
		//all nodes below the root
		System.out.print("【all nodes below the root】：");
		NodeList nodeList = doc.getDocumentElement().getChildNodes();
		for (int i = 0; i < nodeList.getLength(); i++) {
			if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
				System.out.print(nodeList.item(i).getNodeName() + " ");
			}
		}
		System.out.println("length:" + doc.getDocumentElement().getChildNodes().getLength());
	}

	// init Document、XPath
	public static void init() throws Exception {
		// create Document obj
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setValidating(false);
		DocumentBuilder db = dbf.newDocumentBuilder();
		doc = db.parse(new FileInputStream(new File("src/demo.xml")));

		// create XPath obj
		XPathFactory factory = XPathFactory.newInstance();
		xpath = factory.newXPath();
	}

	// channel's child
	public static void getChildEles() throws XPathExpressionException {
		NodeList nodeList = (NodeList) xpath.evaluate("/rss/channel/*", doc,
				XPathConstants.NODESET);
		System.out.print("【channel's child】：");
		for (int i = 0; i < nodeList.getLength(); i++) {
			System.out.print(nodeList.item(i).getNodeName() + " ");
		}
		System.out.println();
	}

	// all title
	public static void getPartEles() throws XPathExpressionException {
		NodeList nodeList = (NodeList) xpath.evaluate("//title",
				doc, XPathConstants.NODESET);
		System.out.print("【all title】：");
		for (int i = 0; i < nodeList.getLength(); i++) {
			System.out.print(nodeList.item(i).getTextContent() + "  ");
		}
		System.out.println();
	}
	
	// all lang
	public static void getLangEles() throws XPathExpressionException {
		System.out.print("【all lang】：");
		NodeList nodeList = (NodeList) xpath.evaluate("//@lang", doc,XPathConstants.NODESET);
			for (int i = 0; i < nodeList.getLength(); i++) {
				System.out.print(nodeList.item(i).getTextContent() + " ");
			}
		System.out.println();
	}

	// get the elements that have child node
	public static void haveChildsEles() throws XPathExpressionException {
		NodeList nodeList = (NodeList) xpath.evaluate("//*[*]", doc,
				XPathConstants.NODESET);
		System.out.print("【all parents】：");
		for (int i = 0; i < nodeList.getLength(); i++) {
			System.out.print(nodeList.item(i).getNodeName() + " ");
		}
		System.out.println();
	}

	// the fourth deep from the top
	public static void getLevelEles() throws XPathExpressionException {
		NodeList nodeList = (NodeList) xpath.evaluate("/*/*/*/*", doc,
				XPathConstants.NODESET);
		System.out.print("【fourth】：");
		for (int i = 0; i < nodeList.getLength(); i++) {
			System.out.println(nodeList.item(i).getNodeName() + "-->"
					+ nodeList.item(i).getTextContent() + " ");
		}
	}

	// get the books the price of which is over 35
	public static void getAttrEles() throws XPathExpressionException {
		NodeList nodeList = (NodeList) xpath.evaluate("//bookstore/book[price>35.00]/title", doc,
				XPathConstants.NODESET);
		System.out.print("【price>35】：");
		for (int i = 0; i < nodeList.getLength(); i++) {
			System.out.print(nodeList.item(i).getTextContent() + " ");
		}
		System.out.println();
	}
}
