package mozart.main;
import mozart.eventdata.MidiEventData;
import mozart.midiEventFactory.MidiEventFactory;
import mozart.parser.MidiCsvParser;
import java.util.ArrayList;
import javax.sound.midi.Sequence;
import javax.sound.midi.Track;
import mozart.abstractFactory.*;


public class Main {

	public static void main(String[] args) {
		try {
			// TODO Auto-generated method stub
			String path = "src\\mystery_song.csv";
			ArrayList<MidiEventData> events = MidiCsvParser.parsedData(path);
			
			Sequence sequence = new Sequence(Sequence.PPQ, 384);
			Track track = sequence.createTrack();
			
			MidiEventAbstractFactory factoryAbstract = new StandardMidiEventFactoryAbstract();
			// Other Factories below:
			
			MidiEventFactory factory = factoryAbstract.createFactory();
			
			// Choose Instrument Strategy
			InstrumentStrategy instrumentStrategy = new ElectricBaseGuitarStrategy();
			
			
			
			
			
			/*
			for (int i = 0; i < 100; i++) {
				System.out.println(events.get(i).toString());
			}
			
			notes: only using .toString for testing, not needed in general.
			 * noteOnOff == 1 means note ON, noteOnOff == 0 means note OFF
			 * remember to download the .csv file and set path to its location on your pc
			*/
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
