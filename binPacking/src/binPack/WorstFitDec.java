package binPack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by srx on 2017/11/30.
 */
public class WorstFitDec {
    public static int wfitd(ArrayList<Float> box){
        Collections.sort(box, Collections.reverseOrder());
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
        System.out.println(WorstFitDec.wfitd(boxes));
        long endTime = System.currentTimeMillis();
        System.out.println("Run time of WorstFit is ：" + (endTime - startTime) + "ms");    //输出程序运行时间

    }
}
