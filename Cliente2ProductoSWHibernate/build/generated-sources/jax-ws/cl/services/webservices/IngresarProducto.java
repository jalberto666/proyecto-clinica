
package cl.services.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para IngresarProducto complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="IngresarProducto">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codigo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="apellidoP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="apellidoM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sexo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechaN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="municipio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="centroSalud" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="direccion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mna" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IngresarProducto", propOrder = {
    "codigo",
    "nombre",
    "apellidoP",
    "apellidoM",
    "sexo",
    "fechaN",
    "municipio",
    "centroSalud",
    "direccion",
    "mna"
})
public class IngresarProducto {

    protected int codigo;
    protected String nombre;
    protected String apellidoP;
    protected String apellidoM;
    protected String sexo;
    protected String fechaN;
    protected String municipio;
    protected String centroSalud;
    protected String direccion;
    protected int mna;

    /**
     * Obtiene el valor de la propiedad codigo.
     * 
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Define el valor de la propiedad codigo.
     * 
     */
    public void setCodigo(int value) {
        this.codigo = value;
    }

    /**
     * Obtiene el valor de la propiedad nombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Define el valor de la propiedad nombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Obtiene el valor de la propiedad apellidoP.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApellidoP() {
        return apellidoP;
    }

    /**
     * Define el valor de la propiedad apellidoP.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApellidoP(String value) {
        this.apellidoP = value;
    }

    /**
     * Obtiene el valor de la propiedad apellidoM.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApellidoM() {
        return apellidoM;
    }

    /**
     * Define el valor de la propiedad apellidoM.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApellidoM(String value) {
        this.apellidoM = value;
    }

    /**
     * Obtiene el valor de la propiedad sexo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * Define el valor de la propiedad sexo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSexo(String value) {
        this.sexo = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaN.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaN() {
        return fechaN;
    }

    /**
     * Define el valor de la propiedad fechaN.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaN(String value) {
        this.fechaN = value;
    }

    /**
     * Obtiene el valor de la propiedad municipio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMunicipio() {
        return municipio;
    }

    /**
     * Define el valor de la propiedad municipio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMunicipio(String value) {
        this.municipio = value;
    }

    /**
     * Obtiene el valor de la propiedad centroSalud.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCentroSalud() {
        return centroSalud;
    }

    /**
     * Define el valor de la propiedad centroSalud.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCentroSalud(String value) {
        this.centroSalud = value;
    }

    /**
     * Obtiene el valor de la propiedad direccion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Define el valor de la propiedad direccion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDireccion(String value) {
        this.direccion = value;
    }

    /**
     * Obtiene el valor de la propiedad mna.
     * 
     */
    public int getMna() {
        return mna;
    }

    /**
     * Define el valor de la propiedad mna.
     * 
     */
    public void setMna(int value) {
        this.mna = value;
    }

}
