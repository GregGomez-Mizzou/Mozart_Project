package mozart.main;
import mozart.eventdata.MidiEventData;
import mozart.parser.MidiCsvParser;
import java.util.ArrayList;


public class Main {

	public static void main(String[] args) {
		try {
			// TODO Auto-generated method stub
			String path = "C:\\Users\\sdmai\\Downloads\\mystery_song.csv";
			ArrayList<MidiEventData> events = MidiCsvParser.parsedData(path);
			for (int i = 0; i < 100; i++) {
				System.out.println(events.get(i).toString());
			}
			
			/*notes: only using .toString for testing, not needed in general.
			 * noteOnOff == 1 means note ON, noteOnOff == 0 means note OFF
			 * remember to download the .csv file and set path to its location on your pc
			*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
