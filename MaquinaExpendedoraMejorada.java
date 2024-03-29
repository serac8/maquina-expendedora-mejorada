public class MaquinaExpendedoraMejorada {
   
    // El precio del billete
    private int precioBillete;
    // La cantidad de dinero que lleva metida el cliente actual
    private int balanceClienteActual;
    // El total de dinero almacenado en la maquina desde su ultimo vaciado
    private int totalDineroAcumulado;
    // El origen del billete
    private String estacionOrigen;
    // El destino del billete
    private String estacionDestino;
    //Contador de billetes vendidos
    private int numeroBilletesVendidos;
    //M�quina con premio
    private boolean premioMaquina;
    //L�mite de billetes
    private int maximoBilletes;
    
    private int billetesPremio;
    
    
    
   

    /**
     * Crea una maquina expendedora de billetes de tren con el
     * precio del billete y el origen y destino dados. Se asume que el precio
     * del billete que se recibe es mayor que 0.
     */
    
     
    
    public MaquinaExpendedoraMejorada(int precioDelBillete, String origen, String destino, boolean premio, int maxVentaBilletes) {
        precioBillete = precioDelBillete;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = origen;
        estacionDestino = destino;
        numeroBilletesVendidos = 0;
        premioMaquina = premio;
        maximoBilletes = maxVentaBilletes;
        billetesPremio = 0;
        
    }

    
    
    
    /**
     * Devuelve el precio del billete
     */
    public int getPrecioBillete() {
        return precioBillete;
    }

    /**
     * Devuelve la cantidad de dinero que el cliente actual lleva introducida
     */
    public int getBalanceClienteActual() {
        return balanceClienteActual;
    }

    /**
     * Simula la introduccion de dinero por parte del cliente actual
     */
    public void introducirDinero(int cantidadIntroducida) {
        if (numeroBilletesVendidos >= maximoBilletes) {
            cantidadIntroducida = 0;
            System.out.println("ERROR 404");
        }
        
        else if (cantidadIntroducida > 0) {
            balanceClienteActual = balanceClienteActual + cantidadIntroducida;
        }
            
        else {
            System.out.println(cantidadIntroducida + " no es una cantidad de dinero valida.");
        }      
       
   
    }
    
    
    /**
     * Imprime un billete para el cliente actual
     */
    public void imprimirBillete() {
        int cantidadDeDineroQueFalta = precioBillete - balanceClienteActual;
        if (numeroBilletesVendidos >= maximoBilletes) {
            System.out.println("L�mite de billetes superado");
        }
        else if (cantidadDeDineroQueFalta <= 0) {        
            // Simula la impresion de un billete
            System.out.println("##################");
            System.out.println("# Billete de tren:");
            System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
            System.out.println("# " + precioBillete + " euros.");
            System.out.println("##################");
            System.out.println();        
   
            // Actualiza el total de dinero acumulado en la maquina
            totalDineroAcumulado = totalDineroAcumulado + precioBillete;
            // Reduce el balance del cliente actual dejandole seguir utilizando la maquina
            balanceClienteActual = balanceClienteActual - precioBillete;
            
            numeroBilletesVendidos = numeroBilletesVendidos + 1;
            
            
            
            if (premioMaquina == true) {
                billetesPremio = numeroBilletesVendidos % 3;
                
                if (billetesPremio == 0){
                double descuentoPrecioBillete = precioBillete * 0.10;    
                System.out.println("Tiene" + descuentoPrecioBillete + "euros de descuento en cualquier supermercado");
                }
            } 
            
        }
        else {
            System.out.println("Necesitas introducir " + (cantidadDeDineroQueFalta) + " euros mas!");
                   
        }        
        
       
       
    }
   
   
    /**
     * Cancela la operacion de compra del cliente actual y le
     * devuelve al cliente el dinero que ha introducido hasta el momento
     */
    public int cancelarOperacionYDevolverDinero() {
        int cantidadDeDineroADevolver;
        cantidadDeDineroADevolver = balanceClienteActual;
        balanceClienteActual = 0;
        return cantidadDeDineroADevolver;
           }
           
    public int vaciarDineroDeLaMaquina() {
        int vaciarMaquina;
        vaciarMaquina = balanceClienteActual + totalDineroAcumulado;
        
        if (balanceClienteActual > 0) {
            System.out.println("No se puede vaciar la m�quina con una operaci�n en curso");
            System.out.println("Cancele la operaci�n y vuelva a intentarlo");
            vaciarMaquina = -1;
            
        }
        else {
            System.out.println("No hay operaciones en curso");
            System.out.println("M�quina vaciada");
            balanceClienteActual = 0;
            totalDineroAcumulado = 0;
        }
        return vaciarMaquina;
    }
    
    
    public int getnumeroBilletesVendidos() {
             return numeroBilletesVendidos;
      
    }
    
    public void imprimeNumeroDeBilletesVendidos() {
        System.out.println("Billetes vendidos:" + numeroBilletesVendidos);
        
    }
   
    
    
    
}
   
