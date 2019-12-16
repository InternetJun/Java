package 牛客网;
/**在一个矩阵中寻找路径，需要有不可以回头的限制，还有只能上下左右的移动。
 * i+1,j
 * i-1,j
 * i,j+1
 * i,j-1
 * 回溯法：首先任意一个点都有可能成为起点，所以要获得任意一点的坐标(位于第几行，第几列)
 *  * 其次要有一个数组记录这个点是否被访问过，同时要有一个指针来记录字符串中字符的位置。
 *  * 当某个点成为合法的起点时，即这个点与字符串中第一个字符相等，则可以继续朝上下左右搜索下一个点；
 *  * 如果这个点不能成为合法的起点，则恢复现场(这个点没有被访问过且字符串指针后退)
 * @指针是对于坐标的移动问题.关键是怎么去实现的问题了.
 * 有对于坐标的只是关心的是左右，那另一个的坐标在说。
 *  * */
public class SearchInMatrix {

    public static void main(String[] args) {
        char[] matrix = {'a','b','c','e','s' ,'f','c', 's','a','d','e','e' };
        int rows = 3;
        int cols = 4;
        char[] str = {'b','c','c','e','d'};
        char[][] newMat = new char[rows][cols];
        //        boolean flag= hasPath(matrix,rows,cols,str);
    }

    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        //需要做的事情是第一个字母要相同的啊，不同怎么去处理呢？
        //matrix是一个数组，不是矩阵的数组。
        if(str.length<0 || rows<0 || cols<0 || matrix.length<0){
            return false;
        }

        boolean[] visited = new boolean[rows*cols];//用他来表示的是没有被访问过.还有的是要去实现的回溯法.
        int[] index = {0};
        for(int i = 0;i < rows;i ++) {/*这里的是实现了所有的数据可以进行遍历了。就实现逻辑的意思。*/
            for(int j = 0;j < cols;j ++) {
                if(isPath(matrix, rows, cols, i, j, str, visited, index)) {//有2个约束的条件,1个是所有的矩阵内的元素,2是智能在上下左右去搜索.
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isPath(char[] matrix, int rows, int cols, int row, int col, char[] str, boolean visited[], int[] index) {
//        并没有记录出所有的点坐标.还有的是,只需要的是
        if (index[0] == str.length) {//记录的是字符串的长度.
            return true;
        }
/**自己的问题是怎么去记录有的坐标的问题.*/
        boolean flag = false;
        //当前点折算到原数组的位置是：row * cols + col
        if (row >= 0 && row < rows && col >= 0 && col < cols
                && !visited[row * cols + col] && matrix[row * cols + col] == str[index[0]]) {
            index[0]++;    //指针右移,就是对数据的移动的实现.
            visited[row * cols + col] = true;

            //第一个点是合法的起点之后开始回溯:上下左右进行搜索
            flag = isPath(matrix, rows, cols, row - 1, col, str, visited, index) ||
                    isPath(matrix, rows, cols, row + 1, col, str, visited, index) ||
                    isPath(matrix, rows, cols, row, col - 1, str, visited, index) ||
                    isPath(matrix, rows, cols, row, col + 1, str, visited, index);
            if (!flag) {        //恢复现场
                index[0]--;
                visited[row * cols + col] = false;
            }
        }

        return flag;

    }
}
