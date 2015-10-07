

public class Plateau {
	
	private int[][] data;
	private double[][] ratio;
	private int[][] neight;
	private int width, height;
	
	public Plateau(int width, int height) {
		this.width = width;
		this.height = height;
		
		data = new int[width][];
		ratio = new double[width][];
		neight = new int[width][];
		for (int x = 0; x < width; x++) {
			data[x] = new int[height];
			ratio[x] = new double[height];
			neight[x] = new int[height];
			for (int y = 0; y < height; y++) {
				//data[x][y] = (x < width / 2 ? 0 : 1);
				//data[x][y] = (Math.random() > 0.5 ? 0 : 1);
				//data[x][y] = (Math.pow((x-50)*(x-50)+(y-50)*(y-50), 2) < 1000000 ? 0 : 1);
				data[x][y] = (((x < width / 2) && (y < height / 2)) || ((x > width / 2) && (y > height / 2)) ? 0 : 1);
				ratio[x][y] = 0.0;
				neight[x][y] = 8;
			}
		}
		
		for (int x = 0; x < width; x++) {
			neight[x][0] = 5;
			neight[x][height-1] = 5;
		}
		for (int y = 0; y < height; y++) {
			neight[0][y] = 5;
			neight[width-1][y] = 5;
		}
		
		neight[0][0] = 3;
		neight[width-1][0] = 3;
		neight[0][height-1] = 3;
		neight[width-1][height-1] = 3;
		
//		s = "";
//		for (int y = 0; y < height; y++) {
//			for (int x = 0; x < width; x++) {
//				s += neight[x][y] + " ";
//			}
//			s += "\n";
//		}
//		System.out.println(s);
	}
	
	public int get(int x, int y) {
		return data[x][y];
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void fight() {
		double help;
		
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				ratio[x][y] = 0;
				for (int i = -1; i <= 1; i++) {
					for (int j = -1; j <= 1; j++) {
						if ((i == 0 && j == 0) || (x+i < 0 || y+j < 0 || x+i >= width || y+j >= height)) {
							
						} else {
							ratio[x][y] += data[x+i][y+j];
						}
					}
				}
				ratio[x][y] /= (double) neight[x][y];
			}
		}
		
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				help = Math.random();
				data[x][y] = (ratio[x][y] > help ? 1 : 0); 
				//data[x][y] = (Math.random() < 0.5 ? 0 : 1);
			}
		}
	}
}
