package org.nfe.commons;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

/**
 * Relação de estados do Brasil com seus respectivos códigos de identificação e
 * IBGE, de acordo com o Manual de Orientação do Contribuinte v5.
 * 
 * {@link http://pt.wikipedia.org/wiki/Unidade_da_Federa%C3%A7%C3%A3o}
 * 
 * @author arthemus
 * @since 02/08/2013
 * @see ProvedorServico
 */
public enum UF implements Federacao, ProvedorServico {

	AC("Acre", 12, 1200401) {
		@Override
		public URL recepcao(Ambiente ambiente) throws MalformedURLException {
			throw new RuntimeException("O estado do 'Acre' não possui WebService para a NF-e.");
		}

		@Override
		public URL retornoRecepcao(Ambiente ambiente)
				throws MalformedURLException {
			throw new RuntimeException("O estado do 'Acre' não possui WebService para a NF-e.");
		}

		@Override
		public URL inutilizacao(Ambiente ambiente) throws MalformedURLException {
			throw new RuntimeException("O estado do 'Acre' não possui WebService para a NF-e.");
		}

		@Override
		public URL consultaProtocolo(Ambiente ambiente)
				throws MalformedURLException {
			throw new RuntimeException("O estado do 'Acre' não possui WebService para a NF-e.");
		}

		@Override
		public URL statusServico(Ambiente ambiente)
				throws MalformedURLException {
			throw new RuntimeException("O estado do 'Acre' não possui WebService para a NF-e.");
		}

		@Override
		public URL consultaCadastro(Ambiente ambiente)
				throws MalformedURLException {
			throw new RuntimeException("O estado do 'Acre' não possui WebService para a NF-e.");
		}

		@Override
		public URL recepcaoEvento(Ambiente ambiente)
				throws MalformedURLException {
			throw new RuntimeException("O estado do 'Acre' não possui WebService para a NF-e.");
		}
	},

	AL("Alagoas", 27, 2704302) {
		@Override
		public URL recepcao(Ambiente ambiente) throws MalformedURLException {
			throw new RuntimeException("O estado de 'Alagoas' não possui WebService para a NF-e.");
		}

		@Override
		public URL retornoRecepcao(Ambiente ambiente)
				throws MalformedURLException {
			throw new RuntimeException("O estado de 'Alagoas' não possui WebService para a NF-e.");
		}

		@Override
		public URL inutilizacao(Ambiente ambiente) throws MalformedURLException {
			throw new RuntimeException("O estado de 'Alagoas' não possui WebService para a NF-e.");
		}

		@Override
		public URL consultaProtocolo(Ambiente ambiente)
				throws MalformedURLException {
			throw new RuntimeException("O estado de 'Alagoas' não possui WebService para a NF-e.");
		}

		@Override
		public URL statusServico(Ambiente ambiente)
				throws MalformedURLException {
			throw new RuntimeException("O estado de 'Alagoas' não possui WebService para a NF-e.");
		}

		@Override
		public URL consultaCadastro(Ambiente ambiente)
				throws MalformedURLException {
			throw new RuntimeException("O estado de 'Alagoas' não possui WebService para a NF-e.");
		}

		@Override
		public URL recepcaoEvento(Ambiente ambiente)
				throws MalformedURLException {
			throw new RuntimeException("O estado de 'Alagoas' não possui WebService para a NF-e.");
		}
	},

	AM("Amazonas", 13, 1302603) {
		@Override
		public URL recepcao(Ambiente ambiente) throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL retornoRecepcao(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL inutilizacao(Ambiente ambiente) throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL consultaProtocolo(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL statusServico(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL consultaCadastro(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL recepcaoEvento(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}
	},

	AP("Amapá", 16, 1600303) {
		@Override
		public URL recepcao(Ambiente ambiente) throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL retornoRecepcao(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL inutilizacao(Ambiente ambiente) throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL consultaProtocolo(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL statusServico(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL consultaCadastro(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL recepcaoEvento(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}
	},

	BA("Bahia", 29, 2927408) {
		@Override
		public URL recepcao(Ambiente ambiente) throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL retornoRecepcao(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL inutilizacao(Ambiente ambiente) throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL consultaProtocolo(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL statusServico(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL consultaCadastro(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL recepcaoEvento(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}
	},

	CE("Ceará", 23, 2304400) {
		@Override
		public URL recepcao(Ambiente ambiente) throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL retornoRecepcao(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL inutilizacao(Ambiente ambiente) throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL consultaProtocolo(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL statusServico(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL consultaCadastro(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL recepcaoEvento(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}
	},

	DF("Distrito Federal", 53, 5300108) {
		@Override
		public URL recepcao(Ambiente ambiente) throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL retornoRecepcao(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL inutilizacao(Ambiente ambiente) throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL consultaProtocolo(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL statusServico(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL consultaCadastro(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL recepcaoEvento(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}
	},

	ES("Espírito Santo", 32, 3205309) {
		@Override
		public URL recepcao(Ambiente ambiente) throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL retornoRecepcao(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL inutilizacao(Ambiente ambiente) throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL consultaProtocolo(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL statusServico(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL consultaCadastro(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL recepcaoEvento(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}
	},

	GO("Goiás", 52, 5208707) {
		@Override
		public URL recepcao(Ambiente ambiente) throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL retornoRecepcao(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL inutilizacao(Ambiente ambiente) throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL consultaProtocolo(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL statusServico(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL consultaCadastro(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL recepcaoEvento(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}
	},

	MA("Maranão", 21, 2111300) {
		@Override
		public URL recepcao(Ambiente ambiente) throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL retornoRecepcao(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL inutilizacao(Ambiente ambiente) throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL consultaProtocolo(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL statusServico(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL consultaCadastro(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL recepcaoEvento(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}
	},

	MG("Minas Gerais", 31, 3106200) {
		@Override
		public URL recepcao(Ambiente ambiente) throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL retornoRecepcao(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL inutilizacao(Ambiente ambiente) throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL consultaProtocolo(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL statusServico(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL consultaCadastro(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL recepcaoEvento(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}
	},

	MS("Mato Grosso do Sul", 50, 5002704) {
		@Override
		public URL recepcao(Ambiente ambiente) throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL retornoRecepcao(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL inutilizacao(Ambiente ambiente) throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL consultaProtocolo(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL statusServico(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL consultaCadastro(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL recepcaoEvento(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}
	},

	MT("Mato Grosso", 51, 5103403) {
		@Override
		public URL recepcao(Ambiente ambiente) throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL retornoRecepcao(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL inutilizacao(Ambiente ambiente) throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL consultaProtocolo(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL statusServico(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL consultaCadastro(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL recepcaoEvento(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}
	},

	PA("Pará", 15, 1501402) {
		@Override
		public URL recepcao(Ambiente ambiente) throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL retornoRecepcao(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL inutilizacao(Ambiente ambiente) throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL consultaProtocolo(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL statusServico(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL consultaCadastro(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL recepcaoEvento(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}
	},

	PB("Paraíba", 25, 2507507) {
		@Override
		public URL recepcao(Ambiente ambiente) throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL retornoRecepcao(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL inutilizacao(Ambiente ambiente) throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL consultaProtocolo(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL statusServico(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL consultaCadastro(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL recepcaoEvento(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}
	},

	PE("Pernambuco", 26, 2611606) {
		@Override
		public URL recepcao(Ambiente ambiente) throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL retornoRecepcao(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL inutilizacao(Ambiente ambiente) throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL consultaProtocolo(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL statusServico(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL consultaCadastro(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL recepcaoEvento(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}
	},

	PI("Piauí", 22, 2211001) {
		@Override
		public URL recepcao(Ambiente ambiente) throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL retornoRecepcao(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL inutilizacao(Ambiente ambiente) throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL consultaProtocolo(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL statusServico(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL consultaCadastro(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL recepcaoEvento(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}
	},

	PR("Paraná", 41, 4106902) {
		@Override
		public URL recepcao(Ambiente ambiente) throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL retornoRecepcao(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL inutilizacao(Ambiente ambiente) throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL consultaProtocolo(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL statusServico(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL consultaCadastro(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL recepcaoEvento(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}
	},

	RJ("Rio de Janeiro", 33, 3304557) {
		@Override
		public URL recepcao(Ambiente ambiente) throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL retornoRecepcao(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL inutilizacao(Ambiente ambiente) throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL consultaProtocolo(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL statusServico(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL consultaCadastro(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL recepcaoEvento(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}
	},

	RN("Rio Grande do Norte", 24, 2408102) {
		@Override
		public URL recepcao(Ambiente ambiente) throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL retornoRecepcao(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL inutilizacao(Ambiente ambiente) throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL consultaProtocolo(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL statusServico(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL consultaCadastro(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL recepcaoEvento(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}
	},

	RO("Rondonia", 11, 1100205) {
		@Override
		public URL recepcao(Ambiente ambiente) throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL retornoRecepcao(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL inutilizacao(Ambiente ambiente) throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL consultaProtocolo(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL statusServico(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL consultaCadastro(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL recepcaoEvento(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}
	},

	RR("Roraima", 14, 1400100) {
		@Override
		public URL recepcao(Ambiente ambiente) throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL retornoRecepcao(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL inutilizacao(Ambiente ambiente) throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL consultaProtocolo(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL statusServico(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL consultaCadastro(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL recepcaoEvento(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}
	},

	RS("Rio Grande do Sul", 43, 4314902) {
		@Override
		public URL recepcao(Ambiente ambiente) throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL retornoRecepcao(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL inutilizacao(Ambiente ambiente) throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL consultaProtocolo(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL statusServico(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL consultaCadastro(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL recepcaoEvento(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}
	},

	SC("Santa Catarina", 42, 4205407) {
		@Override
		public URL recepcao(Ambiente ambiente) throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL retornoRecepcao(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL inutilizacao(Ambiente ambiente) throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL consultaProtocolo(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL statusServico(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL consultaCadastro(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL recepcaoEvento(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}
	},

	SE("Sergipe", 28, 2800308) {
		@Override
		public URL recepcao(Ambiente ambiente) throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL retornoRecepcao(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL inutilizacao(Ambiente ambiente) throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL consultaProtocolo(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL statusServico(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL consultaCadastro(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL recepcaoEvento(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}
	},

	SP("São Paulo", 35, 3550308) {
		@Override
		public URL recepcao(Ambiente ambiente) throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL retornoRecepcao(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL inutilizacao(Ambiente ambiente) throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL consultaProtocolo(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL statusServico(Ambiente ambiente)
				throws MalformedURLException {
			switch (ambiente) {
			case HOMOLOGACAO:
				return new URL("https://homologacao.nfe.fazenda.sp.gov.br/nfeweb/services/NfeStatusServico2.asmx");
			case PRODUCAO:
				return new URL("https://nfe.fazenda.sp.gov.br/nfeweb/services/nfestatusservico2.asmx");
			default:
				return null;
			}
		}

		@Override
		public URL consultaCadastro(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL recepcaoEvento(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}
	},

	TO("Tocantins", 17, 1721000) {
		@Override
		public URL recepcao(Ambiente ambiente) throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL retornoRecepcao(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL inutilizacao(Ambiente ambiente) throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL consultaProtocolo(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL statusServico(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL consultaCadastro(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL recepcaoEvento(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}
	},

	EX("Exterior", 99, 9999999) {
		@Override
		public URL recepcao(Ambiente ambiente) throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL retornoRecepcao(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL inutilizacao(Ambiente ambiente) throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL consultaProtocolo(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL statusServico(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL consultaCadastro(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}

		@Override
		public URL recepcaoEvento(Ambiente ambiente)
				throws MalformedURLException {
			
			return null;
		}
	};

	private final String descricao;
	private final int codigo;
	private final int ibge;

	private UF(String descricao, int codigo, int ibge) {
		this.descricao = descricao;
		this.codigo = codigo;
		this.ibge = ibge;
	}

	@Override
	public String getDescricao() {
		return descricao;
	}

	@Override
	public int getCodigo() {
		return codigo;
	}

	@Override
	public int getIbge() {
		return ibge;
	}
	
	/**
	 * Retorna a UF de acordo com o código do estado.
	 * @param codigo do estado.
	 * @return UF referente.
	 */
	public static UF by(String codigo) {
		Collection<UF> lista = new HashSet<UF>();
		lista.addAll(Arrays.asList(UF.values()));
		UF temp = UF.SP;
		for (UF item : lista) {
			if (String.valueOf(item.getCodigo()) == codigo) {
				temp = item;
				break;
			}
		}
		return temp;
	}
}
