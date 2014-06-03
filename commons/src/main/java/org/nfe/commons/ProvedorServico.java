package org.nfe.commons;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Relação de serviços disponibilizados pela Sefaz com relação a NF-e.
 * 
 * @author arthemus
 * @since 02/08/2013
 */
public interface ProvedorServico {

	URL recepcao(Ambiente ambiente) throws MalformedURLException;

	URL retornoRecepcao(Ambiente ambiente) throws MalformedURLException;

	URL inutilizacao(Ambiente ambiente) throws MalformedURLException;

	URL consultaProtocolo(Ambiente ambiente) throws MalformedURLException;

	URL statusServico(Ambiente ambiente) throws MalformedURLException;

	URL consultaCadastro(Ambiente ambiente) throws MalformedURLException;

	URL recepcaoEvento(Ambiente ambiente) throws MalformedURLException;
}
