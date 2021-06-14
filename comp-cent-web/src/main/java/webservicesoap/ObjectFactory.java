
package webservicesoap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the webservicesoap package. 
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

    private final static QName _AsignarVacunadores_QNAME = new QName("http://webServiceSoap/", "asignarVacunadores");
    private final static QName _AsignarVacunadoresResponse_QNAME = new QName("http://webServiceSoap/", "asignarVacunadoresResponse");
    private final static QName _ListarVacunatorios_QNAME = new QName("http://webServiceSoap/", "listarVacunatorios");
    private final static QName _ListarVacunatoriosResponse_QNAME = new QName("http://webServiceSoap/", "listarVacunatoriosResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webservicesoap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AsignarVacunadores }
     * 
     */
    public AsignarVacunadores createAsignarVacunadores() {
        return new AsignarVacunadores();
    }

    /**
     * Create an instance of {@link AsignarVacunadoresResponse }
     * 
     */
    public AsignarVacunadoresResponse createAsignarVacunadoresResponse() {
        return new AsignarVacunadoresResponse();
    }

    /**
     * Create an instance of {@link ListarVacunatorios }
     * 
     */
    public ListarVacunatorios createListarVacunatorios() {
        return new ListarVacunatorios();
    }

    /**
     * Create an instance of {@link ListarVacunatoriosResponse }
     * 
     */
    public ListarVacunatoriosResponse createListarVacunatoriosResponse() {
        return new ListarVacunatoriosResponse();
    }

    /**
     * Create an instance of {@link DtMsjVacunatorio }
     * 
     */
    public DtMsjVacunatorio createDtMsjVacunatorio() {
        return new DtMsjVacunatorio();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AsignarVacunadores }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AsignarVacunadores }{@code >}
     */
    @XmlElementDecl(namespace = "http://webServiceSoap/", name = "asignarVacunadores")
    public JAXBElement<AsignarVacunadores> createAsignarVacunadores(AsignarVacunadores value) {
        return new JAXBElement<AsignarVacunadores>(_AsignarVacunadores_QNAME, AsignarVacunadores.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AsignarVacunadoresResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AsignarVacunadoresResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://webServiceSoap/", name = "asignarVacunadoresResponse")
    public JAXBElement<AsignarVacunadoresResponse> createAsignarVacunadoresResponse(AsignarVacunadoresResponse value) {
        return new JAXBElement<AsignarVacunadoresResponse>(_AsignarVacunadoresResponse_QNAME, AsignarVacunadoresResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarVacunatorios }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListarVacunatorios }{@code >}
     */
    @XmlElementDecl(namespace = "http://webServiceSoap/", name = "listarVacunatorios")
    public JAXBElement<ListarVacunatorios> createListarVacunatorios(ListarVacunatorios value) {
        return new JAXBElement<ListarVacunatorios>(_ListarVacunatorios_QNAME, ListarVacunatorios.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarVacunatoriosResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListarVacunatoriosResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://webServiceSoap/", name = "listarVacunatoriosResponse")
    public JAXBElement<ListarVacunatoriosResponse> createListarVacunatoriosResponse(ListarVacunatoriosResponse value) {
        return new JAXBElement<ListarVacunatoriosResponse>(_ListarVacunatoriosResponse_QNAME, ListarVacunatoriosResponse.class, null, value);
    }

}
