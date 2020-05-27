/**
* @author      Jiachao Chen <jc3345@cornell.edu>

*<p>
* A semaphore controls access to a shared resource through the use of a counter. If the counter is greater than zero, 
* then access is allowed. If it is zero, then access is denied. 
* What the counter is counting are permits that allow access to the shared resource. 
* Thus, to access the resource, a thread must be granted a permit from the semaphore.
* In general, to use a semaphore, the thread that wants access to the shared resource tries to acquire a permit.

* Reference: retrieved from GeeksforGeeks: https://www.geeksforgeeks.org/semaphore-in-java/
*<p>


 */


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
public class SemaphoreLearn { 

  private static final int SEM_MAX = 12; 
  public static void main(String[] args) {  
    Semaphore sem = new Semaphore(SEM_MAX); 

    ExecutorService threadPool = Executors.newFixedThreadPool(3); 

    threadPool.execute(new MyThread(sem, 7)); 
    threadPool.execute(new MyThread(sem, 4)); 
    threadPool.execute(new MyThread(sem, 2)); 

    threadPool.shutdown(); 
  } 
} 
  class MyThread extends Thread { 
    private volatile Semaphore sem;  // Semaphore 
    private int count;    // Semaphore size 
      
    MyThread(Semaphore sem, int count) { 
      this.sem = sem; 
      this.count = count; 
    } 
    public void run() { 
      try { 
       // acquire count
        sem.acquire(count); 
        Thread.sleep(2000); 
        System.out.println(Thread.currentThread().getName() + " acquire count="+count); 

      } catch (InterruptedException e) { 
        e.printStackTrace(); 

      } finally { 
        // release count 
        sem.release(count); 
        System.out.println(Thread.currentThread().getName() + " release " + count + ""); 
      } 
    } 
  }

