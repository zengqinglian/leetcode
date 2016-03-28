package reconstructItinerary;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        List<String> result = new ArrayList<>();
        if(tickets==null || tickets.length ==0){
        	return result;
        }
        
        if(tickets.length==1){
        	result.add(tickets[0][0]);
        	result.add(tickets[0][1]);
        	return result;
        }
        
        List<List<String>> allResult = new ArrayList<>();
        
        for(String[] ticket : tickets){
        	if(ticket[0].equals("JFK")){
        		List<String> temp = new ArrayList<>();
        		temp.add(ticket[0]);
        		temp.add(ticket[1]);
        		String[][] newTickets = getNewTickets(tickets, ticket);    		
        		String target = ticket[1];
        		getAllRoutes(newTickets, allResult,temp,target);
        		
        	}
        }
        
        return allResult.get(0);
    }
    
    private void getAllRoutes(String[][] tickets, List<List<String>> allResult,List<String> temp, String target ){
    	if(tickets==null || tickets.length==0){
    		return;
    	}
    	if(tickets.length==1){
    		if(target.equals(tickets[0][0])){
    			temp.add(tickets[0][1]);
    			allResult.add(temp);
    		}
    		return;
    	}
    	for(String[] ticket : tickets){
    		if(ticket[0].equals(target)){
    			List<String> newTemp = new ArrayList<>();
    			newTemp.addAll(temp);
    			newTemp.add(ticket[1]);
    			String newTarget = ticket[1];
    			String[][] newTickets = getNewTickets(tickets, ticket);    			
    			getAllRoutes(newTickets, allResult,newTemp,newTarget);
    		}
    	}
    }
    
    private String[][] getNewTickets(String[][] tickets, String[] target){
    	int length = tickets.length;
    	String[][] newTickets = new String[length-1][2];
    	int index = 0;
    	for(String[] ticket : tickets){
    		if(ticket.equals(target)){
    			continue;
    		}else{
    			newTickets[index] =  ticket;
    			index++;
    		}
    	}
    	return newTickets;
    }
    
    public static void main(String[] args) {
		Solution s = new Solution();
		String[][] tickets ={{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
		//[[JFK, SFO, ATL, JFK, ATL, SFO], [JFK, ATL, JFK, SFO, ATL, SFO], [JFK, ATL, SFO, ATL, JFK, SFO]]
		s.findItinerary(tickets);
	}
}
