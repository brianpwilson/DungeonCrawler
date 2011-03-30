package com.wilson;


public class Room {
	private static final String CARD = "c";
	private static final String WEST = "w";
	private static final String SOUTH = "s";
	private static final String EAST = "e";
	private static final String NORTH = "n";
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
	
	public static String invalidKey(String text) {
		String errorMsg = "";
		if (isMovementKey(text)) {
			errorMsg = CANNOT_MOVE + text + CURRENTLY;
		} else if (isActionKey(text)) {
			errorMsg = text
					+ IS_NOT_A_VALID_ACTION_CURRENTLY;
		} else {
			errorMsg = UNKNOWN_KEY;
		}
		return errorMsg;
	}

	private static boolean isActionKey(String text) {
		return text.equalsIgnoreCase(CARD);
	}

	private static boolean isMovementKey(String text) {
		return (text.equalsIgnoreCase(NORTH))
				|| text.equalsIgnoreCase(EAST)
				|| text.equalsIgnoreCase(SOUTH)
				|| text.equalsIgnoreCase(WEST);
	}
	
	@Override
	public String toString() {
		return description + "\n" +
		movementMsg + movements + "\n" +
		actionMsg + actions;
	}
	
}
