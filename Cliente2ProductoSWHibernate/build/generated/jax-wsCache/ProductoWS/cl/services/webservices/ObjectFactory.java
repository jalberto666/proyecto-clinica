
package cl.services.webservices;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the cl.services.webservices package. 
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

    private final static QName _ConsultarProductoResponse_QNAME = new QName("http://webservices.services.cl/", "ConsultarProductoResponse");
    private final static QName _BuscarProducto_QNAME = new QName("http://webservices.services.cl/", "BuscarProducto");
    private final static QName _IngresarProducto_QNAME = new QName("http://webservices.services.cl/", "IngresarProducto");
    private final static QName _IngresarProductoResponse_QNAME = new QName("http://webservices.services.cl/", "IngresarProductoResponse");
    private final static QName _ConsultarProducto_QNAME = new QName("http://webservices.services.cl/", "ConsultarProducto");
    private final static QName _BuscarProductoResponse_QNAME = new QName("http://webservices.services.cl/", "BuscarProductoResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cl.services.webservices
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ConsultarProductoResponse }
     * 
     */
    public ConsultarProductoResponse createConsultarProductoResponse() {
        return new ConsultarProductoResponse();
    }

    /**
     * Create an instance of {@link BuscarProducto }
     * 
     */
    public BuscarProducto createBuscarProducto() {
        return new BuscarProducto();
    }

    /**
     * Create an instance of {@link IngresarProducto }
     * 
     */
    public IngresarProducto createIngresarProducto() {
        return new IngresarProducto();
    }

    /**
     * Create an instance of {@link IngresarProductoResponse }
     * 
     */
    public IngresarProductoResponse createIngresarProductoResponse() {
        return new IngresarProductoResponse();
    }

    /**
     * Create an instance of {@link ConsultarProducto }
     * 
     */
    public ConsultarProducto createConsultarProducto() {
        return new ConsultarProducto();
    }

    /**
     * Create an instance of {@link BuscarProductoResponse }
     * 
     */
    public BuscarProductoResponse createBuscarProductoResponse() {
        return new BuscarProductoResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarProductoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.services.cl/", name = "ConsultarProductoResponse")
    public JAXBElement<ConsultarProductoResponse> createConsultarProductoResponse(ConsultarProductoResponse value) {
        return new JAXBElement<ConsultarProductoResponse>(_ConsultarProductoResponse_QNAME, ConsultarProductoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarProducto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.services.cl/", name = "BuscarProducto")
    public JAXBElement<BuscarProducto> createBuscarProducto(BuscarProducto value) {
        return new JAXBElement<BuscarProducto>(_BuscarProducto_QNAME, BuscarProducto.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IngresarProducto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.services.cl/", name = "IngresarProducto")
    public JAXBElement<IngresarProducto> createIngresarProducto(IngresarProducto value) {
        return new JAXBElement<IngresarProducto>(_IngresarProducto_QNAME, IngresarProducto.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IngresarProductoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.services.cl/", name = "IngresarProductoResponse")
    public JAXBElement<IngresarProductoResponse> createIngresarProductoResponse(IngresarProductoResponse value) {
        return new JAXBElement<IngresarProductoResponse>(_IngresarProductoResponse_QNAME, IngresarProductoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarProducto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.services.cl/", name = "ConsultarProducto")
    public JAXBElement<ConsultarProducto> createConsultarProducto(ConsultarProducto value) {
        return new JAXBElement<ConsultarProducto>(_ConsultarProducto_QNAME, ConsultarProducto.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarProductoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.services.cl/", name = "BuscarProductoResponse")
    public JAXBElement<BuscarProductoResponse> createBuscarProductoResponse(BuscarProductoResponse value) {
        return new JAXBElement<BuscarProductoResponse>(_BuscarProductoResponse_QNAME, BuscarProductoResponse.class, null, value);
    }

}
