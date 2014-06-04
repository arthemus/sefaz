package nfe.produces.api.icms;

import org.nfe.xsd.pl6.procNFe.TNFe;
import org.nfe.xsd.pl6.procNFe.TNFe.InfNFe.Det.Imposto.ICMS.ICMSSN201;

/**
 * 
 * @author arthemus
 * @since 13/12/2013
 */
public class ICMSSN201Adapter extends ICMSAdapter {

	private final ICMSSN201 icms;

	public ICMSSN201Adapter(TNFe.InfNFe.Det.Imposto.ICMS.ICMSSN201 icms) {
		this.icms = icms;
	}

	@Override
	public OrigemICMS getOrigem() {
		return OrigemICMS.values()[Integer.parseInt(icms.getOrig())];		
	}

	@Override
	public String getCSOSN() {
		return icms.getCSOSN();
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
	public Double getCredSN() {
		return super.getDoubleValue(icms.getPCredSN());
	}

	@Override
	public Double getCreditoSN() {
		return super.getDoubleValue(icms.getVCredICMSSN());
	}

	@Override
	protected boolean isInstance() {
		return (this.icms != null);
	}
}
