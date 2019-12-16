package 牛客网;

import java.util.ArrayList;
import java.util.Arrays;
/*1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10*/
public class SolutionClockwise {
    public static void main(String[] args) {
        int[][] arrs = {{1, 2, 3, 4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        ArrayList<Integer> list = printMatrix(arrs);
        for(int i=0; i<list.size(); i++){
            System.out.print(list.get(i)+"\t");

        }
    }
        public static ArrayList<Integer> printMatrix(int [][] matrix) {
            int left=0,right=matrix[0].length-1,top=0,boom= matrix.length-1;//记录四个角的位置
            ArrayList<Integer> list = new ArrayList<Integer>();
//这里的就是说明了这个一个矩阵的表达形式.要是有一个相等一个数的时候,就是一个row 和column
            while((right>left)&&(boom>top)){
                for(int i=left;i<=right;i++){//从左到右
                    list.add(matrix[top][i]);
                }
                for(int i=top+1;i<=boom;i++){//上到下
                    list.add(matrix[i][right]);
                }
                for(int i = right-1;i>=left;i--){//右到左
                    list.add(matrix[boom][i]);
                }
                for(int i = boom-1;i>top;i--){//下到上
                    list.add(matrix[i][left]);
                }
                left++;
                right--;
                top++;
                boom--;
            }

            if((boom==top)&&(left<right)){//单独剩下一行的情况
                for(int i=left;i<=right;i++){
                    list.add(matrix[top][i]);
                }
            }
            if((left==right)&&(boom>top)){//单独剩下一列的情况
                for(int i =top;i<= boom;i++){
                    list.add(matrix[i][left]);
                }
            }
            if((boom==top)&&(right==left)){//单独剩下一个元素的情况
                list.add(matrix[left][boom]);
            }
            return list;
        }

}
