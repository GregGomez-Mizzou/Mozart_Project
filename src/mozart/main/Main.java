package mozart.main;
import mozart.eventdata.MidiEventData;
import mozart.midiEventFactory.MidiEventFactory;
import mozart.parser.MidiCsvParser;
import java.util.ArrayList;
import javax.sound.midi.Sequence;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;
import mozart.abstractFactory.*;
import instrumentStrategy.*;
import mozart.pitch.*;


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
			instrumentStrategy.applyInstrument(track, 0);
			instrumentStrategy = new AcousticGrandPianoStrategy();
			instrumentStrategy.applyInstrument(track, 1);
			
			// Pitch Strategy
			PitchStrategy pitchStrategy = new HigherPitchStrategy();
			
			for (MidiEventData event : midiEvents) {
				int modifiedNote = pitchStrategy.modifyPitch(event.getNote());
				
				// Call to modify to higher pitch
				modifiedNote = pitchStrategy.modifyPitch(modifiedNote);
				
				if(event.GetNoteOnOff() == ShortMessage.NOTE_ON) {
					track.add(factory.createNoteOn(event.getStartEndTick(), modifiedNote, event.getVelocity(), event.getChannel()));
				}
				else {
					track.add(factory.createNoteOff(event.getStartEndTick(), modifiedNote, event.getChannel()));
				}
			}
			
			
			
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
