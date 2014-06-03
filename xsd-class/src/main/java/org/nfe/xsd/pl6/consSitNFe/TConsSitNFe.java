//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.07.31 at 02:35:52 PM BRT 
//

package org.nfe.xsd.pl6.consSitNFe;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Tipo Pedido de Consulta da Situa��o Atual da Nota Fiscal Eletr�nica
 * 
 * <p>
 * Java class for TConsSitNFe complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="TConsSitNFe">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tpAmb" type="{http://www.portalfiscal.inf.br/nfe}TAmb"/>
 *         &lt;element name="xServ">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/nfe}TServ">
 *               &lt;enumeration value="CONSULTAR"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="chNFe" type="{http://www.portalfiscal.inf.br/nfe}TChNFe"/>
 *       &lt;/sequence>
 *       &lt;attribute name="versao" use="required" type="{http://www.portalfiscal.inf.br/nfe}TVerConsSitNFe" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TConsSitNFe", namespace = "http://www.portalfiscal.inf.br/nfe", propOrder = {
		"tpAmb", "xServ", "chNFe" })
public class TConsSitNFe {

	@XmlElement(required = true)
	protected String tpAmb;
	@XmlElement(required = true)
	protected String xServ;
	@XmlElement(required = true)
	protected String chNFe;
	@XmlAttribute(required = true)
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	protected String versao;

	/**
	 * Gets the value of the tpAmb property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTpAmb() {
		return tpAmb;
	}

	/**
	 * Sets the value of the tpAmb property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTpAmb(String value) {
		this.tpAmb = value;
	}

	/**
	 * Gets the value of the xServ property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getXServ() {
		return xServ;
	}

	/**
	 * Sets the value of the xServ property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setXServ(String value) {
		this.xServ = value;
	}

	/**
	 * Gets the value of the chNFe property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getChNFe() {
		return chNFe;
	}

	/**
	 * Sets the value of the chNFe property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setChNFe(String value) {
		this.chNFe = value;
	}

	/**
	 * Gets the value of the versao property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getVersao() {
		return versao;
	}

	/**
	 * Sets the value of the versao property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setVersao(String value) {
		this.versao = value;
	}

}
