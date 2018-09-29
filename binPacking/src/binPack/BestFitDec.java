package binPack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by srx on 2017/11/30.
 */
public class BestFitDec {
    public static int findBest(Float item, ArrayList<Bin> bin){
        int minIndex = 0;
        for(int i = 0; i<bin.size();i++){
            if ((bin.get(i).capacity > item) && (bin.get(i).capacity < bin.get(minIndex).capacity)){
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static int bfitd(ArrayList<Float> box){
        ArrayList<Bin> bin = new ArrayList<Bin>();
        bin.add(new Bin());
        Collections.sort(box, Collections.reverseOrder());
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
        System.out.println(BestFitDec.bfitd(boxes));
        long endTime = System.currentTimeMillis();
        System.out.println("Run time of BestFit is ：" + (endTime - startTime) + "ms");    //输出程序运行时间

    }
}
