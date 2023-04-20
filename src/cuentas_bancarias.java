public class cuentas_bancarias {
  float saldo;
  String nombre;

  cuentas_bancarias(String nombre) {
    this.nombre = nombre;
    saldo = 0;
  }

  public void depositarcuenta(float deposito) {
    saldo += deposito - calcularinteres(deposito);
  }

  public float retirarcuenta(float monto_retirar) {
    if (monto_retirar < saldo) {
      return monto_retirar;
    } else {
      return -1;
    }
  }

  public float calcularinteres(float cuenta) {
    return 0;
  }

  public String getNombre() {
    return nombre;
  }

  public float getSaldo() {
    return saldo;
  }
}

abstract class cuenta_regular extends cuentas_bancarias {
  cuenta_regular(String nombre) {
    super(nombre);
  }
  /*
   * Una cuenta regular: produce un interés del 1%. Cada vez que se hace un retiro
   * se revisa para ver si se puede realizar el retiro y que no quede sobregirar
   * la cuenta.
   */

  @Override
  public float calcularinteres(float deposito) {
    return deposito * 0.01f;
  }

  @Override
  public void depositarcuenta(float deposito) {
    super.depositarcuenta(deposito);
  }

}

abstract class cuenta_credito extends cuentas_bancarias {
  cuenta_credito(String nombre) {
    super(nombre);
  }

  /*
   * Una cuenta crédito: produce un interés del 8%. El cliente puede sobregirarse
   * en forma indefinida al realizar un retiro. Y se le cobra 1.00 cada vez que
   * retira.
   */
  @Override
  public float calcularinteres(float deposito) {
    return deposito * 0.08f;
  }

  @Override
  public float retirarcuenta(float monto_retirar) {
    return saldo = (saldo - 1) - monto_retirar - calcularinteres(monto_retirar);
  }
}