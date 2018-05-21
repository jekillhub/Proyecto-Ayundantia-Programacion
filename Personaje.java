public abstract class Personaje {

	protected String faccion;
	protected double hp;
	protected double atk;
	protected double def;
	protected double spd;

	protected abstract void chosenFaction();

	protected abstract void showInfo();

}