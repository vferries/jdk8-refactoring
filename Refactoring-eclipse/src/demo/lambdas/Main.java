package demo.lambdas;

public class Main {
	public static void main(String[] args) {
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				System.out.println("Hello Eclipse Con");
			}
		};
		new Thread(runnable).start();
	}
}
