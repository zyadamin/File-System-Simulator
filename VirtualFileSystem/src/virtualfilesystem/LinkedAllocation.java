/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtualfilesystem;
import virtualfilesystem.Alocation_techniques;
/**
 *
 * @author Manar Atef
 */
public class LinkedAllocation implements Alocation_techniques{

    @Override
    public File Allocation(int[] disk, String name, int size) {
        
        File New=null;
        int countZero=0;
        for(int i=0;i<disk.length;i++){
        if(disk[i]==0){
        countZero++;
        } 
        }
        
        if(size<=countZero){
        
        int count=0;
        int arr[]= new int[size];
     
       for(int i=0;i<disk.length;i++)  {
           if(disk[i]==0){
            if(size==0){break;}   
              arr[count++]=i;  
              disk[i]=1;
              size--;
           }
       
       }
       
    New= new File();
    New.setFilePath(name);
    New.setAllocatedBlocks(arr);
    New.setDeleted(false);
        
        
        }

   
   return New;
   }

    @Override
    public void DeAllocation(File file, int[] disk) {
       
        
  for(int i=0;i<file.getAllocatedBlocks().length;i++){
        
        disk[file.getAllocatedBlocks()[i]]=0;
        
   
   }
        
        
    }
    
    
}
