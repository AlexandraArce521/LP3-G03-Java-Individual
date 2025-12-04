public class DescuentoPorcentual implements DescuentoEstrategia {
  public int codProduct1;
  public int codProduct2;
  
  public DescuentoPorcentual(int cod1, int cod2) {
    this.codProduct1 = cod1;
    this.codProduct2 = cod2;
  }
  
  @Override
  public double aplicarDescuento(double precio) {
    if(codProduct1 == codProduct2) {
      return precio * 0.70;
    }
    return precio;
  }
}

