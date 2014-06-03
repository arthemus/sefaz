package nfe.produces.api.icms;

import org.nfe.xsd.pl6.procNFe.TNFe;
import org.nfe.xsd.pl6.procNFe.TNFe.InfNFe.Det.Imposto.ICMS.ICMS40;

/**
 * 
 * @author arthemus
 * @since 13/08/2013
 */
public class ICMS40Adapter extends ICMSAdapter {

	private final ICMS40 icms;

	public ICMS40Adapter(TNFe.InfNFe.Det.Imposto.ICMS.ICMS40 icms) {
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
	public Double getICMS() {
		return super.getDoubleValue(icms.getVICMS());
	}

	@Override
	public MotivoDesoneracao getMotivo() {
		return MotivoDesoneracao.valueOf(icms.getMotDesICMS());
	}

	@Override
	protected boolean isInstance() {
		return (this.icms != null);
	}
}