public class Histo {
    static public int image[][]={
        {1,3,5,7,9,3,4,4,5,6},
        {1,20,25,24,3,5,6,4,2,4},
        {1,22,35,24,3,5,6,4,5,7},
        {1,20,28,34,2,5,6,4,8,9},
        {1,3,5,7,9,3,4,4,5,6},
        {1,3,5,7,9,3,67,4,5,6},
        {1,3,5,7,9,78,54,94 ,5 ,6},
        {1,3,5,7,9,99,98 ,54,5,6},
        {1,3,5,7,9,3,64,4,5,6},
        {1,3,5,7,9,3,4,4,5,6},
        };
    public static void main(String args[]) {
        int c1 = 0;
        int c2 = 0;
        int c3 = 0;
        for(int i = 0; i < 10; i++) {
            for (int j = 0; j <10; j++) {
                if(image[i][j] == 1)
                    c1++;
                if(image[i][j] == 3)
                    c2++;
                if(image[i][j] == 4)
                    c3++;
            }
        }
        System.out.println("1 :" + c1);
        System.out.println("2 :" + c2);
        System.out.println("3 :" + c3);
        }
}

