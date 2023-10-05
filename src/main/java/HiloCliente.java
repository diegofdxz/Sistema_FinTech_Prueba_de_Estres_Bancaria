public class HiloCliente implements Runnable {
        private Cuenta cuenta;
        private int cantidad;
        private boolean depositar;

        public HiloCliente(Cuenta cuenta, int cantidad, boolean depositar) {
            this.cuenta = cuenta;
            this.cantidad = cantidad;
            this.depositar = depositar;
        }

        @Override
        public void run() {
            if (depositar) {
                cuenta.depositar(cantidad);
            } else {
                cuenta.retirar(cantidad);
            }
        }
    }

