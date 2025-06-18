import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Concurrency {
    public static void main(String[] args) {

        System.out.println("Problem 1114: Print in Order: ");
        _1114_PrintInOrder printInOrder = new _1114_PrintInOrder();

        Thread threadA = new Thread(() -> {
            try {
                printInOrder.first(() -> System.out.println("first"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadB = new Thread(() -> {
            try {
                printInOrder.second(() -> System.out.println("second"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadC = new Thread(() -> {
            try {
                printInOrder.third(() -> System.out.println("third"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Randomize thread start order to simulate concurrency
        threadC.start();
        threadA.start();
        threadB.start();

        try {
            threadA.join();
            threadB.join();
            threadC.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println();
        _1115_FooBar fooBar = new _1115_FooBar(2);

        Thread A = new Thread(()-> {
            try {
                fooBar.foo(new Runnable() {
                    @Override
                    public void run() {
                        System.out.printf("Foo");
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread B = new Thread(()-> {
            try {
                fooBar.bar(new Runnable() {
                    @Override
                    public void run() {
                        System.out.printf("Bar");
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        A.start();
        B.start();

        try {
            A.join();
            B.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}



/**
 * Suppose we have a class:
 * <pre>{@code
 * public class Foo {
 *     public void first() { print("first"); }
 *     public void second() { print("second"); }
 *     public void third() { print("third"); }
 * }
 * }</pre>
 *
 * The same instance of {@code Foo} will be passed to three different threads.
 * Thread A will call {@code first()}, thread B will call {@code second()}, and thread C will call {@code third()}.
 * Design a mechanism and modify the program to ensure that:
 * <ul>
 *   <li>{@code second()} is executed after {@code first()}</li>
 *   <li>{@code third()} is executed after {@code second()}</li>
 * </ul>
 *
 * <p><strong>Note:</strong><br>
 * We do not know how the threads will be scheduled by the operating system, even though the numbers in the input may imply an ordering.
 * The input format is mainly used to ensure comprehensiveness in our tests.
 *
 * <p><strong>Example 1:</strong><br>
 * Input: nums = [1, 2, 3] <br>
 * Output: "firstsecondthird" <br>
 * Explanation: There are three threads being fired asynchronously.
 * The input [1, 2, 3] means thread A calls {@code first()}, thread B calls {@code second()}, and thread C calls {@code third()}.
 * "firstsecondthird" is the correct output.
 *
 * <p><strong>Example 2:</strong><br>
 * Input: nums = [1, 3, 2] <br>
 * Output: "firstsecondthird" <br>
 * Explanation: The input [1, 3, 2] means thread A calls {@code first()}, thread B calls {@code third()}, and thread C calls {@code second()}.
 * "firstsecondthird" is the correct output.
 * <br><br>
 * <b>Thoughts: </b><br><br>
 * Keep boolean to make sure the work is done in order by waiting. <br>
 * since multiple threads are using the same global variables in multiple methods use synchronized <br>
 *
 */

class _1114_PrintInOrder {
    private boolean oneDone ;
    private boolean twoDone ;

    public _1114_PrintInOrder() {
        oneDone = false;
        twoDone = false;
    }

    public synchronized void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        oneDone = true;
        notifyAll();
    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {
        while (! oneDone) {
            wait();
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        twoDone = true;
        notifyAll();
    }

    public synchronized void third(Runnable printThird) throws InterruptedException {
        while(!twoDone) {
            wait();
        }

        // printThird.run () outputs "third". Do not change or remove this line.
        printThird.run();
    }
}

/**
 * <b>Problem 1115: Print FooBar Alternately</b><br><br>
 * <pre>{@code
 * class FooBar {
 *   public void foo() {
 *     for (int i = 0; i < n; i++) {
 *       print("foo");
 *     }
 *   }
 *
 *   public void bar() {
 *     for (int i = 0; i < n; i++) {
 *       print("bar");
 *     }
 *   }
 * }
 * }</pre>
 *
 * The same instance of {@code FooBar} will be passed to two different threads: <br>
 * <ul>
 *   <li>Thread {@code A} will call {@code foo()}, while</li>
 *   <li>Thread {@code B} will call {@code bar()}.</li>
 * </ul>
 * Modify the given program to output {@code "foobar"} {@code n} times.
 */
class _1115_FooBar {
    private int n;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private boolean fooTurn = true;

    public _1115_FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            try {
                lock.lock();
                while (!fooTurn) {
                    condition.await();
                }
                printFoo.run();
                fooTurn = false;
                condition.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        Thread.sleep(1000); // Make sure the lock on the firstThread is reached first.
        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                while (fooTurn) {
                    condition.await();
                }
                printBar.run();
                fooTurn = true;
                condition.signal();
            } finally {
                lock.unlock();
            }
        }
    }
}
