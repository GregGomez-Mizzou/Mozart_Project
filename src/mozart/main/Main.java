package mozart.main;
import mozart.eventdata.MidiEventData;
import mozart.instrumentStrategy.*;
import mozart.midiEventFactory.MidiEventFactory;
import mozart.parser.MidiCsvParser;
import java.util.ArrayList;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.Track;
import mozart.abstractFactory.*;
import mozart.pitch.*;


public class Main {

	public static void main(String[] args) {
		try {
			
			String path = "src/mystery_song.csv";
			ArrayList<MidiEventData> events = MidiCsvParser.parsedData(path);
			
			/*
			for (int i = 0; i < 100; i++) {
				System.out.println(events.get(i).toString());
			}
			
			notes: only using .toString for testing, not needed in general.
			 * noteOnOff == 1 means note ON, noteOnOff == 0 means note OFF
			 * remember to download the .csv file and set path to its location on your pc
			 * 
			 * 
			 * THE SONG IS:
			 * Billy Eilish - Bad Guy
			 * 
			
			*/
			
			Sequence sequence = new Sequence(Sequence.PPQ, 384);
			Track track = sequence.createTrack();
			
			MidiEventAbstractFactory factoryAbstract = new StandardMidiEventFactoryAbstract();
			// Other Factories below:
			// LegatoMidiEventFactoryAbstract();
			// StaccatoMidiEventFactoryAbstract();
			
			MidiEventFactory factory = factoryAbstract.createFactory();
			
			// Choose Instrument Strategy
			// Electric Base Guitar
			InstrumentStrategy instrumentStrategy = new ElectricBaseGuitarStrategy();
			instrumentStrategy.applyInstrument(track, 0);
			
			// Trumpet
			instrumentStrategy = new TrumpetStrategy();
			instrumentStrategy.applyInstrument(track, 1);
			
			// Piano
			instrumentStrategy = new AcousticGrandPianoStrategy();
			instrumentStrategy.applyInstrument(track, 2);
			
			// Pitch Strategy
			PitchStrategy pitchStrategy = new HigherPitchStrategy();
		
			for (MidiEventData event : events) {
				int modifiedNote = pitchStrategy.modifyPitch(event.getNote());
				
				// Call to modify to higher pitch
				//modifiedNote = pitchStrategy.modifyPitch(modifiedNote);
				
				if(event.getNoteOnOff() == 1) {
					track.add(factory.createNoteOn(event.getStartEndTick(), modifiedNote, event.getVelocity(), event.getChannel()));
				}
				else {
					track.add(factory.createNoteOff(event.getStartEndTick(), modifiedNote, event.getChannel()));
				}
			}
			
			// Play Sequence
			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();
			sequencer.setSequence(sequence);
			sequencer.start();
			System.out.println("Sequencer started: " + sequencer.isRunning());
			
			while (sequencer.isRunning()) {
			    Thread.sleep(500);
			}
			
			Thread.sleep(300);
			sequencer.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
