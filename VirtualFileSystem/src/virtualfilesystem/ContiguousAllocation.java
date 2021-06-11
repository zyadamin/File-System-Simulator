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
public class  ContiguousAllocation implements Alocation_techniques{
    private int start;
    private int length;
   
   public File Allocation(int disk[],String name,int size){
       
       
       File New=null;
       int arr[]= new int[size];
       int countZero=0;
       
        for(int i=0;i<disk.length;i++){
        if(disk[i]==0){
        countZero++;
        } 
        }
        
        if(size<=countZero){
        for(int i=0;i<disk.length;i++)  {
           
           if(disk[i]==0){
           start=i;
           break;
           }
       
       }
       
       length =size;
       
       
       
       int count=0;
     for(int i=start;i<(start+length);i++){  
         arr[count++]=i;
         disk[i]=1;
   }
     
    New= new File();
    New.setFilePath(name);
    New.setAllocatedBlocks(arr);
    New.setDeleted(false);
        }
        
        
   return New;
   }

   public  void DeAllocation(File file,int disk[]){

   for(int i=0;i<file.getAllocatedBlocks().length;i++){
        
        disk[file.getAllocatedBlocks()[i]]=0;
        
   
   }
   
}
}