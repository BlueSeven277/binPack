package binPack;

import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;
/**
 * Created by srx on 2017/11/30.
 * The idea of Best Fit is to try to pack each item in the tightest spot available, in the hope that this will better fill the bins:

 Try to place the item in the fullest bin that will accommodate it, i.e., the bin that will leave the least room left over
 If no bin is found, start a new bin
 */
public class BestFit {
    public static int findBest(Float item, ArrayList<Bin> bin){
        int minIndex = 0;
        for(int i = 0; i<bin.size();i++){
            if ((bin.get(i).capacity > item) && (bin.get(i).capacity < bin.get(minIndex).capacity)){
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static int bfit(ArrayList<Float> box){
        ArrayList<Bin> bin = new ArrayList<Bin>();
        bin.add(new Bin());
        for (Float boxitem : box) {
            // find the best fit bin
            int minCap = findBest(boxitem, bin);
            // if not found, open a new bin and pack it
            if (minCap == 0){
                Bin nbin = new Bin();
                nbin.addBoxes(boxitem);
                bin.add(nbin);
            }
            //pack the box in the best fit bin
            else {
                bin.get(minCap).addBoxes(boxitem);

            }

        }
        return bin.size();
    }
    public static int bfitp(ArrayList<Float> box){
        //improved BF with technique of pruning
        ArrayList<Bin> bin = new ArrayList<Bin>();
        bin.add(new Bin());
        int i = 1;
        for (Float boxitem : box) {
            // find the best fit bin
            int minCap = findBest(boxitem, bin);
            // if not found, open a new bin and pack it
            if (minCap == 0){
                Bin nbin = new Bin();
                i++;
                nbin.addBoxes(boxitem);
                bin.add(nbin);
            }
            //pack the box in the best fit bin
            else {
                bin.get(minCap).addBoxes(boxitem);
                // improve: prune the bins whose capacity is too small
                if (bin.get(minCap).capacity < 0.1){
                    bin.remove(minCap);
                }

            }

        }
        return i;
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
        System.out.println(BestFit.bfit(boxes));
        long endTime = System.currentTimeMillis();
        System.out.println("Run time of BestFit is ：" + (endTime - startTime) + "ms");    //输出程序运行时间

    }
}
