package 牛客网;
/**1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.\
 *
 * {@思路是?  }
 * */
public class ClockWiseRotate {
   /* 1  2  3  4
     5  6  7  8        顺时针的输出数据,怎么去控制呢?自己定义好四个方向.
     9 10 11  12
     13 14 15 16*/
   public static void main(String[] args) {
        int[][] arrs = {{1, 2, 3, 4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        getAll(arrs);
   }

   public static void getAll(int[][] arrs){
       //什么的条件是终止的呢?
       int row = arrs.length;
       int column = arrs[0].length;
       while(row>=1&&column>=1){
            clockElement(arrs);
            row--;
            column--;
       }
   }

   public static void clockElement(int[][] arrs){
       int row = arrs.length;
       int column = arrs[0].length;
//       if(/**/)
       for(int i=0; i<row; i++){
           for (int j=0; j<column; j++){
               //在这里去定义好四个direction.
              if(i==0){
                  System.out.print(arrs[i][j]+"\t");
              }
               System.out.println();
              if(j==column-1){
                  System.out.println(arrs[i][j]+"\t");
              }
               System.out.println();
              if(i==row-1){
                  //需要的是对数据的逆向的输出,有的是说
                  System.out.println(arrs[i][column-1-j]+"\t");
              }
               System.out.println();
              if(j==0) {
                  System.out.println(arrs[row-1-i][j]+"\t");
             }
              //这些是相对于一个外围的实现,需要去递归他的实现.
           }


       }
   }
}
