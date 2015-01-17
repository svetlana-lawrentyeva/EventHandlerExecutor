import events.impl.ProducerImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created with IntelliJ IDEA.
 * User: nau
 * Date: 1/17/15
 * Time: 7:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Future<String>>list = new ArrayList<Future<String>>();
        for(int i=0;i<100;++i){
            list.add(executorService.submit(new ProducerImpl(i)));
        }
        for(Future<String>future:list){
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            } catch (ExecutionException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
        executorService.shutdown();
    }
}
