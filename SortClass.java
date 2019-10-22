import java.util.ArrayList;
/**
*/
public class SortClass<T>{

	   public void sort(ArrayList<Comparable> list){
	   
	   	int index;
	   	
	   	//selection sort
        for (int i = 0; i < list.size() - 1; i++)  
        {  
            for (int j = i + 1; j < list.size(); j++){  
                if (list.get(j).compareTo(list.get(index)) < 0){  
                    index = j;//searching for lowest index  
                }  
            }  
            if(i!= index){
            	int temp = list.get(index);   
            	list.get(index) = list.get(i);  
            	list.get(i) = temp;  
            }
        }  
	   }
}

