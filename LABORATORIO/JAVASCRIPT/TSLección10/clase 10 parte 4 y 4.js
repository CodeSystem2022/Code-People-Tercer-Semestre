class Producto{
    static contadorProductos = 0;
    constructor(nombre, precio){
        this._idProducto=++Producto.contadorProductos;//incrementa el valor estatic
        this._nombre = nombre;
        this._precio = precio;
    }

    get idProducto(){
        return this._idProducto;
    }

    get nombre(){
        return this._nombre;
    }

    set nombre(nombre){
        this._nombre = nombre;
    }

    get precio(){
        return this._precio;
    }

    set precio(precio){
        this._precio = precio;
    }
    toString() {//Templeate literals : no permite insertar código dinamicamente
        return `idProducto : ${this._idProducto}, nombre : ${this._nombre}, precio : ${this._precio}`;

    }
}
//Fin de la clase Producto //clase10 parte 3

let = producto1 = new Producto("Pantalon", 200);
let = producto2 = new Producto("Camisa",150);
console.log(producto1.toString()); idProducto : 1, nombre : Pantalon, precio : $200
console.log(producto2.toString()); idProducto : 2, nombre : Camisa, precio : $150

/*
let producto1 = new Producto ("Pantalon",200);
let producto2 = new Producto("Camisa",150);
console.log(producto1.toString()); idProducto : 1, nombre : Pantalon, precio : $200
console.log(producto2.toString()); idProducto: 2, nombre : Camisa, precio : $150
*/

// clase 10 parte 4

class Orden{
    static contadorOrden = 0;
    static getMAX_PRODUCTOS(){
        return 5;
    }
    constructor(){
        this._idOrden = ++Orden.contadorOrden;
        this._producto =[];
        this._contadorProductoAgregados = 0;
    
    }
    get idOrden(){
        return this._idOrden;
    }
    agregatProducto(prodcuto){
        if (this._productos.leght < Orden.getMAX_PRODUCTOS){
            this._productos.push(producto);//Tenemos 2 tipos de sintaxis: 1
           // this._productos[this._contadorProductoAgregados++] = producto;
            else {
                console.log("Nose pueden agregar mas productos");
            }
        }
        //Fin del metoo agregar producto

    }

}//Fin de la clase orden

