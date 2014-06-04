package nfe.produces.api;

import nfe.produces.api.utils.CertificadoFactory;

import org.junit.Assert;
import org.junit.Test;
import org.nfe.certificado.CertificadoDigital;
import org.nfe.commons.Ambiente;
import org.nfe.commons.UF;

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
	
}
