//bushra abu saaad 325998870
//shams alzeadna 214840316
package Race;
	public class Racer implements Runnable {

	    private static int globalId = 1; 
	    private int id;
	    private int speed;
	    private Track track;

	    public Racer(int speed, Track track) {
	        if(speed < 1 || speed > 10) {
	        	if (speed < 1 || speed > 10) {
	        	    System.out.println("Error: speed must be between 1 and 10");
	        	    speed = 1;
	        	}

	        }
	        this.id = globalId++;
	        this.speed = speed;
	        this.track = track;
	    }

	    public void go() {
	        Thread.currentThread().setPriority(speed);
	        for(int i = 1; i <= 100; i++) {
	            System.out.println("Runner " + id + " ran " + i + " meters");
	            try { Thread.sleep(100); } catch(Exception e){}
	        }
	        int place = track.incrementFinished();
	        String suffix = (place==1 ? "st" : place==2 ? "nd" : place==3 ? "rd" : "th");
	        System.out.println("Runner " + id + " finished " + place + suffix);
	    }

	    @Override
	    public void run() {
	        go();
	    }
	}

