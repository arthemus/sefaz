//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.07.31 at 02:36:13 PM BRT 
//

package org.nfe.xsd.pl6.retConsCad;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Tipo Dados do Endere�o
 * 
 * <p>
 * Java class for TEndereco complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="TEndereco">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="xLgr" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/nfe}TString">
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="255"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="nro" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/nfe}TString">
 *               &lt;maxLength value="60"/>
 *               &lt;minLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="xCpl" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/nfe}TString">
 *               &lt;maxLength value="60"/>
 *               &lt;minLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="xBairro" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/nfe}TString">
 *               &lt;maxLength value="60"/>
 *               &lt;minLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="cMun" type="{http://www.portalfiscal.inf.br/nfe}TCodMunIBGE" minOccurs="0"/>
 *         &lt;element name="xMun" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/nfe}TString">
 *               &lt;maxLength value="60"/>
 *               &lt;minLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CEP" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *               &lt;pattern value="[0-9]{7,8}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TEndereco", propOrder = { "xLgr", "nro", "xCpl", "xBairro",
		"cMun", "xMun", "cep" })
public class TEndereco {

	protected String xLgr;
	protected String nro;
	protected String xCpl;
	protected String xBairro;
	protected String cMun;
	protected String xMun;
	@XmlElement(name = "CEP")
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	protected String cep;

	/**
	 * Gets the value of the xLgr property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getXLgr() {
		return xLgr;
	}

	/**
	 * Sets the value of the xLgr property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setXLgr(String value) {
		this.xLgr = value;
	}

	/**
	 * Gets the value of the nro property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNro() {
		return nro;
	}

	/**
	 * Sets the value of the nro property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNro(String value) {
		this.nro = value;
	}

	/**
	 * Gets the value of the xCpl property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getXCpl() {
		return xCpl;
	}

	/**
	 * Sets the value of the xCpl property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setXCpl(String value) {
		this.xCpl = value;
	}

	/**
	 * Gets the value of the xBairro property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getXBairro() {
		return xBairro;
	}

	/**
	 * Sets the value of the xBairro property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setXBairro(String value) {
		this.xBairro = value;
	}

	/**
	 * Gets the value of the cMun property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCMun() {
		return cMun;
	}

	/**
	 * Sets the value of the cMun property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCMun(String value) {
		this.cMun = value;
	}

	/**
	 * Gets the value of the xMun property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getXMun() {
		return xMun;
	}

	/**
	 * Sets the value of the xMun property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setXMun(String value) {
		this.xMun = value;
	}

	/**
	 * Gets the value of the cep property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCEP() {
		return cep;
	}

	/**
	 * Sets the value of the cep property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCEP(String value) {
		this.cep = value;
	}

}