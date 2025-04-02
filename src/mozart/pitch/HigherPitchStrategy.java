package mozart.pitch;

public class HigherPitchStrategy implements PitchStrategy {

	/*
	 * this implements the function in the PitchStrategy interface
	 * to raise the pitch
	 */
	
	@Override
	public int modifyPitch(int note) {
		return note + 2;
	}
	
	
}
