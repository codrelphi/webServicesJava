/**
 * ProduitServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.mesproduits.service;

public class ProduitServiceServiceLocator extends org.apache.axis.client.Service implements fr.mesproduits.service.ProduitServiceService {

    public ProduitServiceServiceLocator() {
    }


    public ProduitServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ProduitServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ProduitWSPort
    private java.lang.String ProduitWSPort_address = "http://localhost:9090/";

    public java.lang.String getProduitWSPortAddress() {
        return ProduitWSPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ProduitWSPortWSDDServiceName = "ProduitWSPort";

    public java.lang.String getProduitWSPortWSDDServiceName() {
        return ProduitWSPortWSDDServiceName;
    }

    public void setProduitWSPortWSDDServiceName(java.lang.String name) {
        ProduitWSPortWSDDServiceName = name;
    }

    public fr.mesproduits.service.ProduitWS getProduitWSPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ProduitWSPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getProduitWSPort(endpoint);
    }

    public fr.mesproduits.service.ProduitWS getProduitWSPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            fr.mesproduits.service.ProduitWSPortBindingStub _stub = new fr.mesproduits.service.ProduitWSPortBindingStub(portAddress, this);
            _stub.setPortName(getProduitWSPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setProduitWSPortEndpointAddress(java.lang.String address) {
        ProduitWSPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (fr.mesproduits.service.ProduitWS.class.isAssignableFrom(serviceEndpointInterface)) {
                fr.mesproduits.service.ProduitWSPortBindingStub _stub = new fr.mesproduits.service.ProduitWSPortBindingStub(new java.net.URL(ProduitWSPort_address), this);
                _stub.setPortName(getProduitWSPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ProduitWSPort".equals(inputPortName)) {
            return getProduitWSPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service.mesproduits.fr/", "ProduitServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service.mesproduits.fr/", "ProduitWSPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ProduitWSPort".equals(portName)) {
            setProduitWSPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
