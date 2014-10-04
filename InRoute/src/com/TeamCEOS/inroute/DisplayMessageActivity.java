package com.TeamCEOS.inroute;

import java.util.ArrayList;
import java.util.LinkedList;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class DisplayMessageActivity extends Activity {
	public ArrayList<Vertex> rooms;
	public ArrayList<Edge> edges;
	public final static String EXTRA_MESSAGE_1 = "com.example.myfirstapp.MESSAGE1";
	public final static String EXTRA_MESSAGE_2 = "com.example.myfirstapp.MESSAGE2";
	public String startRoom;
	public String endRoom;
	TextView directions;
	Vertex source;
    Vertex destination;
	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		boolean found_start = false, found_end = false;
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_message);
		rooms = new ArrayList<Vertex>();
		edges = new ArrayList<Edge>();
		
		rooms.add(new Vertex("Main_Entrance", "Main Entrance"));		//0
		rooms.add(new Vertex("North_Entrance", "North Entrance"));		//1
		rooms.add(new Vertex("South_Entrance", "South Entrance"));		//2
		rooms.add(new Vertex("int_1_1", "Main Lobby"));					//3
		rooms.add(new Vertex("bathrooms_1", "Bathrooms Floor 1"));		//4
		rooms.add(new Vertex("stairs_1_1", "North Staircase Floor 1"));	//5
		rooms.add(new Vertex("stairs_1_2", "South Staircase Floor 1"));	//6
		rooms.add(new Vertex("elevator_1","Elevator Floor 1"));			//7
		rooms.add(new Vertex("Room_1115","Room 1115"));					//8
		rooms.add(new Vertex("Room_1121","Room 1121"));					//9
		rooms.add(new Vertex("Room_1122","Room 1122"));					//10
		rooms.add(new Vertex("bathrooms_2","Bathrooms Floor 2"));		//11
		rooms.add(new Vertex("int_2_1", "Intersection 2_1"));			//12
		rooms.add(new Vertex("int_2_2", "Intersection 2_2"));			//13
		rooms.add(new Vertex("int_2_3", "Intersection 2_3"));			//14
		rooms.add(new Vertex("elevator_2", "Elevator Floor 2"));		//15
		rooms.add(new Vertex("stairs_2_1", "North Staircase Floor 2"));	//16
		rooms.add(new Vertex("stairs_2_2", "South Staircase Floor 2"));	//17
		rooms.add(new Vertex("Room_2107","Room 2107"));					//18
		rooms.add(new Vertex("Room_2117","Room 2117"));					//19
		rooms.add(new Vertex("Room_2118","Room 2118"));					//20
		rooms.add(new Vertex("Room_2120","Room 2120"));					//21
		rooms.add(new Vertex("bathrooms_3","Bathrooms Floor 3"));		//22
		rooms.add(new Vertex("int_3_1", "Intersection 3_1"));			//23
		rooms.add(new Vertex("int_3_2", "Bridge to AVW"));				//24
		rooms.add(new Vertex("int_3_3", "Intersection 3_3"));			//25
		rooms.add(new Vertex("elevator_3", "Elevator Floor 3"));		//26
		rooms.add(new Vertex("stairs_3_1", "North Staircase Floor 3"));	//27
		rooms.add(new Vertex("stairs_3_2", "South Staircase Floor 3"));	//28
		rooms.add(new Vertex("Room_3107","Room 3107"));					//29
		rooms.add(new Vertex("Room_3117","Room 3117"));					//30
		rooms.add(new Vertex("Room_3118","Room 3118"));					//31
		rooms.add(new Vertex("Room_3120","Room 3120"));					//32
	
		edges.add(new Edge("Edge1", rooms.get(0), rooms.get(4), 2, 0));
		edges.add(new Edge("Edge2", rooms.get(0), rooms.get(3), 3, 90));
		edges.add(new Edge("Edge3", rooms.get(3), rooms.get(5), 3, 0));
		edges.add(new Edge("Edge4", rooms.get(3), rooms.get(7), 1, 90));
		edges.add(new Edge("Edge5", rooms.get(3), rooms.get(8), 3, 90));
		edges.add(new Edge("Edge6", rooms.get(3), rooms.get(9), 2, 180));
		edges.add(new Edge("Edge7", rooms.get(9), rooms.get(10), 2, 180));
		edges.add(new Edge("Edge8", rooms.get(10), rooms.get(2), 3, 180));
		edges.add(new Edge("Edge9", rooms.get(2), rooms.get(6), 4, 90));
		edges.add(new Edge("Edge10", rooms.get(7), rooms.get(1), 3, 0));
		edges.add(new Edge("Edge11", rooms.get(5), rooms.get(16), 3, 361)); //Floor 2
		edges.add(new Edge("Edge12", rooms.get(12), rooms.get(16), 1, 270));
		edges.add(new Edge("Edge13", rooms.get(12), rooms.get(13), 2, 0));
		edges.add(new Edge("Edge14", rooms.get(12), rooms.get(15), 1, 180));
		edges.add(new Edge("Edge15", rooms.get(13), rooms.get(18), 1, 90));
		edges.add(new Edge("Edge16", rooms.get(15), rooms.get(14), 3, 270));
		edges.add(new Edge("Edge17", rooms.get(15), rooms.get(19), 1, 180));
		edges.add(new Edge("Edge18", rooms.get(14), rooms.get(11), 2, 0));
		edges.add(new Edge("Edge19", rooms.get(19), rooms.get(20), 2, 180));
		edges.add(new Edge("Edge20", rooms.get(20), rooms.get(21), 3, 180));
		edges.add(new Edge("Edge21", rooms.get(21), rooms.get(17), 3, 90));
		edges.add(new Edge("Edge22", rooms.get(6), rooms.get(17), 3, 361));
		edges.add(new Edge("Edge23", rooms.get(7), rooms.get(15), 3, 361));
		edges.add(new Edge("Edge24", rooms.get(16), rooms.get(27), 3, 361)); //Floor 3
		edges.add(new Edge("Edge25", rooms.get(23), rooms.get(27), 1, 270));
		edges.add(new Edge("Edge26", rooms.get(23), rooms.get(24), 2, 0));
		edges.add(new Edge("Edge27", rooms.get(23), rooms.get(26), 1, 180));
		edges.add(new Edge("Edge28", rooms.get(24), rooms.get(29), 1, 90));
		edges.add(new Edge("Edge29", rooms.get(26), rooms.get(25), 3, 270));
		edges.add(new Edge("Edge30", rooms.get(26), rooms.get(30), 1, 180));
		edges.add(new Edge("Edge31", rooms.get(25), rooms.get(22), 2, 0));
		edges.add(new Edge("Edge32", rooms.get(30), rooms.get(31), 2, 180));
		edges.add(new Edge("Edge33", rooms.get(31), rooms.get(32), 3, 180));
		edges.add(new Edge("Edge34", rooms.get(32), rooms.get(28), 3, 90));
		edges.add(new Edge("Edge35", rooms.get(17), rooms.get(28), 3, 361));
		edges.add(new Edge("Edge36", rooms.get(15), rooms.get(26), 3, 361));
		
		//reversed directions
		edges.add(new Edge("Edge1", rooms.get(4), rooms.get(0), 2, 180));
		edges.add(new Edge("Edge2", rooms.get(3), rooms.get(0), 3, 270));
		edges.add(new Edge("Edge3", rooms.get(5), rooms.get(3), 3, 180));
		edges.add(new Edge("Edge3", rooms.get(7), rooms.get(3), 1, 270));
		edges.add(new Edge("Edge3", rooms.get(8), rooms.get(3), 3, 270));
		edges.add(new Edge("Edge3", rooms.get(9), rooms.get(3), 2, 0));
		edges.add(new Edge("Edge3", rooms.get(10), rooms.get(9), 2, 0));
		edges.add(new Edge("Edge3", rooms.get(2), rooms.get(10), 3, 0));
		edges.add(new Edge("Edge3", rooms.get(6), rooms.get(2), 4, 270));
		edges.add(new Edge("Edge3", rooms.get(1), rooms.get(7), 3, 180));
		edges.add(new Edge("Edge11", rooms.get(16), rooms.get(5), 3, 361)); //Floor 2
		edges.add(new Edge("Edge11", rooms.get(16), rooms.get(12), 1, 90));
		edges.add(new Edge("Edge11", rooms.get(13), rooms.get(12), 2, 180));
		edges.add(new Edge("Edge11", rooms.get(15), rooms.get(12), 1, 0));
		edges.add(new Edge("Edge11", rooms.get(18), rooms.get(13), 1, 270));
		edges.add(new Edge("Edge11", rooms.get(14), rooms.get(15), 3, 90));
		edges.add(new Edge("Edge11", rooms.get(19), rooms.get(15), 1, 0));
		edges.add(new Edge("Edge11", rooms.get(11), rooms.get(14), 2, 180));
		edges.add(new Edge("Edge11", rooms.get(20), rooms.get(19), 2, 0));
		edges.add(new Edge("Edge11", rooms.get(21), rooms.get(20), 3, 0));
		edges.add(new Edge("Edge11", rooms.get(17), rooms.get(21), 3, 270));
		edges.add(new Edge("Edge11", rooms.get(17), rooms.get(6), 3, 361));
		edges.add(new Edge("Edge11", rooms.get(15), rooms.get(7), 3, 361));
		edges.add(new Edge("Edge11", rooms.get(27), rooms.get(16), 3, 361)); //Floor 3
		edges.add(new Edge("Edge11", rooms.get(27), rooms.get(23), 1, 90));
		edges.add(new Edge("Edge11", rooms.get(24), rooms.get(23), 2, 180));
		edges.add(new Edge("Edge11", rooms.get(26), rooms.get(23), 1, 0));
		edges.add(new Edge("Edge11", rooms.get(29), rooms.get(24), 1, 270));
		edges.add(new Edge("Edge11", rooms.get(25), rooms.get(26), 3, 90));
		edges.add(new Edge("Edge11", rooms.get(30), rooms.get(26), 1, 0));
		edges.add(new Edge("Edge11", rooms.get(22), rooms.get(25), 2, 180));
		edges.add(new Edge("Edge11", rooms.get(31), rooms.get(30), 2, 0));
		edges.add(new Edge("Edge11", rooms.get(32), rooms.get(31), 3, 0));
		edges.add(new Edge("Edge11", rooms.get(28), rooms.get(32), 3, 270));
		edges.add(new Edge("Edge11", rooms.get(28), rooms.get(17), 3, 361));
		edges.add(new Edge("Edge11", rooms.get(26), rooms.get(15), 3, 361));
		
		RadioButton rb = (RadioButton) findViewById(R.id.button_shortest_distance);
        rb.setChecked(true);
        RadioGroup rg = (RadioGroup) findViewById(R.id.preferences_group);
        rg.setPadding(0, 0, 5, 0);
		
		// Get the message from the intent
	    Intent intent = getIntent();
	    startRoom = intent.getStringExtra(MainActivity.EXTRA_MESSAGE_1);
	    endRoom = intent.getStringExtra(MainActivity.EXTRA_MESSAGE_2); 
	    source = null;
	    destination = null;
	    
	    // Create the text view
	    directions = (TextView) findViewById(R.id.directions_text);
	    directions.setPadding(10, 0, 0, 0);
	    
	    for (Vertex r: rooms) {
	    	String s = r.getName();
	    	if (s.equalsIgnoreCase(startRoom)) {
	    		found_start = true;
	    		source = r;
	    	}
	    	if (s.equalsIgnoreCase(endRoom)) {
	    		found_end = true;
	    		destination = r;
	    	}
	    }
	    if (found_start && found_end) {
	    	findPath(edges);
	    } else { 
	    	if (!found_start && !found_end)
	    		directions.setText("Start and End Rooms are invalid!");
	    	else if (!found_start)
	    		directions.setText("Start Room is invalid!");
	    	else if (!found_end)
	    		directions.setText("End Room is invalid!");
	    }

	    // Set the text view as the activity layout
	    //setContentView(textView);
	}

	public void findPath(ArrayList<Edge> l) {
		String result = "";
    	Graph graph = new Graph(rooms, l);
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
        dijkstra.execute(rooms.get(rooms.indexOf(source)));
        LinkedList<Vertex> path = dijkstra.getPath(rooms.get(rooms.indexOf(destination)));

        int stepCounter = 1, listCounter = 0;

        for (Vertex vertex : path) {
        	if(listCounter == 0)
        		result = result+ stepCounter + ". Start from " + vertex + "\n";
        	else if(listCounter == path.size()-1) {
        		result = result+ stepCounter + ". Arrived at " + vertex + "\n";
        	}
        	else {
        		Vertex prev = path.get(listCounter-1);
        		Vertex next = path.get(listCounter+1);
        		Edge prevE = null, nextE = null;
        		int prevD = 0;
        		int nextD = 0;
        		int tempNextDir = 0;
        		
        		for (Edge e: edges) {
        			if(e.getSource().equals(prev) && e.getDestination().equals(vertex)) {
        				prevE = e;
        				prevD = e.getDirection();
        			}
        			if(e.getSource().equals(vertex) && e.getDestination().equals(next)) {
        				nextE = e;
        				nextD = e.getDirection();
        				tempNextDir = nextD;
        			}
        		}
        		if(prevD == 361){
        			if(prevE.getDestination().getId().matches("elevator.*"))
        				tempNextDir = 270;
        			else if(prevE.getDestination().getId().matches("stairs_\f_1"))
        				tempNextDir = 90;
        			else
        				tempNextDir = 270;
        		}
        		
        		if(prevD == tempNextDir && tempNextDir != 361)
        			result = result+ stepCounter + ". Continue straight past " + vertex + "\n";
        		else if (nextD == 361) {
        			if(vertex.getId().matches("stairs.*"))
        				result = result+ stepCounter + ". Take stairs up from " + vertex + "\n";
        			else
        				result = result+ stepCounter + ". Take elevator up from " + vertex + "\n";
        		} 
        		else if(prevD == tempNextDir + 90 || prevD == (tempNextDir + 90) - 360 ||
        				prevD == tempNextDir + 90 + 1 || prevD == (tempNextDir + 90 + 1) + 360)
        			result = result+ stepCounter + ". Turn left at " + vertex + "\n";
        		else if(prevD == tempNextDir - 90 || prevD == (tempNextDir - 90) + 360 ||
        				prevD == tempNextDir - 90 + 1 || prevD == (tempNextDir - 90 + 1) - 360)
        			result = result+ stepCounter + ". Turn right at " + vertex + "\n";
        		else
        			result = result+ stepCounter + ". " + vertex + "\n";
        	}
        	stepCounter++;
        	listCounter++;
        }
        directions.setText(result);
        Button b = (Button) findViewById(R.id.map_button);
        b.setVisibility(0);

	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_message, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void showMap(View view) {
		Intent intent = new Intent(this, MainActivity.class);
		
		intent.putExtra(EXTRA_MESSAGE_1, startRoom);
    	intent.putExtra(EXTRA_MESSAGE_2, endRoom);
    	startActivity(intent);
	 }
	
	public void applyPreference(View view) {
		boolean checked = ((RadioButton) view).isChecked();
        ImageView v = (ImageView) this.findViewById(R.id.csic_map);
        //Drawable d;
        
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.button_shortest_distance:
                if (checked) {
                	findPath(edges);
                }
                break;
            case R.id.button_stairs_only:
                if (checked) {
                	ArrayList<Edge> newEdges = new ArrayList<Edge>();
                    for(Edge e: edges) {
                    	if(!(e.getSource().getId().matches("elevator.*") && 
                    			e.getDestination().getId().matches("elevator.*"))) {
                    		newEdges.add(e);
                    	}
                    }
                    findPath(newEdges);
                }
                break;
            case R.id.button_elevator_only:
                if (checked) {
                	ArrayList<Edge> newEdges = new ArrayList<Edge>();
                    for(Edge e: edges) {
                    	if(!(e.getSource().getId().matches("stairs.*") && 
                    			e.getDestination().getId().matches("stairs.*"))) {
                    		newEdges.add(e);
                    	}
                    }
                    findPath(newEdges);
                }
                break;
        }
		
	}

}
