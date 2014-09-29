package linkedlist;

/**
 * You've got a lot design to learn!
 * @author fengjiaojiang
 *
 */
public class FlatMultipleLevelList {
	public static class LevelList{
		public LevelList next;
		public LevelList child;
		public int value;
		
		public LevelList(int v){
			this.value = v;
			this.next = this.child = null;
		}
		
		public void AddNext(int[] arr){
			for(int i = 0; i < arr.length; i++)
				this.AddNext(arr[i]);
		}
		
		public void AddChildren(int[] arr){
			for(int i = 0; i < arr.length; i++)
				this.AddChild(arr[i]);
		}
		
		public void AddNext(int value){
			LevelList p = this;
			while(p.next != null)
				p = p.next;
			p.next = AddNode(value);
		}
		
		public void AddChild(int value){
			LevelList p = this;
			while(p.child != null)
				p = p.child;
			this.child = AddNode(value);
		}
		
		public LevelList AddNode(int value){
			return new LevelList(value);
		}
	}
	
	public static LevelList ConstructList(){
		return null;
	}
	
	
	
	
	
	
	public static void main(String[] args){
		LevelList head = ConstructList();
	}
}
