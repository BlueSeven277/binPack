package binPack;

import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;
/**
 * Created by srx on 2017/11/29.
 */
public class FirstFitDec {
    public static int ffitd(ArrayList<Float> box){
//        Comparator<Float> comp = Collections.reverseOrder();
        Collections.sort(box, Collections.reverseOrder());
        ArrayList<Bin> bin = new ArrayList<Bin>();
        for (Float boxitem : box) {
            boolean packed = false;
            for (Bin binitem: bin
                    ) {
                if (boxitem < binitem.getCapacity()){
                    binitem.addBoxes(boxitem);
                    packed = true;
                    break;
                }
            }
            if (packed == false){
                Bin nbin = new Bin();
                bin.add(nbin);
                nbin.addBoxes(boxitem);
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
        System.out.println(FirstFitDec.ffitd(boxes));
        long endTime = System.currentTimeMillis();
        System.out.println("Run time of FirstFit is ：" + (endTime - startTime) + "ms");    //输出程序运行时间

    }
}
