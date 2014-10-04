package com.TeamCEOS.inroute;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends Activity {
	/**TO DO: 
	* Fix elevator/stairs glitch- it ALWAYS goes left!
	* set map to android:drawable= true??????
	* Separate search bars & floor buttons into different ViewGroups
	* Visual display w/ lines, etc.
	* 		Button on directions screen to show map w/ directions
	* 		Store lines in separate list first
	* 		When floor is selected (by RadioButton), display appropriate lines
	* Nearest bathroom option
	* 		Search through list of paths to all rooms, find all that are to bathrooms
	* 		Find minimum path length to a bathroom, display
	* Re-sizable maps
	*/
	public final static String EXTRA_MESSAGE_1 = "com.example.myfirstapp.MESSAGE1";
	public final static String EXTRA_MESSAGE_2 = "com.example.myfirstapp.MESSAGE2";
	public String startRoom, endRoom;
	public final static String[] rooms = {"Room 111","Room 123"};
	Paint paint = new Paint();
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        paint.setColor(Color.BLACK);
        paint.setTextSize(30);
        
        RadioButton r = (RadioButton) findViewById(R.id.button_floor_1);
        r.setChecked(true);
        RadioGroup rb = (RadioGroup) findViewById(R.id.floors_radio_group);
        rb.setPadding(0, 0, 5, 0);
        
        Intent intent = getIntent();
	    startRoom = intent.getStringExtra(MainActivity.EXTRA_MESSAGE_1);
	    endRoom = intent.getStringExtra(MainActivity.EXTRA_MESSAGE_2);
	    EditText editText1 = (EditText) findViewById(R.id.search_start_room);
	    EditText editText2 = (EditText) findViewById(R.id.search_end_room);
	    /*
	    if(startRoom != null && endRoom != null){
	    	String[] words1 = startRoom.split(" ");
	    	String[] words2 = endRoom.split(" ");
	    	String newStart = "", newEnd = "";
	    	for(int i = 0; i < words1.length; i++) {
	    		String s = words1[i];
	    		String newString = s;
	    		char newStartChar = newString.charAt(0);
	    		if(newStartChar >= 'a' && newStartChar <= 'z') {
	    			newStartChar = (char)(newStartChar -('a'-'A'));
	    			newString.replaceAll("[a-z]", "" + newStartChar);
	    		}
	    		if(i == words1.length - 1)
	    			newStart = newStart + newString;
	    		else
	    			newStart = newStart + newString + " ";

	    	}
	    	for(int i = 0; i < words2.length; i++) {
	    		String s = words2[i];
	    		String newString = s;
	    		char newStartChar = newString.charAt(0);
	    		if(newStartChar >= 'a' && newStartChar <= 'z') {
	    			newStartChar = (char)(newStartChar -('a'-'A'));
	    			newString.replaceFirst("[a-z]", "" + newStartChar);
	    		}
	    		if(i == words2.length - 1)
	    			newEnd = newEnd + newString;
	    		else
	    			newEnd = newEnd + newString + " ";

	    	}
	    	

	    	editText1.setText(newStart);
	    	editText2.setText(newEnd);
	    }
	    */
	    editText1.setText(startRoom);
    	editText2.setText(endRoom);
	    
    	DrawView v = new DrawView(this);
    	v.setBackgroundResource(R.drawable.csic_first);
    	//this.setContentView(v);
    }

    public void onDraw(Canvas canvas) {
    	canvas.drawLine(0, 0, 100, 100, paint);
        canvas.drawLine(100, 0, 0, 100, paint);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    /** Called when the user clicks the Search button */
    public void searchForRoom(View view) {
    	//boolean found = false;
    	Intent intent = new Intent(this, DisplayMessageActivity.class);
    	EditText editText1 = (EditText) findViewById(R.id.search_start_room);
    	EditText editText2 = (EditText) findViewById(R.id.search_end_room);
    	startRoom = editText1.getText().toString();
    	endRoom = editText2.getText().toString();
    	intent.putExtra(EXTRA_MESSAGE_1, startRoom);
    	intent.putExtra(EXTRA_MESSAGE_2, endRoom);
    	startActivity(intent);
    		
    }
    
    public void displayCorrectFloor(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        ImageView v = (ImageView) this.findViewById(R.id.csic_map);
        //Drawable d;
        
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.button_floor_1:
                if (checked) {
                	//d = Drawable.createFromPath("csic_first");
                	//v.setImageDrawable(d);
                	v.setImageResource(R.drawable.csic_first);
                }
                break;
            case R.id.button_floor_2:
                if (checked) {
                    //d = Drawable.createFromPath("csic_second");
                    //v.setImageDrawable(d);
                    v.setImageResource(R.drawable.csic_second);
                }
                break;
            case R.id.button_floor_3:
                if (checked) {
                	//d = Drawable.createFromPath("csic_third");
                	//v.setImageDrawable(d);
                	v.setImageResource(R.drawable.csic_third);
                }
                break;
        }
    }
    
    public void showData(View view) {
    	
    	
    }
    
}
