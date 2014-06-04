package org.sefaz.nfe.core;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.rmi.RemoteException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.stream.StreamResult;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.axis2.AxisFault;
import org.nfe.xsd.pl6.consStatServ.TConsStatServ;
import org.sefaz.certificado.Certificado;
import org.sefaz.certificado.CertificadoDigital;
import org.sefaz.certificado.CertificadoValidateException;
import org.sefaz.commons.Ambiente;
import org.sefaz.commons.Federacao;
import org.sefaz.commons.SefazOperationException;
import org.sefaz.commons.Xsd;

/**
 * Classe para prover acesso aos serviços da Nota Fiscal Eletrônica.
 * 
 * @author arthemus
 * @since 05/08/2013
 * @see CertificadoDigital
 * @see Federacao
 * @see ProvedorServico
 * @see Ambiente
 * 
 */
public final class Nfe {

	static final String VERSAO = new String("2.00");
	
	private final CertificadoDigital certificadoDigital;
	private final Federacao federacao;
	private final ProvedorServico provedorServico;
	private final Ambiente ambiente;

	public Nfe(final CertificadoDigital certificadoDigital, final Federacao federacao, 
			final ProvedorServico provedorServico, final Ambiente ambiente) {
		this.certificadoDigital = certificadoDigital;
		this.federacao = federacao;
		this.provedorServico = provedorServico;
		this.ambiente = ambiente;
	}

	/**
	 * Consulta o status do serviço da Nfe para o estado informado na
	 * instanciação da classe.
	 * 
	 * @return Classe com informações do status da Nfe.
	 * @throws SefazOperationException
	 */
	@SuppressWarnings("unchecked")
	public org.nfe.xsd.pl6.retConsStatServ.TRetConsStatServ getStatusServico() 
			throws SefazOperationException {
		
		try {
			Certificado.validate(certificadoDigital);
		} catch (CertificadoValidateException e) {
			throw new SefazOperationException(e.getMessage());
		}
		
		final String SERVICO = "STATUS";
		
		org.nfe.xsd.pl6.consStatServ.ObjectFactory factory = 
				new org.nfe.xsd.pl6.consStatServ.ObjectFactory();
		
		org.nfe.xsd.pl6.consStatServ.TConsStatServ consulta = factory.createTConsStatServ();
		consulta.setCUF(String.valueOf(federacao.getCodigo()));
		consulta.setTpAmb(ambiente.getCodigo());			
		consulta.setVersao(VERSAO);
		consulta.setXServ(SERVICO);			
		
		StreamResult result = new StreamResult(new StringWriter());
		
		JAXBContext contextEnvio;
		try {
			contextEnvio = JAXBContext.newInstance("org.nfe.xsd.pl6.consStatServ");
		} catch (JAXBException e) {
			throw new SefazOperationException(e.getMessage());
		}
		
		Marshaller marshaller;
		try {
			marshaller = contextEnvio.createMarshaller();
		} catch (JAXBException e) {
			throw new SefazOperationException(e.getMessage());
		}
		
		JAXBElement<TConsStatServ> elementoEscrita = factory.createConsStatServ(consulta);
		try {
			marshaller.marshal(elementoEscrita, result);
		} catch (JAXBException e) {
			throw new SefazOperationException(e.getMessage());
		}
		
		OMElement ome;
		try {
			ome = AXIOMUtil.stringToOM(result.getWriter().toString());
		} catch (XMLStreamException e) {
			throw new SefazOperationException(e.getMessage());
		}
		
		br.inf.portalfiscal.www.nfe.wsdl.nfestatusservico2.NfeDadosMsg dadosMsg = 
				new br.inf.portalfiscal.www.nfe.wsdl.nfestatusservico2.NfeDadosMsg();
		dadosMsg.setExtraElement(ome);

		br.inf.portalfiscal.www.nfe.wsdl.nfestatusservico2.NfeCabecMsg nfeCabecMsg = 
				new br.inf.portalfiscal.www.nfe.wsdl.nfestatusservico2.NfeCabecMsg();			
		nfeCabecMsg.setCUF(String.valueOf(federacao.getCodigo()));
		nfeCabecMsg.setVersaoDados(VERSAO);
		
		br.inf.portalfiscal.www.nfe.wsdl.nfestatusservico2.NfeCabecMsgE cabecMsg = 
				new br.inf.portalfiscal.www.nfe.wsdl.nfestatusservico2.NfeCabecMsgE();
		cabecMsg.setNfeCabecMsg(nfeCabecMsg);
						  
		br.inf.portalfiscal.www.nfe.wsdl.nfestatusservico2.NfeStatusServico2Stub consultaStatus;
		try {
			consultaStatus = new br.inf.portalfiscal.www.nfe.wsdl.nfestatusservico2
					.NfeStatusServico2Stub(provedorServico.statusServico(ambiente).toString());
		} catch (AxisFault e) {
			throw new SefazOperationException(e.getMessage());
		} catch (MalformedURLException e) {
			throw new SefazOperationException(e.getMessage());
		}
		
		br.inf.portalfiscal.www.nfe.wsdl.nfestatusservico2.NfeStatusServicoNF2Result resultadoConsulta;
		try {
			resultadoConsulta = consultaStatus.nfeStatusServicoNF2(dadosMsg, cabecMsg);
		} catch (RemoteException e) {
			throw new SefazOperationException(e.getMessage());
		}
		
		JAXBContext contextRetorno;
		try {
			contextRetorno = JAXBContext.newInstance("org.nfe.xsd.pl6.retConsStatServ");
		} catch (JAXBException e) {
			throw new SefazOperationException(e.getMessage());
		}
		
		Unmarshaller unmarshaller;
		try {
			unmarshaller = contextRetorno.createUnmarshaller();
		} catch (JAXBException e) {
			throw new SefazOperationException(e.getMessage());
		}		
		
		JAXBElement<org.nfe.xsd.pl6.retConsStatServ.TRetConsStatServ> elementoLeitura;
		try {
			elementoLeitura = (JAXBElement<org.nfe.xsd.pl6.retConsStatServ.TRetConsStatServ>) 
					unmarshaller.unmarshal(resultadoConsulta.getExtraElement().getXMLStreamReader());
		} catch (JAXBException e) {
			throw new SefazOperationException(e.getMessage());
		}
		
		org.nfe.xsd.pl6.retConsStatServ.TRetConsStatServ retorno = elementoLeitura.getValue();		
		return retorno;
	}

	/**
	 * Carrega um objeto da NF-e de com base em um arquivo XML. A própria
	 * operação de carregar o arquivo já o valida com o layout da nf-e, caso o
	 * arquivo não seja válido, uma exceção será criada.
	 * 
	 * @param file
	 *            Arquivo XML da nota já processada.
	 * @return Objeto representando a nota fiscal.
	 * @throws SefazOperationException
	 */
	public org.nfe.xsd.pl6.procNFe.TNfeProc getNotaProcessada(
			final InputStream file) throws SefazOperationException {
		try {
			return Xsd.by(file).getObject(org.nfe.xsd.pl6.procNFe.TNfeProc.class);
		} catch (JAXBException e) {
			throw new SefazOperationException(e.getMessage());
		}
	}

	/**
	 * Gera uma saída textual do arquivo xml com base em um objeto já
	 * processado.
	 * 
	 * @param nfeProcessada
	 *            Objeto da nota fiscal já processada.
	 * @param arquivoRetorno
	 *            Saída textual, pode ser um arquivo texto ou uma escrita no
	 *            próprio console (System.out).
	 * @throws SefazOperationException
	 */
	public void doProcessaArquivoNfe(org.nfe.xsd.pl6.procNFe.TNfeProc nfeProcessada, 
			OutputStream arquivoRetorno) throws SefazOperationException {		
		
		JAXBContext context = null;
		try {
			context = JAXBContext.newInstance("org.nfe.xsd.pl6.procNFe");
		} catch (JAXBException e) {
			throw new SefazOperationException(e.getMessage());
		}
		
		Marshaller marshaller = null;
		try {
			marshaller = context.createMarshaller();
		} catch (JAXBException e) {
			throw new SefazOperationException(e.getMessage());
		}
		
		JAXBElement<org.nfe.xsd.pl6.procNFe.TNfeProc> element = 
				new org.nfe.xsd.pl6.procNFe.ObjectFactory().createNfeProc(nfeProcessada);
		try {
			marshaller.marshal(element, arquivoRetorno);
		} catch (JAXBException e) {
			String msg = e.getMessage();
			if (msg.contains("unexpected element"))
				msg = "O conteudo do arquivo está em um formato inválido ou a nota fiscal não está processada.";
			throw new SefazOperationException(msg);
		}
	}
}
