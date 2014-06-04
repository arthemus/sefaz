package org.sefaz.nfe.core.icms;

import org.nfe.xsd.pl6.procNFe.TNFe;
import org.nfe.xsd.pl6.procNFe.TNFe.InfNFe.Det.Imposto.ICMS.ICMSPart;
import org.sefaz.nfe.core.UF;

/**
 * 
 * @author arthemus
 * 
 */
public class ICMSPartAdapter extends ICMSAdapter {

	private final ICMSPart icms;

	public ICMSPartAdapter(TNFe.InfNFe.Det.Imposto.ICMS.ICMSPart icms) {
		this.icms = icms;
	}

	@Override
	public OrigemICMS getOrigem() {
		return OrigemICMS.values()[Integer.parseInt(icms.getOrig())];		
	}

	@Override
	public String getCST() {
		return super.getParseCST(icms.getCST());
	}

	@Override
	public ModalidadeBC getModalidadeBC() {
		return ModalidadeBC.valueOf(icms.getModBC());
	}

	@Override
	public Double getReducaoBase() {
		return super.getDoubleValue(icms.getPRedBC());
	}

	@Override
	public Double getBase() {
		return super.getDoubleValue(icms.getVBC());
	}

	@Override
	public Double getAliquota() {
		return super.getDoubleValue(icms.getPICMS());
	}

	@Override
	public Double getICMS() {
		return super.getDoubleValue(icms.getVICMS());
	}

	@Override
	public ModalidadeBaseST getModalidadeBCST() {
		return ModalidadeBaseST.valueOf(icms.getModBCST());
	}

	@Override
	public Double getMVAST() {
		return super.getDoubleValue(icms.getPMVAST());
	}

	@Override
	public Double getReducaoBaseST() {
		return super.getDoubleValue(icms.getPRedBCST());
	}

	@Override
	public Double getBaseST() {
		return super.getDoubleValue(icms.getVBCST());
	}

	@Override
	public Double getAliquotaST() {
		return super.getDoubleValue(icms.getPICMSST());
	}

	@Override
	public Double getST() {
		return super.getDoubleValue(icms.getVICMSST());
	}

	@Override
	public Double getBaseOperacaoPropria() {
		return super.getDoubleValue(icms.getPBCOp());
	}

	@Override
	public UF getUFST() {
		return UF.valueOf(icms.getUFST().value());
	}

	@Override
	protected boolean isInstance() {
		return (this.icms != null);
	}
}
