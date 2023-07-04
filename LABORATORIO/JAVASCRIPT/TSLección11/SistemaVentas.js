class Producto{

    static contadorProductos = 0; 

    constructor(nombre,precio){
        this._idProducto = ++Producto.contadorProductos; 
        this._nombre = nombre; 
        this._precio = precio; 
    }
    
    get idProducto(){
        return this._idProducto
    }
    get nombre(){
        return this._nombre
    }
    set nombre(nombre){
        this._nombre = nombre; 
    }
    get precio(){
      return this._precio;   
    }
    set precio(precio){
        this.precio = precio; 
    }
    toString(){ //Template Literals: Nos permite insertar codigo dinamicamente
        return `idProducto: ${this._idProducto}, nombre: ${this._nombre}, precio: $${this._precio}`;
    } 
    
}//Fin de la clase producto

class Orden{
    static contadorOrdenes = 0; 
    static getMAX_PRODUCTOS(){ //Simula una constante
        return 5; 
    }
    constructor(){
        this._idOrden = ++Orden.contadorOrdenes; 
        this._productos = []; 
        this._contadorProductosAgregados = 0; 
    }
    