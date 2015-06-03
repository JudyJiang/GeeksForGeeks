import java.util.*;

public class CourseScheduleII {
	public static int[] findOrder(int numCourses, int[][] prerequisites) {
		// if (prerequisites == null) {
		// throw new IllegalArgumentException("illegal prerequisites array");
		// }
		//
		// int len = prerequisites.length;
		//
		// if (numCourses == 0 || len == 0) {
		// return null;
		// }
		//
		// // counter for number of prerequisites
		// int[] pCounter = new int[numCourses];
		// for (int i = 0; i < len; i++) {
		// pCounter[prerequisites[i][0]]++;
		// }
		//
		// // store courses that have no prerequisites
		// LinkedList<Integer> queue = new LinkedList<Integer>();
		// for (int i = 0; i < numCourses; i++) {
		// if (pCounter[i] == 0) {
		// queue.add(i);
		// }
		// }
		//
		// // number of courses that have no prerequisites
		// int numNoPre = queue.size();
		//
		// while (!queue.isEmpty()) {
		// int top = queue.remove();
		// for (int i = 0; i < len; i++) {
		// // if a course's prerequisite can be satisfied by a course in
		// // queue
		// if (prerequisites[i][1] == top) {
		// pCounter[prerequisites[i][0]]--;
		// if (pCounter[prerequisites[i][0]] == 0) {
		// numNoPre++;
		// queue.add(prerequisites[i][0]);
		// }
		// }
		// }
		// }
		// System.out.println(numNoPre == numCourses);
		// return null;
		int len = prerequisites.length;
		int[] pCourses = new int[numCourses];
		for (int i = 0; i < len; i++) {
			pCourses[prerequisites[i][0]]++;
		}

		LinkedList<Integer> courses = new LinkedList<Integer>();
		for (int i = 0; i < numCourses; i++) {
			if (pCourses[i] == 0) {
				courses.add(i);
			}
		}

		int[] sequence = new int[numCourses];
		int index = 0, num = courses.size();
		while (!courses.isEmpty()) {
			int top = courses.remove();
			sequence[index++] = top;
			for (int i = 0; i < len; i++) {
				if (prerequisites[i][1] == top) {
					pCourses[prerequisites[i][0]]--;
					if (pCourses[prerequisites[i][0]] == 0) {
						num++;
						courses.add(prerequisites[i][0]);
					}
				}
			}
		}
		//System.out.println(num);
		if (num != numCourses)
			return new int[0];//What the fuck.. can't return null, can't return new int[numCourses]
		//but only to return this! WHY! But anyway it got accepted.
		return sequence;
	}

	public static void main(String[] args) {
		int[][] pres = {{0, 1}, {1, 0}};//{ { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };

		int[] res = findOrder(2, pres);
		if(res == null)
			System.out.println("No solution");
	}
}
