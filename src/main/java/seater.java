import java.util.ArrayList;
import java.util.Arrays;

/**
TO DO:
 figure out what to do if numTables/numStudents is not even
 */

public class seater {
    private ArrayList<String> names;
    private int numTables;
    private int numStudents;
    private int studentsPerTable;

    public seater(int numTables, int numStudents, int studentsPerTable, String students){
        this.numTables = numTables;
        this.numStudents = numStudents;
        this.studentsPerTable = studentsPerTable;
        //break string of students names
        String[] split = students.split(",");
        this.names = new ArrayList<String>(Arrays.asList(split));
    }

    public seater(int numTables, int numStudents, String students){
        this.numTables = numTables;
        this.numStudents = numStudents;

        //break string of students names
        String[] split = students.split(",");
        this.names = new ArrayList<String>(Arrays.asList(split));
    }

    public ArrayList<Student> randomize(){
        ArrayList<Student> groups = new ArrayList<Student>();

        for(int i = 0; i < numTables; i ++){
            for(int j = 0; j < studentsPerTable; j++){
                int index = (int) (Math.random() * names.size());
               // tableGroups[i][j] = names.get(index);
            }
        }

        return groups;
    }
}

