package mozart.eventdata;

public class MidiEventData {
	
	//data fields
	private int startEndTick, velocity, note, channel, noteOnOff;
	private int instrument;
	
	//constructor to initialize data fields
	public MidiEventData(int startEndTick, int velocity, int note, int channel, int instrument, int noteOnOff) {
		this.startEndTick = startEndTick;
		this.velocity = velocity;
		this.note = note;
		this.channel = channel;
		this.instrument = instrument;
		this.noteOnOff = noteOnOff;
	}
	
	/** 
	 * gets StartEndTick
	 * @return the StartEndTick
	 */
	public int getStartEndTick() {
		return startEndTick;
	}
	
	/** 
	 * sets/changes StartEndTick
	 * @param startEndTick to be changed to
	 */
	public void setStartEndTick(int startEndTick) {
		this.startEndTick = startEndTick;
	}
	
	/** 
	 * gets the velocity
	 * @return the velocity
	 */
	public int getVelocity() {
		return velocity;
	}
	
	/**
	 * sets/changes the velocity
	 * @param velocity to be changed to 
	 */
	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}
	
	/**
	 * gets the note
	 * @return the note
	 */
	public int getNote() {
		return note;
	}
	
	/**
	 * sets/changes the note
	 * @param note to be changed to 
	 */
	public void setNote(int note) {
		this.note = note;
	}
	
	/**
	 * gets the channel
	 * @return the channel
	 */
	public int getChannel() {
		return channel;
	}
	
	/**
	 * sets/changes the channel
	 * @param channel to be changed to
	 */
	public void setChannel(int channel) {
		this.channel = channel;
	}
	
	/**
	 * gets the noteOnOff value
	 * @return the noteOnOff value
	 */
	public int getNoteOnOff() {
		return noteOnOff;
	}
	
	/**
	 * sets/changes the noteOnOff
	 * @param noteOnOff to be changed to
	 */
	public void setNoteOnOff(int noteOnOff) {
		this.noteOnOff = noteOnOff;
	}
	
	/**
	 * gets the instrument
	 * @return the instrument
	 */
	public int getInstrument() {
		return instrument;
	}
	
	/**
	 * sets/changes the instrument
	 * @param instrument to be changed to
	 */
	public void setInstrument(int instrument) {
		this.instrument = instrument;
	}
	
	/**
	 * displays information about the data as a string. 
	 */
	public String toString() {
		return "startEndTick = " + startEndTick + " velocity = " + velocity + " note = " + note + " channel = " + channel + " instrument = " + instrument + " noteOnOff = " + noteOnOff;
	}
	
}
