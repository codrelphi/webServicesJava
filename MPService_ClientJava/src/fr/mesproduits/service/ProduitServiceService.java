/**
 * ProduitServiceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.mesproduits.service;

public interface ProduitServiceService extends javax.xml.rpc.Service {
    public java.lang.String getProduitWSPortAddress();

    public fr.mesproduits.service.ProduitWS getProduitWSPort() throws javax.xml.rpc.ServiceException;

    public fr.mesproduits.service.ProduitWS getProduitWSPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}

//JAX-WS --> JDK 6, 7, 8
// JDK 9, 10, 11 (LTS), 12, ....
// JAX-WS n'est plus dans le JDK
 // - importer les impélmentations de JAX-WS
// wsimport
 