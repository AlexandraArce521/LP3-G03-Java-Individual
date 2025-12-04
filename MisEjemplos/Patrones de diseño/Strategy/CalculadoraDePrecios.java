class CalculadoraDePrecios {
  private DescuentoEstrategia descuentoEstrategia;
  
  public void setDescuentoPrecio(DescuentoEstrategia descuentoEstrategia) {
    this.descuentoEstrategia = descuentoEstrategia;
  }
  
  public double calcularPrecio(double precio) {
    return descuentoEstrategia.aplicarDescuento(precio);
  }
}
