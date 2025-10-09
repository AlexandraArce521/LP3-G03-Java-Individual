public class DescuentoVerano implements AplicadorDescuento
{
    
	@Override
    public double descuentoFijo(Carrito carrito) {
      
        double total = carrito.totalPrecio();
        double descuento = 0;


        if (total > 100) {
            descuento = total * 0.10;
        }

        return total - descuento;
    }
    
}
