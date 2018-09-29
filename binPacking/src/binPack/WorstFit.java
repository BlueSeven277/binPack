package binPack;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by srx on 2017/11/30.
 * Worst fit:
 1. Put each item into the emptiest bin among those with something in them. Only start a new bin if the item doesn't fit into any bin that's already been started.
 2. If there are two or more bins already started which are tied for emptiest, use the bin opened earliest from among those tied.
 Note: You can think of this as putting each piece into the box which is lightest so far, trying to "even things out." The second rule is just a "tie breaker" when the first rule has more than one answer.

 */
public class WorstFit {
    public static int wfit(ArrayList<Float> box){
        
        ArrayList<Bin> bin = new ArrayList<Bin>();
        bin.add(new Bin());
        int maxCap = 0;
        for (Float boxitem : box) {
           // find the bin with the largest capacity
           for (int i = 0; i < bin.size(); i++){
               if (bin.get(i).capacity > bin.get(maxCap).capacity){
                   maxCap = i;
               }
           }
           if (bin.get(maxCap).capacity > boxitem){
               bin.get(maxCap).addBoxes(boxitem);
           }
           else {
               Bin nbin = new Bin();
               nbin.addBoxes(boxitem);
               bin.add(nbin);
           }

        }
        return bin.size();
    }

    public static void main(String[] args) {

        ArrayList<Float> boxes = new ArrayList<Float>();
        // Test case 3: initialize the size of the boxes by random numbers
        for (int i = 0; i< 100000; i++) {
            Random rand = new Random();
            float f = rand.nextFloat() * 1;
            boxes.add(f);
        }
        //Test case 1 and Test case 2
//        for (int i = 0; i< 100; i++){
//            boxes.add((float)0.3);
//            boxes.add((float)0.8);
//            boxes.add((float)0.5);
//            boxes.add((float)0.1);
//            boxes.add((float)0.7);
//            boxes.add((float)0.7);
//            boxes.add((float)0.3);
//        }
        long startTime = System.currentTimeMillis();
        System.out.println(WorstFit.wfit(boxes));
        long endTime = System.currentTimeMillis();
        System.out.println("Run time of WorstFit is ：" + (endTime - startTime) + "ms");    //输出程序运行时间

    }
}
