import java.util.ArrayList;
import java.util.List;
import java.util.Random;

doItInParallel(loadData())

def loadData(){
    // override this method with your own loading data logic
    list = new ArrayList<String>();

    for(i=0;i < 100 ; i++){
        list.add(new String(""+i));
    }
    return list
}
def doTask(taskData){
    // override this method with your own specific task
    list = new ArrayList<String>();
    println taskData
}
def doItInParallel(data){
    batchSize = 10;

    lists = splitList(data, batchSize)

    def threads = []

    lists.each{ l ->
        th = new Thread({
            Random rand = new Random()
            def wait = (long)(rand.nextDouble() * 1000)
            this.sleep wait
            doTask(l)
        })
        threads << th
    }

    threads.each { it.start() }
    threads.each { it.join() }
}
def splitList(List<List<String>> list,int L) {

    parts = new ArrayList<List<String>>()
    N = list.size()
    for (int i = 0; i < N; i += L) {
        parts.add(new ArrayList<String>(
                list.subList(i, Math.min(N, i + L)))
        )
    }
    return parts
}









