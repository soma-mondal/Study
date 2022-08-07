package language.java.multithreading;

import java.math.BigInteger;

public class ThreadTermination {

    public static void main(String args[]) {
//        Thread thread = new Thread(new Blocked());
//        thread.start();
//        thread.interrupt();
        Thread thread = new Thread(new LongComputation(new BigInteger("200000"), new BigInteger("100000000")));

        thread.start();
        //thread.interrupt();
    }

    private static class Blocked implements Runnable {

        @Override
        public void run() {
            try {
                System.out.println("Starting thread:" + this.getClass().getName());
                Thread.sleep(50000);
            } catch (InterruptedException exception) {
                System.out.println("Interrupted");
            }
        }
    }

    private static class LongComputation implements Runnable {

        private BigInteger base;
        private BigInteger power;

        public LongComputation(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
            System.out.println(base + "^" + power + " = " + pow(base, power));
        }

        private BigInteger pow(BigInteger base, BigInteger power) {
            BigInteger result = BigInteger.ONE;

            for (BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Prematurely interrupted computation");
                    return BigInteger.ZERO;
                }
                result = result.multiply(base);
            }

            return result;
        }
    }
}
