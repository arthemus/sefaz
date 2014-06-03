package org.nfe.commons;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Classe utilitária para trabalhar com arquivos XML.
 * 
 * @author Arthemus C. Moreira
 * @since 28/05/2013
 */
public class MyXML {

	private final Document documento;

	public MyXML(final Document documento) {
		this.documento = documento;
	}
	
	public MyXML(final InputStream arquivo) 
			throws ParserConfigurationException, SAXException, IOException {
		this.documento = buildDocument(arquivo);		
	}

	/**
	 * Realiza a leitura de um determinado arquivo XML.
	 * 
	 * @param arquivo
	 *            Arquivo a ser lido.
	 * @return Novo Documento com os valores do arquivo.
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 * @throws FacadeException
	 *             Excecoes decorrentes.
	 */
	public Document buildDocument(final InputStream arquivo) 
			throws ParserConfigurationException, SAXException, IOException {
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		
		Document doc = null;		
		try {
			doc = db.parse(arquivo);
		} catch (SAXException e) {
			throw new SAXException("Problemas ao ler arquivo XML!"
					+ "\nErro: " + e.getMessage());
		} catch (IOException e) {
			throw new IOException("Arquivo XML não encontrado!"
					+ "\nErro: " + e.getMessage());
		}		
		return doc;
	}

	public String getTag(final String tagPai, final String tagFilho) {		
		Element raiz = documento.getDocumentElement();
		NodeList noPai = raiz.getElementsByTagName(tagPai);
		if (noPai == null) 
			return null;
		Element itemPai = (Element) noPai.item(0);
		if (itemPai == null) 
			return null;
		Node noFilho = itemPai.getFirstChild();
		return noFilho.getNodeValue();		
	}
	
	public boolean isTagExist(final String tagName) {
		Element raiz = documento.getDocumentElement();
		NodeList noPai = raiz.getElementsByTagName(tagName);
		if (noPai == null) 
			return Boolean.FALSE;
		return Boolean.TRUE;
	}

	public void salvaDocumento(final File arquivoDestino) throws TransformerException, IOException {

		Transformer transformer = null;

		try {
			transformer = TransformerFactory.newInstance().newTransformer();
		} catch (TransformerConfigurationException e) {
			throw new TransformerConfigurationException("Problemas na configuração do arquivo!"
					+ "\nErro: " + e.getMessage());
		} catch (TransformerFactoryConfigurationError e) {
			throw new TransformerFactoryConfigurationError(
					"Problemas ao criar configuração do arquivo!" + "\nErro: "
							+ e.getMessage());
		}

		/*
		 * Se passado como parametro, "no", escreve o conteudo do arquivo em uma
		 * unica linha. Se "yes", formata (Indenta) o conteudo do arquivo.
		 */
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");

		StreamResult result = new StreamResult(new StringWriter());

		DOMSource fonte = new DOMSource(documento);

		try {
			transformer.transform(fonte, result);
		} catch (TransformerException e) {
			throw new TransformerException(
					"Problemas ao transformar o conteudo do arquivo XML em Texto!"
							+ "\nErro: " + e.getMessage());
		}

		String conteudoXml = result.getWriter().toString();

		/*
		 * Criando arquivo...
		 */
		try {
			FileWriter file = new FileWriter(arquivoDestino);
			file.write(conteudoXml);
			file.flush();
			file.close();
		} catch (IOException e) {
			throw new IOException("Problemas ao criar arquivo XML!"
					+ "\nErro: " + e.getMessage());
		}
	}
}
