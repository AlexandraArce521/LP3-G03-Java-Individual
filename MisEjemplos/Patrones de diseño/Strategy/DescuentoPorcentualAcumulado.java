public class DescuentoPorcentualAcumulado implements DescuentoEstrategia {

    private double[] precios;

    public DescuentoPorcentualAcumulado(double[] precios) {
        this.precios = precios;
    }

    @Override
    public double aplicarDescuento(double precioTotal) {

        if (precios.length >= 3) {

            double menorPrecio = precios[0];

            for (int i = 1; i < precios.length; i++) {
                if (precios[i] < menorPrecio) {
                    menorPrecio = precios[i];
                }
            }

            double descuento = menorPrecio * 0.50;
            precioTotal = precioTotal - descuento;
        }

        return precioTotal;
    }
}
