package reconstructItinerary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Solution1 {
	private int length;
	private HashMap<String, ArrayList<String>> ticketMap = new HashMap<String, ArrayList<String>>();

	public List<String> findItinerary(String[][] tickets) {

	    length = tickets.length + 1;

	    for (String[] trip : tickets)
	    {
	        if (ticketMap.containsKey(trip[0]))
	        {
	            ticketMap.get(trip[0]).add(trip[1]);
	        }
	        else
	        {
	            ArrayList<String> arr = new ArrayList<String>();
	            arr.add(trip[1]);
	            ticketMap.put(trip[0], arr);
	        }
	    }

	    for (ArrayList<String> value : ticketMap.values()) {
	        Collections.sort(value);
	    }

	    ArrayList<String> itinerary = new ArrayList<String>();
	    itinerary.add("JFK");

	    search("JFK", itinerary);

	    return itinerary;
	}

	public boolean search(String start, ArrayList<String> itinerary)
	{
	    if (itinerary.size() == length)
	        return true;
	    ArrayList<String> arr = ticketMap.get(start);
	    if (arr != null)
	    {//it's OK to continue
	        for (int i = 0; i < arr.size(); ++i)
	        {
	            String end = arr.get(i);
	            itinerary.add(end);
	            arr.remove(i);
	            if (search(end, itinerary) == false)
	            {
	                //undo the move
	                itinerary.remove(itinerary.size() - 1);
	                arr.add(i, end);
	            }
	            else
	            {
	                return true;
	            }
	        }
	        return false;
	    }
	    else
	    {
	        return false;
	    }
	}
public static void main(String[] args) {
	Solution1 s = new Solution1();
	String[][] tickets ={{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
	//[[JFK, SFO, ATL, JFK, ATL, SFO], [JFK, ATL, JFK, SFO, ATL, SFO], [JFK, ATL, SFO, ATL, JFK, SFO]]
	s.findItinerary(tickets);
}
}
