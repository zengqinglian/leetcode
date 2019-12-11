package fizzBuzzMultithreaded;

import java.util.concurrent.atomic.AtomicInteger;
//4ms solution , meet 50%
public class FizzBuzz {
    private int n;
    private AtomicInteger count = new AtomicInteger(1);
    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while(count.get()<=n){
            if(count.get()%3 ==0 && count.get()%5!=0){
                printFizz.run();
                count.getAndIncrement();
            }else{
                Thread.sleep(1);
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while(count.get()<=n){
            if(count.get()%5 ==0 && count.get()%3!=0){
                printBuzz.run();
                count.getAndIncrement();
            }else{
                Thread.sleep(1);
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while(count.get()<=n){
            if(count.get()%5 ==0 && count.get()%3==0){
                printFizzBuzz.run();
                count.getAndIncrement();
            }else{
                Thread.sleep(1);
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while(count.get()<=n){
            if(count.get()%5 !=0 && count.get()%3!=0){
                printNumber.accept(count.getAndIncrement());
            }else{
                Thread.sleep(1);
            }
        }
    }
}
