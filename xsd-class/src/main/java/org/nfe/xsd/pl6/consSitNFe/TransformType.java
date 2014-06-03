//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.07.31 at 02:35:52 PM BRT 
//

package org.nfe.xsd.pl6.consSitNFe;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for TransformType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="TransformType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence maxOccurs="unbounded" minOccurs="0">
 *         &lt;element name="XPath" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Algorithm" use="required" type="{http://www.w3.org/2000/09/xmldsig#}TTransformURI" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransformType", propOrder = { "xPath" })
public class TransformType {

	@XmlElement(name = "XPath")
	protected List<String> xPath;
	@XmlAttribute(name = "Algorithm", required = true)
	protected String algorithm;

	/**
	 * Gets the value of the xPath property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the xPath property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getXPath().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link String }
	 * 
	 * 
	 */
	public List<String> getXPath() {
		if (xPath == null) {
			xPath = new ArrayList<String>();
		}
		return this.xPath;
	}

	/**
	 * Gets the value of the algorithm property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAlgorithm() {
		return algorithm;
	}

	/**
	 * Sets the value of the algorithm property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAlgorithm(String value) {
		this.algorithm = value;
	}

}
