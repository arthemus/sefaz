package org.sefaz.nfe.core;

import java.net.MalformedURLException;
import java.net.URL;

import org.sefaz.commons.Ambiente;

/**
 * Relação de serviços disponibilizados pela Nfe com relação a NF-e.
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
