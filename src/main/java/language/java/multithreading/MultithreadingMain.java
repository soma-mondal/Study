package language.java.multithreading;

public class MultithreadingMain {

//    public static void main(String args[]) {
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("We are in thread" + Thread.currentThread().getName());
//                throw new RuntimeException("Intentional");
//            }
//        });
//        thread.setName("M Thread");
//        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
//
//            @Override
//            public void uncaughtException(Thread t, Throwable e) {
//                System.out.println("CriticalError in thread" + t.getName() + "with exception" + e.getMessage());
//            }
//
//        });
//        System.out.println("We are executing thread" + Thread.currentThread().getName() + "before starting new thread");
//        thread.start();
//        System.out.println("We are executing thread" + Thread.currentThread().getName() + "after starting new thread");
//    }

    public static void main(String args[]) {
        Thread thread = new NThread();
        thread.start();
    }

    private static class NThread extends Thread {
        @Override
        public void run() {
            System.out.println("We are in thread " + Thread.currentThread().getName());
        }
    }
}
