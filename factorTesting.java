import java.util.*;
import java.text.*;
class factorTesting{

  public static void main(String[] args){

    int cofactor = 0;
    int coprime = 0;
    int trials = 1000000;
    NumberFormat formatter = new DecimalFormat("#0.000");
    for(int j = 0; j<trials; j++){
      boolean[] num1 = factorMaker();
      boolean[] num2 = factorMaker();
      boolean commonFactor = false;
      for(int i = 0; i < num1.length && i < num2.length; i++){
        if((num1[i]==true)&&(num2[i]==true)){
          commonFactor = true;
        }
      }
      if(commonFactor){
        cofactor++;
      } else {
        coprime++;
      }
    }
    System.out.println(formatter.format(Math.sqrt(6/((double)coprime/trials))));
  }

  public static boolean[] factorMaker(){
    boolean[] nums = new boolean[1000];
    Random rand = new Random();
    int toTest = rand.nextInt(1000)+1;
    int testWith = 2;
    while(toTest != 1){
      if(((double)toTest/testWith)==(Math.floor(toTest/testWith))){
        toTest = toTest/testWith;
        nums[testWith] = true;
        testWith = 1;
      }
      testWith++;
    }
    return nums;
  }

}
