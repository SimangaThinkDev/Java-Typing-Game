public class MyRunnable implements Runnable {

    private final int time; // The time that the user has to type the word

    public MyRunnable ( int time ) {
        this.time = time;
    }

    @Override
    public void run() {

        for ( int i = 1 ; i <= time ; i++ ) {

            try {
                Thread.sleep( 1000 );
            } catch (Exception e) {
                System.out.println( "Thread was interrupted" );
            }

        }

    }

}
