import java.util.concurrent.atomic.AtomicInteger;

public class Cuenta {
    private AtomicInteger saldo = new AtomicInteger(10000);

    public void depositar(int cantidad) {
        saldo.addAndGet(cantidad);
    }

    public void retirar(int cantidad) {
        saldo.addAndGet(-cantidad);
    }

    public int getSaldo() {
        return saldo.get();
    }
}
