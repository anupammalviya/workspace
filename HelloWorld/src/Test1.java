
public class Test1 {
	public static void testing(String[] arr) {
		arr = new String[10];
		System.out.println(arr.length);
	}

	public static void main(String[] args) {
		EvenOdd eo = new EvenOdd(0);
		Thread t1 = new Thread(new EvenThread(eo));
		Thread t2 = new Thread(new OddThread(eo));
		t1.start();
		t2.start();
	}
}

class EvenThread implements Runnable {
	EvenOdd sharedObject;
 
	public EvenThread(EvenOdd sharedObject) {
		super();
		this.sharedObject = sharedObject;
	}

	@Override
	public void run() {
		synchronized (sharedObject) {
			while (sharedObject.getI() <= 100) {
				if (sharedObject.getI() % 2 == 0) {

					int i = sharedObject.getI();
					System.out.println(i);
					i = i + 1;
					sharedObject.setI(i);
					sharedObject.notifyAll();

				} else {
					try {
						sharedObject.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		}

	}

}

class OddThread implements Runnable {
	EvenOdd sharedObject;
 

	public OddThread(EvenOdd sharedObject) {
		super();
		this.sharedObject = sharedObject;
	}

	@Override
	public void run() {
			synchronized (sharedObject) {
				while (sharedObject.getI() <= 100) {
					if (sharedObject.getI() % 2 != 0) {

						int i = sharedObject.getI();
						System.out.println(i);
						i = i + 1;
						sharedObject.setI(i);
						sharedObject.notifyAll();

					} else {
						try {
							sharedObject.wait();

						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}

	}

}

class EvenOdd {
	int i = 0;

	public EvenOdd(int i) {
		super();
		this.i = i;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
}
