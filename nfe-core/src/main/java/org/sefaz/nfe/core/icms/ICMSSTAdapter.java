package org.sefaz.nfe.core.icms;

import org.nfe.xsd.pl6.procNFe.TNFe;
import org.nfe.xsd.pl6.procNFe.TNFe.InfNFe.Det.Imposto.ICMS.ICMSST;

/**
 * 
 * @author arthemus
 * @since 13/12/2013
 */
public class ICMSSTAdapter extends ICMSAdapter {

	private final ICMSST icms;

	public ICMSSTAdapter(TNFe.InfNFe.Det.Imposto.ICMS.ICMSST icms) {
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
	public Double getBaseSTRetido() {
		return super.getDoubleValue(icms.getVBCSTRet());
	}

	@Override
	public Double getSTRetido() {
		return super.getDoubleValue(icms.getVICMSSTRet());
	}

	@Override
	public Double getBaseSTDestino() {
		return super.getDoubleValue(icms.getVBCSTDest());
	}

	@Override
	public Double getSTDestino() {
		return super.getDoubleValue(icms.getVICMSSTDest());
	}

	@Override
	protected boolean isInstance() {
		return (this.icms != null);
	}
}
