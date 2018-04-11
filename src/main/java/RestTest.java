import io.vertx.core.Vertx;

public class RestTest extends TestI implements Cloneable{

    public RestTest(String filename) {
        super(filename);
        setUpEnvironment();
    }

    Communicator comm;

    @Override
    void testSendTransactions(int amountOfTests) {
        super.setFileNameEnding("SendManyTrans"+amountOfTests);
        new Thread(new Measurement(filename)).start();
        comm.sendLoginForm();
        for(int i = 0;i<amountOfTests;i++)
            comm.makeTransaction();
        Measurement.setRunning(false);
    }

    @Override
    void testRetrieveTransactions(int amountOfTests) {
        super.setFileNameEnding("RetrieveManyTrans"+amountOfTests);
        new Thread(new Measurement(filename)).start();
        comm.sendLoginForm();
        for(int i = 0;i<amountOfTests;i++) {
            comm.getNrOfTransactions();
        }
        Measurement.setRunning(false);
    }



    @Override
    void setUpEnvironment() {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new BigBoiVertx());
        comm = new Communicator();
        vertx.deployVerticle(comm);


    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
