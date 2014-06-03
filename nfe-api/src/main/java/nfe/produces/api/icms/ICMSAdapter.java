package nfe.produces.api.icms;

import java.util.ArrayList;

import org.nfe.commons.UF;
import org.nfe.xsd.pl6.procNFe.TNFe;

/**
 * Classe abstrata para prover acesso as informações de ICMS de uma nota fiscal,
 * independente do código e tipo de ICMS encontrado.
 * 
 * @author arthemus
 * @since 13/08/2013
 */
public abstract class ICMSAdapter {

	public ICMSAdapter() {
		super();
	}

	/**
	 * Retorna a implementação correta do ICMS de acordo com a nota fiscal.
	 * 
	 * @param icms
	 * @return Implementação da interface ICMSAdapter.
	 * @throws ICMSModelNotFoundException
	 */
	public static final ICMSAdapter getInstance(
			final TNFe.InfNFe.Det.Imposto.ICMS icms)
			throws ICMSModelNotFoundException {

		ICMSAdapter adapter = null;

		ArrayList<ICMSAdapter> list = new ArrayList<ICMSAdapter>(17);		
		list.add(new ICMS00Adapter(icms.getICMS00()));
		list.add(new ICMS10Adapter(icms.getICMS10()));
		list.add(new ICMS20Adapter(icms.getICMS20()));
		list.add(new ICMS30Adapter(icms.getICMS30()));
		list.add(new ICMS40Adapter(icms.getICMS40()));
		list.add(new ICMS51Adapter(icms.getICMS51()));
		list.add(new ICMS60Adapter(icms.getICMS60()));
		list.add(new ICMS70Adapter(icms.getICMS70()));
		list.add(new ICMS90Adapter(icms.getICMS90()));
		list.add(new ICMSPartAdapter(icms.getICMSPart()));
		list.add(new ICMSSTAdapter(icms.getICMSST()));
		list.add(new ICMSSN101Adapter(icms.getICMSSN101()));
		list.add(new ICMSSN102Adapter(icms.getICMSSN102()));
		list.add(new ICMSSN201Adapter(icms.getICMSSN201()));
		list.add(new ICMSSN202Adapter(icms.getICMSSN202()));
		list.add(new ICMSSN500Adapter(icms.getICMSSN500()));
		list.add(new ICMSSN900Adapter(icms.getICMSSN900()));

		for (ICMSAdapter item : list) {
			if (item.isInstance())
				adapter = item;
		}

		if (adapter == null)
			throw new ICMSModelNotFoundException("Classe de ICMS não reconhecida: ".concat(icms.toString())
					.concat("\n\nInforme a equipe de suporte da Softland e se possível separe o arquivo XML para análise."));

		return adapter;
	}

	/**
	 * Informa se a classe de ICMS é implementada e utilizada pela nota.
	 * 
	 * @return
	 */
	protected abstract boolean isInstance();

	/**
	 * Trata o código de CST concatenando-o com o código de Origem. 
	 * 
	 * @return
	 */
	protected String getParseCST(final String cst) {
		String cstSN = Integer.toString(getOrigem().ordinal());
		cstSN = cstSN.concat(cst);
		return cstSN;
	}
	
	/**
	 * Para obter um valor double de forma mais segura
	 * evitando NullPointerException.
	 *  
	 * @param value
	 * @return
	 */
	protected double getDoubleValue(final String value) {
		if (value == null || value.isEmpty()) 
			return 0D;
		return Double.valueOf(value);
	}
	
	/**
	 * Origem da mercadoria.
	 * 
	 * Campo: orig
	 * 
	 * @return
	 */
	public OrigemICMS getOrigem() {
		return OrigemICMS.NACIONAL;
	}

	/**
	 * Tributação do ICMS.
	 * 
	 * Campo: CST
	 * 
	 * @return
	 */
	public String getCST() {		
		return this.getParseCST("40");
	}

	/**
	 * Modalidade de determinação da base de calculo do ICMS.
	 * 
	 * Campo: modBC
	 * 
	 * @return
	 */
	public ModalidadeBC getModalidadeBC() {
		return ModalidadeBC.MARGEM_VALOR_AGREGADO;
	}

	/**
	 * Valor da base de calculo do ICMS.
	 * 
	 * Campo: vBC
	 * 
	 * @return
	 */
	public Double getBase() {
		return 0D;
	}

	/**
	 * Aliquota do imposto.
	 * 
	 * Campo: pICMS
	 * 
	 * @return
	 */
	public Double getAliquota() {
		return 0D;
	}

	/**
	 * Valor do imposto.
	 * 
	 * Campo: vICMS
	 * 
	 * @return
	 */
	public Double getICMS() {
		return 0D;
	}

	/**
	 * Campo: modBCST
	 * 
	 * @return
	 */
	public ModalidadeBaseST getModalidadeBCST() {
		return ModalidadeBaseST.PRECO_TABELADO;
	}

	/**
	 * Percentual da margem de valor adicionado do ICMS ST.
	 * 
	 * Campo: pMVAST
	 * 
	 * @return
	 */
	public Double getMVAST() {
		return 0D;
	}

	/**
	 * Percentual redução da base de calculo do ICMS ST.
	 * 
	 * Campo: pRedBCST
	 * 
	 * @return
	 */
	public Double getReducaoBaseST() {
		return 0D;
	}

	/**
	 * Valor da base de calculo do ICMS ST.
	 * 
	 * Campo: vBCST
	 * 
	 * @return
	 */
	public Double getBaseST() {
		return 0D;
	}

	/**
	 * Aliquota do imposto do ICMS ST.
	 * 
	 * Campo: pICMSST
	 * 
	 * @return
	 */
	public Double getAliquotaST() {
		return 0D;
	}

	/**
	 * Valor do ICMS ST.
	 * 
	 * Campo: vICMSST
	 * 
	 * @return
	 */
	public Double getST() {
		return 0D;
	}

	/**
	 * Percentual de redução da base de calculo do ICMS.
	 * 
	 * Campo: pRedBC
	 * 
	 * @return
	 */
	public Double getReducaoBase() {
		return 0D;
	}

	/**
	 * Motivo de desoneração do ICMS.
	 * 
	 * Campo: motDesICMS
	 * 
	 * @return
	 */
	public MotivoDesoneracao getMotivo() {
		return MotivoDesoneracao.OUTROS;
	}

	/**
	 * Valor da base de calculo do ICMS ST Retido.
	 * 
	 * Campo: vBCSTRet
	 * 
	 * @return
	 */
	public Double getBaseSTRetido() {
		return 0D;
	}

	/**
	 * Valor do ICMS ST Retido.
	 * 
	 * Campo: vICMSSTRet
	 * 
	 * @return
	 */
	public Double getSTRetido() {
		return 0D;
	}

	/**
	 * Percentual da base de calculo de operação própria.
	 * 
	 * Campo: pBCOp
	 * 
	 * @return
	 */
	public Double getBaseOperacaoPropria() {
		return 0D;
	}

	/**
	 * UF para qual é devido o ICMS ST.
	 * 
	 * Campo: UFST
	 * 
	 * @return
	 */
	public UF getUFST() {
		return UF.SP;
	}

	/**
	 * Valor da base de calculo do ICMS ST da UF de destino.
	 * 
	 * Campo: vBCSTDest
	 * 
	 * @return
	 */
	public Double getBaseSTDestino() {
		return 0D;
	}

	/**
	 * Valor do ICMS ST da UF de destino.
	 * 
	 * Campo: vICMSSTDest
	 * 
	 * @return
	 */
	public Double getSTDestino() {
		return 0D;
	}

	/**
	 * Código de situação da operação.
	 * 
	 * Campo: CSOSN
	 * 
	 * @return
	 */
	public String getCSOSN() {
		return null;
	}

	/**
	 * Aliquota aplicavel de calculo do crédito (Simples Nacional).
	 * 
	 * Campo: pCredSN
	 * 
	 * @return
	 */
	public Double getCredSN() {
		return 0D;
	}

	/**
	 * Valor crédito do ICMS que pode ser aproveitado nos termos do art. 23 da
	 * LC 123 (Simples Nascional).
	 * 
	 * Campo: vCredICMSSN
	 * 
	 * @return
	 */
	public Double getCreditoSN() {
		return 0D;
	}

}