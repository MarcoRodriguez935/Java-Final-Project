//objects
//light
//size
//individual characteristics
//smell
//sounds


public class anceint_scripture{
	public static void main(String[] args){
		//same thing as the item_descs; these are just loose arrays for each room
	}
	public static String startingRoomDesc(){
		String starting_desc = "You pick yourself up off the floor, dazed and disoriented from had just occurred. \n"+
					  "You can feel the dampness of the water on your hands from the sodden tan carpet that seemingly \n"+
					  "lines every square inch of this place. From where you stand, every wall in view is covered \n"+
					  "by this lifeless, drab yellow wallpaper thats emitting a smell similar to that of paper mache. \n"+
					  "The low hum of the flourescent lights overhead is the only sign of activity in this stale place.\n\n"+

					  "In the current room, there is only you and your sense of direction, which, at the moment, is completely \n"+
					  "at a loss. You look around and see that you're able to go down or left \n"+
					  "\n You decide to go ________.\n";
		return starting_desc;
	}
	public static String mov_menu(){
		String menu = "- Ignore\n"+
					  "- This\n"+
					  "- For\n"+
					  "- Now\n"+
					  ">>>";
					  return menu;
	}
	public static String altar(String item1, String item2, String item3){
		//the "items" in the message prompt are there just in case
		String altar = "The lights in this room are all turned off; the only source of light coming from the candle of an altar \n"+
					   "that exists in the center of the room. Out of curiosity, you continue to search around this altar, discovering \n"+ 
					   "a small box with a padlock on it and an empty backpack. On top of the altar lies the aforementioned \n"+
					   "candles, with only one being lit, along with an item lying on one of the altar pillars. You can see \n"+
					   "a small key locked at the base of the altar, which you assume can only be for the padlock on the box.\n\n"+
					   "You then see through the dim light of the candle that there is writing next to each pillar.\n\n"+
					   "One pillar writes \""+item1+"\", the second pillar writes \""+item2+"\", and on the third pillar \n"+
					   "lies a "+item3+".";
		return altar;
	}
	public static String[] yellowRoomDesc(){
		String[] yellow_desc= new String[9];
		yellow_desc[0] = "Entering this new room, the smell of wallpaper remains as pungent as it has beem, but there aree\n"+
					  	 "pillars situated across the room.";

		yellow_desc[1] = "This room looks to be the same as the last, except there's a set of pits across the floor \n"+
						 "and these pits seemingly go on forever. Luckily, there are slim passageways that seperate \n"+
						 "that you can walk across, but seeing as the room is relatively larger, you know to take caution.";

		yellow_desc[2] = "Some of the wallpaper in here has been torn off, lacerated by something big. These signs give you a \n"+
		                 "sense of uneasiness. The smell of the wet carpet doesn't help with the situation";

		yellow_desc[3] = "This room looks to be pretty small, with narrow passageways allowing access in here. The flourescent lights \n"+
						 "are also slightly dimmer that usual.";

		yellow_desc[4] = "As you enter this room, you can see writing on the wall. As far you can make out, its mostly \n"+
						 "indiscnernable scribbles and markings, but there some shapes drawn together in make some structure.";

		yellow_desc[5] = "The room you enter is much darker than before, with the flourescnet lights flickering on and off. THe \n"+
						 "doesn't look to be too large and between the flickering of the lights you can see what appears to be \n"+
						 "two chairs.";

		yellow_desc[6] = "The new room you walk into has a higher ceiling than what you've seen so far. There's three holes in \n"+
						 "the wall, but they're situated higher than normal, rendering them impossible to look in to. The \n"+
						 "wall farthest from you looks to have been smeared with some sort of black substance, fortunately \n"+
						 "its not giving off a smell.";

		yellow_desc[7] = "This room wreaks of wet carpet and glue from the ripped wallpaper. There's small divider that don't \n"+
						 "connect with the ceiling which block off your vision from some of the rooms corners.";

		yellow_desc[8] = "You can immediateley hear that the flourescnet lights are humming at a greater volume. Nestled in \n"+
						 "lies three discarded chairs torn apart viciously. You notice that there are stains around these chairs, \n"+
						 "and these stains are smeared along the carpet leading towards one of the doorways.";
		return yellow_desc;
	}
	public static String[] poolDesc(){
		String[] pool_desc = new String[6];
		pool_desc[0] = "This room doesn't look the same as what you've seen; in here there are tiles lining the entirety of the \n"+
					   "room. The floor is still wet, however.";

		pool_desc[1] = "This room looks to be some sort of large pool area, with the telltale sign given by the giant hole in the \n"+
					   "center of the room. Each step you take in this room reverberates, the room wreaks of chlorine.";

		pool_desc[2] = "The smell of chlorine hits your senses as you enter this room. Lights from over head beam through square holes \n"+
					   "in the ceiling emit down into the room and reflect off the white tiled walls and floor. Faint sounds from other \n"+
					   "rooms resonate softly throughout the room, giving you an uneasy feeling.";

		pool_desc[3] = "Entering this new room you immediately notice that there are scratch markings engraved all across walls here. \n"+
					   "Some of the tiles that are in this room are cracked or completely removed, seemingly by force.";

		pool_desc[4] = "When you enter this room, the first thing that catches your eye are the small pockets of water situated in \n"+
					   "each corner of the room and reflects a mosaic of light onto all surfaces of the room. Because of the presence \n"+
					   "of the water, the tile below your feet is slippery.";

		pool_desc[5] = "This room looks to be a something out of pool locker room. The chlorine smell in the air assures you that there \n"+
					   "may be some source of water here in these rooms. In here, the lights that are in this room are somewhat more dimmer.";
		return pool_desc;
	}
	public static String[] aptDesc(){
		String[] apt_desc = new String[6];
		apt_desc[0] = "The air in here is noticeably more stagnant as you step onto the wooden floors of what might be an apartment complex.";

		apt_desc[1] = "Entering this room, the walls are completely covered in white paint, and there exists several printers set up \n"+
					  "against those walls.";

		apt_desc[2] = "The air in this room is much colder than usual. Looking around you notice that there are now windows in the \n"+
					  "walls, however the windows only show complete darkness on the other side, giving you an increasing amount \n"+
					  "of concern given the strange circumstances you're in";

		apt_desc[3] = "The room is noticeably empty in here, the only exception being one table and a dumpster sitting in here. Each \n"+
					  "step you take in here causes the floorboards to creak under your feet. The overhead lamps are fortunately working.";

		apt_desc[4] = "There is no smell in here, but you feel much colder than before, as if a draft from a window was left open. \n"+
					  "Scanning the room you find that there are two windows that don't show anything on the other side, and one of \n"+
					  "these windows is cracked open, asuumedly causing the breeze.";

		apt_desc[5] = "Walking into this room, you find several dumpsters lining the walls of the room, but they're not giving off \n"+
					  "any smell. The one window that's to your right shows what seems to be some living complex.";
		return apt_desc;

	}
	public static String[] underDesc(){
		String[] under_desc = new String[4];
		under_desc[0] = "The thin layer of dirt crunches beneath your feet as you enter this room. This place looks to be in some \n"+
						"underground area. The lights overhead are the flourescnet type again, connected by a a black wire to other \n"+
						"lights. Large industrial pipes line the walls of this room.";

		under_desc[1] = "This room is covered in white, polished brick, and there's a weathered sign painted on one of the walls. \n"+
						"It says \"4th & LaFayette\", giving the assumption that you're might be in a subway area, but you're not \n"+
						"completely sure";

		under_desc[2] = "When you enter this room, you notice that walls are a mix between white brick and rock. This confuses you \n"+
						"seeing that the previous rooms were, for the most part, put together. But here it looks like run-down \n"+
						"maintainence area in side of some basement or cave complex";

		//This description is for the final room
		under_desc[3] = "As you enter this particular room, every direction you look at is poorly lit and thus you can't really \n"+
						"make see anything that's in the room. The sounds in this room put you in a state of uneasiness that \n"+
						"surpasses any feeling that you've felt so far in this place. \n\n"+
						"After a minute of trying to understand where you are, the lights in the room suddenly turn on, blinding \n"+
						"you momentarily. As your vision reestablishes itself, you're face to face to, much to your surprise, JACK BLACK!"+
						"By far this is the most confused you've been in your life. Seeing THE actor from timeless classics such as \n"+
						"\"Kung Fu Panda\", \"Jumanji\", \"School of Rock\" & \"Goosebumps\" is very much a surprise, however there's \n"+
						"something... uncanny about this whole thing. He does not seem to be in the same state of delirium being \n"+
						"within this place, unlike you.\n\n"+
						"Mr. Black says nothing other than this: \n"+
						"\"To free yourself from these rooms, become the victor from a simple game of poker\" \n"+
						"Seeing as you haven't found a single door in this place, the guarantee of escape attracts you to the table \n"+
						"in the center of the room, reluctantly complying to Mr. Black's wishes.";
	}


 }