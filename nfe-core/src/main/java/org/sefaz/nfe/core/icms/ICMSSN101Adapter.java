package org.sefaz.nfe.core.icms;

import org.nfe.xsd.pl6.procNFe.TNFe;
import org.nfe.xsd.pl6.procNFe.TNFe.InfNFe.Det.Imposto.ICMS.ICMSSN101;

/**
 * 
 * @author arthemus
 * @since 16/12/2013
 */
public class ICMSSN101Adapter extends ICMSAdapter {

	private final ICMSSN101 icms;

	public ICMSSN101Adapter(TNFe.InfNFe.Det.Imposto.ICMS.ICMSSN101 icms) {
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