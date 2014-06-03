package nfe.produces.api.icms;

import org.nfe.xsd.pl6.procNFe.TNFe;
import org.nfe.xsd.pl6.procNFe.TNFe.InfNFe.Det.Imposto.ICMS.ICMS30;

/**
 * 
 * @author arthemus
 * @since 13/08/2013
 */
public class ICMS30Adapter extends ICMSAdapter {

	private final ICMS30 icms;

	public ICMS30Adapter(TNFe.InfNFe.Det.Imposto.ICMS.ICMS30 icms) {
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
	protected boolean isInstance() {
		return (this.icms != null);
	}
}