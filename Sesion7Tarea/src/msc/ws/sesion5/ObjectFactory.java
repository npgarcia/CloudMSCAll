
package msc.ws.sesion5;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the msc.ws.sesion5 package. 
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

    private final static QName _Carrera_QNAME = new QName("http://sesion5.ws.msc/", "Carrera");
    private final static QName _ObtenerListaMateriasPorCategoria_QNAME = new QName("http://sesion5.ws.msc/", "obtenerListaMateriasPorCategoria");
    private final static QName _ObtenerListaMateriasPorCategoriaResponse_QNAME = new QName("http://sesion5.ws.msc/", "obtenerListaMateriasPorCategoriaResponse");
    private final static QName _AgregarMateriasResponse_QNAME = new QName("http://sesion5.ws.msc/", "agregarMateriasResponse");
    private final static QName _ObtenerMateriasPorCategoriaResponse_QNAME = new QName("http://sesion5.ws.msc/", "obtenerMateriasPorCategoriaResponse");
    private final static QName _ObtenerMateriasPorCategoria_QNAME = new QName("http://sesion5.ws.msc/", "obtenerMateriasPorCategoria");
    private final static QName _AgregarMaterias_QNAME = new QName("http://sesion5.ws.msc/", "agregarMaterias");
    private final static QName _EntradaInvalida_QNAME = new QName("http://sesion5.ws.msc/", "EntradaInvalida");
    private final static QName _Materia_QNAME = new QName("http://sesion5.ws.msc/", "Materia");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: msc.ws.sesion5
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ObtenerMateriasPorCategoriaResponse }
     * 
     */
    public ObtenerMateriasPorCategoriaResponse createObtenerMateriasPorCategoriaResponse() {
        return new ObtenerMateriasPorCategoriaResponse();
    }

    /**
     * Create an instance of {@link AgregarMateriasResponse }
     * 
     */
    public AgregarMateriasResponse createAgregarMateriasResponse() {
        return new AgregarMateriasResponse();
    }

    /**
     * Create an instance of {@link ObtenerListaMateriasPorCategoriaResponse }
     * 
     */
    public ObtenerListaMateriasPorCategoriaResponse createObtenerListaMateriasPorCategoriaResponse() {
        return new ObtenerListaMateriasPorCategoriaResponse();
    }

    /**
     * Create an instance of {@link ObtenerListaMateriasPorCategoria }
     * 
     */
    public ObtenerListaMateriasPorCategoria createObtenerListaMateriasPorCategoria() {
        return new ObtenerListaMateriasPorCategoria();
    }

    /**
     * Create an instance of {@link AgregarMaterias }
     * 
     */
    public AgregarMaterias createAgregarMaterias() {
        return new AgregarMaterias();
    }

    /**
     * Create an instance of {@link Materia }
     * 
     */
    public Materia createMateria() {
        return new Materia();
    }

    /**
     * Create an instance of {@link EntradaInvalida }
     * 
     */
    public EntradaInvalida createEntradaInvalida() {
        return new EntradaInvalida();
    }

    /**
     * Create an instance of {@link ObtenerMateriasPorCategoria }
     * 
     */
    public ObtenerMateriasPorCategoria createObtenerMateriasPorCategoria() {
        return new ObtenerMateriasPorCategoria();
    }

    /**
     * Create an instance of {@link Carrera }
     * 
     */
    public Carrera createCarrera() {
        return new Carrera();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Carrera }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sesion5.ws.msc/", name = "Carrera")
    public JAXBElement<Carrera> createCarrera(Carrera value) {
        return new JAXBElement<Carrera>(_Carrera_QNAME, Carrera.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerListaMateriasPorCategoria }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sesion5.ws.msc/", name = "obtenerListaMateriasPorCategoria")
    public JAXBElement<ObtenerListaMateriasPorCategoria> createObtenerListaMateriasPorCategoria(ObtenerListaMateriasPorCategoria value) {
        return new JAXBElement<ObtenerListaMateriasPorCategoria>(_ObtenerListaMateriasPorCategoria_QNAME, ObtenerListaMateriasPorCategoria.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerListaMateriasPorCategoriaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sesion5.ws.msc/", name = "obtenerListaMateriasPorCategoriaResponse")
    public JAXBElement<ObtenerListaMateriasPorCategoriaResponse> createObtenerListaMateriasPorCategoriaResponse(ObtenerListaMateriasPorCategoriaResponse value) {
        return new JAXBElement<ObtenerListaMateriasPorCategoriaResponse>(_ObtenerListaMateriasPorCategoriaResponse_QNAME, ObtenerListaMateriasPorCategoriaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AgregarMateriasResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sesion5.ws.msc/", name = "agregarMateriasResponse")
    public JAXBElement<AgregarMateriasResponse> createAgregarMateriasResponse(AgregarMateriasResponse value) {
        return new JAXBElement<AgregarMateriasResponse>(_AgregarMateriasResponse_QNAME, AgregarMateriasResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerMateriasPorCategoriaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sesion5.ws.msc/", name = "obtenerMateriasPorCategoriaResponse")
    public JAXBElement<ObtenerMateriasPorCategoriaResponse> createObtenerMateriasPorCategoriaResponse(ObtenerMateriasPorCategoriaResponse value) {
        return new JAXBElement<ObtenerMateriasPorCategoriaResponse>(_ObtenerMateriasPorCategoriaResponse_QNAME, ObtenerMateriasPorCategoriaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerMateriasPorCategoria }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sesion5.ws.msc/", name = "obtenerMateriasPorCategoria")
    public JAXBElement<ObtenerMateriasPorCategoria> createObtenerMateriasPorCategoria(ObtenerMateriasPorCategoria value) {
        return new JAXBElement<ObtenerMateriasPorCategoria>(_ObtenerMateriasPorCategoria_QNAME, ObtenerMateriasPorCategoria.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AgregarMaterias }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sesion5.ws.msc/", name = "agregarMaterias")
    public JAXBElement<AgregarMaterias> createAgregarMaterias(AgregarMaterias value) {
        return new JAXBElement<AgregarMaterias>(_AgregarMaterias_QNAME, AgregarMaterias.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EntradaInvalida }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sesion5.ws.msc/", name = "EntradaInvalida")
    public JAXBElement<EntradaInvalida> createEntradaInvalida(EntradaInvalida value) {
        return new JAXBElement<EntradaInvalida>(_EntradaInvalida_QNAME, EntradaInvalida.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Materia }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sesion5.ws.msc/", name = "Materia")
    public JAXBElement<Materia> createMateria(Materia value) {
        return new JAXBElement<Materia>(_Materia_QNAME, Materia.class, null, value);
    }

}
