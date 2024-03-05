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

		List<Tondeuse> list=new DeplacementControl(fileLine).processTondeuse();
		list.forEach(tondeuse -> System.out.println(tondeuse.toString()));


	}

}
