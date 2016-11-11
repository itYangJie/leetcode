package com.ityang.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Subject133 {

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null)
			return null;
		
		UndirectedGraphNode res = new UndirectedGraphNode(node.label);
		
		if (node.neighbors.size() == 0)
			return res;
		
		Queue<UndirectedGraphNode> queue = new LinkedList<>();
		Map<Integer,UndirectedGraphNode> map = new HashMap<>();
		map.put(node.label,res);
		queue.offer(node);
		
		UndirectedGraphNode cur ;
		
		while(!queue.isEmpty()){
			
			UndirectedGraphNode temp = queue.poll();
			cur = map.get(temp.label);
			
			for(int i=0;i<temp.neighbors.size();i++){
				UndirectedGraphNode neighbor = temp.neighbors.get(i);
				UndirectedGraphNode newNode = map.get(neighbor.label);
				if(newNode==null){
					map.put(neighbor.label, newNode = new UndirectedGraphNode(neighbor.label));
					queue.offer(neighbor);
				}
				cur.neighbors.add(newNode);
			}
			
			
		}
		return res;
	}
}

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
};
