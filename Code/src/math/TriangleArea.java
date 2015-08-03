package math;

public class TriangleArea {
	public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H){
		int area1 = Math.abs(A - C) * Math.abs(B - D);
		int area2 = Math.abs(E - G) * Math.abs(F - H);
		
		if(C <= E || G <= A)
			return area1 + area2;
		
		if(F >= D || H <= B){
			return area1 + area2;
		}
		
		int crossX = Math.abs(Math.min(C, G) - Math.max(A,  E));
		int crossY = Math.abs(Math.min(D,  H) - Math.max(B,  F));
		
		return (area1 + area2) - (crossX * crossY);
	}
}
