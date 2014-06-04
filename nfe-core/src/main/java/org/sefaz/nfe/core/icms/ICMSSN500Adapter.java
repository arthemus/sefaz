package org.sefaz.nfe.core.icms;

import org.nfe.xsd.pl6.procNFe.TNFe;
import org.nfe.xsd.pl6.procNFe.TNFe.InfNFe.Det.Imposto.ICMS.ICMSSN500;

/**
 * 
 * @author arthemus
 * @since 13/12/2013
 */
public class ICMSSN500Adapter extends ICMSAdapter {

	private final ICMSSN500 icms;

	public ICMSSN500Adapter(TNFe.InfNFe.Det.Imposto.ICMS.ICMSSN500 icms) {
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
	public Double getBaseSTRetido() {
		return super.getDoubleValue(icms.getVBCSTRet());
	}

	@Override
	public Double getSTRetido() {
		return super.getDoubleValue(icms.getVICMSSTRet());
	}

	@Override
	protected boolean isInstance() {
		return (this.icms != null);
	}
}
