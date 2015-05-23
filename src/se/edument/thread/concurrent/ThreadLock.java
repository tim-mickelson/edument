package se.edument.thread.concurrent;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ThreadLock<T> {
	private ConcurrentLinkedQueue<T> pageId = new ConcurrentLinkedQueue<T>();
	
	public synchronized void acquire(T pageID){
		while(pageId.contains(pageID)){
			try{
				// wait for other thread to become free 
				wait();
			}catch(InterruptedException e){
				/* do nothing */
			}
		} // end wait for lock
		// pageID is free, lock it
		pageId.add(pageID);
	}  // end public function acquire

	/**
	 * The pageID has been elaborated now free it.
	 * 
	 * @author Tim Mickelson
	 * @since 04/12/2013
	 * @param pageID Facebook page ID
	 */
	public synchronized void release(T pageID){
		pageId.remove(pageID);
		// Tell all waiting threads that this pageID is free
		notifyAll();
	}  // end public function release
	
	@Override
	public String toString(){
		return pageId.toString();
	}
	
} // end public class ThreadLock