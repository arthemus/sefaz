package org.sefaz.nfe.core.icms;

import org.nfe.xsd.pl6.procNFe.TNFe;
import org.nfe.xsd.pl6.procNFe.TNFe.InfNFe.Det.Imposto.ICMS.ICMSSN102;

/**
 * 
 * @author arthemus
 * @since 13/12/2013
 */
public class ICMSSN102Adapter extends ICMSAdapter {

	private final ICMSSN102 icms;

	public ICMSSN102Adapter(TNFe.InfNFe.Det.Imposto.ICMS.ICMSSN102 icms) {
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
	protected boolean isInstance() {
		return (this.icms != null);
	}
}
