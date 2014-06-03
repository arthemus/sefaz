package nfe.produces.api.icms;

import org.nfe.xsd.pl6.procNFe.TNFe;
import org.nfe.xsd.pl6.procNFe.TNFe.InfNFe.Det.Imposto.ICMS.ICMS60;

/**
 * 
 * @author arthemus
 * @since 13/08/2013
 */
public class ICMS60Adapter extends ICMSAdapter {

	private final ICMS60 icms;

	public ICMS60Adapter(TNFe.InfNFe.Det.Imposto.ICMS.ICMS60 icms) {
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
	protected boolean isInstance() {
		return (this.icms != null);
	}
}