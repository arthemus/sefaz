//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.07.31 at 02:36:02 PM BRT 
//

package org.nfe.xsd.pl6.leiauteInutNFe;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for TUf.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name="TUf">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;whiteSpace value="preserve"/>
 *     &lt;enumeration value="AC"/>
 *     &lt;enumeration value="AL"/>
 *     &lt;enumeration value="AM"/>
 *     &lt;enumeration value="AP"/>
 *     &lt;enumeration value="BA"/>
 *     &lt;enumeration value="CE"/>
 *     &lt;enumeration value="DF"/>
 *     &lt;enumeration value="ES"/>
 *     &lt;enumeration value="GO"/>
 *     &lt;enumeration value="MA"/>
 *     &lt;enumeration value="MG"/>
 *     &lt;enumeration value="MS"/>
 *     &lt;enumeration value="MT"/>
 *     &lt;enumeration value="PA"/>
 *     &lt;enumeration value="PB"/>
 *     &lt;enumeration value="PE"/>
 *     &lt;enumeration value="PI"/>
 *     &lt;enumeration value="PR"/>
 *     &lt;enumeration value="RJ"/>
 *     &lt;enumeration value="RN"/>
 *     &lt;enumeration value="RO"/>
 *     &lt;enumeration value="RR"/>
 *     &lt;enumeration value="RS"/>
 *     &lt;enumeration value="SC"/>
 *     &lt;enumeration value="SE"/>
 *     &lt;enumeration value="SP"/>
 *     &lt;enumeration value="TO"/>
 *     &lt;enumeration value="EX"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TUf", namespace = "http://www.portalfiscal.inf.br/nfe")
@XmlEnum
public enum TUf {

	AC, AL, AM, AP, BA, CE, DF, ES, GO, MA, MG, MS, MT, PA, PB, PE, PI, PR, RJ, RN, RO, RR, RS, SC, SE, SP, TO, EX;

	public String value() {
		return name();
	}

	public static TUf fromValue(String v) {
		return valueOf(v);
	}

}
