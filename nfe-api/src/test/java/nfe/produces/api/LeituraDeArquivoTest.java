package nfe.produces.api;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import javax.xml.stream.XMLStreamException;

import nfe.produces.api.utils.CertificadoFactory;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.junit.Assert;
import org.junit.Test;
import org.nfe.certificado.Certificado;
import org.nfe.certificado.CertificadoDigital;
import org.nfe.certificado.CertificadoValidateException;
import org.nfe.commons.Ambiente;
import org.nfe.commons.UF;

import br.inf.portalfiscal.www.nfe.wsdl.nfedownloadnf.NfeCabecMsg;
import br.inf.portalfiscal.www.nfe.wsdl.nfedownloadnf.NfeCabecMsgE;
import br.inf.portalfiscal.www.nfe.wsdl.nfedownloadnf.NfeDadosMsg;
import br.inf.portalfiscal.www.nfe.wsdl.nfedownloadnf.NfeDownloadNFResult;
import br.inf.portalfiscal.www.nfe.wsdl.nfedownloadnf.NfeDownloadNFStub;

/**
 * 
 * @author arthemus
 * @since 05/08/2013
 */
public class LeituraDeArquivoTest {

	@Test
	public void testaLeituraDeArquivoXMLLocal() {	
		CertificadoDigital certificado = CertificadoFactory.getCertificadoLocalValido();
		Sefaz sefaz = new Sefaz(certificado, UF.SP, UF.SP, Ambiente.HOMOLOGACAO);
		org.nfe.xsd.pl6.procNFe.TNfeProc nfe;
		try {
			nfe = sefaz.getNFProcessada(this.getClass().getResourceAsStream("/35130446928552000165550010004228611006018360.xml"));
			Assert.assertNotNull(nfe);
			Assert.assertEquals("422861", nfe.getNFe().getInfNFe().getIde().getNNF());
		} catch (SefazOperationException e) {
			e.printStackTrace();
		}		
	}
	
	@Test
	public void testaLeituraDeArquivoXMLInvalido() {	
		CertificadoDigital certificado = CertificadoFactory.getCertificadoLocalValido();
		Sefaz sefaz = new Sefaz(certificado, UF.SP, UF.SP, Ambiente.HOMOLOGACAO);
		org.nfe.xsd.pl6.procNFe.TNfeProc nfe;
		try {
			nfe = sefaz.getNFProcessada(this.getClass().getResourceAsStream("/context.xml"));
			Assert.assertNotNull(nfe);			
		} catch (SefazOperationException e) {
			Assert.assertTrue(e.getMessage().contains("O conteudo do arquivo está em um formato inválido ou não coincide com o tipo referente da Classe informado."));
		}		
	}
	
	public void testaConsultaNFPelaChaveDeAcesso() 
			throws MalformedURLException, XMLStreamException, RemoteException, CertificadoValidateException {
		CertificadoDigital certificado = CertificadoFactory.getCertificadoLocalValido();		
		//--Em testes, necessita dos arquivos xsd do layout de download do arquivo xml...
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
		result.getExtraElement().toString();				
	}
}
