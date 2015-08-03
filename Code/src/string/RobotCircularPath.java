package string;

public class RobotCircularPath {
	public static boolean isCircular(String path) {
		int orinX = 0, orinY = 0;
		char direction = 'E';
		for (int i = 0; i < path.length(); i++) {
			char c = path.charAt(i);
			switch(direction){
			case 'N':
				if(c == 'G'){
					orinY += 1;
					continue;
				}
				direction = (c == 'L')? 'E' : 'W';
				break;
				
			case 'S':
				if(c == 'G'){
					orinY -= 1;
					continue;
				}
				direction = (c == 'L')? 'W' : 'E';
				break;
				
			case 'E':
				if(c == 'G'){
					orinX -= 1;
					continue;
				}
				direction = (c == 'L')? 'S' : 'N';
				break;
				
			case 'W':
				if(c == 'G'){
					orinX += 1;
					continue;
				}
				direction = (c == 'L')? 'N' : 'S';
				break;
			default:
				break;
			}
		}
		
		return (orinX == 0 && orinY == 0);
	}
	
	public static void main(String[] args){
		String path = "GLGLGLG";
		System.out.println(isCircular(path));
	}
}
