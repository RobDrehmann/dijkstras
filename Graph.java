public class Graph {
//make legnth = # of nodes
   public static int legnth = 6;
   public static int[][] graph = new int[legnth][legnth];
   public static int[] solution = new int[legnth];
    public static boolean[] checked = new boolean[legnth];
  //infinity represented by 100 can be changed
   public static int infinity = 100;
 //start node #
   public static int start = 0;
   public static void main(String[] args) {
       //add path value from a to b: graph[a][b] = path value
       //node numbers are arbitrary such that start node # = start
         graph[0][1]=6;
         graph[0][2]=1;
         graph[0][4]=10;
         graph[1][5]=3;
         graph[2][1]=4;
         graph[2][3]=2;
         graph[3][1]=1;
         graph[5][4]=3;
         findshortest(graph);
   }
   public static int[] findshortest(int graph[][]){
      for(int i = 0; i < legnth; i++){
         solution[i] = infinity;
      }
      solution[start] = 0;
      int lowest = infinity;
      int lowestloc = start;
      print(solution);
      for(int i = 0; i < legnth; i++){
         lowest = infinity;
         for(int j = 0; j < legnth; j++){
            if(solution[j] < lowest && checked[j] == false){
             lowestloc = j;
             lowest = solution[j];
            }
         }
          findpaths(lowestloc);
          checked[lowestloc] = true;
          print(solution);
      }
      return solution;
   }
   public static void findpaths(int i){
       if(solution[i] < infinity){
            for(int j = 0; j< legnth; j++){
               if(solution[j] == infinity && graph[i][j] != 0){
                  solution[j] = graph[i][j] + solution[i];
              }else if(graph[i][j] != 0 && graph[i][j] + solution[i] < solution[j] ){
                  solution[j] = graph[i][j]+ solution[i];
              }
            }
         }
   }
    public static void print(int solution[]){ 
     System.out.println("________________________________________");
       for(int i = 0; i < legnth; i++){   
          if (solution[i] == infinity){
              System.out.println(i + ": infinity");
          }else{
              System.out.println(i + ": " + solution[i]);
          }
       }
    }
}