public class NoDescuento implements DescuentoEstrategia {
  @Override
  public double aplicarDescuento(double precio) {
    return precio;
  }
}
