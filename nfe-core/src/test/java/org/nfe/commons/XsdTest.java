package org.nfe.commons;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.xml.bind.JAXBException;

import org.junit.Assert;
import org.junit.Test;
import org.nfe.xsd.pl6.procNFe.TNfeProc;

/**
 * Testes unitários para leitura de classes com layout com base em XSD.
 * 
 * @author arthemus
 * 
 */
public class XsdTest {

	@Test
	public void retornaNovaInstancia() throws FileNotFoundException, JAXBException {
		InputStream file = new FileInputStream(new File("src/test/resources/35130446928552000165550010004228611006018360.xml"));
		TNfeProc proc = Xsd.doReadFile(file).getObject(TNfeProc.class);
		Assert.assertNotNull(proc);
	}
}
