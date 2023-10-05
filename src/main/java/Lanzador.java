public class Lanzador {


        public static void main(String[] args) {
            Cuenta cuenta = new Cuenta();

            int numDepositos100 = 400;
            int numRetiros100 = 400;
            int numDepositos50 = 200;
            int numRetiros50 = 200;
            int numDepositos20 = 600;
            int numRetiros20 = 600;

            Thread[] hilos = new Thread[numDepositos100 + numRetiros100 + numDepositos50 + numRetiros50 + numDepositos20 + numRetiros20];

            for (int i = 0; i < numDepositos100; i++) {
                hilos[i] = new Thread(new HiloCliente(cuenta, 100, true));
            }

            for (int i = 0; i < numRetiros100; i++) {
                hilos[numDepositos100 + i] = new Thread(new HiloCliente(cuenta, 100, false));
            }

            for (int i = 0; i < numDepositos50; i++) {
                hilos[numDepositos100 + numRetiros100 + i] = new Thread(new HiloCliente(cuenta, 50, true));
            }

            for (int i = 0; i < numRetiros50; i++) {
                hilos[numDepositos100 + numRetiros100 + numDepositos50 + i] = new Thread(new HiloCliente(cuenta, 50, false));
            }

            for (int i = 0; i < numDepositos20; i++) {
                hilos[numDepositos100 + numRetiros100 + numDepositos50 + numRetiros50 + i] = new Thread(new HiloCliente(cuenta, 20, true));
            }

            for (int i = 0; i < numRetiros20; i++) {
                hilos[numDepositos100 + numRetiros100 + numDepositos50 + numRetiros50 + numDepositos20 + i] = new Thread(new HiloCliente(cuenta, 20, false));
            }



            for (Thread hilo : hilos) {
                hilo.start();
            }

            for (Thread hilo : hilos) {
                try {
                    hilo.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            int saldoFinal = cuenta.getSaldo();
            if (saldoFinal == 10000) {
                System.out.println("La simulación fue exitosa. El saldo final es 10,000 euros.");
            } else {
                System.out.println("La simulación falló. El saldo final es " + saldoFinal + " euros.");
            }
        }
    }

