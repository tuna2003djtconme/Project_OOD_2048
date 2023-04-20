package Model;

import java.util.Random;

public class model {
	private int score;
	private int[][] matrix;
	private int size;

	public model(int size) {
		this.score = 0;
		this.matrix = new int[size][size];
		this.size = matrix.length;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void taoO () {
		Random r = new Random();
		int x = r.nextInt(getSize());
		int y = r.nextInt(getSize());
		while(getMatrix()[x][y] != 0) {
			 x = r.nextInt(getSize());
			 y = r.nextInt(getSize());
		}	
		int value = 0;
		if (r.nextInt()>4) {
			value = 4;
		}else {
			value = 2;
		}
		getMatrix()[x][y] = value;
	}
	public void moveLeft() {
		for (int i = 0; i < getSize(); i++) {
			for (int j = 0; j < getSize(); j++) {
				if (getMatrix()[i][j] != 0) {
					// j giảm dần
					donO(i, j, 0, -1);
				}
			}
		}
		for (int i = 0; i < getSize(); i++) {
			for (int j = 0; j < getSize(); j++) {
				if (getMatrix()[i][j] != 0) {
					// j giảm dần
					GopO(i, j, 0, 1);
				}
			}
		}
		for (int i = 0; i < getSize(); i++) {
			for (int j = 0; j < getSize(); j++) {
				if (getMatrix()[i][j] != 0) {
					// j giảm dần
					donO(i, j, 0, -1);
				}
			}
		}
		taoO();
	}

	public void moveRight() {
		for (int i = 0; i < getSize(); i++) {
			for (int j = getSize() - 1; j > -1; j--) {
				if (getMatrix()[i][j] != 0) {
					// j giảm dần
					donO(i, j, 0, 1);
				}
			}
		}
		for (int i = 0; i < getSize(); i++) {
			for (int j = 0; j < getSize(); j++) {
				if (getMatrix()[i][j] != 0) {
					// j giảm dần
					GopO(i, j, 0, 1);
				}
			}
		}
		for (int i = 0; i < getSize(); i++) {
			for (int j = getSize() - 1; j > -1; j--) {
				if (getMatrix()[i][j] != 0) {
					// j giảm dần
					donO(i, j, 0, 1);
				}
			}
		}
		taoO();
	}

	public void moveTop() {
		for (int j = 0; j < getSize(); j++) {
			for (int i = getSize() - 1; i > -1; i--) {
				if (getMatrix()[i][j] != 0) {
					// j giảm dần
					donO(i, j, -1, 0);
				}
			}
		}
		for (int i = 0; i < getSize(); i++) {
			for (int j = 0; j < getSize(); j++) {
				if (getMatrix()[i][j] != 0) {
					// j giảm dần
					GopO(i, j, 1, 0);
				}
			}
		}
		for (int j = 0; j < getSize(); j++) {
			for (int i = getSize() - 1; i > -1; i--) {
				if (getMatrix()[i][j] != 0) {
					// j giảm dần
					donO(i, j, -1, 0);
				}
			}
		}
		taoO();
	}

	public void moveBot() {
		for (int j = 0; j < getSize(); j++) {
			for (int i = getSize() - 1; i > -1; i--) {
				if (getMatrix()[i][j] != 0) {
					// j giảm dần
					donO(i, j, 1, 0);
				}
			}
		}
		for (int i = 0; i < getSize(); i++) {
			for (int j = 0; j < getSize(); j++) {
				if (getMatrix()[i][j] != 0) {
					// j giảm dần
					GopO(i, j, 1, 0);
				}
			}
		}
		for (int j = 0; j < getSize(); j++) {
			for (int i = getSize() - 1; i > -1; i--) {
				if (getMatrix()[i][j] != 0) {
					// j giảm dần
					donO(i, j, 1, 0);
				}
			}
		}
		taoO();
	}

	// it là i tăng
	// jt là j tăng
	public void donO(int i, int j, int it, int jt) {
		if (i == 0 && it == -1) {
			return;
		}
		if (i == 3 && it == 1) {
			return;
		}
		if (j == 0 && jt == -1) {
			return;
		}
		if (j == 3 && jt == 1) {
			return;
		}
		// tọa độ sau khi move
		int x = i + it;
		int y = j + jt;

		if (getMatrix()[x][y] != 0) {
			return;
		}
		// k là giá trị tại i j ( tọa độ ban đầu)
		int k = getMatrix()[i][j];
		// vị trí move đc gán bằng giá trị k
		;
		this.getMatrix()[x][y] = k;
		// vị trí ban đầu đc gán bằng giá trị 0
		this.getMatrix()[i][j] = 0;
		donO(x, y, it, jt);
	}

	public void printMatrix() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(getMatrix()[i][j] + " ");
			}
			System.out.println();
		}
	}
public void GopO(int i, int j, int it, int jt) {
	if (i == 0 && it == -1) {
		return;
	}
	if (i == getSize()-1 && it == 1) {
		return;
	}
	if (j == 0 && jt == -1) {
		return;
	}
	if (j == getSize()-1 && jt == 1) {
		return;
	}
	// tọa độ sau khi move
	int x = i + it;
	int y = j + jt;

	// so sánh giá trị ô ban dâu và ô index+1
	if (getMatrix()[x][y] != getMatrix()[i][j]) {
		return;
	}
	// k là giá trị tại i j ( tọa độ ban đầu)
	int k = getMatrix()[i][j]*2;
	// vị trí move đc gán bằng giá trị k
	;
	this.getMatrix()[x][y] = k;
	// vị trí ban đầu đc gán bằng giá trị 0
	this.getMatrix()[i][j] = 0;
}
	public static void main(String[] args) {
		model m = new model(4);
		m.getMatrix()[0][0] = 2;
		m.getMatrix()[0][2] = 4;
		m.getMatrix()[2][3] = 2;
		m.getMatrix()[2][2] = 2;
		m.getMatrix()[0][3] =2;
		m.printMatrix();
//		m.moveLeft();
//		System.out.println("left");
//		m.printMatrix();
//		
//		System.out.println("right");
//		m.moveRight();
//		m.printMatrix();	
//		System.out.println("top");
//		m.moveTop();
//		m.printMatrix();
		System.out.println("bot");
		m.moveBot();
		m.printMatrix();
	}

}
