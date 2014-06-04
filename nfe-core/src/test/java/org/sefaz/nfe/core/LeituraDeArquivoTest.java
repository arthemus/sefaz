package org.sefaz.nfe.core;

import org.junit.Assert;
import org.junit.Test;
import org.sefaz.certificado.CertificadoDigital;
import org.sefaz.commons.Ambiente;
import org.sefaz.commons.SefazOperationException;
import org.sefaz.nfe.core.Nfe;
import org.sefaz.nfe.core.UF;
import org.sefaz.nfe.core.utils.CertificadoFactory;

/**
 * 
 * @author arthemus
 * @since 05/08/2013
 */
public class LeituraDeArquivoTest {

	@Test
	public void testaLeituraDeArquivoXMLLocal() {	
		CertificadoDigital certificado = CertificadoFactory.getCertificadoLocalValido();
		Nfe sefaz = new Nfe(certificado, UF.SP, UF.SP, Ambiente.HOMOLOGACAO);
		org.nfe.xsd.pl6.procNFe.TNfeProc nfe;
		try {
			nfe = sefaz.getNotaProcessada(this.getClass().getResourceAsStream("/35130446928552000165550010004228611006018360.xml"));
			Assert.assertNotNull(nfe);
			Assert.assertEquals("422861", nfe.getNFe().getInfNFe().getIde().getNNF());
		} catch (SefazOperationException e) {
			e.printStackTrace();
		}		
	}
	
	@Test
	public void testaLeituraDeArquivoXMLInvalido() {	
		CertificadoDigital certificado = CertificadoFactory.getCertificadoLocalValido();
		Nfe sefaz = new Nfe(certificado, UF.SP, UF.SP, Ambiente.HOMOLOGACAO);
		org.nfe.xsd.pl6.procNFe.TNfeProc nfe;
		try {
			nfe = sefaz.getNotaProcessada(this.getClass().getResourceAsStream("/temp.xml"));
			Assert.assertNotNull(nfe);			
		} catch (SefazOperationException e) {
			Assert.assertTrue(e.getMessage().contains("O conteudo do arquivo está em um formato inválido ou não coincide com o tipo referente da Classe informado."));
		}		
	}
	
}
