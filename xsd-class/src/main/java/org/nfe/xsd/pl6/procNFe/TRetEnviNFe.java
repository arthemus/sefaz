//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.07.31 at 02:36:10 PM BRT 
//

package org.nfe.xsd.pl6.procNFe;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * Tipo Retorno do Pedido de Concess�o de Autoriza��o da Nota Fiscal Eletr�nica
 * 
 * <p>
 * Java class for TRetEnviNFe complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="TRetEnviNFe">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tpAmb" type="{http://www.portalfiscal.inf.br/nfe}TAmb"/>
 *         &lt;element name="verAplic" type="{http://www.portalfiscal.inf.br/nfe}TVerAplic"/>
 *         &lt;element name="cStat" type="{http://www.portalfiscal.inf.br/nfe}TStat"/>
 *         &lt;element name="xMotivo" type="{http://www.portalfiscal.inf.br/nfe}TMotivo"/>
 *         &lt;element name="cUF" type="{http://www.portalfiscal.inf.br/nfe}TCodUfIBGE"/>
 *         &lt;element name="dhRecbto" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="infRec" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="nRec" type="{http://www.portalfiscal.inf.br/nfe}TRec"/>
 *                   &lt;element name="tMed" type="{http://www.portalfiscal.inf.br/nfe}TMed"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="versao" use="required" type="{http://www.portalfiscal.inf.br/nfe}TVerNFe" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TRetEnviNFe", propOrder = { "tpAmb", "verAplic", "cStat",
		"xMotivo", "cuf", "dhRecbto", "infRec" })
public class TRetEnviNFe {

	@XmlElement(required = true)
	protected String tpAmb;
	@XmlElement(required = true)
	protected String verAplic;
	@XmlElement(required = true)
	protected String cStat;
	@XmlElement(required = true)
	protected String xMotivo;
	@XmlElement(name = "cUF", required = true)
	protected String cuf;
	@XmlElement(required = true)
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar dhRecbto;
	protected TRetEnviNFe.InfRec infRec;
	@XmlAttribute(required = true)
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
	 * Gets the value of the verAplic property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getVerAplic() {
		return verAplic;
	}

	/**
	 * Sets the value of the verAplic property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setVerAplic(String value) {
		this.verAplic = value;
	}

	/**
	 * Gets the value of the cStat property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCStat() {
		return cStat;
	}

	/**
	 * Sets the value of the cStat property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCStat(String value) {
		this.cStat = value;
	}

	/**
	 * Gets the value of the xMotivo property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getXMotivo() {
		return xMotivo;
	}

	/**
	 * Sets the value of the xMotivo property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setXMotivo(String value) {
		this.xMotivo = value;
	}

	/**
	 * Gets the value of the cuf property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCUF() {
		return cuf;
	}

	/**
	 * Sets the value of the cuf property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCUF(String value) {
		this.cuf = value;
	}

	/**
	 * Gets the value of the dhRecbto property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getDhRecbto() {
		return dhRecbto;
	}

	/**
	 * Sets the value of the dhRecbto property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setDhRecbto(XMLGregorianCalendar value) {
		this.dhRecbto = value;
	}

	/**
	 * Gets the value of the infRec property.
	 * 
	 * @return possible object is {@link TRetEnviNFe.InfRec }
	 * 
	 */
	public TRetEnviNFe.InfRec getInfRec() {
		return infRec;
	}

	/**
	 * Sets the value of the infRec property.
	 * 
	 * @param value
	 *            allowed object is {@link TRetEnviNFe.InfRec }
	 * 
	 */
	public void setInfRec(TRetEnviNFe.InfRec value) {
		this.infRec = value;
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

	/**
	 * <p>
	 * Java class for anonymous complex type.
	 * 
	 * <p>
	 * The following schema fragment specifies the expected content contained
	 * within this class.
	 * 
	 * <pre>
	 * &lt;complexType>
	 *   &lt;complexContent>
	 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
	 *       &lt;sequence>
	 *         &lt;element name="nRec" type="{http://www.portalfiscal.inf.br/nfe}TRec"/>
	 *         &lt;element name="tMed" type="{http://www.portalfiscal.inf.br/nfe}TMed"/>
	 *       &lt;/sequence>
	 *     &lt;/restriction>
	 *   &lt;/complexContent>
	 * &lt;/complexType>
	 * </pre>
	 * 
	 * 
	 */
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "nRec", "tMed" })
	public static class InfRec {

		@XmlElement(required = true)
		protected String nRec;
		@XmlElement(required = true)
		protected String tMed;

		/**
		 * Gets the value of the nRec property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getNRec() {
			return nRec;
		}

		/**
		 * Sets the value of the nRec property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setNRec(String value) {
			this.nRec = value;
		}

		/**
		 * Gets the value of the tMed property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getTMed() {
			return tMed;
		}

		/**
		 * Sets the value of the tMed property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setTMed(String value) {
			this.tMed = value;
		}

	}

}
