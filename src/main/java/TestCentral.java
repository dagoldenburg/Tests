public class TestCentral {


    public static void main(String[] args) throws InterruptedException {
        /*TestI[] tests = {new SFTPTest("SFTP"),new RestTest("Rest"),new RobotTest("Robot")};
        for(TestI t : tests){
            for(int i = 1;i<10000;i*=10) {
                t.testSendTransactions(i);
                t.testRetrieveTransactions(i);
            }
        }*/
        TestI t = new SFTPTest("SFTP");
         for(int i = 1;i<=10000;i*=10){
            t.testSendTransactions(i);
        }
    }
}
