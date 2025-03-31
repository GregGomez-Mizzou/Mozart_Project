package mozart.parser;
import mozart.eventdata.MidiEventData;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;


public class MidiCsvParser {
	
	public static ArrayList<MidiEventData> parsedData(String path) {
		ArrayList<MidiEventData> aList = new ArrayList<MidiEventData>();
		try (Scanner scanner = new Scanner(new File(path))) {
			String event;
			while (scanner.hasNextLine()) {
				event = scanner.nextLine();
				String[] b = event.split(",");
				
				int startEndTick = Integer.parseInt(b[0].trim());
				int velocity = Integer.parseInt(b[4].trim());
				int note = Integer.parseInt(b[3].trim());
				int channel = Integer.parseInt(b[2].trim());
				int instrument = Integer.parseInt(b[5].trim());
				int noteOnOff;
				if (b[1].trim().equals("Note_on_c")) {
					noteOnOff = 1;
				}
				else if (b[1].trim().equals("Note_off_c")) {
					noteOnOff = 0;
				}
				else {
					throw new Exception("noteOnOff is unexpected string");
				}
				MidiEventData a = new MidiEventData(startEndTick, velocity, note, channel, instrument, noteOnOff);
				aList.add(a);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception k) {
			String message = k.getMessage();
			System.out.println(message);
			System.exit(0);
		}
		
		return aList;
		
	}
}

