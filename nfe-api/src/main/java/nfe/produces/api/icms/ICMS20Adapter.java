package nfe.produces.api.icms;

import org.nfe.xsd.pl6.procNFe.TNFe;
import org.nfe.xsd.pl6.procNFe.TNFe.InfNFe.Det.Imposto.ICMS.ICMS20;

/**
 * 
 * @author arthemus
 * @since 14/08/2013
 */
public class ICMS20Adapter extends ICMSAdapter {

	private final ICMS20 icms;

	public ICMS20Adapter(TNFe.InfNFe.Det.Imposto.ICMS.ICMS20 icms) {
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
	protected boolean isInstance() {
		return (this.icms != null);
	}
}