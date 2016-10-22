/**
 * Created by EricLee on 10/21/16.
 */
public class A2CAS {

//    private int[][] proposes;
//    private A2CASAtomic a2cas;
//    private int threadNums;
//
//    public A2CAS(int threads) {
//        this.threadNums = threads;
//        proposes = new int[threadNums][threadNums];
//        a2cas = new A2CASAtomic(-1, -1);
//    }
//
//    public int decide(int threadId, int value) {
//        // Set it's own value in propose array first
//        proposes[threadId][threadId] = value;
//        // If this thread is the first then write one of two locations
//        // Suppose compare and set will find all pairs of two input parameters
//        // for example, input (a,b) will find both (a,b) and (b,a)
//        if (a2cas.compareAndSet(-1, -1, threadId)) {
//            return value;
//        } else {
//            for (int i = 0; i < threadNums; i++) {
//                for (int j = 0; j < threadNums; j++) {
//                    if (proposes[i][j] != 0) {
//                        // If one location is overwritten and the other is not
//                        if (a2cas.compareAndSet(-1, i, threadId)) {
//                            return proposes[i][i];
//                        }
//                        // If both locations are overwritten
//                        if (a2cas.compareAndSet(i, j, threadId)) {
//                            return proposes[i][j];
//                        }
//                    }
//                }
//            }
//        }
//        return value;
//    }
}
