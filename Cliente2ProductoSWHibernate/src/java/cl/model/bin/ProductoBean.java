/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.model.bin;

import cl.services.webservices.ConsultarProducto;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Usuario
 */
@ManagedBean
@SessionScoped
public class ProductoBean {

    private Integer codigo;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String sexo;
    private String fechaN;
    private String municipio;
    private String centroSalud;
    private String direccion;
    private Integer mna;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFechaN() {
        return fechaN;
    }

    public void setFechaN(String fechaN) {
        this.fechaN = fechaN;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getCentroSalud() {
        return centroSalud;
    }

    public void setCentroSalud(String centroSalud) {
        this.centroSalud = centroSalud;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getMna() {
        return mna;
    }

    public void setMna(Integer mna) {
        this.mna = mna;
    }
    
    
    
    public ProductoBean() {
        
        
    }
    
    public String guardarProd(){
        String msj=ingresarProducto(codigo, nombre, apellidoP, apellidoM, sexo,fechaN,municipio,centroSalud,direccion,mna);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, msj,"...");
        
        FacesContext.getCurrentInstance().addMessage(null, msg);
        limpiarForm();
        
        return "index";
    }
    
    public String buscarProd(){
        String msj=buscarProducto(codigo);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, msj,"...");
        
        FacesContext.getCurrentInstance().addMessage(null, msg);
        limpiarForm();
        
        return "index";
    }
    
    public List<Producto> getListaProd(){
        List<Producto> lista= ConsultarProductos();
        return lista; 
    }
   
    public void limpiarForm(){
        this.codigo=0;
        this.nombre="";
        this.apellidoP="";
        this.apellidoM="";
        this.sexo="";
        this.fechaN="";
        this.municipio="";
        this.centroSalud="";
        this.direccion="";
        this.mna=0;
        
        
        
    }
    
 
    private static String buscarProducto(int codigo) {
        cl.services.webservices.ProductoWS_Service service = new cl.services.webservices.ProductoWS_Service();
        cl.services.webservices.ProductoWS port = service.getProductoWSPort();
        return port.buscarProducto(codigo);
    }

    private static java.util.List<java.lang.Object> consultarProducto() {
        cl.services.webservices.ProductoWS_Service service = new cl.services.webservices.ProductoWS_Service();
        cl.services.webservices.ProductoWS port = service.getProductoWSPort();
        return port.consultarProducto();
    }

    private static String ingresarProducto(int codigo, java.lang.String nombre, java.lang.String apellidoP, java.lang.String apellidoM, java.lang.String sexo, java.lang.String fechaN, java.lang.String municipio, java.lang.String centroSalud, java.lang.String direccion, int mna) {
        cl.services.webservices.ProductoWS_Service service = new cl.services.webservices.ProductoWS_Service();
        cl.services.webservices.ProductoWS port = service.getProductoWSPort();
        return port.ingresarProducto(codigo, nombre, apellidoP, apellidoM, sexo, fechaN, municipio, centroSalud, direccion, mna);
    }
    
    
    
}
