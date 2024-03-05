package start;

import enumerations.EDeplacement;
import enumerations.EDirection;
import exceptions.DeplacementException;
import exceptions.LigneFormatException;
import modele.Tondeuse;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DeplacementControl {


    private final List<Tondeuse> tondeuseList = new ArrayList<>();
    private final List<String> deplacements = new ArrayList<>();

    /*
    lire les lignes du fichiers
    ligne pour limite du fichier
    ligne pour pos tondeuse 1
    ligne pour suite deplacement tondeuse 1
    ligne pour pos tondeuse 2
    ligne pour suite deplacement tondeuse 2
     */
    public DeplacementControl(List<String> fileLine) throws LigneFormatException {

        System.out.println(fileLine.toString());
        Iterator<String> iterator = fileLine.iterator();

        // premier ligne contenant la limite de pelouse
        String limiteLigne = iterator.next();
        String[] pos = limiteLigne.split(" ");
        while(iterator.hasNext()){

            // premier ligne contient la position du tondeuse
            String[] positionTondeuse=iterator.next().split(" ");

            if(!iterator.hasNext()){
                throw new LigneFormatException("fichier invalide");
            }
            Tondeuse tondeuse= new Tondeuse(Integer.valueOf(pos[0]), Integer.valueOf(pos[1]),Integer.valueOf(positionTondeuse[0]),Integer.valueOf(positionTondeuse[1]), EDirection.getValueFromCode((positionTondeuse[2])));
            tondeuseList.add(tondeuse);
            // deuxieme ligne contient la sequence du déplacement
            String listDeplacement=iterator.next();
            deplacements.add(listDeplacement.replaceAll("\\s", ""));

        }
    }

    public List<Tondeuse> processTondeuse(){

                for(int i=0; i<tondeuseList.size(); i++) {
                    Tondeuse tondeuse = tondeuseList.get(i);
                    String deplacement = deplacements.get(i);
                    try {
                        processTondeuseDeplacement(tondeuse,deplacement);

                }
                //service.execute(processTondeuseDeplacement(tondeuseList.get(i), deplacements.get(i)));
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
                return tondeuseList;
    }


       Tondeuse processTondeuseDeplacement(Tondeuse tondeuse, String deplacement) throws DeplacementException {
        char[] sequenceDeplacement=deplacement.toCharArray();
        for(int j=0; j<sequenceDeplacement.length; j++){
            tondeuse.deplacement(EDeplacement.valueOf(String.valueOf(sequenceDeplacement[j])));
        }
           return  tondeuse;
       }



}
