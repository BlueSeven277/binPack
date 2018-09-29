package binPack;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by srx on 2017/11/29.
 */
public class NextFit {
    public static int nfit(ArrayList<Float> box) {
        ArrayList<Bin> bin = new ArrayList<Bin>();
        Bin nbin = new Bin();
        bin.add(nbin);
        int j = 0;
        for (int i = 0; i < box.size(); ) {
            // pack the box if fit
            if (box.get(i) < bin.get(j).capacity) {
                bin.get(j).addBoxes(box.get(i));
                i++;
                //box.remove(i);
            }
            // open a new bin to pack this box if it does not fit the existing bins
            else {
                j++;
                bin.add(new Bin());
            }

        }

        return bin.size();
    }

    public static void main(String[] args) {

        ArrayList<Float> boxes = new ArrayList<Float>();
        // Test case 3: initialize the size of the boxes by random numbers
        for (int i = 0; i < 100000; i++) {
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
        System.out.println(NextFit.nfit(boxes));
        long endTime = System.currentTimeMillis();
        System.out.println("Run time of NextFit is ：" + (endTime - startTime) + "ms");    //输出程序运行时间

    }
}
