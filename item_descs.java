//objects
//light
//size
//individual characteristics
//smell
//sounds


public class item_descs{
	public static void main(String[] args){
		//idk what to put in the main method, seeing that these are just arrays 
		//of possible text scenarios
	}
	public static String[] descHeaders(){
		String[] desc_header = new String[3];
		desc_header[0] = "After scowering the room for anything useful,";
		desc_header[1] = "After thoroughly searching the room,";
		desc_header[2] = "Looking around the room for anything to use,";
		return desc_header;
	}
	public static String[] descItemPresent(){
		String[] desc_present = new String[5];
		desc_present[0] = "you come across ";
		desc_present[1] = "you find ";
		desc_present[2] = "you happen upon ";
		desc_present[3] = "you happen to find ";
		desc_present[4] = "you find that there is ";
		return desc_present;
	}
	public static String[] descItemAbsent(){
		String[] desc_absent = new String[4];
		desc_absent[0] = "you don't find anything that you can use."
		desc_absent[1] = "you couldn't find anything";
		desc_absent[2] = "you find that there is nothing else in the room."
		desc_absent[3] = "you don't find anything in here.";
		return desc_absent;
	}
	public static String[] itemWater(){
		String[]  item_water = new String[3];
		item_water[0] = "an unopened bottle of almond water.";
		item_water[1] = "some almond water.";
		item_water[2] = "a bottle of almond water";
		return item_water; 
	}
	public static String[] itemBandage(){
		String[] item_bandage = new String[2];
		item_bandage[0] = "a roll of bandages.";
		item_bandage[1] = "some bandages.";
		return item_bandage;
	}
	public static String[] itemPack(){
		String[] item_pack = new String[2];
		item_pack[0] = "a first aid kit.";
		item_pack[1] = "a trauma kit."
		return item_pack;
	}
	public static String[] itemPipe(){
		String[] item_pipe = new String[3];
		item_pipe[0] = "a bent metal pipe.";
		item_pipe[1] = "a metal pipe brokem off at one of its ends.";
		item_pipe[2] = "a pipe with one of its ends crushed."
		return item_pipe;
	}
	public static String[] itemLeg(){
		String[] item_leg = new String[3];
		item_leg[0] = "a chair leg that's been ripped off from the rest of the chair. "+
					   "Its nail is still intact.";
		item_leg[1] = "a leg of a chair. The base of the leg looks to be torn off, "+
		              "leaving exposed sharp splints of laminated wood."
		item_leg[2] = "a chair leg. Looks to still be intact.";
		return item_leg;
	}
	public static String[] item_bat(){
		String[] item_bat = new String[2];
		item_bat[0] = "a baseball bat. The side of the bat has been bent inward.";
		item_bat[1] = "what looks to be a baseball bat, and you can still see the faded "+
					  "marker from its signature.";
		return item_bat;
	}
	public static String[] item_racket(){
		String[] item_racket = new String[3];
		item_racket[0] = "a tennis racket which looks to be contorted from some previous "+
						 "previous altercation.";
		item_racket[1] = "a bent tennis racket.";
		item_racket[2] = "a tennis racket. Half of it has been broken, leaving only two "+
		                 "prongs exposed from the rim of the racket.";
		return item_racket;
	}
	public static String[] itemShroom(){
		String[] item_shroom = new String[2];
		item_shroom[0] = "a strange thing growing from the ground in the dark corner. \n"+
						 "They look to be some type of fungus, and the smell of them "+
						 "strangely smells like parmesean.";
		item_shroom[1] = "what seems to be mushrooms growing from some of the cracks "+
						 "in the wall.";
		return item_shroom;
	}
	
	public static String itemAcquisition(){
		String item_pick_up = "You picked up ";
		return item_pick_up;
	}
	public static String itemDrop(){
		String item_drop = "You dropped ";
		return item_drop;
	}
	public static String[] entityEncounter(){
		String[] entity_encounter = new String[5];
		entity_encounter[0] = "The moment you step into this new room, your heart drops as you come face to face \n"+
							  "with some kind of... indescribable thing.";
		entity_encounter[1] = "You have no time to react entering this room, as suddenly an entity that towers over \n"+
							  "you becomes aware of your presence.";
		entity_encounter[2] = "The room you enter feels different. The flourescent lights flicker, the air grows thinner. \n";
							  "In the dark corner of the room, a pair of eyes stares you down, ensnaring you to this room.";
		entity_encounter[3] = "Walking into this room you feel that you're not alone. Your assumptions are proven correct, \n"+
							  "as some kind of crawling entity shambles across the floor towards you.";
		entity_encounter[4] = "This new room seems to appear vacant at the moment. After a few seconds, some wretched entity \n"+
							  "enters the room from another doorway, letting out an ear-piercing yell.";
		return entity_encounter;
	}
	public static String cry(){
		String cry = "You descend to your knees and somber, anguished at the dreadful revalation of the unfortunate \n"+
					 "situation that has been misfortunately happened upon your woeful being. In your episoede of \n"+
					 "despondency, your hands cover your eyes, as if to prevent a mutual acknowledgement between you \n"+
					 "whatever else roamsn these halls of your current state. However, you are wholly unaware of your \n"+
					 "immediate surrounding environment. \n\n"+
					 "You're not in those rooms anymore. \n"+
					 "The reprivation of the bewildering emotinons delivered from what was just once total helplessness \n"+
					 "pushes your body to the grass around you. You lay there, contemplating this most recent occurrence, \n"+
					 "breathing in air that is recognizable to the body.\n\n"+
					 "Whatever just happened, you hope that nothing like that ever happens again.\n\n"+
					 "At least for now...";
	return cry;				 
	}
}