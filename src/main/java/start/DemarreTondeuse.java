package start;

import exceptions.LigneFormatException;
import modele.Tondeuse;
import utils.FileReader;

import java.io.FileNotFoundException;
import java.util.List;

public class DemarreTondeuse {

	public static void main(String[] args) throws FileNotFoundException, LigneFormatException {

		String path =String.valueOf(DemarreTondeuse.class.getClassLoader().getResource("input.txt"))
				.replace("file:\\","").replace("file:/","");
		List<String> fileLine = FileReader.getInstance().read(path);

		DeplacementControl deplacementControl=new DeplacementControl(fileLine);
		//deplacementControl.deplacerTondeuse();
		List<Tondeuse> list=deplacementControl.deplacerTondeuse();
		list.forEach(tondeuse -> System.out.println(tondeuse.toString()));


	}

}
