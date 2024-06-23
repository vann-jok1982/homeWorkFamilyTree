package family_tree;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> humanList;

    public FamilyTree() {
        humanList=new ArrayList<>();
    }

    public FamilyTree(List<Human> humanList) {
        this.humanList = humanList;
    }

    public void addHuman(Human human){
        if (human!=null){
            if (!humanList.contains(human)){
                humanList.add(human);

                addChildToParents(human);
                addParentsToChild(human);
            }
        }
    }
    private void addChildToParents(Human human){  //добавить родителям ребёнка
        if (human.getMother()!=null)
          human.getMother().addChild(human);
        if (human.getFather()!=null)
           human.getFather().addChild(human);
    }
    private void addParentsToChild(Human human){  //К детям родителя
        if(human.getGender()==Gender.FEMALE)
          human.getChildren().forEach((ch)->ch.addMother(human)) ;

        if(human.getGender()==Gender.MALE)
            human.getChildren().forEach((ch)->ch.addFather(human)) ;

    }
    public Human getById(int id){
        for (Human human : humanList) {
            if (human.id==id)return human;
        }
        return null;
    }
    public  List<Human> getByName(String name){
        List<Human> humans=new ArrayList<>();
        for (Human human : humanList) {
            if (human.getName().equals(name)) humans.add(human);
        }
        return humans;
    }
    public  List<Human> getSiblings(int id){
        Human humanId=getById(id);
        if (humanId==null)return null;

        List<Human> humans=new ArrayList<>();
        if (humanId.getFather()!=null) {
            for (Human human : humanId.getFather().getChildren()) {
                if (!human.equals(humanId))
                 humans.add(human);
            }
            return humans;
        }
        else return null;
    }

    @Override
    public String toString() {
        return "FamilyTree{" +
                "humanList=" + humanList +
                '}';
    }
}