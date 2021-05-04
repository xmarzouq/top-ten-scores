public class Scoreboard {
	private SinglyLinkedList<GameEntry> boardList;
	public Scoreboard(SinglyLinkedList<GameEntry> s) {
		boardList = s;
	}
	public void add(GameEntry e) {
		if(boardList.size() == 10)
			boardList.removeFirst();
		boardList.addFirst(e);
		sortList();
	}	
	public GameEntry remove(int i) {
		GameEntry removed = boardList.remove(i);
		sortList();
		return removed;
	}
	public void sortList() {  
        //Node current will point to head  
        Node<GameEntry> current = boardList.getHead(), index = null;  
        GameEntry temp;
          
        if(boardList.getHead() == null) {  
            return;  
        }  
        else {  
            while(current != null) {  
                //Node index will point to node next to current  
                index = current.getNext();
                  
                while(index != null) {  
                    //If current node's data is greater than index's node data, swap the data between them  
                    if(current.getData().getScore() > index.getData().getScore()) {  
                        temp = current.getData();  
                        current.setData(index.getData()); 
                        index.setData(temp); 
                    }  
                    index = index.getNext();  
                }  
                current = current.getNext();  
            }      
        }  
    }
}

