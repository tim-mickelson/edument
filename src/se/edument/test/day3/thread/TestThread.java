package se.edument.test.day3.thread;

import org.junit.Test;

import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Tim on 2015-05-24.
 */
public class TestThread {

    public void queue(){
        Queue q;
    }

    @Test
    public void testDownloadNoPool() throws InterruptedException {
        Downloader downloader = new Downloader();

        for(int i=0;i<10;i++){
            Thread thread = new Thread(downloader);
            thread.start();
        }

        Thread.sleep(60000L);
    }  // end function testDownloadNoPool

    @Test
    public void testDownloadSingleThread() throws InterruptedException {
        Downloader downloader = new Downloader();
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for(int i=0;i<10;i++){
            executorService.execute(downloader);
        }

        executorService.shutdown();
        Thread.sleep(60000L);
    }  // end function testDownloadSingleThread

    @Test
    public void testDownloadCachedPool() throws InterruptedException {
        Downloader downloader = new Downloader();
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for(int i=0;i<10;i++){
            executorService.execute(downloader);
        }

        executorService.shutdown();
        Thread.sleep(60000L);
    }  // end function testDownloadSingleThread


    private class Downloader implements Runnable{

        @Override
        public void run() {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("Exit thread %1$s%n", Thread.currentThread().getName());
        }  // end run
    } // end class Downloader

}  // end class TestThread