package com.wilson;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DungeonCrawler extends Activity {
	private static final String EAST = "e";
	private static final String NORTH = "n";
	private static final String SOUTH = "s";
	private static final String WEST = "w";
	private static final String CARD = "c";
	private TextView tv;
	private int currentRoom = 0;
	private Room[] rooms = new Room[] {
			new Room("You are staring east at a large brick building", EAST, ""),
			new Room("A locked door lies directly east", "", "c"), 
			new Room("The security guard ahead is sleeping", "n, s", ""), 
			new Room("There is a locked door ahead of you", "", "c"), 
			new Room("Paths lie north and a mysterious room is east", "n, e", ""), 
			//5
			new Room("This room is filled with human feces and paper towels", "w", ""), 
			new Room("Human activity is heard to the west. A path lies east", "e, w", ""), 
			new Room("The path continues east", "e, w", ""), 
			new Room("A path lies north and south", "n, s", ""), 
			new Room("You must be very quiet as you continue east", "e, s, w", ""), 
			//10
			new Room("A strange stain is on the floor", "n, e, s ,w", ""), 
			new Room("A man plays guitar while others work", "s", ""), 
			new Room("Joyous celebration can be heard to the east", "n, e, s", ""), 
			new Room("A turn approaches", "s, w", ""), 
			new Room("The path continues", "n, s", ""), 
			//15
			new Room("", "", ""), 
			new Room("", "", ""), 
			new Room("", "", ""), 
			new Room("Buzzing is heard south", "w", "c"), 
			new Room("", "", ""), 
			//20
			new Room("", "", ""), 
			new Room("A door is north", "n, e, w", ""), 
			new Room("The path continues east and west", "e, w", ""), 
			new Room("A north bound turn approaches", "n, e", ""), 
			new Room("A locked door is south", "n", "c"), 
			//25
			new Room("A door approaches to the west", "n, s, w", ""), 
			new Room("The path continues", "n, s", ""), 
			new Room("A large man watches tv on his cell phone", EAST, ""), 
			new Room("The path continues north and south", "n, s", ""), 
			new Room("A group of ogres stumbles around blindly", EAST, ""), 
			//30
			new Room("You've reached The PIT! Congratulations", "n", ""),
			new Room("Many workers appear hard at work", "n", ""),
			new Room("Large machines throw paper in all directions", "n", "")};
	private EditText textField;
	private MediaPlayer mp;


	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		tv = (TextView) findViewById(R.id.textView);
		
		Button button = (Button) findViewById(R.id.enterButton);
		button.setOnClickListener(new ClickListener());
		
		textField = (EditText) findViewById(R.id.textField);

		printRoom();
		
		mp = MediaPlayer.create(this, R.raw.zelda);
	    mp.start();
	}

	private void printRoom() {
		printRoom("");
	}
	
	private void printRoom(String errorMsg) {
		tv.setText(rooms[currentRoom].toString() + "\n" + errorMsg);
	}

	private class ClickListener implements View.OnClickListener{
		@Override
		public void onClick(View v) {
			handleEnter(textField.getText().toString());
			textField.setText("");
			InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(textField.getWindowToken(), 0);

		}
	}
	
	
	@Override
	protected void onPause() {
		super.onPause();
		if( mp != null && mp.isPlaying() ){
			mp.pause();
		}
	}

	@Override
	protected void onResume() {
		super.onResume();
		if( mp != null && !mp.isPlaying() ){
			mp.start();
		}
	}

	public void handleEnter(String text) {
		switch (currentRoom) {
		case 0:
			if (text.equalsIgnoreCase(EAST)) {
				currentRoom = 1;
				printRoom();
			} else {
				printRoom(Room.invalidKey(text));
			}
			break;
		case 1:
			if (text.equalsIgnoreCase(CARD)) {
				currentRoom = 2;
				printRoom();
			} else if (text.equalsIgnoreCase(WEST)) {
				currentRoom = 0;
				printRoom();
			}else {
				printRoom(Room.invalidKey(text));
			}
			break;
		case 2:
			if (text.equalsIgnoreCase(NORTH)) {
				currentRoom = 3;
				printRoom();
			} else if (text.equalsIgnoreCase(SOUTH)) {
				currentRoom = 24;
				printRoom();
			} else if (text.equalsIgnoreCase(WEST)) {
				currentRoom = 1;
				printRoom();
			}else {
				printRoom(Room.invalidKey(text));
			}
			break;
		case 3:
			if (text.equalsIgnoreCase(CARD)) {
				currentRoom = 4;
				printRoom();
			} else if (text.equalsIgnoreCase(SOUTH)) {
				currentRoom = 2;
				printRoom();
			} else {
				printRoom(Room.invalidKey(text));
			}
			break;
		case 4:
			if (text.equalsIgnoreCase(NORTH)) {
				currentRoom = 6;
				printRoom();
			} else if (text.equalsIgnoreCase(SOUTH)) {
				currentRoom = 3;
				printRoom();
			} else if (text.equalsIgnoreCase(EAST)) {
				currentRoom = 5;
				printRoom();
			}else {
				printRoom(Room.invalidKey(text));
			}
			break;
		case 5:
			if (text.equalsIgnoreCase(WEST)) {
				currentRoom = 4;
				printRoom();
			}else {
				printRoom(Room.invalidKey(text));
			}
			break;
		case 6:
			if (text.equalsIgnoreCase(WEST)) {
				currentRoom = 29;
				printRoom();
			} else if (text.equalsIgnoreCase(EAST)) {
				currentRoom = 7;
				printRoom();
			}else if (text.equalsIgnoreCase(SOUTH)) {
				currentRoom = 4;
				printRoom();
			}else {
				printRoom(Room.invalidKey(text));
			}
			break;
		case 7:
			if (text.equalsIgnoreCase(EAST)) {
				currentRoom = 9;
				printRoom();
			} else if (text.equalsIgnoreCase(WEST)) {
				currentRoom = 6;
				printRoom();
			}else {
				printRoom(Room.invalidKey(text));
			}
			break;
		case 8:
			if (text.equalsIgnoreCase(NORTH)) {
				currentRoom = 9;
				printRoom();
			}  else if (text.equalsIgnoreCase(SOUTH)) {
				currentRoom = 28;
				printRoom();
			}else {
				printRoom(Room.invalidKey(text));
			}
			break;
		case 9:
			if (text.equalsIgnoreCase(EAST)) {
				currentRoom = 10;
				printRoom();
			} else if (text.equalsIgnoreCase(WEST)) {
				currentRoom = 7;
				printRoom();
			} else if (text.equalsIgnoreCase(SOUTH)) {
				currentRoom = 8;
				printRoom();
			}else {
				printRoom(Room.invalidKey(text));
			}
			break;
		case 10:
			if (text.equalsIgnoreCase(NORTH)) {
				currentRoom = 11;
				printRoom();
			} else if (text.equalsIgnoreCase(SOUTH)) {
				currentRoom = 31;
				printRoom();
			} else if (text.equalsIgnoreCase(WEST)) {
				currentRoom = 9;
				printRoom();
			}else if (text.equalsIgnoreCase(EAST)) {
				currentRoom = 12;
				printRoom();
			}else {
				printRoom(Room.invalidKey(text));
			}
			break;
		case 11:
			if (text.equalsIgnoreCase(SOUTH)) {
				currentRoom = 10;
				printRoom();
			} else {
				printRoom(Room.invalidKey(text));
			}
			break;
		case 12:
			if (text.equalsIgnoreCase(EAST)) {
				currentRoom = 13;
				printRoom();
			} else if (text.equalsIgnoreCase(SOUTH)) {
				currentRoom = 30;
				printRoom();
			} else if (text.equalsIgnoreCase(WEST)) {
				currentRoom = 10;
				printRoom();
			}else {
				printRoom(Room.invalidKey(text));
			}
			break;
		case 13:
			if (text.equalsIgnoreCase(WEST)) {
				currentRoom = 12;
				printRoom();
			} else if (text.equalsIgnoreCase(SOUTH)) {
				currentRoom = 14;
				printRoom();
			} else {
				printRoom(Room.invalidKey(text));
			}
			break;
		case 14:
			if (text.equalsIgnoreCase(NORTH)) {
				currentRoom = 13;
				printRoom();
			} else if (text.equalsIgnoreCase(SOUTH)) {
				currentRoom = 18;
				printRoom();
			} else {
				printRoom(Room.invalidKey(text));
			}
			break;
		case 15:
			if (text.equalsIgnoreCase(NORTH)) {
				currentRoom = 14;
				printRoom();
			} else if (text.equalsIgnoreCase(SOUTH)) {
				currentRoom = 16;
				printRoom();
			} else {
				printRoom(Room.invalidKey(text));
			}
			break;
		case 16:
			if (text.equalsIgnoreCase(NORTH)) {
				currentRoom = 15;
				printRoom();
			} else if (text.equalsIgnoreCase(SOUTH)) {
				currentRoom = 17;
				printRoom();
			} else {
				printRoom(Room.invalidKey(text));
			}
			break;
		case 17:
			if (text.equalsIgnoreCase(NORTH)) {
				currentRoom = 16;
				printRoom();
			} else if (text.equalsIgnoreCase(SOUTH)) {
				currentRoom = 18;
				printRoom();
			} else {
				printRoom(Room.invalidKey(text));
			}
			break;
		case 18:
			if (text.equalsIgnoreCase(NORTH)) {
				currentRoom = 14;
				printRoom();
			} else if (text.equalsIgnoreCase(CARD)) {
				currentRoom = 32;
				printRoom();
			} else if (text.equalsIgnoreCase(WEST)) {
				currentRoom = 21;
				printRoom();
			}else {
				printRoom(Room.invalidKey(text));
			}
			break;
		case 19:
			if (text.equalsIgnoreCase(EAST)) {
				currentRoom = 18;
				printRoom();
			} else if (text.equalsIgnoreCase(WEST)) {
				currentRoom = 20;
				printRoom();
			} else {
				printRoom(Room.invalidKey(text));
			}
			break;
		case 20:
			if (text.equalsIgnoreCase(EAST)) {
				currentRoom = 19;
				printRoom();
			} else if (text.equalsIgnoreCase(WEST)) {
				currentRoom = 21;
				printRoom();
			} else {
				printRoom(Room.invalidKey(text));
			}
			break;
		case 21:
			if (text.equalsIgnoreCase(EAST)) {
				currentRoom = 18;
				printRoom();
			} else if (text.equalsIgnoreCase(WEST)) {
				currentRoom = 22;
				printRoom();
			} else if (text.equalsIgnoreCase(NORTH)) {
				currentRoom = 26;
				printRoom();
			}else {
				printRoom(Room.invalidKey(text));
			}
			break;
		case 22:
			if (text.equalsIgnoreCase(EAST)) {
				currentRoom = 21;
				printRoom();
			} else if (text.equalsIgnoreCase(WEST)) {
				currentRoom = 23;
				printRoom();
			} else {
				printRoom(Room.invalidKey(text));
			}
			break;
		case 23:
			if (text.equalsIgnoreCase(EAST)) {
				currentRoom = 22;
				printRoom();
			} else if (text.equalsIgnoreCase(NORTH)) {
				currentRoom = 24;
				printRoom();
			} else {
				printRoom(Room.invalidKey(text));
			}
			break;
		case 24:
			if (text.equalsIgnoreCase(NORTH)) {
				currentRoom = 2;
				printRoom();
			} else if (text.equalsIgnoreCase(CARD)) {
				currentRoom = 23;
				printRoom();
			} else {
				printRoom(Room.invalidKey(text));
			}
			break;
		case 25:
			if (text.equalsIgnoreCase(WEST)) {
				currentRoom = 27;
				printRoom();
			} else if (text.equalsIgnoreCase(NORTH)) {
				currentRoom = 28;
				printRoom();
			} else if (text.equalsIgnoreCase(SOUTH)) {
				currentRoom = 26;
				printRoom();
			} else {
				printRoom(Room.invalidKey(text));
			}
			break;
		case 26:
			if (text.equalsIgnoreCase(SOUTH)) {
				currentRoom = 21;
				printRoom();
			} else if (text.equalsIgnoreCase(NORTH)) {
				currentRoom = 25;
				printRoom();
			}  else {
				printRoom(Room.invalidKey(text));
			}
			break;
		case 27:
			if (text.equalsIgnoreCase(EAST)) {
				currentRoom = 25;
				printRoom();
			}  else {
				printRoom(Room.invalidKey(text));
			}
			break;
		case 28:
			if (text.equalsIgnoreCase(SOUTH)) {
				currentRoom = 25;
				printRoom();
			} else if (text.equalsIgnoreCase(NORTH)) {
				currentRoom = 8;
				printRoom();
			} else {
				printRoom(Room.invalidKey(text));
			}
			break;
		case 29:
			if (text.equalsIgnoreCase(EAST)) {
				currentRoom = 6;
				printRoom();
			} else {
				printRoom(Room.invalidKey(text));
			}
			break;
		case 30:
			if (text.equalsIgnoreCase(NORTH)) {
				currentRoom = 12;
				printRoom();
			} else {
				printRoom(Room.invalidKey(text));
			}
			break;
		case 31:
			if (text.equalsIgnoreCase(NORTH)) {
				currentRoom = 10;
				printRoom();
			} else {
				printRoom(Room.invalidKey(text));
			}
			break;
		case 32:
			if (text.equalsIgnoreCase(NORTH)) {
				currentRoom = 18;
				printRoom();
			} else {
				printRoom(Room.invalidKey(text));
			}
			break;
		default:
			break;
		}
	}

}