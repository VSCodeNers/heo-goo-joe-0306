public class Yoon_pro11 {
        public int solution(int[][] sizes) {
            int max_width = 0;
            int max_height = 0;
            
            for (int i =0; i < sizes.length; i++) {
                if (sizes[i][0] < sizes[i][1]) {
                    int temp = sizes[i][0];
                    sizes[i][0] = sizes[i][1];
                    sizes[i][1] = temp;
                }
                
                max_width = Math.max(max_width, sizes[i][0]);
                max_height = Math.max(max_height, sizes[i][1]);
            }
            
            return max_width * max_height;
        }
    }
}
