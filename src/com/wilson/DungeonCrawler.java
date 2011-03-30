package com.wilson;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;

public class DungeonCrawler extends Activity {
	private TextView tv;
	private int currentRoom = 0;
	private Room[] rooms = new Room[] {
			new Room("You are staring east at a large brick building", "e", ""),
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
			new Room("A large man watches tv on his cell phone", "e", ""), 
			new Room("The path continues north and south", "n, s", ""), 
			new Room("A group of ogres stumbles around blindly", "e", ""), 
			//30
			new Room("You've reached The PIT! Congratulations", "n", ""),
			new Room("Many workers appear hard at work", "n", ""),
			new Room("Large machines throw paper in all directions", "n", "")};



	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		tv = new TextView(this);
		printRoom();
		setContentView(tv);
	}

	private void printRoom() {
		printRoom("");
	}
	
	private void printRoom(String errorMsg) {
		tv.setText(rooms[currentRoom].toString() + "\n" + errorMsg);
	}

	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		switch (currentRoom) {
		case 0:
			if (keyCode == KeyEvent.KEYCODE_E) {
				currentRoom = 1;
				printRoom();
			} else {
				printRoom(Room.invalidKey(keyCode, event));
			}
			break;
		case 1:
			if (keyCode == KeyEvent.KEYCODE_C) {
				currentRoom = 2;
				printRoom();
			} else if (keyCode == KeyEvent.KEYCODE_W) {
				currentRoom = 0;
				printRoom();
			}else {
				printRoom(Room.invalidKey(keyCode, event));
			}
			break;
		case 2:
			if (keyCode == KeyEvent.KEYCODE_N) {
				currentRoom = 3;
				printRoom();
			} else if (keyCode == KeyEvent.KEYCODE_S) {
				currentRoom = 24;
				printRoom();
			} else if (keyCode == KeyEvent.KEYCODE_W) {
				currentRoom = 1;
				printRoom();
			}else {
				printRoom(Room.invalidKey(keyCode, event));
			}
			break;
		case 3:
			if (keyCode == KeyEvent.KEYCODE_C) {
				currentRoom = 4;
				printRoom();
			} else if (keyCode == KeyEvent.KEYCODE_S) {
				currentRoom = 2;
				printRoom();
			} else {
				printRoom(Room.invalidKey(keyCode, event));
			}
			break;
		case 4:
			if (keyCode == KeyEvent.KEYCODE_N) {
				currentRoom = 6;
				printRoom();
			} else if (keyCode == KeyEvent.KEYCODE_S) {
				currentRoom = 3;
				printRoom();
			} else if (keyCode == KeyEvent.KEYCODE_E) {
				currentRoom = 5;
				printRoom();
			}else {
				printRoom(Room.invalidKey(keyCode, event));
			}
			break;
		case 5:
			if (keyCode == KeyEvent.KEYCODE_W) {
				currentRoom = 4;
				printRoom();
			}else {
				printRoom(Room.invalidKey(keyCode, event));
			}
			break;
		case 6:
			if (keyCode == KeyEvent.KEYCODE_W) {
				currentRoom = 29;
				printRoom();
			} else if (keyCode == KeyEvent.KEYCODE_E) {
				currentRoom = 7;
				printRoom();
			}else if (keyCode == KeyEvent.KEYCODE_S) {
				currentRoom = 4;
				printRoom();
			}else {
				printRoom(Room.invalidKey(keyCode, event));
			}
			break;
		case 7:
			if (keyCode == KeyEvent.KEYCODE_E) {
				currentRoom = 9;
				printRoom();
			} else if (keyCode == KeyEvent.KEYCODE_W) {
				currentRoom = 6;
				printRoom();
			}else {
				printRoom(Room.invalidKey(keyCode, event));
			}
			break;
		case 8:
			if (keyCode == KeyEvent.KEYCODE_N) {
				currentRoom = 9;
				printRoom();
			}  else if (keyCode == KeyEvent.KEYCODE_S) {
				currentRoom = 28;
				printRoom();
			}else {
				printRoom(Room.invalidKey(keyCode, event));
			}
			break;
		case 9:
			if (keyCode == KeyEvent.KEYCODE_E) {
				currentRoom = 10;
				printRoom();
			} else if (keyCode == KeyEvent.KEYCODE_W) {
				currentRoom = 7;
				printRoom();
			} else if (keyCode == KeyEvent.KEYCODE_S) {
				currentRoom = 8;
				printRoom();
			}else {
				printRoom(Room.invalidKey(keyCode, event));
			}
			break;
		case 10:
			if (keyCode == KeyEvent.KEYCODE_N) {
				currentRoom = 11;
				printRoom();
			} else if (keyCode == KeyEvent.KEYCODE_S) {
				currentRoom = 31;
				printRoom();
			} else if (keyCode == KeyEvent.KEYCODE_W) {
				currentRoom = 9;
				printRoom();
			}else if (keyCode == KeyEvent.KEYCODE_E) {
				currentRoom = 12;
				printRoom();
			}else {
				printRoom(Room.invalidKey(keyCode, event));
			}
			break;
		case 11:
			if (keyCode == KeyEvent.KEYCODE_S) {
				currentRoom = 10;
				printRoom();
			} else {
				printRoom(Room.invalidKey(keyCode, event));
			}
			break;
		case 12:
			if (keyCode == KeyEvent.KEYCODE_E) {
				currentRoom = 13;
				printRoom();
			} else if (keyCode == KeyEvent.KEYCODE_S) {
				currentRoom = 30;
				printRoom();
			} else if (keyCode == KeyEvent.KEYCODE_W) {
				currentRoom = 10;
				printRoom();
			}else {
				printRoom(Room.invalidKey(keyCode, event));
			}
			break;
		case 13:
			if (keyCode == KeyEvent.KEYCODE_W) {
				currentRoom = 12;
				printRoom();
			} else if (keyCode == KeyEvent.KEYCODE_S) {
				currentRoom = 14;
				printRoom();
			} else {
				printRoom(Room.invalidKey(keyCode, event));
			}
			break;
		case 14:
			if (keyCode == KeyEvent.KEYCODE_N) {
				currentRoom = 13;
				printRoom();
			} else if (keyCode == KeyEvent.KEYCODE_S) {
				currentRoom = 18;
				printRoom();
			} else {
				printRoom(Room.invalidKey(keyCode, event));
			}
			break;
		case 15:
			if (keyCode == KeyEvent.KEYCODE_N) {
				currentRoom = 14;
				printRoom();
			} else if (keyCode == KeyEvent.KEYCODE_S) {
				currentRoom = 16;
				printRoom();
			} else {
				printRoom(Room.invalidKey(keyCode, event));
			}
			break;
		case 16:
			if (keyCode == KeyEvent.KEYCODE_N) {
				currentRoom = 15;
				printRoom();
			} else if (keyCode == KeyEvent.KEYCODE_S) {
				currentRoom = 17;
				printRoom();
			} else {
				printRoom(Room.invalidKey(keyCode, event));
			}
			break;
		case 17:
			if (keyCode == KeyEvent.KEYCODE_N) {
				currentRoom = 16;
				printRoom();
			} else if (keyCode == KeyEvent.KEYCODE_S) {
				currentRoom = 18;
				printRoom();
			} else {
				printRoom(Room.invalidKey(keyCode, event));
			}
			break;
		case 18:
			if (keyCode == KeyEvent.KEYCODE_N) {
				currentRoom = 14;
				printRoom();
			} else if (keyCode == KeyEvent.KEYCODE_C) {
				currentRoom = 32;
				printRoom();
			} else if (keyCode == KeyEvent.KEYCODE_W) {
				currentRoom = 21;
				printRoom();
			}else {
				printRoom(Room.invalidKey(keyCode, event));
			}
			break;
		case 19:
			if (keyCode == KeyEvent.KEYCODE_E) {
				currentRoom = 18;
				printRoom();
			} else if (keyCode == KeyEvent.KEYCODE_W) {
				currentRoom = 20;
				printRoom();
			} else {
				printRoom(Room.invalidKey(keyCode, event));
			}
			break;
		case 20:
			if (keyCode == KeyEvent.KEYCODE_E) {
				currentRoom = 19;
				printRoom();
			} else if (keyCode == KeyEvent.KEYCODE_W) {
				currentRoom = 21;
				printRoom();
			} else {
				printRoom(Room.invalidKey(keyCode, event));
			}
			break;
		case 21:
			if (keyCode == KeyEvent.KEYCODE_E) {
				currentRoom = 18;
				printRoom();
			} else if (keyCode == KeyEvent.KEYCODE_W) {
				currentRoom = 22;
				printRoom();
			} else if (keyCode == KeyEvent.KEYCODE_N) {
				currentRoom = 26;
				printRoom();
			}else {
				printRoom(Room.invalidKey(keyCode, event));
			}
			break;
		case 22:
			if (keyCode == KeyEvent.KEYCODE_E) {
				currentRoom = 21;
				printRoom();
			} else if (keyCode == KeyEvent.KEYCODE_W) {
				currentRoom = 23;
				printRoom();
			} else {
				printRoom(Room.invalidKey(keyCode, event));
			}
			break;
		case 23:
			if (keyCode == KeyEvent.KEYCODE_E) {
				currentRoom = 22;
				printRoom();
			} else if (keyCode == KeyEvent.KEYCODE_N) {
				currentRoom = 24;
				printRoom();
			} else {
				printRoom(Room.invalidKey(keyCode, event));
			}
			break;
		case 24:
			if (keyCode == KeyEvent.KEYCODE_N) {
				currentRoom = 2;
				printRoom();
			} else if (keyCode == KeyEvent.KEYCODE_C) {
				currentRoom = 23;
				printRoom();
			} else {
				printRoom(Room.invalidKey(keyCode, event));
			}
			break;
		case 25:
			if (keyCode == KeyEvent.KEYCODE_W) {
				currentRoom = 27;
				printRoom();
			} else if (keyCode == KeyEvent.KEYCODE_N) {
				currentRoom = 28;
				printRoom();
			} else if (keyCode == KeyEvent.KEYCODE_S) {
				currentRoom = 26;
				printRoom();
			} else {
				printRoom(Room.invalidKey(keyCode, event));
			}
			break;
		case 26:
			if (keyCode == KeyEvent.KEYCODE_S) {
				currentRoom = 21;
				printRoom();
			} else if (keyCode == KeyEvent.KEYCODE_N) {
				currentRoom = 25;
				printRoom();
			}  else {
				printRoom(Room.invalidKey(keyCode, event));
			}
			break;
		case 27:
			if (keyCode == KeyEvent.KEYCODE_E) {
				currentRoom = 25;
				printRoom();
			}  else {
				printRoom(Room.invalidKey(keyCode, event));
			}
			break;
		case 28:
			if (keyCode == KeyEvent.KEYCODE_S) {
				currentRoom = 25;
				printRoom();
			} else if (keyCode == KeyEvent.KEYCODE_N) {
				currentRoom = 8;
				printRoom();
			} else {
				printRoom(Room.invalidKey(keyCode, event));
			}
			break;
		case 29:
			if (keyCode == KeyEvent.KEYCODE_E) {
				currentRoom = 6;
				printRoom();
			} else {
				printRoom(Room.invalidKey(keyCode, event));
			}
			break;
		case 30:
			if (keyCode == KeyEvent.KEYCODE_N) {
				currentRoom = 12;
				printRoom();
			} else {
				printRoom(Room.invalidKey(keyCode, event));
			}
			break;
		case 31:
			if (keyCode == KeyEvent.KEYCODE_N) {
				currentRoom = 10;
				printRoom();
			} else {
				printRoom(Room.invalidKey(keyCode, event));
			}
			break;
		case 32:
			if (keyCode == KeyEvent.KEYCODE_N) {
				currentRoom = 18;
				printRoom();
			} else {
				printRoom(Room.invalidKey(keyCode, event));
			}
			break;
		default:
			break;
		}
		return true;
	}

}