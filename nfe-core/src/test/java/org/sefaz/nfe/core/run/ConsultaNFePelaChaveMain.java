package org.sefaz.nfe.core.run;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.sefaz.certificado.Certificado;
import org.sefaz.certificado.CertificadoDigital;
import org.sefaz.certificado.CertificadoValidateException;
import org.sefaz.nfe.core.utils.CertificadoFactory;

import br.inf.portalfiscal.www.nfe.wsdl.nfedownloadnf.NfeCabecMsg;
import br.inf.portalfiscal.www.nfe.wsdl.nfedownloadnf.NfeCabecMsgE;
import br.inf.portalfiscal.www.nfe.wsdl.nfedownloadnf.NfeDadosMsg;
import br.inf.portalfiscal.www.nfe.wsdl.nfedownloadnf.NfeDownloadNFResult;
import br.inf.portalfiscal.www.nfe.wsdl.nfedownloadnf.NfeDownloadNFStub;

/**
 * 
 * @author arthemus.moreira
 *
 */
public class ConsultaNFePelaChaveMain {

	public static void main(String[] args) 
			throws MalformedURLException, XMLStreamException, RemoteException, 
			CertificadoValidateException {
		
		CertificadoDigital certificado = CertificadoFactory.getCertificadoLocalValido();
		Certificado.validate(certificado);						
		
		NfeDownloadNFResult result = new NfeDownloadNFResult();

		String Dados = "<?xml version='1.0' encoding='UTF-8' ?>"
				+ "<downloadNFe xmlns='http://www.portalfiscal.inf.br/nfe' versao='1.00'>"
				+ "<tpAmb>1</tpAmb>"
				+ "<xServ>DOWNLOAD NFE</xServ>" 
				+ "<CNPJ>02609944000196</CNPJ>"
				+ "<chNFe>35130546928552000165550010004291241002641341</chNFe>" 
				+ "</downloadNFe>";

		OMElement ome = AXIOMUtil.stringToOM(Dados.trim());
		NfeDadosMsg dadosMsg = new NfeDadosMsg();
		dadosMsg.setExtraElement(ome);
		NfeCabecMsg nfeCabecMsg = new NfeCabecMsg();
		nfeCabecMsg.setCUF("43");
		nfeCabecMsg.setVersaoDados("1.00");
		NfeCabecMsgE nfeCabecMsgE = new NfeCabecMsgE();
		nfeCabecMsgE.setNfeCabecMsg(nfeCabecMsg);
		URL url = new URL("https://nfe.sefaz.rs.gov.br/ws/nfeDownloadNF/nfeDownloadNF.asmx");
		NfeDownloadNFStub stub = new NfeDownloadNFStub(url.toString());
		result = stub.nfeDownloadNF(dadosMsg, nfeCabecMsgE);
		String conteudo = result.getExtraElement().toString();		
		System.out.println(conteudo);
	}
}
