package com.wilson;

import android.view.KeyEvent;

public class Room {
	private static final String IS_NOT_A_VALID_ACTION_CURRENTLY = " is not a valid action currently";
	private static final String CURRENTLY = " currently";
	private static final String CANNOT_MOVE = "Cannot move ";
	private static final String UNKNOWN_KEY = "Unknown key";
	private String actionMsg = "Current available actions: ";
	private String movementMsg = "Movement: ";
	private String description;
	private String actions;
	private String movements;
	
	public Room( String description, String movements, String actions){
		this.description = description;
		this.movements = movements;
		this.actions = actions;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getActions() {
		return actions;
	}
	public void setActions(String actions) {
		this.actions = actions;
	}
	public String getMovements() {
		return movements;
	}
	public void setMovements(String movements) {
		this.movements = movements;
	}
	
	public static String invalidKey(int keyCode, KeyEvent event) {
		String errorMsg = "";
		if (isMovementKey(keyCode)) {
			errorMsg = CANNOT_MOVE + event.getDisplayLabel() + CURRENTLY;
		} else if (isActionKey(keyCode)) {
			errorMsg = event.getDisplayLabel()
					+ IS_NOT_A_VALID_ACTION_CURRENTLY;
		} else {
			errorMsg = UNKNOWN_KEY;
		}
		return errorMsg;
	}

	private static boolean isActionKey(int keyCode) {
		return (keyCode == KeyEvent.KEYCODE_C);
	}

	private static boolean isMovementKey(int keyCode) {
		return (keyCode == KeyEvent.KEYCODE_N)
				|| (keyCode == KeyEvent.KEYCODE_E)
				|| (keyCode == KeyEvent.KEYCODE_W)
				|| (keyCode == KeyEvent.KEYCODE_S);
	}
	
	@Override
	public String toString() {
		return description + "\n" +
		movementMsg + movements + "\n" +
		actionMsg + actions;
	}
	
}
