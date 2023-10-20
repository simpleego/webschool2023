public class Array2D {
    public static void main(String[] args) {
        // 2차원 배열 초기화

        int [][] num = new int[3][3];
        int [][] ages = {
                {20,23,25},
                {34,37,39,38},
                {43,44,45,50,60}
        };

        for (int i = 0; i < ages.length; i++) {
            for (int j = 0; j < ages[i].length; j++) {
                System.out.print(", "+ages[i][j]);
            }
            System.out.println();
        }

    }
}
