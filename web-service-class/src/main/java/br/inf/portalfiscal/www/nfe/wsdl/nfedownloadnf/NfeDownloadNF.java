/**
 * NfeDownloadNF.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package br.inf.portalfiscal.www.nfe.wsdl.nfedownloadnf;

/*
 *  NfeDownloadNF java interface
 */

public interface NfeDownloadNF {

	/**
	 * Auto generated method signature
	 * 
	 * @param nfeDadosMsg0
	 * 
	 * @param nfeCabecMsg1
	 */

	public br.inf.portalfiscal.www.nfe.wsdl.nfedownloadnf.NfeDownloadNFResult nfeDownloadNF(

			br.inf.portalfiscal.www.nfe.wsdl.nfedownloadnf.NfeDadosMsg nfeDadosMsg0,
			br.inf.portalfiscal.www.nfe.wsdl.nfedownloadnf.NfeCabecMsgE nfeCabecMsg1)
			throws java.rmi.RemoteException;

	/**
	 * Auto generated method signature for Asynchronous Invocations
	 * 
	 * @param nfeDadosMsg0
	 * 
	 * @param nfeCabecMsg1
	 */
	public void startnfeDownloadNF(

			br.inf.portalfiscal.www.nfe.wsdl.nfedownloadnf.NfeDadosMsg nfeDadosMsg0,
			br.inf.portalfiscal.www.nfe.wsdl.nfedownloadnf.NfeCabecMsgE nfeCabecMsg1,

			final br.inf.portalfiscal.www.nfe.wsdl.nfedownloadnf.NfeDownloadNFCallbackHandler callback)

	throws java.rmi.RemoteException;

	//
}
