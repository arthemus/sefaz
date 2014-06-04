package nfe.produces.api;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Enumeration;

import javax.xml.stream.XMLStreamException;

import nfe.produces.api.utils.CertificadoFactory;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.httpclient.protocol.ProtocolSocketFactory;
import org.junit.Assert;
import org.junit.Test;
import org.nfe.certificado.CertificadoDigital;
import org.nfe.certificado.SocketProtocolFactory;
import org.nfe.commons.Ambiente;
import org.nfe.commons.UF;
import org.nfe.xsd.pl6.retConsStatServ.TRetConsStatServ;

import br.inf.portalfiscal.www.nfe.wsdl.nfestatusservico2.NfeCabecMsg;
import br.inf.portalfiscal.www.nfe.wsdl.nfestatusservico2.NfeCabecMsgE;
import br.inf.portalfiscal.www.nfe.wsdl.nfestatusservico2.NfeDadosMsg;
import br.inf.portalfiscal.www.nfe.wsdl.nfestatusservico2.NfeStatusServico2Stub;
import br.inf.portalfiscal.www.nfe.wsdl.nfestatusservico2.NfeStatusServicoNF2Result;

/**
 * 
 * @author arthemus
 * @since 05/08/2013
 */
public class ConsultaStatusTest {

	@Test
	public void testaAConsultaDoStatusDeFormaDiretaSemAPIComCertificadoInvalido() {		
		try {			
			String caminhoDoCertificadoDoCliente = "src/test/resources/certificado-invalido.pfx";
			String senhaDoCertificado = "associacao";
			String arquivoCacertsGeradoTodosOsEstados = "src/test/resources/NFeCacerts";

			InputStream entrada = new FileInputStream(caminhoDoCertificadoDoCliente);
			KeyStore ks = KeyStore.getInstance("pkcs12");
			ks.load(entrada, senhaDoCertificado.toCharArray());			
			
			String alias = "";
			Enumeration<String> aliasesEnum = ks.aliases();
			while (aliasesEnum.hasMoreElements()) {
				alias = aliasesEnum.nextElement();
				if (ks.isKeyEntry(alias))
					break;
			}

			X509Certificate certificate = (X509Certificate) ks.getCertificate(alias);			
			PrivateKey privateKey = (PrivateKey) ks.getKey(alias, senhaDoCertificado.toCharArray());
			
			ProtocolSocketFactory socketFactoryLocal = 
					new SocketProtocolFactory(certificate, privateKey, new FileInputStream(new File(arquivoCacertsGeradoTodosOsEstados)));			

			Protocol protocol = new Protocol("https", socketFactoryLocal, 443);
			Protocol.registerProtocol("https", protocol);
			
			StringBuilder xmlManual = new StringBuilder();
			xmlManual.append("<?xml version='1.0' encoding='UTF-8'?>")
					.append("<consStatServ versao='2.00' xmlns='http://www.portalfiscal.inf.br/nfe'>")
					.append("<tpAmb>2</tpAmb>")
					.append("<cUF>").append(43).append("</cUF>")
					.append("<xServ>STATUS</xServ>")
					.append("</consStatServ>");
			
			OMElement ome = AXIOMUtil.stringToOM(xmlManual.toString());
			
			NfeDadosMsg dadosMsg = new NfeDadosMsg();
			dadosMsg.setExtraElement(ome);

			NfeCabecMsg nfeCabecMsg = new NfeCabecMsg();			
			nfeCabecMsg.setCUF(String.valueOf(43));
			nfeCabecMsg.setVersaoDados("2.00");
			
			NfeCabecMsgE cabecMsg = new NfeCabecMsgE();
			cabecMsg.setNfeCabecMsg(nfeCabecMsg);

			URL url = new URL("https://homologacao.nfe.sefaz.rs.gov.br/ws/NfeStatusServico/NfeStatusServico2.asmx");
							  
			NfeStatusServico2Stub stub = new NfeStatusServico2Stub(url.toString());
			NfeStatusServicoNF2Result retorno = stub.nfeStatusServicoNF2(dadosMsg, cabecMsg);
			
			Assert.assertNotNull(retorno);
			
		} catch (MalformedURLException e) {			
			e.printStackTrace();		
		} catch (FileNotFoundException e1) {			
			e1.printStackTrace();
		} catch (KeyStoreException e1) {			
			e1.printStackTrace();
		} catch (NoSuchAlgorithmException e) {			
			e.printStackTrace();
		} catch (CertificateException e) {			
			e.printStackTrace();
		} catch (XMLStreamException e) {			
			e.printStackTrace();
		} catch (UnrecoverableKeyException e) {			
			e.printStackTrace();
		} catch (IOException e) {
			Assert.assertEquals("Transport error: 403 Error: Forbidden", e.getMessage());
		}		
	}
	
	@Test
	public void testaConsultaDeStatusComAPIComCertificadoInvalido() {		
		CertificadoDigital certificado = CertificadoFactory.getCertificadoLocalInvalido();		
		Sefaz sefaz = new Sefaz(certificado, UF.SP, UF.SP, Ambiente.HOMOLOGACAO);
		TRetConsStatServ retorno;
		try {
			retorno = sefaz.getStatusServico();
			Assert.assertNotEquals("107", retorno.getCStat());
		} catch (SefazOperationException e) {			
			Assert.assertEquals(SefazOperationException.ERROR_DEFAULT + "Transport error: 403 Error: Forbidden", e.getMessage());
		}		
	}
	
	@Test
	public void testaAConsultaDeStatusComCertificadoValido() {		
		CertificadoDigital certificado = CertificadoFactory.getCertificadoLocalValido();
		Sefaz sefaz = new Sefaz(certificado, UF.SP, UF.SP, Ambiente.HOMOLOGACAO);
		TRetConsStatServ retorno;
		try {
			retorno = sefaz.getStatusServico();			
			// Código 107 - Serviço em Operação
			Assert.assertEquals("107", retorno.getCStat());
		} catch (SefazOperationException e) {			
			Assert.assertTrue(e.getMessage().contains("Transport error: 403 Error: Forbidden"));
		}
	}
}
