package rk.org.matrix;

public class MazeCell {
	Point pt;
	int dist;
	MazeCell(){}
	MazeCell(Point p,int dist){
		this.pt = new Point(p.x,p.y);
		this.dist = dist;
	}

}
