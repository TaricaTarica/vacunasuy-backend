
package agesicsoap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the servicios package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ObtenerPersona_QNAME = new QName("http://servicios/", "obtenerPersona");
    private final static QName _ObtenerPersonaResponse_QNAME = new QName("http://servicios/", "obtenerPersonaResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: servicios
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ObtenerPersona }
     * 
     */
    public ObtenerPersona createObtenerPersona() {
        return new ObtenerPersona();
    }

    /**
     * Create an instance of {@link ObtenerPersonaResponse }
     * 
     */
    public ObtenerPersonaResponse createObtenerPersonaResponse() {
        return new ObtenerPersonaResponse();
    }

    /**
     * Create an instance of {@link DtPersona }
     * 
     */
    public DtPersona createDtPersona() {
        return new DtPersona();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerPersona }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ObtenerPersona }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "obtenerPersona")
    public JAXBElement<ObtenerPersona> createObtenerPersona(ObtenerPersona value) {
        return new JAXBElement<ObtenerPersona>(_ObtenerPersona_QNAME, ObtenerPersona.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerPersonaResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ObtenerPersonaResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "obtenerPersonaResponse")
    public JAXBElement<ObtenerPersonaResponse> createObtenerPersonaResponse(ObtenerPersonaResponse value) {
        return new JAXBElement<ObtenerPersonaResponse>(_ObtenerPersonaResponse_QNAME, ObtenerPersonaResponse.class, null, value);
    }

}
