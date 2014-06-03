package org.nfe.commons;

import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 * Classe para leitura de arquivos XML com base em classes geradas a partir
 * de arquivos XSD.
 * 
 * @author arthemus
 * 
 * @param <T>
 */
public final class Xsd {

	private final InputStream inputStream;

	private Xsd(final InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	/**
	 * Obtem uma nova instancia da classe XSD realizando a leitura de um 
	 * arquivo XML.
	 * 
	 * @param inputStream
	 * @return
	 */
	public static Xsd doReadFile(final InputStream inputStream) {
		return new Xsd(inputStream);
	}

	/**
	 * Obtem o objeto referente a leitura e conversão do arquivo XML.
	 * 
	 * @param classReference
	 * @return
	 * @throws JAXBException
	 */	
	@SuppressWarnings("unchecked")
	public <T> T getObject(final Class<T> classReference) throws JAXBException {
		
		JAXBContext contextRetorno = null;
		try {
			contextRetorno = JAXBContext.newInstance(classReference.getPackage().getName());
		} catch (JAXBException e) {
			throw new JAXBException(e.getMessage());
		}
		
		Unmarshaller unmarshaller = null;
		try {
			unmarshaller = contextRetorno.createUnmarshaller();
		} catch (JAXBException e) {
			throw new JAXBException(e.getMessage());
		}		
		
		JAXBElement<T> elementoLeitura = null;
		try {
			Object object = unmarshaller.unmarshal(inputStream);
			elementoLeitura = (JAXBElement<T>) object;
		} catch (JAXBException e) {
			String msg = e.getMessage();
			if (msg.contains("unexpected element"))
				msg = "O conteudo do arquivo está em um formato inválido ou não coincide com o tipo referente da Classe informado.";
			throw new JAXBException(msg);
		}
		
		T retorno = elementoLeitura.getValue();
		return retorno;
	}
}
